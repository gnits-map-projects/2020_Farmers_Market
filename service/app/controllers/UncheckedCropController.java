package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.UncheckedCrop;
import models.UncheckedCropRepository;
import models.Crop;                                 ///////added for approval
import models.CropRepository;                       ///////added for approval
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.stream.Collectors;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import play.data.FormFactory;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class UncheckedCropController extends Controller {

    private final UncheckedCropRepository uncheckedCropRepository;
    private final CropRepository cropRepository;
    private final HttpExecutionContext ec;
    private final CropController cropController;
    private final FormFactory formFactory;


    @Inject
    public UncheckedCropController(FormFactory formFactory, UncheckedCropRepository uncheckedCropRepository, CropRepository cropRepository, HttpExecutionContext ec,CropController cropController) {           ///////added for approval
        this.uncheckedCropRepository = uncheckedCropRepository;
        this.cropRepository  = cropRepository;                                                                             ///////added for approval
        this.ec = ec;
        this.cropController =cropController;
        this.formFactory = formFactory;
    }

    public CompletionStage<Result> addUncheckedCrop() {
        JsonNode js = request().body().asJson();
        UncheckedCrop uncheckedcrop = fromJson(js, UncheckedCrop.class);
        return uncheckedCropRepository.add(uncheckedcrop).thenApplyAsync(p -> {
            return ok("Created");
        }, ec.current());
    }

    public CompletionStage<Result> getUncheckedCrops() {
        return uncheckedCropRepository.listc().thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getUncheckedCrop(Long cid) {
        return uncheckedCropRepository.getuc(cid).thenApplyAsync(crop -> {
            return ok(toJson(crop));
        }, ec.current());
    }

    public CompletionStage<Result> approveCrop(Long cid) {
        UncheckedCrop uncheckedCrop = uncheckedCropRepository.approveCrop(cid);
        JsonNode js = toJson(uncheckedCrop);
        Crop crop = fromJson(js, Crop.class);
        CompletionStage<UncheckedCrop> cs = uncheckedCropRepository.deleteCrop(cid);///////added for approval
        CropController cropController=new CropController(formFactory, cropRepository, ec);
        return cropController.addChecked(crop).thenApplyAsync(p -> {
            return ok("Approved.");                                                                                       ///////added for approval
        }, ec.current());
    }

//    public CompletionStage<Result> approveCrop(Long cid) {
//        UncheckedCrop uncheckedCrop = uncheckedCropRepository.approveCrop(cid);
//        JsonNode js = toJson(uncheckedCrop);
//        Crop crop = fromJson(js, Crop.class);                                                                           ///////added for approval
//        return cropRepository.add(crop).thenApplyAsync(p -> {
//            return ok("Approved.");                                                                                       ///////added for approval
//        }, ec.current());
//    }


    public CompletionStage<Result> deleteCrop(Long cid) {
        System.out.println("Called delete with id:" + cid);
        return uncheckedCropRepository.deleteCrop(cid).thenApplyAsync(crop -> {
            return ok("Rejected. Deleted.");
        }, ec.current());
    }

//    public CompletionStage<Result> cropsIn(String location) {
//        return cropRepository.listCinL(location).thenApplyAsync(cropStream -> {
//            return ok(toJson(cropStream.collect(Collectors.toList())));
//        }, ec.current());
//    }
//
//    public CompletionStage<Result> getLocations() {
//        return cropRepository.listl().thenApplyAsync(cropStream -> {
//            return ok(toJson(cropStream.collect(Collectors.toList())));
//        }, ec.current());
//    }
}
