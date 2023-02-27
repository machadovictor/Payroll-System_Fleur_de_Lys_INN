import java.util.ArrayList;
import java.util.List;

/**
 * The Employee class represents an Employee with attributes such as employee ID, first name, last name,
 * department ID and a list of their pay amounts.
 */
public class Employee {
    /**
     * Declaring private instance variables for the employee's ID, first name, last name, department ID, and a list of their pay amounts.
     */
    private int empId;

    private String firstName;

    private String lastName;

    private int deptId;

    private List<Pay> payList;

    /**
     * A constructor that initializes the values of the instance variables when an object of the Employee class is created.
     *
     * @param empId The employee ID
     * @param firstName The first name of the employee
     * @param lastName The last name of the employee
     * @param deptId The department ID the employee belongs to
     */
    public Employee(int empId, String firstName, String lastName, int deptId) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deptId = deptId;
        this.payList = new ArrayList<>();
    }

    /**
     * Getter method for employee ID
     *
     * @return The employee ID
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Setter method for employee ID
     *
     * @param empId The new employee ID
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    } // Setting the employee ID to the input value

    /**
     * Getter method for first name
     *
     * @return The first name of the employee
     */
    public String getFirstName() {
        return firstName;
    } // Setting the employee ID to the input value

    /**
     * Setter method for first name
     *
     * @param firstName The new first name of the employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // Setting the employee ID to the input value

    /**
     * Getter method for last name
     *
     * @return The last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for last name
     *
     * @param lastName The new last name of the employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // Setting the employee ID to the input value

    /**
     * Getter method for department ID
     *
     * @return The department ID the employee belongs to
     */
    public int getDeptId() {
        return deptId;
    } // Setting the employee ID to the input value

    /**
     * Setter method for department ID
     *
     * @param deptId The new department ID the employee belongs to
     */
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    } // Setting the department ID to the input value

    /**
     * Getter method for pay list
     *
     * @return The list of pay amounts for the employee
     */
    public List<Pay> getPayList() {
        return payList;
    }

    public void setPayList(List<Pay> payList) {
        this.payList = payList;
    }

    // Overriding the toString method to return a string representation of the employee object
    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", deptId=" + deptId + ", paysList=" + payList + '}';
    }

    /**
     * Method to add a new pay amount to the list of pay amounts
     *
     * @param pay
     */
    public void addPay(Pay pay) {
        // Adding the new pay amount to the list
        payList.add(pay);
    }

    /**
     * Calculate and return the total overtime hours for the Employee
     *
     * @return total overtime hours for the Employee
     */
    public double getTotalOvertimeHours() {
        double totalOverTimeHours = 0;

        for (Pay pay : payList) {
            totalOverTimeHours += pay.getOvertime();
        }

        return (double) Math.round(totalOverTimeHours * 100) / 100;
    }

    /**
     * Calculate and return the total gross sales for the Employee
     *
     * @return total gross sales for the Employee
     */
    public double getTotalGrossSales() {
        double totalGrossSales = 0;

        for (Pay pay : payList) {
            totalGrossSales += pay.getTotalSales();
        }

        return (double) Math.round(totalGrossSales * 100) / 100;
    }
}

