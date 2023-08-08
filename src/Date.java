import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    // return String date as LocalDate Object
    public static LocalDate dateMaker(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return LocalDate.parse(date,formatter);
    }

    // compare if two LocalDate objects have same month and same day
    public static boolean compareMonthAndDay(LocalDate date1, LocalDate date2){
        if (date1.getDayOfMonth() == date2.getDayOfMonth() & date1.getMonthValue() == date2.getMonthValue()){




            return true;
        }
        else{
            return false;
        }
    }

}
