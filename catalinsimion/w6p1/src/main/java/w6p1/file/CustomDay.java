package w6p1.file;

public enum CustomDay {
    MONDAY(1,"Monday"),
    TUESDAY(2,"Tuesday"),
    WEDNESDAY(3,"Wensday"),
    THURSDAY(4,"Wensday"),
    FRIDAY(5,"Wensday"),
    SATURDAY(6,"Wensday"),
    SUNDAY(7,"Wensday");

    CustomDay(int i, String day) {

    }
    public static CustomDay valueOf(int i){
        int day=i%7;
        switch (day){

            case(1):
                return MONDAY;
            case(2):
                return TUESDAY;

            default:return null;
        }

    }
}




