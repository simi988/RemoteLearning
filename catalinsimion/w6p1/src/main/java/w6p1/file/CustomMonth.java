package w6p1.file;

public enum CustomMonth {
    JANUARY(1, "January"),
    FEBRUARY(2, "February"),
    MARCH(3, "March"),
    APRIL(4, "April"),
    MAY(5, "May"),
    JUNE(6, "June"),
    JULY(7, "July"),
    AUGUST(8, "August"),
    SEPTEMBER(9, "September"),
    OCTOBER(10, "October"),
    NOVEMBER(11, "November"),
    DECEMBER(12, "December");

    private int i;
    private String month;

    CustomMonth(int i, String month) {
        this.i = i;
        this.month = month;
    }

    public static CustomMonth valueOf(int i) {
        switch (i) {
            case (1):
                return CustomMonth.JANUARY;
            case (2):
                return CustomMonth.FEBRUARY;
            case (3):
                return CustomMonth.MARCH;
            case (4):
                return CustomMonth.APRIL;
            case (5):
                return CustomMonth.MAY;
            case (6):
                return CustomMonth.JUNE;
            case (7):
                return CustomMonth.JULY;
            case (8):
                return CustomMonth.AUGUST;
            case (9):
                return CustomMonth.SEPTEMBER;
            case (10):
                return CustomMonth.OCTOBER;
            case (11):
                return CustomMonth.NOVEMBER;
            case (12):
                return CustomMonth.DECEMBER;

            default:
                return null;
        }
    }
}


