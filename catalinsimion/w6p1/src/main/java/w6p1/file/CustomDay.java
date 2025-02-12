package w6p1.file;

public enum CustomDay {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

    CustomDay(int value, String day) {
    }

    public static CustomDay valueOf(int value) {
        switch (value) {
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
            case (0):
                return SUNDAY;

            default:
                return null;
        }
    }
}




