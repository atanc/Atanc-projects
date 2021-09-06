/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package Carlys_Catering;

public class Bartender extends Employee {
    public Bartender(int id, String lastName, String firstName, double payRate) {
        super(id, lastName, firstName, payRate);
    }

    /**
     * Set the pay rate for the given employee
     * @param if payRate is less than 14 then it will be a bartender payrate.
     */
    @Override
    public void setPayRate(double payRate) {
        this.payRate = 14;
        if (payRate < 14) {
            this.payRate = payRate;
        }
    }

    /**
     * Sets the job title for the given employee
     */
    @Override
    public void setJobTitle() {
        this.jobTitle = "bartender";
    }
}
