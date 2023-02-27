/**
 * The `Department` class represents a department within Fleur de Lys Inn company.
 * It contains information about the department, such as its ID, name, and hourly rate.
 */
public class Department {
    /** The unique identifier of the department. */
    private int deptId;

    /** The name of the department. */
    private String deptName;

    /** The hourly rate for the department. */
    private double hourlyRate;

    /**
     * Constructs a new `Department` object with the given parameters.
     *
     * @param deptId the unique identifier of the department
     * @param deptName the name of the department
     * @param hourlyRate the hourly rate for the department
     */
    public Department(int deptId, String deptName, double hourlyRate) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the unique identifier of the department.
     *
     * @return the department ID
     */
    public int getDeptId() {
        return deptId;
    }

    /**
     * Returns the name of the department.
     *
     * @return the department name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Returns the hourly rate for the department.
     *
     * @return the hourly rate
     */
    public double getHourlyRate() {
        return hourlyRate;
    }
}