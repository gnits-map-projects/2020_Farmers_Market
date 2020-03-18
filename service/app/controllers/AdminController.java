package controllers;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import utils.EmailUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class AdminController extends Controller {

    private final HttpExecutionContext ec;
    EmailUtil emailUtil;

    @Inject
    public AdminController(HttpExecutionContext ec, EmailUtil emailUtil) {
        this.ec = ec;
        this.emailUtil = emailUtil;
    }

    public Result sendEmail(String to) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail("Test", toList, "<h2> Test </h2> <br><br> <p> Testing Email </p>"+
                "<a href=\"http://localhost:3000/login\" target=\"_blank\">\n" +
                "                          Click             \n" +
                "                      </a>");
        return ok("successful");
    }

    public Result sendAuthEmail(String to) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail("Test", toList, "<h2> Test </h2> <br><br> <p> Testing Email </p>");
        return ok("successful");
    }

    public Result sendBidAcceptedEmail(String to) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail("Congratulations", toList, "<h2> Your bid has been accepted.</h2><p>Please proceed to the advance payment.<br/></p>" +
                "<a href=\"http://localhost:3000/login\" target=\"_blank\">Farmer's Market</a>");
        return ok("successful");
    }

    public Result sendBidRejectedEmail(String to) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail("Test", toList, "<h2> Test </h2> <br><br> <p> Testing Email </p>");
        return ok("successful");
    }



}
