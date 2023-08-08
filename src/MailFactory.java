import  java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.*;

public class MailFactory {
    private RecipientFactory recipientFactory = new RecipientFactory();

    private ArrayList<Recipient> recipients = recipientFactory.getRecipients();
    private ArrayList<BD_Wishable> BD_Guys = recipientFactory.getBD_Guys();
    private ArrayList<Email> mailList = new ArrayList<>();

    private MailHandler mailHandler = new MailHandler();

    // start the factory
    public void startFactory(){
        System.out.println("Start MailFactory");
        getMails();
        recipientFactory.makeRecipients();
        sendWishes();
    }

    // stop the factory
    public void stopFactory(){

        saveMails();
        System.out.println("Stop MailFactory");
    }

    // store details input to clientList.txt
    public void storeDetails(String details){
        recipientFactory.storeDetails(details);
        String[] detailList = details.split(":");
        recipientFactory.createRecipient(detailList);
        sendWish((BD_Wishable) BD_Guys.get(BD_Guys.size()-1));
    }

    // send a mail
    public void sendMail(String recipient, String subject, String content ){
        Email email = new Email(recipient,subject,content);
        mailList.add(email);
        SendMail.sendMail(email);
    }

    // send wish if wish able recipient have birthday today
    private void sendWish(BD_Wishable BDGuy){
        if (BDGuy.isBirthday()) {
            Email wishEmail = BDGuy.birthDayWish();
            mailList.add(wishEmail);
            SendMail.sendMail(wishEmail);
        }
    }

    // send wish to all the recipients to be wished if they haven't been wished yet.
    private void sendWishes(){
        for(BD_Wishable b: BD_Guys) {
            BD_Wishable BDGuy = (BD_Wishable) b;
            if (BDGuy.isBirthday()) {
                boolean wished = false;
                for (Email e: mailList){
                    if (e.getRecipient().equals(BDGuy.getMail()) && e.getSubject().equals("Birthday Wish")){
                        wished = true;
                        break;
                    }
                }
                if (!wished) {
                    sendWish(BDGuy);
                }
            }

        }
    }

    // print all the recipients with birthdays im the input date
    public void printBirthdayRecipients(String dateInput){
        recipientFactory.printBirthdayRecipients(dateInput);
    }

    public void printMails(String dateInput){
        LocalDate date = Date.dateMaker(dateInput);
        if(!mailList.isEmpty()){
            for (Email e: mailList){
                if (date.equals(e.getDateSent())){
                    System.out.println( "Recipient: " + e.getRecipient() + ", Subject: " + e.getSubject() + ", Content: " + e.

                            getContent() + "\n");
                }
            }
        }
    }

    // print no of email recipients
    public void recipientCount(){
        System.out.println(recipientFactory.getNoOfRecipients());
    }

    // save sent Emails arraylist in Mail.ser as serialized object
    private void saveMails(){
        mailHandler.serialize(mailList);
    }

    // Deserialize Mails.ser and save sent mails in mailList.
    private void getMails(){
        try {
            mailList=(ArrayList<Email>) mailHandler.deserialize();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

}
