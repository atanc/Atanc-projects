/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package Carlys_Catering;

import java.util.Scanner;

public class GraduationEventDemo {
    public static void main(String argsp[]) {
        GraduationEvent[] events = new GraduationEvent[4];

        for (int x = 0; x < events.length; ++x) {
            String eventNum = getEventNumber();
            int guests = getGuests();
            int appetizer = getAppetizerChoice();
            int entree = getEntreeChoice();
            int sideDish1 = getSideDishChoice();
            int sideDish2 = getSideDishChoice();
            int dessert = getDessertChoice();

            events[x] = new GraduationEvent(eventNum, guests, appetizer, entree, sideDish1, sideDish2, dessert);
        }
        for (GraduationEvent ge : events) {
            displayDetails(ge);
        }
    }


    /**
     * Captures the appetizer choice
     * @return
     */
    public static int getAppetizerChoice() {
        int type = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Appetizer types are");
        for (int x = 0; x < GraduationEvent.APPETIZER_OPTIONS.length; ++x)
            System.out.println("    " + x + " " + GraduationEvent.APPETIZER_OPTIONS[x]);
        while (type < 0 || type > GraduationEvent.APPETIZER_OPTIONS.length - 1) {
            System.out.print("Enter Appetizer type >> ");
            type = input.nextInt();
            if (type < 0 || type > GraduationEvent.APPETIZER_OPTIONS.length - 1) {
                System.out.println("Invalid Appetizer type ID(Enter id between 0-"
                        + (GraduationEvent.APPETIZER_OPTIONS.length - 1) + ") ");
            }
        }
        return type;
    }

    /**
     * Captures the entree choice
     * @return
     */
    public static int getEntreeChoice() {
        int type = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Entree types are");
        for (int x = 0; x < GraduationEvent.ENTREE_OPTIONS.length; ++x)
            System.out.println("    " + x + " " + GraduationEvent.ENTREE_OPTIONS[x]);
        while (type < 0 || type > GraduationEvent.ENTREE_OPTIONS.length - 1) {
            System.out.print("Enter Appetizer type >> ");
            type = input.nextInt();
            if (type < 0 || type > GraduationEvent.ENTREE_OPTIONS.length - 1) {
                System.out.println("Invalid Entree type ID(Enter id between 0-"
                        + (GraduationEvent.ENTREE_OPTIONS.length - 1) + ") ");
            }
        }
        return type;
    }

    /**
     * Captures the side dish choice
     * @return
     */
    public static int getSideDishChoice() {
        int type = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Side Dish types are");
        for (int x = 0; x < GraduationEvent.SIDE_DISH_OPTIONS.length; ++x)
            System.out.println("    " + x + " " + GraduationEvent.SIDE_DISH_OPTIONS[x]);
        while (type < 0 || type > GraduationEvent.SIDE_DISH_OPTIONS.length - 1) {
            System.out.print("Enter Side Dish type >> ");
            type = input.nextInt();
            if (type < 0 || type > GraduationEvent.SIDE_DISH_OPTIONS.length - 1) {
                System.out.println("Invalid Side Dish type ID(Enter id between 0-"
                        + (GraduationEvent.SIDE_DISH_OPTIONS.length - 1) + ") ");
            }
        }
        return type;
    }

    /**
     * Returns the dessert choice
     * @return
     */
    public static int getDessertChoice() {
        int type = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Dessert types are");
        for (int x = 0; x < GraduationEvent.DESSERT_OPTIONS.length; ++x)
            System.out.println("    " + x + " " + GraduationEvent.DESSERT_OPTIONS[x]);
        while (type < 0 || type > GraduationEvent.DESSERT_OPTIONS.length - 1) {
            System.out.print("Enter Dessert type >> ");
            type = input.nextInt();
            if (type < 0 || type > GraduationEvent.DESSERT_OPTIONS.length - 1) {
                System.out.println("Invalid Dessert type ID(Enter id between 0-"
                        + (GraduationEvent.DESSERT_OPTIONS.length - 1) + ") ");
            }
        }
        return type;
    }

    /**
     * Asks the user for the Event Number
     *
     * @return The Event Number provided by the user
     */
    public static String getEventNumber() {
        String num = "0";
        int n = -1;
        while (n < 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter event number >> ");
            num = input.nextLine();
            n = Integer.parseInt(num);
            if (n < 0) {
                System.out.print("Invalid event number(Enter non negative number)");
            }
        }
        return num;
    }

    /**
     * Asks the user for the Event Guests Number
     *
     * @return The Event Guests Number provided by the user
     */
    public static int getGuests() {
        int guests;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of guests >> ");
        guests = input.nextInt();
        //condion to check if the number of guests are within limits: 5 to 100
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
        for (int x = 0; x < Event.EVENT_TYPES.length; ++x) {
            System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
        }

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
     * display details
     *
     * @param e
     */
    public static void displayDetails(GraduationEvent e) {
        System.out.println("\nGraduationEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests() +
                " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
        System.out.println("Whether this is a large event is " +
                (e.getGuests() >= e.LARGE_EVENT));
        System.out.println("The event is type " + e.getEventTypeID() + " which is the following type: " + e.getEventTypeName());
        System.out.println("The menu for this graduation event includes the following: " + e.getMenu());
    }
}
