/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package sammys_Seashore;

/**
 * Rental represents a rental for Sammy's Seashore.
 */
public class Rental {
    public static final int MINUTES_IN_HOUR = 60;
    public static final int HOUR_RATE = 40; // The rental rate for an hour
    public static final int CONTRACT_NUM_LENGTH = 4; // The required length of the contract number
    public static final String[] EQUIP_TYPES = {"jet ski", "pontoon boat", "paddle boat", "rowboat", "canoe", "kayak", "beach chair", "umbrella", "wagon", "other"};
    private int equipmentTypeID; // an integer field that holds an equipment type ID called equipmentTypeID
    private String contractNumber;
    private int hours;
    private int extraMinutes;
    private double totalPrice; // Total cost of the rental

    /**
     * Creates a Rental object based on given contract number and rental minutes.
     *
     * @param num     The contract number for this Rental
     * @param minutes The total number of minutes for this Rental
     */
    public Rental(String num, int minutes) {
        setContractNumber(num);
        setHoursAndMinutes(minutes);
    }


    /**
     * Creates a Rental object based on given contract number, rental minutes and equipment type id.
     *
     * @param num         The contract number for this Rental
     * @param minutes     The total number of minutes for this Rental
     * @param equipmentID The equipment type if for this Rental
     */
    public Rental(String num, int minutes, int equipmentID) {
        setContractNumber(num);
        setHoursAndMinutes(minutes);
        setEquipmentTypeID(equipmentID);
    }

    /**
     * Creates a Rental object with a contract number of "A000" and rental time of 0.
     * Price is also set to 0.
     * Any additional instance variables are set to a default value.
     */
    public Rental() {
        this("A000", 0);
    }

    /**
     * Sets the contract number of this Event based on the given value.
     * If it meets the format requirements it sets it to the uppercase version of the
     * given value.  Otherwise, it sets it to "A000"
     *
     * @param num The desired contract number
     */
    private void setContractNumber(String num) {
        if (validatesContactNumber(num))
            contractNumber = "A000";
        else
            contractNumber = num.toUpperCase();
    }

    private boolean validatesContactNumber(String num) {
        return num.length() != CONTRACT_NUM_LENGTH ||
                !Character.isLetter(num.charAt(0)) ||
                !Character.isDigit(num.charAt(1)) ||
                !Character.isDigit(num.charAt(2)) ||
                !Character.isDigit(num.charAt(3));
    }

    /**
     * method to set equipment type id. if argument passed to the method that s
     * etc the equipment type is greater than or equal to the size of the array 
     * of String equipment types, then set the equipmentTypeID to the element number
     * occupied by other.
     */

    public void setEquipmentTypeID(int equipmentType) {
        if (equipmentType < EQUIP_TYPES.length)
            equipmentTypeID = equipmentType;
        else
            equipmentTypeID = EQUIP_TYPES.length - 1;
    }

    /**
     * Gets the equipment type id of this Rental
     *
     * @return equipment type ID
     */
    public int getEquipmentTypeID() {
        return equipmentTypeID;
    }

    //returns a rental's String equipment type based on the numeric equipment type.
    public String getEquipmentTypeName() {
        return EQUIP_TYPES[equipmentTypeID];
    }

    /**
     * Sets the hours, extra minutes, and price based on the given minutes.
     *
     * @param minutes The total number of minutes for this Rental
     */
    private void setHoursAndMinutes(int minutes) {
        hours = minutes / MINUTES_IN_HOUR;
        extraMinutes = minutes % MINUTES_IN_HOUR;
        if (extraMinutes <= HOUR_RATE)
            totalPrice = hours * HOUR_RATE + extraMinutes;
        else
            totalPrice = hours * HOUR_RATE + HOUR_RATE;
    }

    /**
     * Gets the contract number of the Rental
     *
     * @return this Rental's contractNumber
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * Gets the number of hours for this Rental
     *
     * @return this Rental's hour
     */
    public int getHours() {
        return hours;
    }

    /**
     * Gets the number of extra minutes beyond an hour for this Rental
     *
     * @return this Rental's extraMinutes
     */
    public int getExtraMinutes() {
        return extraMinutes;
    }

    /**
     * Gets the total price of this Rental
     *
     * @return this Rental's price
     */
    public double getPrice() {
        return totalPrice;
    }

}
