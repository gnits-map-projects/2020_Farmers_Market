package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
    public CompletionStage<Bidding> acceptBid(Long bid, Long cid) {
        return supplyAsync(() -> wrap(em -> acceptBid(em, bid, cid)), executionContext);
    }

    @Override
    public CompletionStage<Bidding> rejectBid(Long bid) {
        return supplyAsync(() -> wrap(em -> rejectBid(em, bid)), executionContext);
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
                ObjectNode json = (ObjectNode) new ObjectMapper().readTree("{ \"id\" : \""+ bids.get(i).id +"\", \"buyerId\" : \""+id+"\", \"name\" : \""+buyer+"\", \"rating\" : \""+rating+"\", \"biddingPrice\" : \"" + (bids.get(i).biddingPrice).toString()+"\" }");
                System.out.println(json);
                bidDetails.add(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bidDetails.stream();
    }

    private Bidding acceptBid(EntityManager em, Long bid, Long cid){
        int i= em.createQuery("update Bidding b set b.status =: status where b.id =: bid").setParameter("status","accepted").setParameter("bid",bid).executeUpdate();
        int j= em.createQuery("update Bidding b set b.status =: status where b.cid =: cid and b.id != :bid").setParameter("status","rejected").setParameter("bid",bid).setParameter("cid",cid).executeUpdate();

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
