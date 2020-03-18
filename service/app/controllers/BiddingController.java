package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
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
    EmailUtil emailUtil;

    @Inject
    public BiddingController(CropRepository cropRepository, CropController cropController, RegisterRepository registerRepository, RegisterController registerController, BiddingRepository biddingRepository, HttpExecutionContext ec, FormFactory formFactory, AdminController adminController, EmailUtil emailUtil) {
        this.biddingRepository = biddingRepository;
        this.ec = ec;
        this.cropController = cropController;
        this.cropRepository = cropRepository;
        this.registerController = registerController;
        this.registerRepository = registerRepository;
        this.adminController = adminController;
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

    public CompletionStage<Result> getCropBids(Long cid) {
        return biddingRepository.listcb(cid).thenApplyAsync(cropStream -> {
            return ok(toJson(cropStream.collect(Collectors.toList())));
        }, ec.current());
    }

    public CompletionStage<Result> getBidTrends(Long cid) {
        return biddingRepository.listbt(cid).thenApplyAsync(bidTrend -> {
            return ok(toJson(bidTrend));
        }, ec.current());
    }

    public CompletionStage<Result> acceptBid(Long bid, Long cid){
        CompletionStage<Crop> crop = cropRepository.updateCrop(cid, "closed");
        Register register = biddingRepository.getBuyer(bid);
        AdminController adminController = new AdminController(ec,emailUtil);
        Result res = adminController.sendBidAcceptedEmail(register.email); //to buyer
        return biddingRepository.acceptBid(bid, cid).thenApplyAsync(p->{
            return ok("update successful");
        },ec.current());

    }

    public CompletionStage<Result> rejectBid(Long bid){
        return biddingRepository.rejectBid(bid).thenApplyAsync(p->{
            return ok("update successful");
        },ec.current());

    }

}