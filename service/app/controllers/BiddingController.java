package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import static play.libs.Json.toJson;
import static play.libs.Json.fromJson;
import play.data.FormFactory;
import utils.EmailUtil;


public class BiddingController extends Controller {

    private final BiddingRepository biddingRepository;
    private final HttpExecutionContext ec;
    private final AdminController adminController;
    private final FormFactory formFactory;
    private final RegisterController registerController;
    private final RegisterRepository registerRepository;
    private final CropRepository cropRepository;
    private final CropController cropController;
    private final NotificationRepository notificationRepository;
    EmailUtil emailUtil;

    @Inject
    public BiddingController(NotificationRepository notificationRepository,
                             AdminController adminController,
                             EmailUtil emailUtil,
                             CropRepository cropRepository,
                             CropController cropController,
                             RegisterRepository registerRepository,
                             RegisterController registerController,
                             BiddingRepository biddingRepository,
                             HttpExecutionContext ec, FormFactory formFactory
                             ) {
        this.biddingRepository = biddingRepository;
        this.ec = ec;
        this.cropController = cropController;
        this.cropRepository = cropRepository;
        this.registerController = registerController;
        this.registerRepository = registerRepository;
        this.adminController = adminController;
        this.notificationRepository = notificationRepository;
        this.formFactory = formFactory;
        this.emailUtil = emailUtil;
    }

    public CompletionStage<Result> add() {
        JsonNode js = request().body().asJson();
        Bidding bidding = fromJson(js, Bidding.class);
        return biddingRepository.add(bidding).thenApplyAsync(p -> {
            return ok("Created.");
        }, ec.current());
    }

    public CompletionStage<Result> update() {
        JsonNode js = request().body().asJson();
        return biddingRepository.update(js).thenApplyAsync(p -> {
            return ok("Updated.");
        }, ec.current());
    }

    public CompletionStage<Result> getCropBids(Long cid) {
        return biddingRepository.listcb(cid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getPastBids(Long buyerId) {
        return biddingRepository.listpb(buyerId).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getAllPastBids(Long buyerId) {
        return biddingRepository.listAllpb(buyerId).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getBidTrends(Long cid) {
        return biddingRepository.listbt(cid).thenApplyAsync(bidTrend -> {
            return ok(toJson(bidTrend));
        }, ec.current());
    }

    public CompletionStage<Result> getPreviousBid(Long buyerId, Long cid) {
        return biddingRepository.getPrevBid(buyerId, cid).thenApplyAsync(prevBid -> {
            return ok(toJson(prevBid));
        }, ec.current());
    }

    public CompletionStage<Result> acceptBid(Long bid, Long cid){
        CompletionStage<Crop> crop = cropRepository.updateCrop(cid, "closed");
        Crop c = null;
        try {
            c = crop.toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Register register = biddingRepository.getBuyer(bid);
        String message = "Your bid for "+c.name+" crop in "+c.location+" has won. You may proceed to payment.";
        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        CompletionStage<Result> n = notificationController.addNotification(register.id, message);

        AdminController adminController = new AdminController(ec, emailUtil);
        adminController.sendEmail(register.email, "Crop Bid Won", message);

        List<Register> losers = biddingRepository.getLosers(bid, cid);
        message = "Your bid for "+c.name+" crop in "+c.location+" was not selected. Bidding for this crop has closed";
        String finalMessage = message;
        losers.forEach(loser -> notificationController.addNotification(loser.id, finalMessage));
        losers.forEach(loser -> adminController.sendEmail(loser.email, "Crop Bid Not Selected", finalMessage));

        return biddingRepository.acceptBid(bid, cid).thenApplyAsync(p->{
            return ok("update successful");
        },ec.current());

    }

    public CompletionStage<Result> rejectBid(Long bid, Long cid){
        CompletionStage<Crop> crop = cropRepository.getc(cid);
        Crop c = null;
        try {
            c = crop.toCompletableFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Register register = biddingRepository.getBuyer(bid);
        String message = "Your bid for "+c.name+" crop in "+c.location+" was not selected. Bidding for this crop has closed";
        NotificationController notificationController=new NotificationController(formFactory, notificationRepository, ec);
        CompletionStage<Result> n = notificationController.addNotification(register.id, message);

        AdminController adminController = new AdminController(ec, emailUtil);
        adminController.sendEmail(register.email, "Crop Bid Not Selected", message);
        return biddingRepository.rejectBid(bid).thenApplyAsync(p->{
            return ok("reject successful");
        },ec.current());
    }

    public CompletionStage<Result> getWinner(Long cid) {
        return biddingRepository.getWinner(cid).thenApplyAsync(buyer -> {
            return ok(toJson(buyer));
        }, ec.current());
    }
}