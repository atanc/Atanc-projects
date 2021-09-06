package sammys_Seashore;

public abstract class Equipment {
    private int equipmentTypeID;
    private String equipmentTypeName;
    protected int surchargeFee;
    public static final String[] EQUIPMENT_NAMES = {"jet ski", "pontoon boat", "paddle boat", "rowboat", "canoe", "kayak", "beach chair", "umbrella", "wagon", "other"};
    public static final int[] SURCHARGES = {50, 40, 15, 12, 10, 10, 2, 1, 3, 0};

    public Equipment(int equipmentTypeID) {
        this.equipmentTypeID = equipmentTypeID;
    }

    /**
     * @return Returns the equipment id
     * 
     */
    public int getEquipmentTypeID() {
        return equipmentTypeID;
    }

    /**
     *@return Returns the equipment name
     * 
     */
    public String getEquipmentTypeName() {
        return equipmentTypeName;
    }

    /**
     * @return Returns surcharge of the equipment
     * 
     */
    public int getSurchargeFee() {
        return surchargeFee;
    }

    /**
     * Sets the equipmentTypeID, equipmentTypeName and surcharge fee by equipmentType
     * @param equipmentType
     */
    public void setEquipmentTypeID(int equipmentType) {
        if (equipmentType >=0 && equipmentType < EQUIPMENT_NAMES.length)
            this.equipmentTypeID = equipmentType;
        else
            this.equipmentTypeID = EQUIPMENT_NAMES.length - 1;

        this.equipmentTypeName = EQUIPMENT_NAMES[this.getEquipmentTypeID()];
        this.surchargeFee = SURCHARGES[this.getEquipmentTypeID()];
    }

    /**
     * Returns a String explaining the lesson policy for the type of equipment.
     */
    public abstract String getLessonPolicy();
}
