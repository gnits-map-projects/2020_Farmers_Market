package models;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
@ImplementedBy(JPABiddingRepository.class)
public interface BiddingRepository {

    CompletionStage<Bidding> add(Bidding bidding);

    CompletionStage<String> update(JsonNode js);

    CompletionStage<Stream<JsonNode>> listcb(Long cid);

    CompletionStage<Stream<JsonNode>> listpb(Long buyerId);

    CompletionStage<Stream<JsonNode>> listAllpb(Long buyerId);

    CompletionStage<JsonNode> listbt(Long cid);

    CompletionStage<JsonNode> getPrevBid(Long buyerId, Long cid);

    public CompletionStage<Bidding> acceptBid(Long bid, Long cid);

    public CompletionStage<Bidding> rejectBid(Long bid);

    Register getBuyer(Long bid);

    List<Register> getLosers(Long bid, Long cid);

    CompletionStage<JsonNode> getWinner(Long cid);
}
