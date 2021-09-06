/**
 * Addison Tancredi
 * 4/4/20
 * Week 4
 */
package sammys_Seashore;

import java.util.Scanner;

public class LessonWithRentalDemo {
    public static void main(String args[]) {
        LessonWithRental[] lessonWithRentals = new LessonWithRental[4];

        int option;
        String contractNum;
        int minutes;
        int typeid;
        final int QUIT = 9;
        int x;
        //loop to Fill the array with 4 LessonWithRental objects created based on user input
        for (x = 0; x < lessonWithRentals.length; ++x) {
            contractNum = getContractNumber();
            minutes = getMinutes();
            typeid = getType();
            lessonWithRentals[x] = new LessonWithRental(contractNum, minutes, typeid);
        }
        //Display the details for each object in the array.
        System.out.println("\n\nNow display the rentals");

        for (LessonWithRental lessonWithRental : lessonWithRentals) {
            displayDetails(lessonWithRental);
        }
    }

    /**
     * Asks the user for the contract number
     *
     * @return The contract number provided by the user
     */
    public static String getContractNumber() {
        String num = "";
        int n = -1;
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter contract number >> ");
        num = input.nextLine();
        return num;
    }

    /**
     * Asks the user for the contract minutes
     *
     * @return The contract minutes provided by the user
     */
    public static int getMinutes() {
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
        for (int x = 0; x < Equipment.EQUIPMENT_NAMES.length; ++x) {
            System.out.println("   " + x + "  " + Equipment.EQUIPMENT_NAMES[x]);
        }

        while (equipmentType < 0) {
            System.out.print("Enter equipment type >> ");
            equipmentType = input.nextInt();
            if (equipmentType < 0 || equipmentType > Equipment.EQUIPMENT_NAMES.length - 1) {
                System.out.println("Invalid Type ID(Enter id between 0-" + (Equipment.EQUIPMENT_NAMES.length - 1) +") ");
            }
        }
        return equipmentType;
    }


    /**
     * Displays the details
     *
     * @param r
     */
    public static void displayDetails(LessonWithRental r) {
        System.out.println("\nContract #" + r.getContractNumber());
        System.out.println("For a rental of " + r.getHours() +
                " hours and " + r.getExtraMinutes() +
                " minutes,\n    at a rate of $" + r.HOUR_RATE +
                " per hour and $1 per minute,\n    the price is $" + r.getPrice());
        System.out.println("Equipment rented is type #" + r.getEquipment().getEquipmentTypeID() +
                "  " + r.getEquipment().getEquipmentTypeName());
        System.out.println(r.getInstructor());
    }
}
