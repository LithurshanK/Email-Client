import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.time.LocalDate;
import java.lang.Exception;

public class SendMail {
    public static void sendMail (Email email){
        String recipient = email.getRecipient();
        String subject = email.getSubject();
        String content = email.getContent();
        email.setDateSent(LocalDate.now());
        System.out.println("Preparing to send an email...");
        //store the properties needed to access the SMTP server
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        //sender username(email) and password
        String username = "lithurshan2000ad@gmail.com";
        String password = "aezdiqwxwmtzxfsi";

        //create session objects and pass the credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message = prepareMessage(session,username,recipient,subject,content);
        try{
            Transport.send(message);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Email sent successfully to " + recipient);
    }

    private static Message prepareMessage (Session session, String username, String recepient, String subject, String content){
        Message message = new MimeMessage(session) ;
        try{
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject(subject);
            message.setText(content);
        }catch(Exception e){
            e.printStackTrace();
        }
        return message;
    }

}
