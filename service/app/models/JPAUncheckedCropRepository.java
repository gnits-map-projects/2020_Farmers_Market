package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

//import app/models/JPACropRepository.java:58

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPAUncheckedCropRepository implements UncheckedCropRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPAUncheckedCropRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<UncheckedCrop> add(UncheckedCrop uncheckedCrop) {
        return supplyAsync(() -> wrap(em -> insert(em, uncheckedCrop)), executionContext);
    }

    @Override
    public CompletionStage<Stream<UncheckedCrop>> listc() {
        return supplyAsync(() -> wrap(em -> listc(em)), executionContext);
    }

    @Override
    public CompletionStage<UncheckedCrop> getuc(Long cid) {
        return supplyAsync(() -> wrap(em -> getuc(em, cid)), executionContext);
    }

    @Override
    public UncheckedCrop approveCrop(Long cid) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        UncheckedCrop foundUncheckedCrop = em.createQuery("select c from UncheckedCrop c where c.id=:cid", UncheckedCrop.class).setParameter("cid", cid).getSingleResult();
        return foundUncheckedCrop;
    }

    @Override
    public CompletionStage<UncheckedCrop> deleteCrop(Long cid) {
        return supplyAsync(() -> wrap(em -> del(em, cid)), executionContext);
    }

    @Override
    public Register getFarmer(Long cid){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Register foundRegister = em.createQuery("select r from Register r where r.id = (select c.fid from UncheckedCrop c where c.id =: cid)",Register.class).setParameter("cid",cid).getSingleResult();
        return foundRegister;
    }

    @Override
    public UncheckedCrop getUCrop(Long cid){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        UncheckedCrop uncheckedCrop = em.createQuery("select c from UncheckedCrop c where c.id =: cid",UncheckedCrop.class).setParameter("cid",cid).getSingleResult();
        return uncheckedCrop;
    }


    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }





    private UncheckedCrop insert(EntityManager em, UncheckedCrop uncheckedCrop) {
        em.persist(uncheckedCrop);
        return uncheckedCrop;
    }

    private UncheckedCrop getuc(EntityManager em, Long cid) {
        UncheckedCrop crop = em.createQuery("select c from UncheckedCrop c where c.id=:cid", UncheckedCrop.class).setParameter("cid", cid).getSingleResult();
        return crop;
    }

    private Stream<UncheckedCrop> listc(EntityManager em) {
        List<UncheckedCrop> uncheckedCrops = em.createQuery("select c from UncheckedCrop c", UncheckedCrop.class).getResultList();
        return uncheckedCrops.stream();
    }

    private UncheckedCrop del(EntityManager em, Long cid) {
        UncheckedCrop foundUncheckedCrop = em.createQuery("select c from UncheckedCrop c where c.id=:cid", UncheckedCrop.class).setParameter("cid", cid).getSingleResult();
        em.remove(foundUncheckedCrop);
        return foundUncheckedCrop;

    }


//    private UncheckedCrop approveCrop(EntityManager em, Long cid) {
//        UncheckedCrop foundUncheckedCrop = em.createQuery("select c from UncheckedCrop c where c.id=:cid", UncheckedCrop.class).setParameter("cid", cid).getSingleResult();
//        //insertIntoCrop(crop)
//        em.remove(foundUncheckedCrop);
//        return foundUncheckedCrop;
//    }
}
