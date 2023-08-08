import java.time.LocalDate;
public class Office_friend extends OfficialRecipient implements BD_Wishable{
    private String birthDate;

    public Office_friend(String name, String email, String designation, String birthDate) {
        super(name, email, designation);
        this.birthDate = birthDate;
    }

    @Override
    public Email birthDayWish() {
        Email email = new Email(this.getEmail(), "Birthday Wish", "Wish you a Happy Birthday. Lithurshan K.");
        return email;
    }

    @Override
    public LocalDate birthDate() {
        return Date.dateMaker(this.birthDate);
    }

    @Override
    public String getMail() {
        return this.getEmail();
    }

    @Override
    public Boolean isBirthday() {
        return Date.compareMonthAndDay(this.birthDate(),LocalDate.now());
    }

    public String getBirthDate() {
        return birthDate;
    }
}
