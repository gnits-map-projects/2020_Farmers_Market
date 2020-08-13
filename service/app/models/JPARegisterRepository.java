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
    public String sendResetLink(String email){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Long id = 0L;
        try{
            id = (Long)em.createQuery("select r.id from Register r where r.email =: email").setParameter("email",email).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(id == 0)
            return "Absent";
        return "Present" + id;
    }

    @Override
    public Register getUser(Long uid) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Register register = em.createQuery("select r from Register r where r.id=:userId", Register.class).setParameter("userId", uid).getSingleResult();
        return register;
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
    public CompletionStage<Register> update(Long id, String name, String email, String mobile) {
        return supplyAsync(() -> wrap(em -> updatevalue(em, id, name, email, mobile)), executionContext);
    }

    @Override
    public CompletionStage<Register> resetPassword(Long id, String password) {
        return supplyAsync(() -> wrap(em -> resetPassword(em, id, password)), executionContext);
    }

    @Override
    public CompletionStage<String> verify(Long id) {
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

    private Register updatevalue(EntityManager em, Long id, String name, String email, String mobile){
        int i= em.createQuery("update Register r set r.name =: name, r.email =: email, r.status = 'unauthenticated', r.password =: password, r.mobile=:mobile where r.id =: id").setParameter("name",name).setParameter("email",email).setParameter("mobile",mobile).setParameter("id",id).executeUpdate();
        if(i!=0){
            Register register=em.createQuery("select r from Register r where r.id=:id",Register.class).setParameter("id",id).getSingleResult();
            return register;
        }
        else{
            return null;
         }
    }

    private Register resetPassword(EntityManager em, Long id, String password){
        int i= em.createQuery("update Register r set r.password =: password where r.id =: id").setParameter("password",password).setParameter("id",id).executeUpdate();
        if(i!=0){
            Register register=em.createQuery("select r from Register r where r.id=:id",Register.class).setParameter("id",id).getSingleResult();
            return register;
        }
        else{
            return null;
        }
    }

    private String verify(EntityManager em, Long id) {
        String txt = (String) em.createQuery("select r.status from Register r where r.id =: id").setParameter("id",id).getSingleResult();
        int i= em.createQuery("update Register r set r.status =: status where r.id =: id").
                setParameter("status","authenticated").
                setParameter("id",id).
                executeUpdate();
        System.out.println(txt);
        return txt;
    }

}
