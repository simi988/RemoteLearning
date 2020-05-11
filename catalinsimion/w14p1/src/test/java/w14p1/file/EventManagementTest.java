package w14p1.file;

import org.junit.Test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EventManagementTest {
    @Test
    public void addTest() {
        List<EventManagement> eventManagementList = new ArrayList<>();
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        ZonedDateTime dateStart = localDateTimeStart.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime dateEnd = localDateTimeEnd.atZone(ZoneId.of("Europe/Bucharest"));
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        eventManagementList.add(eventManagement);
        assertEquals(1, eventManagementList.size());
    }

    @Test
    public void nextWeekTest() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020, Month.MAY, 10, 06, 30);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020, Month.MAY, 10, 07, 30);
        ZonedDateTime saturdayStart = localDateTimeStart.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime sundayEnd = localDateTimeEnd.atZone(ZoneId.of("Europe/Bucharest"));
        EventManagement eventManagementLocation = new EventManagement(saturdayStart, sundayEnd, "Muma lui de examen", "Somesului nr 14 ");
        eventManagementLocation.addEvent(eventManagementLocation);
        List<EventManagement> eventManagementList = eventManagementLocation.nextWeekEvents();
        assertEquals(1,eventManagementList.size());
    }

    @Test
    public void searchEventTest() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        ZonedDateTime dateStart = localDateTimeStart.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime dateEnd = localDateTimeEnd.atZone(ZoneId.of("Europe/Bucharest"));
        LocalDateTime searchDate =  LocalDateTime.of(2020, Month.MAY, 7,06,30);
        String zone = "Europe/Bucharest";
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        eventManagement.addEvent(eventManagement);
        List<EventManagement> eventManagementList = eventManagement.searchEvent(searchDate, zone);
        assertEquals(1,eventManagementList.size());
    }

    @Test
    public void searchEventIntervalTest() {
        LocalDateTime localDateTimeStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        ZonedDateTime dateStart = localDateTimeStart.atZone(ZoneId.of("Europe/Bucharest"));
        ZonedDateTime dateEnd = localDateTimeEnd.atZone(ZoneId.of("Europe/Bucharest"));
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        eventManagement.addEvent(eventManagement);
        List<EventManagement> eventManagementList = eventManagement.searchEventInterval(dateStart, dateEnd);
        assertEquals(1, eventManagementList.size());
    }

}
