/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package sammys_Seashore;

public class LessonWithRental extends Rental {
    private boolean isLessonRequired;
    public static final String[] instructor = {"John Doe", "Adam Smith", "Stephen Shaw", "Adam Bonnet", "Mark Taylor",
            "Michael Jordan", "Ray Donnonvan", "Megan Cielia", "John Snow","Danny Elfman"};


    /**
     *
     * @param num
     * @param minutes
     * @param equipmentID
     */
    public LessonWithRental(String num, int minutes, int equipmentID) {
        super(num, minutes, equipmentID);
        setEquipmentTypeID(equipmentID);
    }

    /**
     * Sets whether the lessons required or not
     */
    private void setLessonRequired() {
        isLessonRequired = false;

        if ("jet ski".equals(getEquipmentTypeName()) || "pontoon boat".equals(getEquipmentTypeName())) {
            isLessonRequired = true;
        }
    }

    /**
     * Returns whether a lession is required for given quipment or not
     * @return
     */
    public boolean isLessonRequired() {
        return isLessonRequired;
    }

    /**
     * Sets the eventType and setting the lessons required
     * @param eType
     */
    @Override
    public void setEquipmentTypeID(int eType) {
        setLessonRequired();
    }

    /**
     * Returns the instructor
     * @return
     */

    public String getInstructor() {

        if (isLessonRequired) {
            return "To rent the personal " + getEquipmentTypeName() + " , training is required."
                    + " The instructor for training is :" + instructor[getEquipmentTypeID()];
        }
        return "To rent the personal " + getEquipmentTypeName() + " , training is not required."
                + " The instructor for training is :" + instructor[getEquipmentTypeID()];
    }
}
