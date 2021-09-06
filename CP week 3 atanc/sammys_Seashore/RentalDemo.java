/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package sammys_Seashore;

import java.util.Scanner;

/**
 * RentalDemo is used to create Rental objects based on user input and display the information
 * about the created rentals.
 */
public class RentalDemo {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int userinput;
        Rental[] rentals = new Rental[8];   //array of eight Rental objects.
        init(rentals);
        //Display the details for each object in the array.
        execute(rentals);
    }
    /**
     * Starts the main rentals loop
     *
     * @param rentals
     */
    private static void execute(Rental[] rentals) {
        int userinput; 
        userinput= getUserInput();
        while(true) {
        System.out.println("\n\nNow display the rentals");
        System.out.println("Choose option: " + userinput);
        switch (userinput) {
        case 1:
        	sortByContractNumber(rentals); 
        	 userinput= getUserInput();
        case 2:
            sortByPrice(rentals);
            userinput= getUserInput();
        case 3:
        	sortByType(rentals);
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
     * loop to Fill the array with 8 Rental objects created based on user input
     *
     * @param rentals
     */
    private static void init(Rental[] rentals) {
        for (int x = 0; x < rentals.length; ++x) {
            String contractNum = askUserForContractNumber();
            int minutes = askUserForMinutes();
            int typeid = getType();
            rentals[x] = new Rental(contractNum, minutes, typeid);
        }
    }

    /**
     * method to ask user for choice whether to display or quit.
     *
     * @return
     */
    public static int getUserInput() {
        System.out.println("\t1 - by contract number");
        System.out.println("\t2 - by price");
        System.out.println("\t3 - by equipment type");
        System.out.println("\t4 - to quit");
        int userinput = input.nextInt();
        input.nextLine();
        return userinput;
    }

    /**
     * method to sort Rentals in ascending order by contract number
     *
     * @param array
     */
    public static void sortByContractNumber(Rental[] array) {
        Rental temp;
        String current, next;
        int length = array.length - 1;

        for (int a = 0; a < length; ++a)

            for (int b = 0; b < length; ++b) {
                current = array[b].getContractNumber();
                next = array[b + 1].getContractNumber();

                if (current.compareTo(next) > 0) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        displayDetails(array);
    }

    /**
     * Display Details
     *
     * @param array
     */
    private static void displayDetails(Rental[] array) {
        for (int a = 0; a < array.length; ++a) {
            displayDetail(array[a]);
        }
    }

    /**
     * method to sort Rentals in ascending order by contract price
     *
     * @param array
     */
    public static void sortByPrice(Rental[] array) {
        Rental temp;
        int length = array.length - 1;

        for (int a = 0; a < length; ++a)

            for (int b = 0; b < length; ++b) {
                if (array[b].getPrice() > array[b + 1].getPrice()) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        displayDetails(array);
    }


    /**
     * method to sort Rentals in ascending order by contract type
     *
     * @param array
     */
    public static void sortByType(Rental[] array) {
        Rental temp;
        int length = array.length - 1;

        for (int a = 0; a < length; ++a)

            for (int b = 0; b < length; ++b) {
                if (array[b].getEquipmentTypeID() > array[b + 1].getEquipmentTypeID()) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;
                }
            }
        displayDetails(array);
    }

    /**
     * Asks the user for the contract number
     *
     * @return The contract number provided by the user
     */
    public static String askUserForContractNumber() {
        String num = "0";
        int n = -1;
        while (n < 0) {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter contract number >> ");
            num = input.nextLine();
            n = Integer.parseInt(num);
            if (n < 0) {
                System.out.print("Invalid contract number(Enter non negative number) ");
            }
        }
        return num;
    }

    /**
     * Asks the user for the contract minutes
     *
     * @return The contract minutes provided by the user
     */
    public static int askUserForMinutes() {
        int minutes;
        final int LOW_MIN = 60;
        final int HIGH_MIN = 7200;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter minutes >> ");
        minutes = input.nextInt();
        while (minutes < LOW_MIN || minutes > HIGH_MIN) {
            System.out.println("Time must be between " + LOW_MIN +
                    " minutes and " + HIGH_MIN + " minutes");
            System.out.print("Please reenter minutes >> ");
            minutes = input.nextInt();
        }
        return minutes;
    }

    /**
     * Asks the user for the contract Type
     *
     * @return The contract type provided by the user
     */
    public static int getType() {
        int equipmentType = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Equipment types:");
        for (int x = 0; x < Rental.EQUIP_TYPES.length; ++x)
            System.out.println("   " + x + "  " + Rental.EQUIP_TYPES[x]);
        while (equipmentType < 0) {
            System.out.print("Enter equipment type >> ");
            equipmentType = input.nextInt();
            if (equipmentType < 0 || equipmentType > Rental.EQUIP_TYPES.length - 1) {
                System.out.println("Invalid Type ID(Enter id between 0-" + (Rental.EQUIP_TYPES.length - 1) +") ");
            }
        }
        return equipmentType;
    }


    /**
     * dispaly method
     *
     * @param r
     */
    public static void displayDetail(Rental r) {
        System.out.println("\nContract #" + r.getContractNumber());
        System.out.println("For a rental of " + r.getHours() +
                " hours and " + r.getExtraMinutes() +
                " minutes,\n    at a rate of $" + r.HOUR_RATE +
                " per hour and $1 per minute,\n    the price is $" + r.getPrice());
        System.out.println("Equipment rented is type #" + r.getEquipmentTypeID() +
                "  " + r.getEquipmentTypeName());
    }
}