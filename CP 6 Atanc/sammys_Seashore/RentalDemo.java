/**
 * Addison Tancredi
 * 4/11/20
 * Week 5
 */
package sammys_Seashore;

import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import Carlys_Catering.GraduationEvent;

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
     * @catch Prompt user to input a numerical value
     * @return The contract number provided by the user
     */
    public static String askUserForContractNumber() {
    	String num = "0";
        int n = -1;
        
        while (n < 0) {
        	
        	try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter contract number >> ");
            num = input.nextLine();
            n = Integer.parseInt(num);
            if (n < 0){
                throw new NumberFormatException();
        	     }
        	}
           catch (NumberFormatException e)  
           { 
            System.out.println(num + "Invalid contract number(Enter a positive numerical value)");     
           }    
        }
        	 return num; 
    }

    /**
     * Asks the user for the contract minutes
     *@try Looks at the input by the user and determines if the value is between 60 or 7200 or an approximate of the numbers
     *@catch Prompts the user to enter a positive numerical input
     * @return The contract minutes provided by the user
     */
    public static int askUserForMinutes() {
    	int minutes = 0;
        final int LOW_MIN = 60;
        final int HIGH_MIN = 7200;
        Scanner input = new Scanner(System.in);
        boolean flag= false;
        while(!flag)
        {
        	flag=true;
        	try
        	{
        		System.out.print("Enter minutes >> ");
        		minutes = Integer.parseInt(input.nextLine());
        		if (minutes < LOW_MIN || minutes > HIGH_MIN) {
                  	 throw new NumberFormatException();
        	}
        	}
        	catch(NumberFormatException e)
            {
               flag = false;
               System.out.println("Time must be between " + LOW_MIN  + " minutes and " + HIGH_MIN + " minutes " + "or input a numerical value\n");     
            }
       }
        return minutes;
        }
    /**
     * Asks the user for the contract Type
     *@catch Prompt user to enter a value between 0-9
     *@try if the entry is any character other than 0-9 then it will throw an exception
     *which will prompt the user to input a numerical value between 0-9
     * @return The contract type provided by the user
     */
    public static int getType() {
        int equipmentType = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Equipment types:");
        for (int x = 0; x < Rental.EQUIP_TYPES.length; ++x)
            System.out.println("   " + x + "  " + Rental.EQUIP_TYPES[x]);
        while (equipmentType < 0) {
       	 try
       	 {
       		 System.out.print("Enter equipment type >> ");
                equipmentType = Integer.parseInt(input.nextLine());
                if (equipmentType < 0 || equipmentType > 9)
               	 throw new NumberFormatException();	 
       	 }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid Type ID(Enter a numerical value between 0-9) ");
            }
        }
        return equipmentType;
   }

    /**
     * display method
     *
     * @param r
     */
    public static void displayDetail(Rental r) {
        System.out.println("\nContract #" + r.getContractNumber());
        System.out.println("For a rental of " + r.getHours() +
                " hours and " + r.getExtraMinutes() +
                " minutes,\n    at a rate of $" + r.HOUR_RATE +
                " per hour and $1 per minute,\n    the price is $" + r.getPrice());
        System.out.println("Equipment base price is " + r.getPrice());
        System.out.println("Equipment rented is type #" + r.getEquipment().getEquipmentTypeID() +
                " " + r.getEquipment().getEquipmentTypeName() + "\n");
    }
    public static void writeDataFile(Rental[] rentals)
    {
    	
    	String comma = ",";
    	String s;
    	try {  
    	      File fileObj = new File("C:\\Users\\A\\Documents\\Rentals.txt"); 
    	      
    	      if (fileObj.createNewFile()) {  
    	        System.out.println("File created: " + fileObj.getName());  
    	      } else {  
    	        System.out.println("File already exists.");
    	        FileWriter RentalWriter = new FileWriter("C:\\Users\\Rentals.txt");
    	        RentalWriter.write("");
    	      }  
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();  
    	    }
    	
    	try {  
    		
    	      FileWriter RentalWriter = new FileWriter("C:\\Users\\Rentals.txt");
    	      for(int x = 0; x < rentals.length; ++x)
              {
                  Equipment e = rentals[x].getEquipment();
                  s = rentals[x].getContractNumber() + comma + rentals[x].getHours() + comma + rentals[x].getExtraMinutes() +
                		comma + e.getEquipmentTypeID() + comma + e.getEquipmentTypeName() + comma + rentals[x].getPrice()+System.getProperty("line.separator");
                  RentalWriter.write(s);
              }
    	      RentalWriter.close();
    	      System.out.println("Successfully wrote to the file.");
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    } 
    } 
}