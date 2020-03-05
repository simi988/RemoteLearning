package w6p1.file;

enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}

public class Days {
    int number;

    public Days(int number) {
        this.number = number;
    }

    public void getDays() {
        number = number % 7;
        if (number == 1) {
            Day day = Day.MONDAY;
            System.out.println(day);
        }
        if (number == 2) {
            Day day = Day.TUESDAY;
            System.out.println(day);
        }
        if (number == 3) {
            Day day = Day.WEDNESDAY;
            System.out.println(day);
        }
        if (number == 4) {
            Day day = Day.THURSDAY;
            System.out.println(day);
        }
        if (number == 5) {
            Day day = Day.FRIDAY;
            System.out.println(day);
        }
        if (number == 6) {
            Day day = Day.SATURDAY;
            System.out.println(day);
        }
        if (number == 7) {
            Day day = Day.SUNDAY;
            System.out.println(day);
        }

    }

}

