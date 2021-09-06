/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package Carlys_Catering;

public class Waitstaff extends Employee {
    public Waitstaff(int id, String lastName, String firstName, double payRate) {
        super(id, lastName, firstName, payRate);
    }

    /**
     * Set the pay rate for the given employee
     * @param if payRate is less than 10 then it will be a waitstaff payrate
     */
    @Override
    public void setPayRate(double payRate) {
        this.payRate = 10;
        if (payRate < 10) {
            this.payRate = payRate;
        }
    }

    /**
     * Sets the job title for the given employee
     */
    @Override
    public void setJobTitle() {
        this.jobTitle = "waitstaff";
    }
}
