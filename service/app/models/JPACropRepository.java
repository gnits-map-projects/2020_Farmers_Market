package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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
    public CompletionStage<Stream<Crop>> listAllfc(Long fid) {
        return supplyAsync(() -> wrap(em -> listAllfc(em, fid)), executionContext);
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
    public CompletionStage<Stream<Crop>> listAllc() {
        return supplyAsync(() -> wrap(em -> listAllc(em)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listcForBuyer(Long buyerId) {
        return supplyAsync(() -> wrap(em -> listcForBuyer(em, buyerId)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listAllcForBuyer(Long buyerId) {
        return supplyAsync(() -> wrap(em -> listAllcForBuyer(em, buyerId)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> cropsToPay(Long buyerId) {
        return supplyAsync(() -> wrap(em -> cropsToPay(em, buyerId)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listOthersc(Long fid) {
        return supplyAsync(() -> wrap(em -> listOthersc(em, fid)), executionContext);
    }

    @Override
    public CompletionStage<Stream<Crop>> listAllOthersc(Long fid) {
        return supplyAsync(() -> wrap(em -> listAllOthersc(em, fid)), executionContext);
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

    private Stream<Crop> listAllfc(EntityManager em, Long fid) {
        List<Crop> crops = em.createQuery("select c from Crop c where c.fid=:fid order by c.id desc", Crop.class).setParameter("fid", fid).getResultList();
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

    private Stream<Crop> listAllc(EntityManager em) {
        List<Crop> crops = em.createQuery("select c from Crop c order by c.bidendtime asc", Crop.class).getResultList();
        return crops.stream();
    }

    private Stream<Crop> listcForBuyer(EntityManager em, Long buyerId) {
        List<Long> bidded = em.createQuery("select b.cropId from Bidding b where b.buyerId = :buyerId").setParameter("buyerId", buyerId).getResultList();
        List<Crop> crops = em.createQuery("select c from Crop c where c.status = 'bidding' order by c.bidendtime asc", Crop.class).setMaxResults(5).getResultList();
        List<Crop> notBidded = new ArrayList<Crop>();
        crops.forEach(crop -> {
            if(!bidded.contains(crop.id)) notBidded.add(crop);
        });
        return notBidded.stream();
    }

    private Stream<Crop> listAllcForBuyer(EntityManager em, Long buyerId) {
        List<Long> bidded = em.createQuery("select b.cropId from Bidding b where b.buyerId = :buyerId").setParameter("buyerId", buyerId).getResultList();
        List<Crop> crops = em.createQuery("select c from Crop c where c.status = 'bidding' order by c.bidendtime asc", Crop.class).getResultList();
        List<Crop> notBidded = new ArrayList<Crop>();
        crops.forEach(crop -> {
            if(!bidded.contains(crop.id)) notBidded.add(crop);
        });
        return notBidded.stream();
    }

    private Stream<Crop> cropsToPay(EntityManager em, Long buyerId) {
        List<Long> accepted = em.createQuery("select b.cropId from Bidding b where b.buyerId = :buyerId and b.status = 'accepted'").setParameter("buyerId", buyerId).getResultList();
        List<Crop> notPayed = em.createQuery("select c from Crop c where c.status = 'closed' order by c.starttime asc", Crop.class).getResultList();
        List<Crop> toPay = new ArrayList<Crop>();
        System.out.println("Crops ids that accepted bid: "+accepted);
        notPayed.forEach(crop -> {
            if(accepted.contains(crop.id)) toPay.add(crop);
        });
        return toPay.stream();
    }

    private Stream<Crop> listOthersc(EntityManager em, Long fid) {
        List<Crop> crops = em.createQuery("select c from Crop c where not c.fid =: fid order by c.bidendtime asc", Crop.class).setParameter("fid",fid).setMaxResults(5).getResultList();
        return crops.stream();
    }

    private Stream<Crop> listAllOthersc(EntityManager em, Long fid) {
        List<Crop> crops = em.createQuery("select c from Crop c where not c.fid =: fid order by c.bidendtime asc", Crop.class).setParameter("fid",fid).getResultList();
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
