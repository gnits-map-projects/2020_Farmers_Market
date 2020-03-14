package models;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
@ImplementedBy(JPABiddingRepository.class)
public interface BiddingRepository {

    CompletionStage<Bidding> add(Bidding bidding);

    CompletionStage<Stream<JsonNode>> listcb(Long cid);

    public CompletionStage<Bidding> acceptBid(Long bid, Long cid);

    public CompletionStage<Bidding> rejectBid(Long bid);


}
