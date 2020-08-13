package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

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
    private final BiddingRepository biddingRepository;
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
                          BiddingRepository biddingRepository,
                          RegisterRepository registerRepository,
                          HttpExecutionContext ec) {
        this.formFactory = formFactory;
        this.cropRepository = cropRepository;
        this.biddingRepository = biddingRepository;
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

    public CompletionStage<Result> getClosedDeals(Long buyerId) {
        return cropRepository.getClosedDeals(buyerId).thenApplyAsync(cropStream -> {
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

    public CompletionStage<Result> closeDeal() {
        JsonNode js = request().body().asJson();
        Long cropId = js.get("cropId").asLong();
        Long buyerId = js.get("buyerId").asLong();
        Float rating = Float.valueOf(js.get("rating").asText());
        return cropRepository.closeDeal(cropId, rating, buyerId).thenApplyAsync(res -> {
            return ok("Deal Closed");
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

        char rupee = '\u20B9'; //₹

        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        AdminController adminController = new AdminController(ec, emailUtil);
        Register farmer = registerRepository.getUser(farmerId);
        Register buyer = registerRepository.getUser(buyerId);

        String message = "Your "+c.name+" crop in "+c.location+" has received an advance payment of " +advancePayment + rupee +" from " +buyer.name+".";
        CompletionStage<Result> n = notificationController.addNotification(farmer.id, message);
        adminController.sendEmail(farmer.email, "Advance Payment received.", message +
                "You may contact them on their email: "+buyer.email+
                "<br/><hr/>We wish you a prosperous crop.");

        message = "Your payment of "+ advancePayment + rupee + " for "+c.name+" crop in "+c.location+" has been processed.";
        n = notificationController.addNotification(buyer.id, message);
        adminController.sendEmail(buyer.email, "Advance Payment Processed.", message +
                "<h1>Payment Receipt</h1><hr/>" +
                "Total tentative amount: "+priceBade+"&#x20b9;<br/>" +
                "Amount paid as advance: "+advancePayment+"&#x20b9;<br/><hr/>" +
                "Thank you.");

        return cropRepository.advPayment(cropId, advancePayment).thenApplyAsync(str -> {
            return ok("Advance payment successful.");
        }, ec.current());
    }

    public CompletionStage<Result> harvestedAndTotalCalculation(){
        JsonNode js = request().body().asJson();
        System.out.println(js);
        Long cropId = js.get("cropId").asLong();
        Float harvestedQuantity = Float.valueOf(js.get("harvestedQuantity").asText());
        System.out.println(harvestedQuantity);
        return cropRepository.harvested(cropId, harvestedQuantity).thenApplyAsync(str -> {
            return ok("Harvested quantity entered successful.");
        }, ec.current());
    }

    public CompletionStage<Result> totalPayment() {
        JsonNode jsPayment = request().body().asJson();
        Long buyerId = jsPayment.get("buyerId").asLong();
        Long cropId = jsPayment.get("cropId").asLong();
        Long farmerId = jsPayment.get("fid").asLong();
        Float rating = Float.valueOf(jsPayment.get("rating").asText());

        CompletionStage<Crop> crop = cropRepository.getc(cropId);
        Crop c = null;
        try {
            c = crop.toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        char rupee = '\u20B9'; //₹

        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        AdminController adminController = new AdminController(ec, emailUtil);
        Register farmer = registerRepository.getUser(farmerId);
        Register buyer = registerRepository.getUser(buyerId);

        String message = "Your "+c.name+" crop in "+c.location+" has received remaining payment of " + (c.totalPayable - c.advPayment) + rupee +" from " +buyer.name+".";
        CompletionStage<Result> n = notificationController.addNotification(farmer.id, message);
        adminController.sendEmail(farmer.email, "Total Payment received.", message +
                "You may contact them on their email: "+buyer.email+
                "<br/><hr/>We wish you a prosperous crop.");

        message = "Your total payment of "+ (c.totalPayable - c.advPayment) + rupee + " for "+c.name+" crop in "+c.location+" has been processed.";
        n = notificationController.addNotification(buyer.id, message);
        adminController.sendEmail(buyer.email, "Total Payment Processed.", message +
                "<h1>Payment Receipt</h1><hr/>" +
                "Amount paid : "+ c.advPayment +"&#x20b9;<br/><hr/>" +
                "Total payment received." +
                "Thank you for buying.");

        return cropRepository.totalPayment(cropId, rating, farmerId).thenApplyAsync(str -> {
            return ok("Total payment successful.");
        }, ec.current());
    }

    public void remind(){
        CompletionStage<Stream<Crop>> crop = cropRepository.remind();
        Stream<Crop> c = null;
        List<Crop> crops = new ArrayList<Crop>();
        try {
            c = crop.toCompletableFuture().get();
            crops = c.collect(Collectors.toList());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        AdminController adminController = new AdminController(ec, emailUtil);

        crops.forEach(crp -> {
            Register farmer = registerRepository.getUser(crp.fid);
            CompletionStage<JsonNode> winner = biddingRepository.getWinner(crp.id);
            JsonNode buyer = null;
            try {
                buyer = winner.toCompletableFuture().get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            String message = "Your "+crp.name+" crop in "+crp.location+" is due for harvest and delivery in 5 days.";
            CompletionStage<Result> n = notificationController.addNotification(farmer.id, message);
            adminController.sendEmail(farmer.email, "Harvest and delivery reminder.", message +
                    "Login to your account and fill the harvested amount. The total payable amount will be then calculated."+
                    "<br/>Ignore if already done."+
                    "<br/>You may contact them on their email: "+buyer.get("email").asText()+
                    "You will receive remaining amount for your crop at the time of delivery when your buyer verifies the crop quantity."+
                    "<br/><hr/>We wish you a prosperous crop.");

            message = crp.name+" crop in "+crp.location+" is due for harvest and delivery in 5 days.";
            n = notificationController.addNotification(buyer.get("id").asLong(), message);
            adminController.sendEmail(buyer.get("email").asText(), "Harvest and delivery reminder.", message +
                    "Login to your account to check the harvested crop quantity and proceed to pay remaining amount after you receive the crop."+
                    "<br/>Ignore if already done."+
                    "Thank you for buying.");

            System.out.println(message);
        });
    }
}
