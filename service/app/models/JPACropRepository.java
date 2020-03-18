package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPACropRepository implements CropRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPACropRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Crop> add(Crop crop) {
        return supplyAsync(() -> wrap(em -> insert(em, crop)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listfc(Long fid) {
        return supplyAsync(() -> wrap(em -> listfc(em, fid)), executionContext);
    }

    @Override
    public CompletionStage<Crop> getc(Long cid) {
        return supplyAsync(() -> wrap(em -> getc(em, cid)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listc() {
        return supplyAsync(() -> wrap(em -> listc(em)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listl() {
        return supplyAsync(() -> wrap(em -> listl(em)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listCinL(String location) {
        return supplyAsync(() -> wrap(em -> listfc(em, location)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listct(String location) {
        return supplyAsync(() -> wrap(em -> listct(em, location)), executionContext);
    }

    @Override
    public CompletionStage<Crop> updateCrop(Long cid, String status) {
        return supplyAsync(() -> wrap(em -> updatevalue(em, cid, status)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public Crop insert(EntityManager em, Crop crop) {
        em.persist(crop);
        return crop;
    }

    private Stream<Crop> listfc(EntityManager em, Long fid) {
        List<Crop> crops = em.createQuery("select c from Crop c where c.fid=:fid order by c.id desc", Crop.class).setParameter("fid", fid).setMaxResults(5).getResultList();
        return crops.stream();
    }

    private Crop getc(EntityManager em, Long cid) {
        Crop crop = em.createQuery("select c from Crop c where c.id=:cid", Crop.class).setParameter("cid", cid).getSingleResult();
        return crop;
    }

    private Stream<Crop> listc(EntityManager em) {
        List<Crop> crops = em.createQuery("select c from Crop c order by c.bidendtime asc", Crop.class).setMaxResults(5).getResultList();
        return crops.stream();
    }

    private Stream<Crop> listl(EntityManager em) {
        List<Crop> locations = em.createQuery("select distinct c.location from Crop c").getResultList();
        return locations.stream();
    }

    private Stream<Crop> listfc(EntityManager em, String location) {
        List<Crop> crops = em.createQuery("select c from Crop c where c.location=:location order by c.id desc", Crop.class).setParameter("location", location).getResultList();
        return crops.stream();
    }

    private Stream<Crop> listct(EntityManager em, String location) {
        List<Crop> locations = em.createQuery("select distinct c.name from Crop c where c.name in (select c1.name from Crop c1 where c1.location=:location)").setParameter("location",location).getResultList();
        return locations.stream();
    }

    private Crop updatevalue(EntityManager em, Long cid, String status){
        int i= em.createQuery("update Crop c set c.status =: status where c.id =: cid").setParameter("status",status).setParameter("cid",cid).executeUpdate();
        if(i!=0){
            Crop crop=em.createQuery("select c from Crop c where c.id=:cid",Crop.class).setParameter("cid",cid).getSingleResult();
            return crop;
        }
        else{
            return null;

        }
    }

}
