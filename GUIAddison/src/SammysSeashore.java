/**
 * Addison Tancredi
 * Week 7
 * 4/29/20
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SammysSeashore extends JFrame implements ItemListener, ActionListener {

	// declare Variables
	private JLabel title;
	private JTextField taChoice;
	// label for Hours
	private JLabel Hour;
	// label for equipmentType
	private JLabel equipmentType;
	// combobox
	static JComboBox c1;
	// checkbox
	JCheckBox lessonBox;
	JCheckBox noLessonBox;
	// label for time
	private JLabel time;
	// label for detail
	private JLabel detail;
	// label for lesson
	private JLabel lsn;
	// label for Total Cost
	private JLabel tCost;
	JTextField hf = new JTextField(10);

	int hourCost = 0;
	int lessonCost = 0;
	int equipCost = 0;
	int price = 0;
	int hours;
	int hourPrice;
	String output = "";
	String equipString = "";
	String timeString = "";
	String lessonString = "";

	public SammysSeashore() {
		// Title name of window
		super("Sammy's Seashore");
		// set size of frame
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set headline of window
		title = new JLabel("<html><span style='font-size:20px'>WELCOME TO Sammy's Seashore Rentals</span></html>");
		// Create JLabel for Hour
		Hour = new JLabel("<html><span style='font-size:14px'> Enter Number of Hours: </span></html>");
		// crrate TextField of 20px length for Guests
		taChoice = new JTextField(20);
		// Create JLabel for equipmentType
		equipmentType = new JLabel(
				"<html><span style='font-size:14px'> choose an Equipment Type from the drop down menu: </span></html>");
		// array of string contating equipmentTypes
		String s1[] = { "Select", "Jet ski", "Pontoon boat", "Row boat", "Canoe", "Kayak", "Beach chair", "Umbrella" };
		// create checkbox
		c1 = new JComboBox(s1);
		// create checkboxes for Lesson and No lesson
		lessonBox = new JCheckBox("Lesson", false);
		noLessonBox = new JCheckBox("No lesson", true);
		// add Checkboxes into Button Group
		ButtonGroup lessonGroup = new ButtonGroup();
		lessonGroup.add(lessonBox);
		lessonGroup.add(noLessonBox);
		// Create JLabel for time
		time = new JLabel();
		// Create JLabel for lesson
		lsn = new JLabel();
		// Create JLabel for details
		detail = new JLabel();
		// Create JLabel for Total Cost
		tCost = new JLabel();
		taChoice.addActionListener(this);
		c1.addItemListener(this);
		lessonBox.addItemListener(this);
		noLessonBox.addItemListener(this);

		// Using grid bag to arrange the components of GUI
		GridBagLayout gbl = new GridBagLayout();
		// creates a constraints object
		GridBagConstraints gbc = new GridBagConstraints();
		// insets for all components
		gbc.insets = new Insets(10, 10, 10, 10);
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

		// set the alignment as WEST for displayng Hour Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(Hour, gbc);

		// set the alignment as EAST for displaying Hour TextField
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(taChoice, gbc);

		// set the alignment as WEST for displaying equipment Type Label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(equipmentType, gbc);

		// set the alignment as EAST for displaying equipmentType Combobox
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.NONE;
		c.add(c1, gbc);

		// set the alignment as EAST for displaying lesson Box
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.NONE;
		c.add(lessonBox, gbc);
		c.add(noLessonBox, gbc);

		// set the alignment as EAST for displaying Total cost label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(tCost, gbc);

		// set the alignment as EAST for displaying Time label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(time, gbc);

		// set the alignment as EAST for displaying detail label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(detail, gbc);

		// set the alignment as EAST for displaying lesson label
		gbc.gridx = 0;
		gbc.gridwidth = 3;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		// constraints passed in
		c.add(lsn, gbc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create instance of SammysSeashore class
		SammysSeashore m = new SammysSeashore();
		m.setVisible(true);
		;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object source = arg0.getSource();

		if (source == taChoice) {
			try {
				 //extract the data from text field and save it into hour variable
				hours = Integer.parseInt(taChoice.getText());
			} catch (Exception exc) {
				//set hour to zero in case of invalid input
				hours = 0;
			}
			//calculate hour price by multiplying hour x equipment cost
			hourPrice = hours * equipCost;
			//calculate final price by adding hour price to lesson
			price = hourPrice + lessonCost;
			tCost.setText("Total Price is: $" + price);
			time.setText("Hours for Rent Are: " + hours);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		String equipment = "";
		// if the state combobox for Equipment Type is changed
		if (arg0.getSource() == c1) {

			//check which combobox value is selected
			equipment = (String) c1.getSelectedItem();
			//if jet sky selected set equipment cost to 40
			if (equipment == "Jet ski") {
				equipCost = 40;
				detail.setText("Rental Details: " + equipment + " at Rate $40 per Hour");
			}
			//if Pontoon boat selected set equipment cost to 40
			if (equipment == "Pontoon boat") {
				equipCost = 40;
				detail.setText("Rental Details: " + equipment + " at Rate $40 per Hour");
			}
			//if Row boat selected set equipment cost to 20
			if (equipment == "Row boat") {
				equipCost = 20;
				detail.setText("Rental Details: " + equipment + " at Rate $20 per Hour");
			}
			//if Canoe selected set equipment cost to 20
			if (equipment == "Canoe") {
				equipCost = 20;
				detail.setText("Rental Details: " + equipment + " at Rate $20 per Hour");
			}
			//if Kayak selected set equipment cost to 20
			if (equipment == "Kayak") {
				equipCost = 20;
				detail.setText("Rental Details: " + equipment + " at Rate $20 per Hour");
			}
			//if Beach chair selected set equipment cost to 20
			if (equipment == "Beach chair") {
				equipCost = 7;
				detail.setText("Rental Details: " + equipment + " at Rate $7 per Hour");
			}
			//if Umbrella selected set equipment cost to 20
			if (equipment == "Umbrella") {
				equipCost = 7;
				detail.setText("Rental Details: " + equipment + " at Rate $7 per Hour");
			}
		}
		//if lessonBox selected set lesson cost to 5
		if (arg0.getSource() == lessonBox) {

			lsn.setText("Lesson Selected: $5 Extra Added");
			lessonCost = 5;
		}
		if (arg0.getSource() == noLessonBox) {

			lsn.setText("No Lesson Selected");
			lessonCost = 0;
		}
		//calculate hour price by multiplying hour x equipment cost
		hourPrice = hours * equipCost;
		//calculate final price by adding hour price to lesson
		price = hourPrice + lessonCost;
		tCost.setText("Total Price is: $" + price);
	}
}