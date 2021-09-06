/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package Carlys_Catering;

/**
 * Event represents an event by Carly's Catering.
 */
public class Event {
    public final static double HIGH_GUEST_PRICE = 35.00; // price for guest for large events
    public final static double LOW_GUEST_PRICE = 32.00;  // price for guests for small events
    public final static int LARGE_EVENT = 50; // minimum number of guests for a large event
    public final static int EVENT_NUM_LENGTH = 4; // required length of the event number
    private String eventNumber;
    private int numOfGuests;
    private double pricePerGuest;
    private double priceForEvent;
    private int eventTypeID; // an integer field that holds an event type called eventTypeID
    //final String array named EVENT_TYPES to hold the names of the types of events
    public final static String[] EVENT_TYPES = {"wedding", "baptism", "graduation", "birthday", "business", "funeral", "other"};

    //Creates an Event where all the instance variables are set to default values
    public Event() {
        this("A000", 0);
    }

    /*Add a parameterized constructor that takes in an event number, number of guests,
    and event type ID */
    public Event(String num, int guests, int TypeID) {
        setEventNumber(num);
        setGuests(guests);
        setEventTypeID(TypeID);
    }

    /**
     * Creates an Event with the given event number and number guests.
     * It calculates the pricePerGuest and priceForEvent based on the number of guests.
     * Any remaining instance variables will be set to a default value
     *
     * @param num    The event number
     * @param guests The number of guests
     */
    public Event(String num, int guests) {
        setEventNumber(num);
        setGuests(guests);
    }

    /**
     * Gets the event type of this Event
     *
     * @return this Event's Type ID
     */
    public int getEventTypeID() {
        return eventTypeID;
    }

    /**
     * Method to set the event type
     * argument passed to the method that sets the event type
     * is greater than or equal to the size of the array of
     * String event types, then set the eventTypeID to the element number occupied by other.
     */
    public void setEventTypeID(int code) {
        if (code < EVENT_TYPES.length)
            eventTypeID = code;
        else
            eventTypeID = EVENT_TYPES.length - 1;
    }

    /**
     * getEventTypeName() method returns an event's String event type
     * based on the numeric event type.
     */
    public String getEventTypeName() {
        return EVENT_TYPES[eventTypeID];
    }

    /**
     * Sets the value of the event number based on the given value.
     * If the given value is the required length, with a letter followed by 3 digits,
     * then eventNumber is set to the uppercase version of the parameter.
     * Otherwise, it is set to a default value of "A000"
     *
     * @param num The desired value for an event number
     */
    private void setEventNumber(String num) {
        if (validateEventNumber(num))
            eventNumber = "A000";
        else
            eventNumber = num.toUpperCase();
    }

    /**
     * Validates the event number
     * @param num
     * @return
     */
    private boolean validateEventNumber(String num) {
        return num.length() != EVENT_NUM_LENGTH ||
                !Character.isLetter(num.charAt(0)) ||
                !Character.isDigit(num.charAt(1)) ||
                !Character.isDigit(num.charAt(2)) ||
                !Character.isDigit(num.charAt(3));
    }

    /**
     * Sets the number of guests to the given value
     * It with also set the pricePerGuest and priceForEvent based on the size of the event
     *
     * @param gsts Number of guests for the event
     */
    private void setGuests(int gsts) {
        numOfGuests = gsts;
        if (isLargeEvent()) {
            pricePerGuest = LOW_GUEST_PRICE;
            priceForEvent = numOfGuests * LOW_GUEST_PRICE;
        } else {
            pricePerGuest = HIGH_GUEST_PRICE;
            priceForEvent = numOfGuests * HIGH_GUEST_PRICE;
        }
    }

    /**
     * Gets the event number of this Event
     *
     * @return this Event's eventNumber
     */
    public String getEventNumber() {
        return eventNumber;
    }

    /**
     * Gets the number of guests for this Event
     *
     * @return this Event's numOfGuests
     */
    public int getGuests() {
        return numOfGuests;
    }

    /**
     * Gets the total price for this Event
     *
     * @return this Event's priceForEvent
     */
    public double getPriceForEvent() {
        return priceForEvent;
    }

    /**
     * Gets the price for each guest for this Event
     *
     * @return this Event's pricePerGuest
     */
    public double getPricePerGuest() {
        return pricePerGuest;
    }

    /**
     * Checks if this Event is a large event
     *
     * @return true if number of guests is greater than or equal to LARGE_EVENT.
     * Otherwise, it returns false.
     */
    public boolean isLargeEvent() {
        boolean isLarge = false;
        if (numOfGuests >= LARGE_EVENT)
            isLarge = true;
        return isLarge;
    }
}

