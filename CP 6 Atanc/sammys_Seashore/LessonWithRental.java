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

        if ("jet ski".equals(getEquipment().getEquipmentTypeName()) || "pontoon boat".equals(getEquipment().getEquipmentTypeName())) {
            isLessonRequired = true;
        }
    }

    /**
     * Returns whether a lesson is required for given equipment or not
     * @return
     */
    public boolean isLessonRequired() {
        return isLessonRequired;
    }

    /**
     * Sets the equipmentType and setting the lessons required
     * @param equipmentType
     */
    public void setEquipmentTypeID(int equipmentType) {
        super.getEquipment().setEquipmentTypeID(equipmentType);
        setLessonRequired();
    }

    /**
     * Returns the instructor
     * @return
     */

    public String getInstructor() {

        if (isLessonRequired) {
            return "To rent the personal " + getEquipment().getEquipmentTypeName() + " , training is required."
                    + " The instructor for training is :" + instructor[getEquipment().getEquipmentTypeID()];
        }
        return "To rent the personal " + getEquipment().getEquipmentTypeName() + " , training is not required."
                + " The instructor for training is :" + instructor[getEquipment().getEquipmentTypeID()];
    }
}
