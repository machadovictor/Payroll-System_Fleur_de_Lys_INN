/**
 * The Pay class represents a weekly payroll calculation for an employee.
 *
 */
public class Pay {
    /** The week number for this payroll calculation. */
    private int weekNumber;

    /** The employee ID for this payroll calculation. */
    private int empId;

    /** The employee's hourly rate of pay. */
    private double hourlyRate;

    /** The number of hours worked by the employee. */
    private int numberOfHours;

    /** The employee's total sales for the week. */
    private double totalSales;

    /** The employee's overtime hours for the week. */
    private double overtime;

    /** The employee's Pension Fund of Canada contribution for the week. */
    private double pfc;

    /** The employee's Employment Insurance contribution for the week. */
    private double ei;

    /** The employee's gross salary for the week. */
    private double grossSalary;

    /**
     * Constructs a new Pay object with the given payroll data.
     *
     * @param weekNumber The week number for this payroll calculation.
     * @param empId The employee ID for this payroll calculation.
     * @param hourlyRate The employee's hourly rate of pay.
     * @param numberOfHours The number of hours worked by the employee.
     * @param totalSales The employee's total sales for the week.
     * @param overtime The employee's overtime hours for the week.
     * @param pfc The employee's provident fund contribution for the week.
     * @param ei The employee's employment insurance contribution for the week.
     * @param grossSalary The employee's gross salary for the week.
     */
    public Pay(int weekNumber, int empId, double hourlyRate, int numberOfHours, double totalSales, double overtime, double pfc, double ei, double grossSalary) {
        this.weekNumber = weekNumber;
        this.empId = empId;
        this.hourlyRate = hourlyRate;
        this.numberOfHours = numberOfHours;
        this.totalSales = totalSales;
        this.overtime = overtime;
        this.pfc = pfc;
        this.ei = ei;
        this.grossSalary = grossSalary;
    }

    /**
     * Returns the week number for this payroll calculation.
     *
     * @return The week number for this payroll calculation.
     */
    public int getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets the week number for this payroll calculation.
     *
     * @param weekNumber The new week number for this payroll calculation.
     */
    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * Returns the employee ID for this payroll calculation.
     *
     * @return The employee ID for this payroll calculation.
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Sets the employee ID for this payroll calculation.
     *
     * @param empId The new employee ID for this payroll calculation.
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * Returns the hourly rate of the employee.
     * @return The hourly rate of the employee.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the hourly rate of the employee.
     * @param hourlyRate The hourly rate of the employee.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the number of hours worked by the employee.
     * @return The number of hours worked by the employee.
     */
    public int getNumberOfHours() {
        return numberOfHours;
    }

    /**
     * Sets the number of hours worked by the employee.
     * @param numberOfHours The number of hours worked by the employee.
     */
    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    /**
     * Returns the total sales made by the employee.
     * @return The total sales made by the employee.
     */
    public double getTotalSales() {
        return totalSales;
    }

    /**
     * Sets the total sales made by the employee.
     * @param totalSales The total sales made by the employee.
     */
    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    /**
     * Returns the overtime amount for the employee.
     * @return The overtime amount for the employee.
     */
    public double getOvertime() {
        return overtime;
    }

    /**
     * Sets the overtime amount for the employee.
     * @param overtime The overtime amount for the employee.
     */
    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    /**
     * Returns the Pension Fund Canada (PFC) contribution.
     * @return The Pension Fund Canada (PFC) contribution.
     */
    public double getPfc() {
        return pfc;
    }

    /**
     * Sets the Pension Fund Canada (PFC) contribution.
     * @param pfc Pension Fund Canada (PFC) contribution.
     */
    public void setPfc(double pfc) {
        this.pfc = pfc;
    }

    /**
     * Returns the Employee Insurance (EI) contribution.
     * @return the Employee Insurance (EI) contribution.
     */
    public double getEi() {
        return ei;
    }

    /**
     * Sets the Employee Insurance (EI) contribution.
     * @param ei Employee Insurance (EI) contribution.
     */
    public void setEi(double ei) {
        this.ei = ei;
    }

    /**
     * Returns the Gross Salary for the employee.
     * @return the grossSalary for the employee.
     */
    public double getGrossSalary() {
        return grossSalary;
    }

    /**
     * Sets the Gross Salary for the employee.
     * @param grossSalary .
     */
    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

}
