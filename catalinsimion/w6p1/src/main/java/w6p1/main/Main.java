package w6p1.main;


import w6p1.file.CustomDay;

import java.util.Date;

public class Main {



    public static void main(String[] args) {
        Date date=new Date(2020,3,6);
        System.out.println("Day: "+ CustomDay.valueOf(date.getDay()));

    }
}
