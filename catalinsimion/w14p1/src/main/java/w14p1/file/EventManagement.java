package w14p1.file;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class EventManagement {

    String summary;
    LocalDateTime startDate;


    LocalDateTime endDate;
    String location;
    List<EventManagement> eventManagementList = new ArrayList<>();

    public EventManagement(LocalDateTime startDate, LocalDateTime endDate, String summary, String location) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.location = location;
    }

    public EventManagement(LocalDateTime startDate, LocalDateTime endDate, String summary) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }

    public void addEvent(EventManagement eventManagement) {

        eventManagementList.add(eventManagement);
        System.out.println(eventManagementList);

    }

    public void nextWeekEvents() {
        LocalDate today = LocalDate.now();
        LocalDate nextSATURDAY = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate nextSUNDAY = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        for (EventManagement event : eventManagementList) {
            if (nextSATURDAY.equals(event.startDate)) {
                System.out.println(event.toString());
            }
            if (nextSUNDAY.equals(event.startDate)) {
                System.out.println(event.toString());
            }
        }

    }

    public void searchEvent(LocalDate localDate, ZoneId zonedDate) {
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(zonedDate);
        for (EventManagement event : eventManagementList) {
            if (zonedDateTime.equals(event.startDate)) {
                System.out.println(event.toString());
            }

        }

    }

    public void searchEventInterval(LocalDateTime startDate, LocalDateTime endDate) {

        for (EventManagement event : eventManagementList) {
            if (startDate.equals(event.startDate) && endDate.equals(event.endDate)) {
                System.out.println(event.toString());
            }
        }

    }

    @Override
    public String toString() {
        return "EventManagement{" +
                "summary='" + summary + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                '}';
    }
}
