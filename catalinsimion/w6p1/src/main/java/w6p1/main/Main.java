package w6p1.main;

import w6p1.file.CustomDay;
import w6p1.file.CustomMonth;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date date = new Date(2020, 2, 15);
        System.out.println(CustomDay.valueOf(date.getDay()) + " " + CustomMonth.valueOf(date.getMonth() + 1) + " " + date.getYear());


    }
}
