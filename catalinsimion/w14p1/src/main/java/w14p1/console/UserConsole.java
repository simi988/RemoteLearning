package w14p1.console;

import org.w3c.dom.ls.LSOutput;
import w14p1.file.EventManagement;

import java.io.Console;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class UserConsole {
    public void myConsole() {
        Scanner in = new Scanner(System.in);

        ZonedDateTime startDate = getStartDate(in);
        ZonedDateTime endDate = getEndDate(in);
        System.out.println("Enter summary: ");
        String summary = in.nextLine();

        System.out.println("Enter location: ");
        String  location = in.nextLine();

        EventManagement eventWithOutLocation = new EventManagement(startDate, endDate, summary);
        EventManagement eventWithLocation = new EventManagement(startDate, endDate, summary, location);
        System.out.println("Enter 1 for add event: ");
        System.out.println("Enter 2 for see events taking place next weekend: ");
        System.out.println("Enter 3 for search an event: ");
        System.out.println("Enter 4 for search an event in the interval: ");

        System.out.println("Enter your option is: ");
        int option = in.nextInt();
        System.out.println("Your option is "+option);

        switch (option) {
            case 1:
                addEvent(eventWithOutLocation, eventWithLocation);
                break;
            case 2:
                nextWeekend(eventWithOutLocation, eventWithLocation);
                break;
            case 3:
                searchEvent(in, eventWithOutLocation, eventWithLocation);
                break;
            case 4:
                searchEventInterval(in, eventWithOutLocation, eventWithLocation);
            break;
        }
    }

    private void addEvent(EventManagement eventWithOutLocation, EventManagement eventWithLocation) {
        eventWithLocation.addEvent(eventWithLocation);
        eventWithOutLocation.addEvent(eventWithOutLocation);
    }

    private void nextWeekend(EventManagement eventWithOutLocation, EventManagement eventWithLocation) {
        eventWithOutLocation.nextWeekEvents();
        eventWithLocation.nextWeekEvents();
    }

    private void searchEvent(Scanner in, EventManagement eventWithOutLocation, EventManagement eventWithLocation) {

        System.out.println("Enter year event search: ");
        int year = in.nextInt();

        System.out.println("Enter month event search: ");
        int month= in.nextInt();

        System.out.println("Enter day event search: ");
        int day=in.nextInt();

        System.out.println("Enter hour event search: ");
        int hour=in.nextInt();

        System.out.println("Enter minute event search: ");
        int minute=in.nextInt();

        LocalDateTime localDateTime=LocalDateTime.of(year, month,day,hour,minute);

        System.out.println("enter zone time");
        String zoneTime=in.nextLine();

        eventWithLocation.searchEvent(localDateTime,zoneTime);
        eventWithOutLocation.searchEvent(localDateTime,zoneTime);
    }

    private void searchEventInterval(Scanner in, EventManagement eventWithOutLocation, EventManagement eventWithLocation) {

        ZonedDateTime startDate = getStartDate(in);
        ZonedDateTime endDate = getEndDate(in);

        eventWithLocation.searchEventInterval(startDate,endDate);
        eventWithOutLocation.searchEventInterval(startDate,endDate);

    }

    private ZonedDateTime getEndDate(Scanner in) {
        System.out.println("Enter year end: ");
        int yearEnd = in.nextInt();

        System.out.println("Enter month end: ");
        int monthEnd= in.nextInt();

        System.out.println("Enter day end: ");
        int dayEnd=in.nextInt();

        System.out.println("Enter hour end: ");
        int hourEnd=in.nextInt();

        System.out.println("Enter minute end: ");
        int minuteEnd=in.nextInt();

        System.out.println("Enter your timezone start: ");
        String zone= in.nextLine();

        LocalDateTime localDateTimeEnd = LocalDateTime.of(yearEnd, monthEnd, dayEnd, hourEnd, minuteEnd);
        ZonedDateTime endDate = localDateTimeEnd.atZone(ZoneId.of(zone));
        return endDate;
    }

    private ZonedDateTime getStartDate(Scanner in) {
        System.out.println("Enter year start: ");
        int yearStart = in.nextInt();

        System.out.println("Enter month start: ");
        int monthStart= in.nextInt();

        System.out.println("Enter day start: ");
        int dayStart=in.nextInt();

        System.out.println("Enter hour start: ");
        int hourStart=in.nextInt();

        System.out.println("Enter minute start: ");
        int minuteStart=in.nextInt();

        System.out.println("Enter your timezone start: ");
        String zone= in.nextLine();

        LocalDateTime localDateTimeStart = LocalDateTime.of(yearStart, monthStart, dayStart, hourStart, minuteStart);
        ZonedDateTime startDate = localDateTimeStart.atZone(ZoneId.of(zone));
        return startDate;
    }
}
