package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.Math.round;
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
    public CompletionStage<Stream<JsonNode>> cropsToPay(Long buyerId) {
        return supplyAsync(() -> wrap(em -> cropsToPay(em, buyerId)), executionContext);
    }

    @Override
    public CompletionStage<Stream<JsonNode>> getClosedDeals(Long buyerId) {
        return supplyAsync(() -> wrap(em -> getClosedDeals(em, buyerId)), executionContext);
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

    @Override
    public CompletionStage<String> advPayment(Long cropId, Long advancePayment) {
        return supplyAsync(() -> wrap(em -> advPayment(em, cropId, advancePayment)), executionContext);
    }

    @Override
    public CompletionStage<String> harvested(Long cropId, Float harvestedQuantity) {
        return supplyAsync(() -> wrap(em -> harvested(em, cropId, harvestedQuantity)), executionContext);
    }

    @Override
    public CompletionStage<String> totalPayment(Long cropId, Float rating, Long fid) {
        return supplyAsync(() -> wrap(em -> totalPayment(em, cropId, rating, fid)), executionContext);
    }

    @Override
    public CompletionStage<String> closeDeal(Long cropId, Float rating, Long fid) { //fid == buyerId
        return supplyAsync(() -> wrap(em -> closeDeal(em, cropId, rating, fid)), executionContext);
    }
    @Override
    public CompletionStage<Stream<Crop>> remind() {
        return supplyAsync(() -> wrap(em -> remind(em)), executionContext);
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

    private Stream<JsonNode> cropsToPay(EntityManager em, Long buyerId) {
        List<Long> accepted = em.createQuery("select b.cropId from Bidding b where b.buyerId = :buyerId and b.status = 'accepted'").setParameter("buyerId", buyerId).getResultList();
        List<Crop> notPayed = em.createQuery("select c from Crop c where not c.status='sold' order by c.starttime asc", Crop.class).getResultList();
        List<Crop> toPay = new ArrayList<Crop>();
        System.out.println("Crops ids that accepted bid: "+accepted);
        notPayed.forEach(crop -> {
            if(accepted.contains(crop.id)) toPay.add(crop);
        });

        List<JsonNode> payable = new ArrayList<JsonNode>();
        for(int i=0; i<toPay.size();i++){
            Long priceBade = (Long) em.createQuery("select b.biddingPrice from Bidding b where b.cropId=:crop and b.buyerId=:buyerId").setParameter("crop",toPay.get(i).id).setParameter("buyerId",buyerId).getSingleResult();
            ObjectNode js = null;
            try {
                js = (ObjectNode) new ObjectMapper().readTree("{" +
                        "\"id\" : \"" + toPay.get(i).id + "\"," +
                        "\"name\" : \"" + toPay.get(i).name + "\"," +
                        "\"area\" : \"" + toPay.get(i).area + "\"," +
                        "\"location\" : \"" + toPay.get(i).location + "\"," +
                        "\"fid\" : \"" + toPay.get(i).fid + "\"," +
                        "\"status\" : \"" + toPay.get(i).status + "\"," +
                        "\"price\" : \"" + priceBade + "\"," +
                        "\"advPayment\" : \"" + toPay.get(i).advPayment + "\"," +
                        "\"harvestedQuantity\" : \"" + toPay.get(i).harvestedQuantity + "\"" +
                        "}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            payable.add(js);
        }
        return payable.stream();
    }

    private Stream<JsonNode> getClosedDeals(EntityManager em, Long buyerId) {
        List<Long> accepted = em.createQuery("select b.cropId from Bidding b where b.buyerId = :buyerId and b.status = 'accepted'").setParameter("buyerId", buyerId).getResultList();
        List<Crop> notPayed = em.createQuery("select c from Crop c where c.status='sold' or c.status='toratebuyer' order by c.starttime asc", Crop.class).getResultList();
        List<Crop> toPay = new ArrayList<Crop>();
        System.out.println("Crops ids that accepted bid: "+accepted);
        notPayed.forEach(crop -> {
            if(accepted.contains(crop.id)) toPay.add(crop);
        });

        List<JsonNode> payable = new ArrayList<JsonNode>();
        for(int i=0; i<toPay.size();i++){
            Long priceBade = (Long) em.createQuery("select b.biddingPrice from Bidding b where b.cropId=:crop and b.buyerId=:buyerId").setParameter("crop",toPay.get(i).id).setParameter("buyerId",buyerId).getSingleResult();
            ObjectNode js = null;
            try {
                js = (ObjectNode) new ObjectMapper().readTree("{" +
                        "\"id\" : \"" + toPay.get(i).id + "\"," +
                        "\"name\" : \"" + toPay.get(i).name + "\"," +
                        "\"area\" : \"" + toPay.get(i).area + "\"," +
                        "\"location\" : \"" + toPay.get(i).location + "\"," +
                        "\"fid\" : \"" + toPay.get(i).fid + "\"," +
                        "\"status\" : \"" + toPay.get(i).status + "\"," +
                        "\"price\" : \"" + priceBade + "\"" +
                        "}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            payable.add(js);
        }
        return payable.stream();
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

    private String advPayment(EntityManager em, Long cropId, Long advancePayment){
        int update = em.createQuery("update Crop c set c.advPayment=:advancePayment where c.id=: cropId").setParameter("advancePayment",advancePayment).setParameter("cropId",cropId).executeUpdate();
        update += em.createQuery("update Crop c set c.status = 'payed' where c.id=: cropId").setParameter("cropId",cropId).executeUpdate();
        System.out.println(update);
        if(update==2)
            return "Advance payment done.";
        else
            return "Advance payment error.";
    }

    private String harvested(EntityManager em, Long cropId, Float harvestedQuantity){
        int update = em.createQuery("update Crop c set c.harvestedQuantity =: harvestedQuantity where c.id=: cropId").setParameter("harvestedQuantity",harvestedQuantity).setParameter("cropId",cropId).executeUpdate();
        System.out.println(harvestedQuantity + "update: "+update);
        Crop crop = em.createQuery("select c from Crop c where c.id =: cropId", Crop.class).setParameter("cropId",cropId).getSingleResult();
        Long priceAgreed = (Long)em.createQuery("select b.biddingPrice from Bidding b where b.cropId =: cropId and b.status='accepted'").setParameter("cropId",cropId).getSingleResult();
        Float fraction = 1f;
        System.out.println("price agreed: "+priceAgreed);
        if(harvestedQuantity < crop.quantitymin) {
            fraction = harvestedQuantity / crop.quantitymin;
        }
        else if(harvestedQuantity > crop.quantitymax) {
            fraction = harvestedQuantity / crop.quantitymax;
        }
        Long totalPayable = Long.valueOf(round(priceAgreed * fraction));
        update += em.createQuery("update Crop c set c.totalPayable =: totalPayable where c.id=: cropId").setParameter("totalPayable",totalPayable).setParameter("cropId",cropId).executeUpdate();
        System.out.println("fraction: "+fraction+"\ntotalPayable: "+totalPayable);
        update += em.createQuery("update Crop c set c.status = 'harvested' where c.id=: cropId").setParameter("cropId",cropId).executeUpdate();
        System.out.println("Status" + "update: "+update);
        if(update==3)
            return "Harvest and total calculation success.";
        return "Harvested and total calculation error.";
    }

    private String totalPayment(EntityManager em, Long cropId, Float rating, Long fid){
        int update = em.createQuery("update Crop c set c.status = 'toratebuyer' where c.id=: cropId").setParameter("cropId",cropId).executeUpdate();
        Long numrating = (Long)em.createQuery("select r.numrating from Register r where r.id =: fid").setParameter("fid",fid).getSingleResult();
        Float prevRating = (Float)em.createQuery("select r.rating from Register r where r.id =: fid").setParameter("fid",fid).getSingleResult();
        if (prevRating==6.0)
            prevRating = 0f;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        Float newRating = ((prevRating*numrating) + rating)/(numrating+1);
        newRating = Float.valueOf(df.format(newRating));        update += em.createQuery("update Register r set r.rating =: rating, r.numrating=:numrating where r.id=: fid").setParameter("rating", newRating).setParameter("numrating", numrating+1).setParameter("fid",fid).executeUpdate();
        System.out.println(update);
        if(update==2)
            return "Total payment done.";
        else
            return "Total payment error.";
    }

    private String closeDeal(EntityManager em, Long cropId, Float rating, Long fid){
        int update = em.createQuery("update Crop c set c.status = 'sold' where c.id=: cropId").setParameter("cropId",cropId).executeUpdate();
        Long numrating = (Long)em.createQuery("select r.numrating from Register r where r.id =: fid").setParameter("fid",fid).getSingleResult();
        Float prevRating = (Float)em.createQuery("select r.rating from Register r where r.id =: fid").setParameter("fid",fid).getSingleResult();
        if (prevRating==6.0)
            prevRating = 0f;

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        Float newRating = ((prevRating*numrating) + rating)/(numrating+1);
        newRating = Float.valueOf(df.format(newRating));
        update += em.createQuery("update Register r set r.rating =: rating, r.numrating=:numrating where r.id=: fid").setParameter("rating", newRating).setParameter("numrating", numrating+1).setParameter("fid",fid).executeUpdate();
        System.out.println(update);
        if(update==2)
            return "Total payment done.";
        else
            return "Total payment error.";
    }

    private Stream<Crop> remind(EntityManager em) {
        Date dt = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 5);
        dt = c.getTime();
        java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
        System.out.println("sqlDate to check: "+sqlDate);

        List<Crop> crops = em.createQuery("select c from Crop c where c.endtime=:sqlDate and (c.status='payed' or c.status='harvested')",Crop.class).setParameter("sqlDate", sqlDate).getResultList();

        return crops.stream();
    }
}
