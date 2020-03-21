package models;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.stream.Stream;
import java.lang.Exception;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;


import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPARegisterRepository implements RegisterRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPARegisterRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Register> add(Register register) {
        return supplyAsync(() -> wrap(em -> insert(em, register)), executionContext);
    }

    @Override
    public CompletionStage<Register> getFarmer(Long fid) {
        return supplyAsync(() -> wrap(em -> getFarmer(em, fid)), executionContext);
    }

    @Override
    public Register login(String email,String password){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Register foundRegister = em.createQuery("select p from Register p where p.email =: email and p.password =: password",Register.class).setParameter("email",email).setParameter("password",password).getSingleResult();
        return foundRegister;
    }

    @Override
    public CompletionStage<Register> update(Long id, String name, String email, String password, String mobile) {
        return supplyAsync(() -> wrap(em -> updatevalue(em, id, name, email,password,mobile)), executionContext);
    }

    @Override
    public CompletionStage<Register> verify(Long id) {
        return supplyAsync(() -> wrap(em -> verify(em, id)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Register insert(EntityManager em, Register register) {
        em.persist(register);
        return register;
    }

    private Register getFarmer(EntityManager em, Long fid) {
        Register register = em.createQuery("select r from Register r where r.id=:fid", Register.class).setParameter("fid", fid).getSingleResult();
        return register;
    }

    private Register updatevalue(EntityManager em, Long id, String name, String email, String password, String mobile){
        int i= em.createQuery("update Register r set r.name =: name, r.email =: email, r.password =: password, r.mobile=:mobile where r.id =: id").setParameter("name",name).setParameter("email",email).setParameter("password",password).setParameter("mobile",mobile).setParameter("id",id).executeUpdate();
        if(i!=0){
            Register register=em.createQuery("select r from Register r where r.id=:id",Register.class).setParameter("id",id).getSingleResult();
            return register;
        }
        else{
            return null;

         }

    }

    private Register verify(EntityManager em, Long id) {
        int i= em.createQuery("update Register r set r.status =: status where r.id =: id").
                setParameter("status","authenticated").
                setParameter("id",id).
                executeUpdate();
        if(i!=0){
            Register register=em.createQuery("select r from Register r where r.id=:id",Register.class).
                    setParameter("id",id).
                    getSingleResult();
            return register;
        }
        else{
            return null;
        }
    }

}
