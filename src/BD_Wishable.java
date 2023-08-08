import java.time.LocalDate;

//interface for recipient classes which can be wihsed for birthday
interface BD_Wishable{
    // return Birthday Wish Email to send
    Email birthDayWish();
    // return Birthday as LocalDate Object
    LocalDate birthDate();
    // return BD_Wishable mail as String
    String getMail();

    Boolean isBirthday();
}