import java.util.Scanner;

public class Email_Client {

    public static void main(String[] args) {
        MailFactory mailFactory = new MailFactory();
        mailFactory.startFactory();
        Scanner scanner = new Scanner(System.in);
        System.out.println(""" 
Enter option type:\s 
1 - Adding a new recipient 
2 - Sending an email 
3 - Printing out all the recipients who have birthdays 
4 - Printing out details of all the emails sent 
5 - Printing out the number of recipient objects in the application 
Other Integers - Stop Email_Client""");
        while(scanner.hasNextInt()) {

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
// Use a single input to get all the details of a recipient
// store details in clientList.txt file
                    System.out.println(""" 
input formats \s 
Official: name,email.com,designation 
Office_friend: name,email,designation,Birthday(yyyy/MM/dd) 
Personal: name,<nick-name>,email,Birthday(yyyy/MM/dd) 
""");
                    String details = scanner.nextLine();
                    mailFactory.storeDetails(details);
                    break;
                case 2:
// input format - email, subject, content
// code to send an email
                    System.out.println("input format - email, subject, content");
                    String[] mail = scanner.nextLine().split(",");
                    mailFactory.sendMail(mail[0], mail[1], mail[2]);

                    break;
                case 3:
// code to print recipients who have birthdays on the given date
                    System.out.println("input format - yyyy/MM/dd");
                    String dateInput = scanner.nextLine();
                    mailFactory.printBirthdayRecipients(dateInput);
                    break;

                case 4:
// code to print the details of all the emails sent on the input date
                    System.out.println("input format - yyyy/MM/dd");
                    String date = scanner.nextLine();
                    mailFactory.printMails(date);
                    break;
                case 5:
// code to print the number of recipient objects in the application
                    mailFactory.recipientCount();
                    break;
            }
            if (option>5 || option<1){
                mailFactory.stopFactory();
                break;
            }
            System.out.println(""" 
Enter option type:\s 
1 - Adding a new recipient 
2 - Sending an email 
3 - Printing out all the recipients who have birthdays 
4 - Printing out details of all the emails sent 
5 - Printing out the number of recipient objects in the application 
Other Integers - Stop Email_Client""");
        }
        scanner.close();
    }
}
