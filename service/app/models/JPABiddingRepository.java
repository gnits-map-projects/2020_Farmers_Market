package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.ArrayList;

import static java.util.concurrent.CompletableFuture.supplyAsync;

/**
 * Provide JPA operations running inside of a thread pool sized to the connection pool
 */
public class JPABiddingRepository implements BiddingRepository {

    private final JPAApi jpaApi;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public JPABiddingRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
        this.jpaApi = jpaApi;
        this.executionContext = executionContext;
    }

    @Override
    public CompletionStage<Bidding> add(Bidding bidding) {
        return supplyAsync(() -> wrap(em -> insert(em, bidding)), executionContext);
    }

    @Override
    public CompletionStage<Stream<JsonNode>> listcb(Long cid) {
        return supplyAsync(() -> wrap(em -> listcb(em, cid)), executionContext);
    }

    @Override
    public CompletionStage<JsonNode> listbt(Long cid) {
        return supplyAsync(() -> wrap(em -> listbt(em, cid)), executionContext);
    }

    @Override
    public CompletionStage<Bidding> acceptBid(Long bid, Long cid) {
        return supplyAsync(() -> wrap(em -> acceptBid(em, bid, cid)), executionContext);
    }

    @Override
    public CompletionStage<Bidding> rejectBid(Long bid) {
        return supplyAsync(() -> wrap(em -> rejectBid(em, bid)), executionContext);
    }

    @Override
    public Register getBuyer(Long bid) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Register register = em.createQuery("select r from Register r where id = (select b.buyerId from Bidding b where b.id =: bid)",Register.class).
                setParameter("bid", bid).
                getSingleResult();
        return register;
    }

    @Override
    public List<Register> getLosers(Long bid, Long cid) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Register> registers = em.createQuery("select r from Register r where r.id in " +
                "(select b.buyerId from Bidding b where b.cropId =: cid and b.status=: status and not b.id=:bid)",Register.class).
                setParameter("cid", cid).
                setParameter("status", "waiting").
                setParameter("bid", bid).
                getResultList();
        registers.forEach(register -> System.out.println(register.email));
        return registers;
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public Bidding insert(EntityManager em, Bidding bidding) {
        em.persist(bidding);
        return bidding;
    }

    private Stream<JsonNode> listcb(EntityManager em, Long cid) {
        List<Bidding> bids = em.createQuery("select b from Bidding b where b.cropId=:cid order by b.biddingPrice desc", Bidding.class).setParameter("cid", cid).getResultList();
        List<JsonNode> bidDetails = new ArrayList<JsonNode>();

        for(int i =0; i<bids.size(); i++){
            String id = (bids.get(i).buyerId).toString();
            String buyer = em.createQuery("select name from Register r where r.id=:buyerId").setParameter("buyerId", bids.get(i).buyerId).getSingleResult().toString();
            String rating = em.createQuery("select rating from Register r where r.id=:buyerId").setParameter("buyerId", bids.get(i).buyerId).getSingleResult().toString();
            System.out.println(rating);
            if(rating.equals("6.0")) {
                rating = "No rating yet";
            }
            System.out.println(rating);
            try {
                ObjectNode json = (ObjectNode) new ObjectMapper().readTree("{ \"id\" : \""+ bids.get(i).id +"\", \"buyerId\" : \""+id+"\", \"name\" : \""+buyer+"\", \"rating\" : \""+rating+"\", \"biddingPrice\" : \"" + (bids.get(i).biddingPrice).toString()+"\", \"status\" : \""+bids.get(i).status+"\" }");
                System.out.println(json);
                bidDetails.add(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bidDetails.stream();
    }

    private JsonNode listbt(EntityManager em, Long cid) {
        ObjectNode json = null;
        if(em.createQuery("select b from Bidding b where b.cropId=:cid").setParameter("cid", cid).setMaxResults(1).getSingleResult().toString() == null){
            String noBids = "No bids yet";
            try {
                json = (ObjectNode) new ObjectMapper().readTree("{ \"noBids\" : \"" + noBids + "\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            String maxBid = em.createQuery("select max(b.biddingPrice) from Bidding b where b.cropId=:cid").setParameter("cid", cid).getSingleResult().toString();
            String minBid = em.createQuery("select min(b.biddingPrice) from Bidding b where b.cropId=:cid").setParameter("cid", cid).getSingleResult().toString();
            try {
                json = (ObjectNode) new ObjectMapper().readTree("{ \"maxBid\" : \"" + maxBid + "\", \"minBid\" : \"" + minBid + "\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return json;
    }

    private Bidding acceptBid(EntityManager em, Long bid, Long cid){
        int i= em.createQuery("update Bidding b set b.status =: status where b.id =: bid").setParameter("status","accepted").setParameter("bid",bid).executeUpdate();
        int j= em.createQuery("update Bidding b set b.status =: status where b.cropId =: cid and not b.id = :bid").setParameter("status","rejected").setParameter("bid",bid).setParameter("cid",cid).executeUpdate();
        if(i!=0){
            Bidding bidding = em.createQuery("select b from Bidding b where b.id=:bid",Bidding.class).setParameter("bid",bid).getSingleResult();
            return bidding;
        }
        else{
            return null;

        }
    }

    private Bidding rejectBid(EntityManager em, Long bid){
        int i= em.createQuery("update Bidding b set b.status =: status where b.id =: bid").setParameter("status","rejected").setParameter("bid",bid).executeUpdate();
        if(i!=0){
            Bidding bidding = em.createQuery("select b from Bidding b where b.id =: bid",Bidding.class).setParameter("bid",bid).getSingleResult();
            return bidding;
        }
        else{
            return null;

        }
    }

}
