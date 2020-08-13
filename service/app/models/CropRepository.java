package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPACropRepository.class)
public interface CropRepository {

    CompletionStage<Crop> add(Crop crop);

    CompletionStage<Crop> getc(Long cid);

    CompletionStage<Stream<Crop>> listfc(Long fid);

    CompletionStage<Stream<Crop>> listAllfc(Long fid);

    CompletionStage<Stream<Crop>> listc();

    CompletionStage<Stream<Crop>> listAllc();

    CompletionStage<Stream<Crop>> listcForBuyer(Long buyerId);

    CompletionStage<Stream<Crop>> listAllcForBuyer(Long buyerId);

    CompletionStage<Stream<Crop>> listOthersc(Long fid);

    CompletionStage<Stream<Crop>> listAllOthersc(Long fid);

    CompletionStage<Stream<Crop>> listl();

    CompletionStage<Stream<Crop>> listCinL(String location);

    CompletionStage<Stream<Crop>> listct(String location);

    public CompletionStage<Crop> updateCrop(Long cid, String status);

    CompletionStage<Stream<JsonNode>> cropsToPay(Long buyerId);

    CompletionStage<Stream<JsonNode>> getClosedDeals(Long buyerId);

    CompletionStage<String> advPayment(Long cropId, Long advancePayment);

    CompletionStage<String> totalPayment(Long cropId, Float rating, Long fid);

    CompletionStage<String> closeDeal(Long cropId, Float rating, Long buyerId);

    CompletionStage<String> harvested(Long cropId, Float harvestedQuantity);

    CompletionStage<Stream<Crop>> remind();
}
