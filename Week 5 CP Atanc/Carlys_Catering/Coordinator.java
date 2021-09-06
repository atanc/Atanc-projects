/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package Carlys_Catering;

public class Coordinator extends Employee {
    public Coordinator(int id, String lastName, String firstName, double payRate) {
        super(id, lastName, firstName, payRate);
    }

    /**
     * Set the pay rate for the given employee
     * @param if payRate is less than 20 then it will be a coordinator payrate
     */
    @Override
    public void setPayRate(double payRate) {
        this.payRate = 20;
        if (payRate < 20) {
            this.payRate = payRate;
        }
    }

    /**
     * Sets the job title for the given employee
     */
    @Override
    public void setJobTitle() {
        this.jobTitle = "coordinator";
    }
}
