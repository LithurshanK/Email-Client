public abstract class Recipient {
    private String name;
    private String email;
    private static int noOfRecipients=0;

    public Recipient(String name, String email) {
        this.name = name;
        this.email = email;
        noOfRecipients+=1;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static int getNoOfRecipients() {
        return noOfRecipients;
    }


}

