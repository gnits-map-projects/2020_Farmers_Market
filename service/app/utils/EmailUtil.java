package utils;

import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmailUtil {
    MailerClient mailerClient;

    @Inject
    public EmailUtil(MailerClient mClient) {
        mailerClient = mClient;
    }

    public void sendEmail(String subject, List<String> to, String bodyHtml) {
        Email email = new Email();
        email.setSubject(subject);
        email.setTo(to);
        email.setBodyHtml(bodyHtml);
        email.setFrom("farmers.market.no.reply@gmail.com");
        mailerClient.send(email);
    }
}