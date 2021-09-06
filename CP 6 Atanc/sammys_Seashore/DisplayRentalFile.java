/**
 * Addison Tancredi
 * 4/21/20
 * Week 6
 */
package sammys_Seashore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayRentalFile {
/**
 * This program displays the rental file. 
 */
	public static void main(String[] args) {
	    try {
	    	 // Specify the filename and path
	      File ReaderObj = new File("C://Users//Public//Rentals.txt");
	      //read the contents of the text file using scanner
	      Scanner myReader = new Scanner(ReaderObj);
	      //while loop return true until it reaches end of the file
	      while (myReader.hasNextLine()) {
	    	  //take the line from file and store into string Variable
	        String Fileline = myReader.nextLine();
	        String[] array = new String[6];
	        String comma = ",";
	        // splits the String into multiple Strings given the delimiter(,) that separates them and store them in array
	        array = Fileline.split(comma);
	        System.out.println("Contract#: " + array[0] + "     Time: " + array[1] + " hours and " + array[2] +  " minutes    Equipment Type: " +
	           array[3] + "      Equipment Name:   " + array[4] + "      Price  $" + array[5]);   
	      }
	      // close the file
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
