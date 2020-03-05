package w6p1.file;

enum Months {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOMBER,
    NOVEMBER,
    DECEMBER;

}

public class Month {
    int number;

    public Month(int number) {
        this.number = number;
    }

    public void getMonth() {
        number = number % 12;
        if (number == 1) {
            Months months = Months.JANUARY;
            System.out.println(months);
        } else if (number == 2) {
            Months months = Months.FEBRUARY;
            System.out.println(months);
        } else if (number == 3) {
            Months months = Months.MARCH;
            System.out.println(months);
        } else if (number == 4) {
            Months months = Months.APRIL;
            System.out.println(months);
        } else if (number == 5) {
            Months months = Months.MAY;
            System.out.println(months);
        } else if (number == 6) {
            Months months = Months.JUNE;
            System.out.println(months);
        } else if (number == 7) {
            Months months = Months.JULY;
            System.out.println(months);
        } else if (number == 8) {
            Months months = Months.AUGUST;
            System.out.println(months);
        } else if (number == 9) {
            Months months = Months.SEPTEMBER;
            System.out.println(months);
        } else if (number == 10) {
            Months months = Months.OCTOMBER;
            System.out.println(months);
        } else if (number == 11) {
            Months months = Months.NOVEMBER;
            System.out.println(months);
        } else if (number == 12) {
            Months months = Months.DECEMBER;
            System.out.println(months);
        }

    }
}

