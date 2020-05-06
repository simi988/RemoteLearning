package w14p1.file;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EventManagementTest {
    @Test
    public void addTest() {
        List<EventManagement> eventManagementList = new ArrayList<>();
        LocalDateTime dateStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime dateEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        LocalDateTime saturdayStart = LocalDateTime.of(2020, Month.MAY, 9, 06, 30);
        LocalDateTime sundayEnd = LocalDateTime.of(2020, Month.MAY, 10, 06, 30);
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        EventManagement eventManagementLocation = new EventManagement(saturdayStart, sundayEnd, "Muma lui de examen", "Somesului nr 14 ");
        eventManagementList.add(eventManagement);
        eventManagementList.add(eventManagementLocation);
        assertEquals(2, eventManagementList.size());
    }

    @Test
    public void nextWeekTest() {
        LocalDateTime saturdayStart = LocalDateTime.of(2020, Month.MAY, 9, 06, 30);
        LocalDateTime sundayEnd = LocalDateTime.of(2020, Month.MAY, 10, 06, 30);
        EventManagement eventManagementLocation = new EventManagement(saturdayStart, sundayEnd, "Muma lui de examen", "Somesului nr 14 ");
        eventManagementLocation.nextWeekEvents();
        assertEquals("w14p1.file.EventManagement@1b0375b3", eventManagementLocation.toString());

    }

    @Test
    public void searchEventTest() {
        LocalDateTime dateStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime dateEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        LocalDate searchDate = LocalDate.of(2020, Month.MAY, 07);
        ZoneId currentZone = ZoneId.systemDefault();
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        eventManagement.searchEvent(searchDate, currentZone);
        assertEquals("w14p1.file.EventManagement@2c8d66b2", eventManagement.toString());
    }

    @Test
    public void searchEventIntervalTest() {
        LocalDateTime dateStart = LocalDateTime.of(2020, Month.MAY, 7, 06, 30);
        LocalDateTime dateEnd = LocalDateTime.of(2020, Month.MAY, 8, 06, 30);
        EventManagement eventManagement = new EventManagement(dateStart, dateEnd, "Muma lui de examen");
        eventManagement.searchEventInterval(dateStart, dateEnd);
        assertEquals("w14p1.file.EventManagement@2d209079", eventManagement.toString());
    }

}
