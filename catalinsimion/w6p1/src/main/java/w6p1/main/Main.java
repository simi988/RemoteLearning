package w6p1.main;
import w6p1.file.CustomDay;
import w6p1.file.CustomMonth;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2020, 3, 9);
        System.out.println("Day: " + CustomDay.valueOf((int) date.getTime() + 1));
        System.out.println("Month: " + CustomMonth.valueOf(date.getMonth()));
    }
}
