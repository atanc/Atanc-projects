/**
 * Addison Tancredi
 * 3/29/20
 * Week 3
 */
package Carlys_Catering;

public class GraduationEvent extends Event {
    public static final String[] APPETIZER_OPTIONS = {"Salad", "Salami", "Sausages"};
    public static final String[] ENTREE_OPTIONS = {"Noodle", "Pizza", "Pasta", "Fried Rice"};
    public static final String[] SIDE_DISH_OPTIONS = {"Chicken", "Fish", "Prawns", "CuttleFish", "Carrot", "Brocolli"};
    public static final String[] DESSERT_OPTIONS = {"Ice Cream", "Jelly", "Cake"};
    private static final int GRADUATION_EVENT_ID = 2;

    private int appetizer;
    private int entree;
    private int sideDish1;
    private int sideDish2;
    private int dessert;

    /**
     * @param num
     * @param guests
     * @param appetizer
     * @param sideDish1
     * @param sideDish2
     * @param dessert
     */
    public GraduationEvent(String num, int guests, int appetizer, int entree, int sideDish1, int sideDish2, int dessert) {
        super(num, guests, GRADUATION_EVENT_ID);
        setAppetizer(appetizer);
        setSideDish1(sideDish1);
        setSideDish2(sideDish2);
        setEntree(entree);
        setDessert(dessert);
    }

    /**
     * Returns the menu for this graduation even
     *
     * @return
     */
    public String getMenu() {
        return APPETIZER_OPTIONS[appetizer] + ", "
                + ENTREE_OPTIONS[entree] + ", "
                + SIDE_DISH_OPTIONS[sideDish1] + ", "
                + SIDE_DISH_OPTIONS[sideDish2] + ", "
                + DESSERT_OPTIONS[dessert];
    }

    /**
     * Returns the appetizer index
     * @return
     */
    public int getAppetizer() {
        return appetizer;
    }

    /**
     * Sets the value for appetizer index
     * @param appetizer
     */
    public void setAppetizer(int appetizer) {
        if (appetizer > 0 && appetizer < APPETIZER_OPTIONS.length) {
            this.appetizer = appetizer;
        } else {
            this.appetizer = 0;
        }
    }

    /**
     * Returns the sideDish1 index
     * @return
     */
    public int getSideDish1() {
        return sideDish1;
    }

    /**
     * Sets the value for sideDish1 index
     * @param sideDish1
     */
    public void setSideDish1(int sideDish1) {

        if (sideDish1 > 0 && sideDish1 < SIDE_DISH_OPTIONS.length) {
            this.sideDish1 = sideDish1;
        } else {
            this.sideDish1 = 0;
        }

    }

    /**
     * Returns the sideDish2 index
     * @return
     */
    public int getSideDish2() {
        return sideDish2;
    }

    /**
     * Sets the value for sideDish2 index
     * @param sideDish2
     */
    public void setSideDish2(int sideDish2) {
        if (sideDish2 > 0 && sideDish2 < SIDE_DISH_OPTIONS.length) {
            this.sideDish2 = sideDish2;
        } else {
            this.sideDish2 = 0;
        }
    }

    /**
     * Returns the dessert index
     * @return
     */
    public int getDessert() {
        return dessert;
    }

    /**
     * Sets the value for dessert index
     * @param dessert
     */
    public void setDessert(int dessert) {
        if (dessert > 0 && dessert < DESSERT_OPTIONS.length) {
            this.dessert = dessert;
        } else {
            this.dessert = 0;
        }
    }

    /**
     * Returns entree index
     * @return
     */
    public int getEntree() {
        return entree;
    }

    /**
     * Sets the value for entree index
     * @param entree
     */
    public void setEntree(int entree) {
        if (entree > 0 && entree < ENTREE_OPTIONS.length) {
            this.entree = entree;
        } else {
            this.entree = 0;
        }
    }
}
