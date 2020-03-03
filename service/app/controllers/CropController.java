package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Crop;
import models.CropRepository;
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
public class CropController extends Controller {

    private final CropRepository cropRepository;
    private final HttpExecutionContext ec;
    private final FormFactory formFactory;

    @Inject
    public CropController(FormFactory formFactory, CropRepository cropRepository, HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.cropRepository = cropRepository;
        this.ec = ec;
    }

    public CompletionStage<Result> addChecked(Crop crop) {
//        JsonNode js = request().body().asJson();
//        Crop crop = fromJson(js, Crop.class);
        return cropRepository.add(crop).thenApplyAsync(p -> {
            return ok("Created.");
        }, ec.current());
    }

    public CompletionStage<Result> getFarmerCrops(Long fid) {
        return cropRepository.listfc(fid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getCrops() {
        return cropRepository.listc().thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getCrop(Long cid) {
        return cropRepository.getc(cid).thenApplyAsync(crop -> {
            return ok(toJson(crop));
        }, ec.current());
    }

    public CompletionStage<Result> cropsIn(String location) {
        return cropRepository.listCinL(location).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getLocations() {
        return cropRepository.listl().thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getCropTypes(String location) {
        return cropRepository.listct(location).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }
}
