package models;

import play.db.jpa.JPAApi;
import javax.inject.Inject;
import javax.persistence.EntityManager;
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
    public CompletionStage<Stream<Bidding>> listcb(Long cid) {
        return supplyAsync(() -> wrap(em -> listcb(em, cid)), executionContext);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    public Bidding insert(EntityManager em, Bidding bidding) {
        em.persist(bidding);
        return bidding;
    }

    private Stream<Bidding> listcb(EntityManager em, Long cid) {
        List<Bidding> bids = em.createQuery("select b from Bidding b where b.cropId=:cid order by b.biddingPrice desc", Bidding.class).setParameter("cid", cid).getResultList();
        List<String> buyers = new ArrayList<String>();
        for(int i =0; i<bids.size(); i++){
            System.out.println(bids.get(i).buyerId);
            String buyer =  em.createQuery("select name from Register r where r.id=:buyerId").setParameter("buyerId", bids.get(i).buyerId).getSingleResult().toString();
            buyers.add(buyer);
        }
        System.out.println(buyers);
        return bids.stream();
    }


}
