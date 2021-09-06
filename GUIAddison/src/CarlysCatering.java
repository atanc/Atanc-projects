/**
 * Addison Tancredi
 * Week 7
 * 4/24/20
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;


public class CarlysCatering extends JFrame implements ItemListener, ActionListener{

	// declare Variables
	private JLabel title;
	private JTextField taChoice;
	// label for guests
	private JLabel Guest;
	// label for appetizer
	private JLabel appetizerLabel;
	// combobox
	static JComboBox c1;
	// label for entree
	private JLabel entree;
	// combobox
	static JComboBox c2;
	// label for side dishes
	private JLabel side;
	// label for desserts
	private JLabel Dessert;
	// combobox
	static JComboBox c3;
	// label for cost
	private JLabel cost;
	// label for menu
	private JLabel menu;
	// label for menu
	private JLabel menu1 = new JLabel();
	// label for menu
	private JLabel menu2 = new JLabel();;
	// label for menu
	private JLabel menu3 = new JLabel();;
	// label for menu
	private JLabel menu4 = new JLabel();;
	
	
	private JCheckBox cb1;
	private JCheckBox cb2 ;
	private JCheckBox cb3;
	private JCheckBox cb4;
	private JCheckBox cb5;
	
	public CarlysCatering()
	{
		// Title name of window
		super("Carly’s Catering");
		// set size of frame
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set headline of window
		title = new JLabel("<html><span style='font-size:20px'>WELCOME TO CARLY'S CATERING</span></html>");
		//Create JLabel for Guests
		Guest = new JLabel("<html><span style='font-size:14px'> Enter Number of Guests: </span></html>");
		//crrate TextField of 20px length for Guests
		taChoice = new JTextField(20);
		//Create JLabel for Appetizer
		appetizerLabel= new JLabel("<html><span style='font-size:14px'> choose an Appetizer from the drop down menu: </span></html>");	
		// array of string contating appetizers  
        String s1[] = { "Select", "Salad", "Salami", "Sausages" }; 
        // create checkbox 
        c1 = new JComboBox(s1); 
		
		// Create JLabel for entree
        entree = new JLabel(
				"<html><span style='font-size:14px'> choose an entree from the drop down menu: </span></html>");
		// array of string contating entree
		String s2[] = {"Select", "Noodle", "Pizza", "Pasta", "Fried Rice" };
		// create checkbox
		c2 = new JComboBox(s2); 
	
		// Create JLabel for entree
        side = new JLabel(
				"<html><span style='font-size:14px'> choose up to two side dishes from the drop down menu: </span></html>");
        cb1 = new JCheckBox("Chicken",false);
       cb2 = new JCheckBox("Fish", false);
         cb3 = new JCheckBox("Prawns", false);
       cb4 = new JCheckBox("CuttleFish",false);
       cb5 = new JCheckBox("Carrot", false);
     // create a new panel 
        JPanel p = new JPanel(); 
     // set layout of frame 
        p.setLayout(new FlowLayout());
        p.add(cb1);
        p.add(cb2);
        p.add(cb3);
        p.add(cb4);
        p.add(cb5);
        
     // Create JLabel for Dessert
        Dessert = new JLabel(
				"<html><span style='font-size:14px'> choose an Dessert from the drop down menu: </span></html>");
		// array of string contating Dessert
		String s3[] = {"Select", "Ice Cream", "Jelly", "Cake" };
		// create checkbox
		c3 = new JComboBox(s3);
		
		// Create JLabel for Cost
        cost = new JLabel(
				"Total cost of the event: 0$ ");
		
		
        taChoice.addActionListener(this);
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        cb4.addItemListener(this);
        cb5.addItemListener(this);
        
		// Using grid bag to arrange the components of GUI
		GridBagLayout gbl = new GridBagLayout();
		// creates a constraints object 
		GridBagConstraints gbc = new GridBagConstraints();
		// insets for all components
		gbc.insets = new Insets(10, 10,10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		// create a content pane container
		Container c = getContentPane();
		c.setBackground(Color.decode("#E0FFFF"));
		c.setLayout(gbl);

		// set the alignment as center for displayng Menu
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		// add menu in content pane
		c.add(title, gbc);
		
		// set the alignment as WEST for displayng Guest Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(Guest, gbc);
		
		// set the alignment as EAST for displaying Guest TextField
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(taChoice, gbc);
		
		// set the alignment as WEST for displaying appetizer Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(appetizerLabel, gbc);
		
		// set the alignment as EAST for displaying appetizer Combobox
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		c.add(c1, gbc);
		
		// set the alignment as WEST for displaying entree Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(entree, gbc);
		
		// set the alignment as EAST for displaying entree Combobox
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(c2, gbc);
		
		// set the alignment as WEST for displaying side dishes Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(side, gbc);
		
		// set the alignment as EAST for displaying side dishes panel
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(p, gbc);
		
		// set the alignment as WEST for displaying Dessert Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(Dessert, gbc);
		
		// set the alignment as EAST for displaying Dessert Combobox
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(c3, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(cost, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(menu1, gbc);

		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(menu2, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(menu3, gbc);
		
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		 // constraints passed in 
		c.add(menu4, gbc);
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
	      final int GuestRate = 35;
	      int PRICE;
	      String Cost = "";
	      if(obj == taChoice)
	      {
	        try
	        {
	          //extract the data from text field and save it into price variable
	          PRICE = Integer.parseInt(taChoice.getText()) * GuestRate;   
	        }
	        catch(Exception exc)
	        {
	          //set price to zero in case of invalid input
	          PRICE = 0;
	        }
	       Cost = "Total cost of the event: " + PRICE + "$";
	          
	      }
		cost.setText(Cost);
		

		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		//declare variables
		String Appetizer = "";
		String Entree = "";
		String side = "";
		String Dessert = "";
		int count= 0;
		Object source = e.getItem();
		 // if the state combobox for Appetizer is changed 
        if (e.getSource() == c1) { 
        	Appetizer = (String) c1.getSelectedItem(); 
        	menu1.setText(Appetizer + " selected"); 
        } 
    
        // if the state combobox for Entree is changed 
        if (e.getSource() == c2) { 
        	Entree = (String) c2.getSelectedItem(); 
        	menu2.setText(Entree + " selected");
        } 
        
        if(source == cb1 || source == cb2 || source == cb3|| source == cb4|| source == cb5)
        {
           if(e.getStateChange() == ItemEvent.SELECTED)
           {
        	 //checkbox has been selected
        	  count = count + 1;
           }   
           else
           {
        	   //checkbox has been deselected
        	   count = count - 1;
           }
            if(count <= 2)
           {
        	   if(cb1.isSelected())
               {
                   side+= "Chicken, ";
               }
               if(cb2.isSelected())
               {
                   side += "Fish, ";
               }
               if(cb3.isSelected())
               {
                   side += "Prawns, ";
               }
               if(cb4.isSelected())
               {
                   side += "CuttleFish, ";
               }
               if(cb5.isSelected())
               {
                   side += "Carrott, ";
               }
     
          }
          else
          {
        	  //deselct all check boxes
        	  cb1.setSelected(false);
              cb2.setSelected(false);
              cb3.setSelected(false);
              cb4.setSelected(false);
              cb5.setSelected(false);
          }
           menu3.setText(side + " selected");
       }	        
	        // if the state combobox for Dessert is changed
     		if (e.getSource() == c3) {
     			Dessert= (String) c3.getSelectedItem();
     			menu4.setText(Dessert + " selected");
     		}
        
		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create instance of CarlysCateringn class
		CarlysCatering m = new CarlysCatering();
		 m.setVisible(true);
	    
	}


}


	
