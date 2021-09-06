/**
 * Addison Tancredi
 * 4/4/20
 * Week 4
 */

package Carlys_Catering;
/**
 * EventDemo is used to create Event objects based on user input and display the information
 * about the created events.
 */

import java.util.Scanner;

import sammys_Seashore.Rental;

public class EventDemo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Event[] events = new Event[8];
        init(events);
        execute(events);
        return;
    }

    /**
     * Initialize the events array
     *
     * @param events
     */
    private static void init(Event[] events) {
        for (int x = 0; x < events.length; ++x) {
            String eventNum = askUserForEventNumber();
            int guests = askUserForGuests();
            int type = getType();
            events[x] = new Event(eventNum, guests, type);
        }
    }

    /**
     * Starts the main event loop
     *
     * @param events
     */
    private static void execute(Event[] events) {
        int userinput; 
        userinput= getUserInput();
        while(true) {
        System.out.println("\n\nNow display the rentals");
        System.out.println("Choose option: " + userinput);
        switch (userinput) {
        case 1:
        	sortByEventNumber(events); 
        	 userinput= getUserInput();
        case 2:
            sortByGuests(events);
            userinput= getUserInput();
        case 3:
        	sortByType(events);
        	 userinput= getUserInput();
        case 4:
            System.exit(0);
        default:
            userinput = getUserInput();
            System.out.println("Invalid value, please re-enter.");
        		}
        	}
        }
    /**
     * method to ask user to display or quit.
     *
     * @return
     */
    public static int getUserInput() {
        Scanner input = new Scanner(System.in);
        int option;
        displayMenu();

        option = input.nextInt();
        input.nextLine();
        return option;
    }

    /**
     * Prints the main menu
     */
    private static void displayMenu() {
        System.out.println("\nPlease enter an option to sort events");
        System.out.println("\t1 - by event number");
        System.out.println("\t2 - by number of guests");
        System.out.println("\t3 - by event type");
        System.out.println("\t4 - to quit");
    }

    /**
     * Asks the user for the event number.
     * @catch 
     * @return The event number provided by the user.
     */
    public static String askUserForEventNumber() {
        String eventNumber = "0";
        int n = -1;
        while (n < 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter event number >> ");
            eventNumber = input.nextLine();
            try {
                n = Integer.parseInt(eventNumber);
                if (n < 0) {
                    System.out.print("Invalid event number(Enter non negative number)");
                }
            } catch (NumberFormatException ne) {
                System.out.print("Invalid event number(Please input a positive numerical value.)");
            }
        }
        return eventNumber;
    }

    /**
     * Asks the user for the number of guests until a valid response is given.
     *
     * @return The number of guests provided by the user.
     */
    public static int askUserForGuests() {
        int guests;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;

        System.out.print("Enter number of guests >> ");
        guests = input.nextInt();
        while (guests < MIN_GUESTS || guests > MAX_GUESTS) {
            System.out.println("The number of guests must be between " +
                    MIN_GUESTS + " and " + MAX_GUESTS);
            System.out.print("Please renter >> ");
            guests = input.nextInt();
        }
        input.nextLine();
        return guests;
    }


    /**
     * Asks the user for the Event Type
     *
     * @return The Event Type provided by the user
     */
    public static int getType() {
        int eventType = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Event types are");
        for (int x = 0; x < Event.EVENT_TYPES.length; ++x)
            System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
        while (eventType < 0) {
            System.out.print("Enter Event type >> ");
            eventType = input.nextInt();
            if (eventType < 0 || eventType > Event.EVENT_TYPES.length - 1) {
                System.out.println("Invalid Type ID(Enter id between 0-" + (Event.EVENT_TYPES.length - 1) + ") ");
            }
        }
        return eventType;
        }
      


    /**
     * This method to sort Events in ascending order by event number
     *
     * @param array
     */
    public static void sortByEventNumber(Event[] array) {
        Event temp;
        String current, next;
        int length = array.length - 1;

        for (int a = 0; a < length; ++a)
            for (int b = 0; b < length; ++b) {
                current = array[b].getEventNumber();
                next = array[b + 1].getEventNumber();

                if (current.compareTo(next) > 0) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }

        displayDetails(array);
    }

    /**
     * method to sort Events in ascending order by Guest
     *
     * @param array
     */
    public static void sortByGuests(Event[] array) {
        Event temp;
        int length = array.length - 1;

        for (int a = 0; a < length; ++a)
            for (int b = 0; b < length; ++b) {
                if (array[b].getGuests() > array[b + 1].getGuests()) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        displayDetails(array);
    }


    /**
     * This method to sort Events in ascending order by Type
     *
     * @param array
     */
    public static void sortByType(Event[] array) {
        Event temp;
        int length = array.length - 1;
        for (int a = 0; a < length; ++a)
            for (int b = 0; b < length; ++b) {
                if (array[b].getEventTypeID() > array[b + 1].getEventTypeID()) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        displayDetails(array);
    }

    /**
     * Prints out the information about the given Events
     *
     * @param array
     */
    public static void displayDetails(Event[] array) {
        for (int a = 0; a < array.length; ++a) {
            displayDetail(array[a]);
        }
    }


    /**
     * Prints out the information about the given Event
     *
     * @param e The Event to display the details of
     */
    public static void displayDetail(Event e) {
        System.out.println("\nEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests() +
                " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
        System.out.println("Whether this is a large event is " +
                (e.getGuests() >= e.LARGE_EVENT));
        System.out.println("The event is type " + e.getEventTypeID() + " which is the following type: " + e.getEventTypeName());
    }
}
