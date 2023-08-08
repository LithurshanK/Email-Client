import java.io.Serializable;
import java.time.LocalDate;

// Email objects for mails sent
public class Email implements Serializable {
    private String recipient;
    private String subject;
    private String content;
    private LocalDate dateSent; // the date the mail was sent
    public Email(String recipient, String subject, String content) {
        this.recipient = recipient;
        this.subject = subject;
        this.content = content;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDateSent() {
        return dateSent;
    }

    public void setDateSent(LocalDate dateSent) {
        this.dateSent = dateSent;
    }
}
