/**
 * Addison Tancredi
 * 4/21/20
 * Week 6
 */
package Carlys_Catering;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayGraduationEventFile {
	/**
	 * Displays Graduation Event File
	 */
	public static void main(String[] args) {
	    try {
	    	
	    	 // Specify the filename and path
	      File ReaderObj = new File("C://Users//Public//GraduationEvents.txt");
	        //read the contents of the text file using scanner
	      Scanner myReader = new Scanner(ReaderObj);
	       //while loop return true untill we reach end of the file
	      while (myReader.hasNextLine()) {
	    	//take the line from file and store into string Variable
	        String Fileline = myReader.nextLine();
	        String[] array = new String[6];
	        String comma = ",";
	        //splits the String into multiple Strings given the delimiter(,) that separates them and store them in array
	        array = Fileline.split(comma);
	        System.out.println("Event#: " + array[0] + "     Event Type Code: " + array[1] + "       Number Of Guests: " + array[2] + 
	            "      Price:  $" + array[3]);   
	      }
	      // close the file
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
}
