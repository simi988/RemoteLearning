package w14p1.file;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.time.ZonedDateTime;

public class EventManagement {

    private String summary;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String location;
    private List<EventManagement> eventManagementList = new ArrayList<>();

    public EventManagement(ZonedDateTime startDate, ZonedDateTime endDate, String summary) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;

    }

    public EventManagement(ZonedDateTime startDate, ZonedDateTime endDate, String summary, String location) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
        this.location = location;

    }

    public void addEvent(EventManagement eventManagement) {
        eventManagementList.add(eventManagement);
        System.out.println(eventManagementList);

    }

    public List<EventManagement> nextWeekEvents() {
        LocalDate today = LocalDate.now();
        LocalDate nextSATURDAY = today.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        LocalDate nextSUNDAY = today.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        LocalDateTime localDateTime = nextSATURDAY.atStartOfDay();
        LocalDateTime localDateTime2 = nextSUNDAY.atStartOfDay();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime zonedDateTime2 = localDateTime2.atZone(ZoneId.of("Europe/Bucharest"));
        List<EventManagement> myEvent = new ArrayList<>();
        for (EventManagement event : eventManagementList) {
            if (zonedDateTime.toLocalDate().equals(event.startDate.toLocalDate())) {
                System.out.println(event.toString());
                myEvent.add(event);
            }
            if (zonedDateTime2.toLocalDate().equals(event.startDate.toLocalDate())) {
                System.out.println(event.toString());
                myEvent.add(event);
            }
        }
        return myEvent;
    }

    public List<EventManagement> searchEvent(LocalDateTime localDateTime, String zoneTime) {
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(zoneTime));
        List<EventManagement> myEvent = new ArrayList<>();
        for (EventManagement event : eventManagementList) {
            if (zonedDateTime.equals(event.startDate)) {
                System.out.println(event.toString());
                myEvent.add(event);
            }
        }
        return myEvent;
    }

    public List<EventManagement> searchEventInterval(ZonedDateTime startDate, ZonedDateTime endDate) {
        List<EventManagement> myEvent = new ArrayList<>();
        for (EventManagement event : eventManagementList) {
            if (startDate.equals(event.startDate) && endDate.equals(event.endDate)) {
                System.out.println(event.toString());
                myEvent.add(event);
            }
        }
        return myEvent;
    }


}
