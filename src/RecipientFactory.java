import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipientFactory {

    public static int noOfRecipients = 0;
    private ArrayList<Recipient> recipients = new ArrayList<>();
    private ArrayList<BD_Wishable> BD_Guys = new ArrayList<>();


    // create a Recipient from given details
    public void createRecipient(String[] detailList){
        Recipient recipient = null;
        String type = detailList[0];
        String[] info = detailList[1].split(",");

        if (type.equals("Official")){
            recipient = new OfficialRecipient(info[0],info[1],info[2]);
        } else if (type.equals("Office_friend")) {
            recipient = new Office_friend(info[0],info[1],info[2],info[3]);
            BD_Guys.add((BD_Wishable) recipient);
        } else if (type.equals("Personal")) {
            if (info.length==4) {
                recipient = new PersonalRecipient(info[0], info[1], info[2], info[3]);
            }
            else {
                recipient = new PersonalRecipient(info[0], info[1], info[2]);
            }
            BD_Guys.add((BD_Wishable) recipient);
        }
        else {
            System.out.println("Invalid Input");
        }
        recipients.add(recipient);
        noOfRecipients++;
    }

    // make Recipient objects from clientList.txt
    public void makeRecipients() {
        try {
            FileReader reader = new FileReader("clientList.txt");
            Scanner reader1 = new Scanner(reader);

            while(reader1.hasNextLine()){
                String details = reader1.nextLine();
                String[] detailList = details.split(":");
                createRecipient(detailList);
            }
            reader1.close();

        } catch (FileNotFoundException ex) {
            System.out.println("clientList.txt does not exist. Add new recipient to continue");
        }
    }

    // store details input to clientList.txt
    public void storeDetails(String details){
        try{
            FileWriter fw = new FileWriter("clientList.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(details);
            bw.newLine();
            bw.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // getters
    public ArrayList<Recipient> getRecipients() {
        return recipients;
    }

    public ArrayList<BD_Wishable> getBD_Guys() {
        return BD_Guys;
    }

    public int getNoOfRecipients() {
        return noOfRecipients;
    }

    // print all the recipients who have birthdays on a given date.
    public void printBirthdayRecipients(String dateInput){
        LocalDate date = Date.dateMaker(dateInput);
        for (BD_Wishable b: BD_Guys){
            LocalDate birthday = b.birthDate();
            if (Date.compareMonthAndDay(date,birthday)){
                System.out.println(((Recipient)b).getName());
            }
        }
    }
}
