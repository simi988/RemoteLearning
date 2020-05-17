package w14p1.console;

import w14p1.file.EventManagement;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class UserConsole {
    private EventManagement event;

    public void myConsole() {

        Scanner in = new Scanner(System.in);
        boolean isValid = true;

        while (isValid) {
            getMenu();
            int option = getOption(in);
            if (validateOption(option)) {
                isValid = runOption(in, option);
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    private boolean runOption(Scanner in, int option) {
        switch (option) {
            case 1:
                event = createEvent(in);
                addEvent();
                break;
            case 2:
                nextWeekend(event);
                break;
            case 3:
                searchEvent(in, event);
                break;
            case 4:
                searchEventInterval(in, event);
                break;
            case 5:
                return false;
        }
        return true;
    }

    private boolean validateOption(int option) {
        return option <= 5 && option >= 1;
    }

    private int getOption(Scanner in) {
        int option = 0;
        System.out.println("Enter your option is: ");
        try {
            option = Integer.parseInt(in.next());
        } catch (NumberFormatException e) {
            System.err.println("Insert just numbers!");
        }
        System.out.println("Your option is " + option);
        return option;
    }

    private void getMenu() {
        System.out.println("Enter 1 for add event: ");
        System.out.println("Enter 2 for see events taking place next weekend: ");
        System.out.println("Enter 3 for search an event: ");
        System.out.println("Enter 4 for search an event in the interval: ");
        System.out.println("Enter 5 for exit: ");
        System.out.println();
    }

    private void addEvent() {
        event.addEvent(event);
    }

    private EventManagement createEvent(Scanner in) {
        ZonedDateTime startDate = getStartDate(in);
        ZonedDateTime endDate = getEndDate(in);

        System.out.println("Enter summary: ");
        String summary = in.next();

        System.out.println("Enter location or null: ");
        String location = in.next();

        EventManagement event;
        if (location.equals("null")) {
            event = new EventManagement(startDate, endDate, summary);
        } else {
            event = new EventManagement(startDate, endDate, summary, location);
        }
        return event;
    }

    private void nextWeekend(EventManagement event) {
        List<EventManagement> eventManagementList = event.nextWeekEvents();
        if (eventManagementList.isEmpty()) {
            System.out.println("Not event in weekend");
        }
    }

    private void searchEvent(Scanner in, EventManagement event) {
        boolean isValid = true;
        while (isValid) {
            try {
                in.nextLine();
                System.out.println("Please enter start date (format:dd-MM-yyyy HH:mm): ");
                String next = in.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(next, formatter);
                System.out.println("enter zone time");
                String zoneTime = in.next();
                event.searchEvent(localDateTime, zoneTime);
                isValid = false;
            } catch (DateTimeParseException dateTimeParseException) {
                System.err.println("Invalid date format");
                isValid = true;
            } catch (NullPointerException nullPointerException) {
                System.err.println("Invalid TimeZone format ");
                isValid = true;
            }
        }
    }

    private void searchEventInterval(Scanner in, EventManagement event) {
        ZonedDateTime startDate = getStartDate(in);
        ZonedDateTime endDate = getEndDate(in);
        event.searchEventInterval(startDate, endDate);
    }

    private ZonedDateTime getEndDate(Scanner in) {
        ZonedDateTime zonedDateTime = null;
        boolean isValid = true;
        while (isValid) {
            try {
                System.out.println("Please enter end date (format:dd-MM-yyyy HH:mm;Timezone): ");
                String next = in.nextLine();
                String[] split = next.split(";");
                if (split.length != 2) {
                    throw new IllegalArgumentException();
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(split[0], formatter);
                zonedDateTime = localDateTime.atZone(ZoneId.of(split[1]));
                isValid = false;
            } catch (DateTimeParseException dateTimeParseException) {
                System.err.println("Invalid date format");
                isValid = true;
            } catch (DateTimeException dateTimeException) {
                System.err.println("Invalid TimeZone format ");
                isValid = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("Invalid arguments ");
                isValid = true;
            }
        }
        return zonedDateTime;
    }

    private ZonedDateTime getStartDate(Scanner in) {

        in.nextLine();

        ZonedDateTime zonedDateTime = null;
        boolean isValid = true;

        while (isValid) {
            try {
                System.out.println("Please enter start date (format:dd-MM-yyyy HH:mm;TimeZone): ");
                String next = in.nextLine();
                String[] split = next.split(";");
                if (split.length != 2) {
                    throw new IllegalArgumentException();
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                LocalDateTime localDateTime = LocalDateTime.parse(split[0], formatter);
                zonedDateTime = localDateTime.atZone(ZoneId.of(split[1]));
                isValid = false;

            } catch (DateTimeParseException dateTimeParseException) {
                System.err.println("Invalid date format");
                isValid = true;
            } catch (DateTimeException dateTimeException) {
                System.err.println("Invalid TimeZone format ");
                isValid = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println("Invalid arguments ");
                isValid = true;
            }
        }
        return zonedDateTime;
    }
}