/**
 * Addison Tancredi
 * Week 5
 * 4/10/20
 */
package Carlys_Catering;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffDinnerEvent {
    private static Scanner input = new Scanner(System.in);
//variables
    public static void main(String argsp[]) {
        GraduationEvent[] events = new GraduationEvent[1];

        for (int x = 0; x < events.length; ++x) {
            String eventNum = getEventNumber();
            int guests = getGuests();
            int appetizer = getAppetizerChoice();
            int entree = getEntreeChoice();
            int sideDish1 = getSideDishChoice();
            int sideDish2 = getSideDishChoice();
            int dessert = getDessertChoice();
            ArrayList<Employee> assignedStaff = getAssignedStaff(guests);
            events[x] = new GraduationEvent(eventNum, guests, appetizer, entree, sideDish1, sideDish2, dessert, assignedStaff);
        }
        for (GraduationEvent ge : events) {
            displayDetails(ge);
        }
    }


    /**
     * Captures the appetizer choice
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return captures appetizer choice
     */
    public static int getAppetizerChoice() {
    	int type = -1;
        boolean isAppetizerOkay = false;
        while(!isAppetizerOkay)
        {
            isAppetizerOkay = true;
            try
            {
            	 System.out.println("Appetizer types are");
         	    for (int x = 0; x < GraduationEvent.APPETIZER_OPTIONS.length; ++x)
         	        System.out.println("    " + x + " " + GraduationEvent.APPETIZER_OPTIONS[x]);
              System.out.print("Enter Option>> ");
              type = Integer.parseInt(input.nextLine());
              if (type < 0 || type > GraduationEvent.APPETIZER_OPTIONS.length - 1) {
             	 throw new NumberFormatException();
           }
          }
           catch(NumberFormatException event)
           {
              isAppetizerOkay = false;
              System.out.println("Invalid Appetizer type ID(Enter id between 0-"
                      + (GraduationEvent.APPETIZER_OPTIONS.length - 1) + ") ");     
           }
      }
      return type;
 }
    /**
     * Captures the entree choice
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return captures the entree choice
     */
    public static int getEntreeChoice() {
        int type = -1;
	    boolean isEntreeOkay = false;
        while(!isEntreeOkay)
	    {
	        isEntreeOkay = true;
	        try
	        {
	       	 System.out.println("Entree types are");
	       	    for (int x = 0; x < GraduationEvent.ENTREE_OPTIONS.length; ++x)
	       	        System.out.println("    " + x + " " + GraduationEvent.ENTREE_OPTIONS[x]);
	            System.out.print("Enter Option>> ");
	            type = Integer.parseInt(input.nextLine());
	            if (type < 0 || type > GraduationEvent.ENTREE_OPTIONS.length - 1) {
	           	 throw new NumberFormatException();
	         }
	        }
	         catch(NumberFormatException e)
	         {
	            isEntreeOkay = false;
	            System.out.println("Invalid Entree type ID(Enter id between 0-"
	                    + (GraduationEvent.ENTREE_OPTIONS.length - 1) + ") ");     
	         }
	    }
	    return type;
}

    /**
     * Captures the side dish choice
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return captures the side dish choice
     */
    public static int getSideDishChoice() {
		 int type = -1;
  	   boolean isSideOkay = false;
  	   while(!isSideOkay)
  	   {
  	       isSideOkay = true;
  	       try
  	       {
  	      	 System.out.println("Side Dish types are");
  	      	    for (int x = 0; x < GraduationEvent.SIDE_DISH_OPTIONS.length; ++x)
  	      	        System.out.println("    " + x + " " + GraduationEvent.SIDE_DISH_OPTIONS[x]);
  	           System.out.print("Enter Option>> ");
  	           type = Integer.parseInt(input.nextLine());
  	           if (type < 0 || type > GraduationEvent.SIDE_DISH_OPTIONS.length - 1) {
  	          	 throw new NumberFormatException();
  	        }
  	       }
  	        catch(NumberFormatException e)
  	        {
  	           isSideOkay = false;
  	           System.out.println("Invalid Side Dish type ID(Enter id between 0-"
  	                   + (GraduationEvent.SIDE_DISH_OPTIONS.length - 1) + ") ");     
  	        }
  	   }
  	   return type;
  }

    /**
     * Returns the dessert choice
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return
     */
    public static int getDessertChoice() {
    	int type = -1;
   	   boolean isDessertOkay = false;
   	   while(!isDessertOkay)
   	   {
   	       isDessertOkay = true;
   	       try
   	       {
   	      	 System.out.println("Dessert types are");
   	      	    for (int x = 0; x < GraduationEvent.DESSERT_OPTIONS.length; ++x)
   	      	        System.out.println("    " + x + " " + GraduationEvent.DESSERT_OPTIONS[x]);
   	           System.out.print("Enter Option>> ");
   	           type = Integer.parseInt(input.nextLine());
   	           if (type < 0 || type > GraduationEvent.DESSERT_OPTIONS.length - 1) {
   	          	 throw new NumberFormatException();
   	        }
   	       }
   	        catch(NumberFormatException event)
   	        {
   	           isDessertOkay = false;
   	           System.out.println("Invalid Dessert type ID(Enter id between 0-"
                          + (GraduationEvent.DESSERT_OPTIONS.length - 1) + ") ");     
   	        }
   	   }
   	   return type;
     }

    /**
     * Asks the user for the Event Number
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return The Event Number provided by the user
     */
    public static String getEventNumber() {
    	 String num = "0";
         int n = -1;
         while (n < 0) {
         	try {
             System.out.print("\nEnter event number >> ");
             num = input.nextLine();
             n = Integer.parseInt(num);
             if (n < 0){
                 throw new NumberFormatException();
         	     }
         	}
         	catch (NumberFormatException e)  
                { 
         		 System.out.print("Invalid event number(Enter non negative number or a numerical value)");   
                }      
         }
         return num;
     }

    /**
     * Asks the user for the Event Guests Number 
     * @catch Prompts user to enter a numerical value between 0 and the length of the array
     * if an invalid entry is inputted
     * @return The Event Guests Number provided by the user
     */
    public static int getGuests() {
    	int guests = 0;
        final int MIN_GUESTS = 5;
        final int MAX_GUESTS = 100;
        Scanner input = new Scanner(System.in);
        boolean isGuestsOkay = false;
        while(!isGuestsOkay)
        {
            isGuestsOkay = true;
            try
            {
                System.out.print("Enter number of guests >> ");
                guests = input.nextInt();
            }
            catch(Exception e)
            {
               isGuestsOkay = false;
               System.out.println("The number of guests must be between " +
                       MIN_GUESTS + " and " + MAX_GUESTS);
            }
            input.nextLine();
        }
        while(guests < MIN_GUESTS || guests > MAX_GUESTS)
        {
            System.out.println("The number of guests must be between " +
              MIN_GUESTS + " and " + MAX_GUESTS);
            isGuestsOkay = false;
            while(!isGuestsOkay)
            {
              isGuestsOkay = true;
              try
              {
                 System.out.print("Please renter >> ");
                 guests = input.nextInt();
              }
              catch(Exception event)
              {
                 isGuestsOkay = false;
                 System.out.println("The number of guests must be between " +
                         MIN_GUESTS + " and " + MAX_GUESTS);
              }
              input.nextLine();
           }
        } 
        return guests;
    }

    /**
     * Asks the user for the Event Type
     *@catch Prompts user to enter a numerical value between 0 and the length of the array
     *if an invalid entry is inputted
     * @return The Event Type provided by the user
     */
    public static int getType() {
    	int eventType = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Event types are");
        for(int x = 0; x < Event.EVENT_TYPES.length; ++x)
           System.out.println("    " + x + " " + Event.EVENT_TYPES[x]);
        boolean isTypeOkay = false;
        while(!isTypeOkay)
        {
           isTypeOkay = true;
           try
           {
               System.out.print("Enter event type >> ");
               eventType = input.nextInt();
           }
           catch(Exception event)
           {
               isTypeOkay = false;
               System.out.println("Invalid Type ID(Enter a positive numerical value starting from 0 and no greater than " + (Event.EVENT_TYPES.length - 1) + ") ");
           }
           input.nextLine();
        }
        return eventType;
    }

    /**
     * Asks the user for the EmployeeeId
     *@catch Prompts user to enter a numerical value that is positive
     * @return The Employee Id provided by the user
     */
    public static int getEmployeeId() {
    	 String num = "0";
 	    int n = -1;
 	    while (n < 0) {
 	    	try {
 	        System.out.print("\nEnter employee Id number >> ");
 	        num = input.nextLine();
 	        n = Integer.parseInt(num);
 	        if (n < 0){
 	            throw new NumberFormatException();
 	    	     }
 	    	}
 	    	catch (NumberFormatException event)  
 	           { 
 	    		 System.out.print("Invalid employee Id number(Enter non negative number or a numerical value)");   
 	           }      
 	    }
 	    return n;
 }

    /**
     * Captures the assigned employees for the graduation event
     * @try Looks at payrate and determines if it is less than 1 or a special character or an alphabet letter
     * @catch Prompts user to input a numerical value 
     * @return list of assigned staff for the graduation event
     */
    public static ArrayList<Employee> getAssignedStaff(int guests) {
        ArrayList<Employee> assignedEmployees = new ArrayList<>();
        System.out.println("");

        int waitStaffCount = (guests / 10) - 1;
        System.out.println("For the Graduation event you need to add " + waitStaffCount + " Waitstaff Employees");

        for(int i = 0; i <= waitStaffCount; i++) {
            double payRate = 0;
            System.out.println("Enter details for the wait staff #" + (i + 1));
            System.out.print("Enter employee id >> ");
            int employeeId = getEmployeeId();

            System.out.print("Enter first name >> ");
            String firstName = input.nextLine();

            System.out.print("Enter last name >> ");
            String lastName = input.nextLine();

            while (payRate < 1) {
            	try
            	{
                System.out.print("Enter Wait Staff Pay Rate >> ");
                payRate = Double.parseDouble(input.nextLine());
                if(payRate < 1) {
                	throw new NumberFormatException();   
                } 
       	     }
            	catch (NumberFormatException e)  
                { 
         	      System.out.println("Invalid Type PayRate, please input a numerical value (that is not negative)");  
                }
            	
       	}
       	      
            Employee waiter = new Waitstaff(employeeId, firstName, lastName, payRate);
            assignedEmployees.add(waiter);
        }
        
        int bartenderCount =  (guests / 25);
        System.out.println("For the Graduation event you need to add " + bartenderCount + " Bartender Employees");
        for(int i = 0; i <= bartenderCount; i++) {
            System.out.println("Enter details for the bartender staff #" + (i + 1));
            System.out.print("Enter employee id >> ");
            int employeeId = getEmployeeId();

            System.out.print("Enter first name >> ");
            String firstName = input.nextLine();

            System.out.print("Enter last name >> ");
            String lastName = input.nextLine();
            double payRate = 0;
            while (payRate < 1) {
            	try
            	{
                System.out.print("Enter Wait Staff Pay Rate >> ");
                payRate = Double.parseDouble(input.nextLine());
                if(payRate < 1) {
                	throw new NumberFormatException();   
                } 
       	     }
            	catch (NumberFormatException event)  
                { 
         	      System.out.println("Invalid Type PayRate, please input a numerical value (that is not negative)");  
                }
          
             }

            Employee bartender = new Bartender(employeeId, firstName, lastName, payRate);
            assignedEmployees.add(bartender);
        }

        double payRate = 0;
        System.out.println("For the Graduation event you need to add 1 Coordinator");
        System.out.print("Enter employee id >> ");
        int employeeId = getEmployeeId();

        System.out.print("Enter first name >> ");
        String firstName = input.nextLine();

        System.out.print("Enter last name >> ");
        String lastName = input.nextLine();

        while (payRate < 1) {
        	try
        	{
            System.out.print("Enter Coordinator Staff Pay Rate >> ");
            payRate = Double.parseDouble(input.nextLine());
            if(payRate < 1) {
            	throw new NumberFormatException();   
            } 
   	     }
        	catch (NumberFormatException event)  
            { 
     	      System.out.println("Invalid Type PayRate, please input a numerical value (that is not negative)");  
            }   	
   	}
        Employee coordinator = new Coordinator(employeeId, firstName, lastName, payRate);
        assignedEmployees.add(coordinator);

        return assignedEmployees;
    }

    /**
     * display details
     *
     * @param e is all the information that will be printed
     */
    public static void displayDetails(GraduationEvent e) {
        System.out.println("\nGraduationEvent #" + e.getEventNumber());
        System.out.println("The price for an event with " + e.getGuests() +
                " guests at $" + e.getPricePerGuest() + " per guest is $" + e.getPriceForEvent());
        System.out.println("Whether this is a large event is " +
                (e.getGuests() >= e.LARGE_EVENT));
        System.out.println("The event is type " + e.getEventTypeID() + " which is the following type: " + e.getEventTypeName());
        System.out.println("The menu for this graduation event includes the following: " + e.getMenu());
        System.out.println("The assigned staff for this graduation event includes the following: ");

        for(Employee emp: e.getAssignedStaff()) {
            System.out.println(emp);
        }
    }
}
