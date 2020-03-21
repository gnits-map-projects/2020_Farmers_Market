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

    public Result sendEmail(String to, String subjectMessage, String bodyMessage) {
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail(subjectMessage, toList, "<h2>"+ subjectMessage +"</h2><p>"+bodyMessage+"</p>"+
                "<a href=\"http://localhost:3000/login\" target=\"_blank\">" +
                    "Farmer's Market" +
                "</a>");
        return ok("successful");
    }

    public Result sendAuthEmail(String to, Long id) {
        System.out.println("SENDING AUTH EMAIL");
        List<String> toList = new ArrayList<String>();
        toList.add(to);
        emailUtil.sendEmail("Test", toList, "<h2>Activation</h2><p>Welcome to Farmer's Market.</p>"+
                "<p>You need to confirm your email address to activate your account.</p>"+
                "<a href=\"http://localhost:3000/verifyEmail/"+id+"\" target=\"_blank\">" +
                    "Activate Account" +
                "</a>");
        return ok("successful");
    }

}
