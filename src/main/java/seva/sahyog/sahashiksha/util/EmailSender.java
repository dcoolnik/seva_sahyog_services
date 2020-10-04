package seva.sahyog.sahashiksha.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);
    private static final String SAHA_SHIKSHA_EMAIL = "sahashiksha_sevasahyog@gmail.com"; //to be updated

    public static void sendEmail(String recipient, String subject, String body) {
        Session session = Session.getDefaultInstance(getEmailProperties());

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SAHA_SHIKSHA_EMAIL));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            LOGGER.info("Email send successfully to user email address " + recipient);
        } catch (Exception e) {
            LOGGER.error("Error occurred while sending email to user email address {} - {}", recipient, e);
        }
    }

    private static Properties getEmailProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.from", SAHA_SHIKSHA_EMAIL);
        properties.put("mail.smtp.host", "localhost"); // host needs to be replaces with environment specific host
        return properties;
    }

}
