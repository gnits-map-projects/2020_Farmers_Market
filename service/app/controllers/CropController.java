package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import play.data.FormFactory;
import utils.EmailUtil;


/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class CropController extends Controller {

    private final CropRepository cropRepository;
    private final HttpExecutionContext ec;
    private final FormFactory formFactory;
    private final NotificationRepository notificationRepository;
    private final RegisterRepository registerRepository;
    private final AdminController adminController;
    EmailUtil emailUtil;

    @Inject
    public CropController(FormFactory formFactory,
                          AdminController adminController,
                          EmailUtil emailUtil,
                          NotificationRepository notificationRepository,
                          CropRepository cropRepository,
                          RegisterRepository registerRepository,
                          HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.cropRepository = cropRepository;
        this.adminController = adminController;
        this.emailUtil = emailUtil;
        this.notificationRepository = notificationRepository;
        this.registerRepository = registerRepository;
        this.ec = ec;
    }

    public CompletionStage<Result> addChecked(Crop crop) {
        return cropRepository.add(crop).thenApplyAsync(p -> {
            return ok("Created.");
        }, ec.current());
    }

    public CompletionStage<Result> getFarmerCrops(Long fid) {
        return cropRepository.listfc(fid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getAllFarmerCrops(Long fid) {
        return cropRepository.listAllfc(fid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getCrops() {
        return cropRepository.listc().thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getAllCrops() {
        return cropRepository.listAllc().thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getCropsForBuyer(Long buyerId) {
        return cropRepository.listcForBuyer(buyerId).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getAllCropsForBuyer(Long buyerId) {
        return cropRepository.listAllcForBuyer(buyerId).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> cropsToPay(Long buyerId) {
        return cropRepository.cropsToPay(buyerId).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getOthersCrops(Long fid) {
        return cropRepository.listOthersc(fid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getAllOthersCrops(Long fid) {
        return cropRepository.listAllOthersc(fid).thenApplyAsync(cropStream -> {
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

    public CompletionStage<Result> advPayment() {
        JsonNode jsPayment = request().body().asJson();
        Long buyerId = jsPayment.get("buyerId").asLong();
        Long cropId = jsPayment.get("cropId").asLong();
        Long farmerId = jsPayment.get("fid").asLong();
        Long advancePayment = jsPayment.get("advancePayment").asLong();
        Long priceBade = jsPayment.get("priceBade").asLong();

        CompletionStage<Crop> crop = cropRepository.getc(cropId);
        Crop c = null;
        try {
            c = crop.toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        AdminController adminController = new AdminController(ec, emailUtil);
        Register farmer = registerRepository.getUser(farmerId);
        Register buyer = registerRepository.getUser(buyerId);

        String message = "Your "+c.name+" crop in "+c.location+" has received an advance payment of " +advancePayment+ "₹ from " +buyer.name+".";
        CompletionStage<Result> n = notificationController.addNotification(farmer.id, message);
        adminController.sendEmail(farmer.email, "Advance Payment received.", message +
                "You may contact them on their email: "+buyer.email+
                "<br/><hr/>We wish you a prosperous crop.");

        message = "Your payment of "+advancePayment+"₹ for "+c.name+" crop in "+c.location+" has been processed.";
        n = notificationController.addNotification(buyer.id, message);
        adminController.sendEmail(buyer.email, "Advance Payment Processed.", message +
                "<h1>Payment Receipt</h1><hr/>" +
                "Total tentative amount: "+priceBade+"₹<br/>" +
                "Amount paid as advance: "+advancePayment+"₹<br/><hr/>" +
                "Thank you.");

        return cropRepository.advPayment(cropId, advancePayment).thenApplyAsync(str -> {
            return ok("Advance payment successful.");
        }, ec.current());
    }
}
