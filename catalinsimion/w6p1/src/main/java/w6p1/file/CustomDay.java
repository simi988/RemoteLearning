package w6p1.file;

public enum CustomDay {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");
    private String day;
    private int value;

    CustomDay(int value, String day) {
        this.value = value;
        this.day = day;
    }

    public static CustomDay valueOf(int value) {

        int day = value % 7;

        switch (day) {

            case (1):

                return MONDAY;
            case (2):
                return TUESDAY;
            case (3):
                return WEDNESDAY;
            case (4):
                return THURSDAY;
            case (5):
                return FRIDAY;
            case (6):
                return SATURDAY;
            case (7):
                return SUNDAY;

            default:
                return null;
        }
    }
}




