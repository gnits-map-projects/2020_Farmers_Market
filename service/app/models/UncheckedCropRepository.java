package models;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * This interface provides a non-blocking API for possibly blocking operations.
 */
@ImplementedBy(JPAUncheckedCropRepository.class)
public interface UncheckedCropRepository {

    CompletionStage<UncheckedCrop> add(UncheckedCrop uncheckedcrop);

    CompletionStage<Stream<UncheckedCrop>> listc();

    CompletionStage<UncheckedCrop> getuc(Long cid);

    UncheckedCrop approveCrop(Long cid);

    CompletionStage<UncheckedCrop> deleteCrop(Long cid);

    Register getFarmer(Long cid);

    UncheckedCrop getUCrop(Long cid);
}
