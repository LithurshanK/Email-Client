import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonalRecipient extends Recipient implements BD_Wishable{
    private String nickName,birthDate;
    public PersonalRecipient(String name,String nickName, String email, String birthDate) {
        super(name,email);
        this.nickName = nickName;
        this.birthDate = birthDate;
    }

    public PersonalRecipient(String name, String email, String birthDate) {
        super(name, email);
        this.birthDate = birthDate;
    }

    @Override
    public Email birthDayWish() {
        Email email = new Email(this.getEmail(),"Birthday Wish", "hugs and love on your birthday. Lithurshan K.");
        return email;
    }

    @Override
    public String getMail() {
        return this.getEmail();
    }

    @Override
    public LocalDate birthDate() {
        return Date.dateMaker(this.birthDate);
    }

    @Override
    public Boolean isBirthday() {
        return Date.compareMonthAndDay(this.birthDate(),LocalDate.now());
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
