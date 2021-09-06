/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package sammys_Seashore;
//Extends to the equipment class
public class EquipmentWithoutLesson extends Equipment {


    public EquipmentWithoutLesson(int equipmentTypeID) {
        super(equipmentTypeID);
        if(equipmentTypeID >= 6) {
            super.setEquipmentTypeID(equipmentTypeID);
        }
    }
    /**
     *  @return Returns a String explaining the lesson policy for the type of equipment.
     */
    @Override
    public String getLessonPolicy() {
        return "This Equipment does not require a lesson! ";
    }
}
