/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package sammys_Seashore;
//EquipmentWithLesson extends to the Equipment class
public class EquipmentWithLesson extends Equipment {


    public EquipmentWithLesson(int equipmentTypeID) {
        super(equipmentTypeID);
        if(equipmentTypeID < 6) {
            super.setEquipmentTypeID(equipmentTypeID);
        }


    }
    /**
     * @return Returns a String explaining the lesson policy for the type of equipment.
     */
    @Override
    public String getLessonPolicy() {
        return "This Equipment does require a $27 Lesson! ";
    }
}
