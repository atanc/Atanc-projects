/**
 * Addison Tancredi
 * Week 4
 * 4/4/20
 */
package Carlys_Catering;

public abstract class Employee {
    private static int idNum; //Field to store the idNum of the Employee
    private String lastName; //Field to store the lastName of the Employee
    private String firstName; //Field to store the firstName of the Employee
    protected double payRate; //Field to store the payRate of the Employee
    protected String jobTitle; //Field to store the jobTitle of the Employee

    public Employee(int id, String lastName, String firstName, double payRate) {
        setIdNum(id);
        setFirstName(firstName);
        setLastName(lastName);
        setPayRate(payRate);
        setJobTitle();
    }

    /**
     * Returns the id number of the Employee
     */
    public int getIdNum() {
        return idNum;
    }

    /**
     * Sets the id number of the Employee
     * @param idNum
     */
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    /**
     * Returns the last number of the Employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the Employee
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the first name of the Employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Employee
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the pay rate of the Employee
     */
    public double getPayRate() {
        return payRate;
    }

    /**
     * Sets the pay rate of the Employee
     * @param payRate
     */
    public abstract void setPayRate(double payRate);

    /**
     * Returns the job title of the Employee
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the job title of the Employee
     */
    public abstract void setJobTitle();

    @Override
    public String toString() {
        return "Employee: "
                + getIdNum() + " "
                + getJobTitle()  + " "
                + getFirstName() + ", " + getLastName()  + " "
                + "$" + getPayRate() + "/hr";
    }
}
