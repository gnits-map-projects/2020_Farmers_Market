package models;
import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;
@ImplementedBy(JPABiddingRepository.class)
public interface BiddingRepository {

    CompletionStage<Bidding> add(Bidding bidding);


}
