import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Class that implements a Pay System for Fleur de Lys Inn
 */
public class PaySystem {

    private List<Employee> myEmployees;

    private List<Pay> myPayList;

    private List<Department> departmentList;

    /**
     * Constructor for the PaySystem class
     * Initializes lists for Employees, Pays, and Departments
     */
    public PaySystem() {
        myEmployees = new ArrayList<>();

        Employee emp1 = new Employee(1, "Victor", "Machado", 1);
        Employee emp2 = new Employee(2, "Priscilla", "Rocha", 4);

        myEmployees.add(emp1);
        myEmployees.add(emp2);

        myPayList = new ArrayList<>();

        departmentList = new ArrayList<>();

        Department restaurant = new Department(1, "Restaurant", 8.5);
        Department maintenance = new Department(2, "Maintenance", 12.5);
        Department clerk = new Department(3, "Clerk / Landscapers", 15.75);
        Department sales = new Department(4, "Sales", 15);

        departmentList.add(restaurant);
        departmentList.add(maintenance);
        departmentList.add(clerk);
        departmentList.add(sales);
    }

    /**
     * Getter for the list of Employees
     * @return list of Employees
     */
    public List<Employee> getMyEmployees() {
        return myEmployees;
    }

    /**
     * Setter for the list of Employees
     * @param myEmployees list of Employees
     */
    public void setMyEmployees(List<Employee> myEmployees) {
        this.myEmployees = myEmployees;
    }

    /**
     * Getter for the list of Payments
     * @return list of payments
     */
    public List<Pay> getMyPayList() {
        return myPayList;
    }

    /**
     * Setter for the list of Payments
     * @param myPayList list of Payments
     */
    public void setMyPayList(List<Pay> myPayList) {
        this.myPayList = myPayList;
    }

    /**
     * Generates and returns the menu for the Pay System
     * @return string with the menu options
     */
    public String displayMenu() {
        StringJoiner sj = new StringJoiner("\n");

        System.out.println("------------------- Fleur de Lys Inn - Payroll System ------------------------");
        sj.add("Choose an option:\n");
        sj.add("1- Add an employee");
        sj.add("2- Add a pay");
        sj.add("3- Display the total contributions to the Pension Fund of Canada");
        sj.add("4- Display the total contributions to the Employment Insurance");
        sj.add("5- List of fixed hourly rate employees (ID, name and overtime hours)");
        sj.add("6- List of commission employees (ID, name and gross sales)");
        sj.add("7- Exit");
        sj.add("\nOption: ");

        return sj.toString();
    }

    /**
     * Refers to option 1 in Menu
     *
     * @return
     */
    public boolean addEmployee(Employee employee) {
        // add employee to the list of employees
        for (Employee emp : myEmployees) {
            if (emp.getEmpId() == employee.getEmpId()) {
                return false;
            }
        }

        return myEmployees.add(employee);
    }

    /**
     * Refers to option 2 in Menu
     *
     * @param pay
     * @return
     */
    public boolean addPay(Pay pay) {
        // add pay to the list of pays
        for (Pay p : myPayList) {
            if (p.getWeekNumber() == pay.getWeekNumber() && p.getEmpId() == pay.getEmpId()) {
                return false;
            }
        }
        return myPayList.add(pay);
    }

    /**
     * Refers to option 3 in Menu
     * <p>
     * Calculate total contributions to the Pension Fund of Canada
     *
     * @return
     */
    public double calculatePFC() {
        double pfcTotal = 0;

        for (Pay pay : myPayList) {
            pfcTotal += pay.getPfc();
        }

        return (double) Math.round(pfcTotal * 100) / 100;
    }

    /**
     * Refers to option 4 in Menu
     * <p>
     * Calculate total contributions to Employment Insurance
     *
     * @return
     */
    public double calculateEI() {
        double eiTotal = 0;

        for (Pay pay : myPayList) {
            eiTotal += pay.getEi();
        }

        return (double) Math.round(eiTotal * 100) / 100;
    }

    /**
     * Refers to option 5 in Menu
     * <p>
     * Display fixed hourly rate employees (ID, name, and overtime hours)
     *
     * @return
     */
    public List<String> displayFixEmployees() {
        List<String> fixEmp = new ArrayList<>();

        for (Employee emp : myEmployees) {
            if (emp.getDeptId() == 1 || emp.getDeptId() == 2 || emp.getDeptId() == 3) {
                String result = String.format("ID : %s \n Name : %s %s \n Overtime hours : %s \n ========================= \n", emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getTotalOvertimeHours());
                fixEmp.add(result);
            }
        }

        return fixEmp;
    }

    /**
     * Refers to option 6 in Menu
     * <p>
     * Display commission employees (ID, name, and gross sales)
     *
     * @return
     */
    public List<String> displayCommEmployees() {
        List<String> commEmp = new ArrayList<>();

        for (Employee emp : myEmployees) {
            if (emp.getDeptId() == 4) {
                String result = String.format("ID : %s \n Name : %s %s \n Gross sales : %s \n ========================= \n", emp.getEmpId(), emp.getFirstName(), emp.getLastName(), emp.getTotalGrossSales());
                commEmp.add(result);
            }
        }

        return commEmp;
    }

    /**
     * Validates an employee by checking if their employee ID exists in the list of employees.
     * @param empId The employee ID to be validated.
     * @return Returns true if the employee ID exists in the list of employees, false otherwise.
     */
    public boolean validateEmployee(int empId) {
        for (Employee emp : myEmployees) {
            if (emp.getEmpId() == empId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Validates the department based on the department ID.
     * @param deptId The department ID to be validated.
     * @return True if the department ID is one of 1, 2, 3, or 4, false otherwise.
     */
    public boolean validateDepartment(int deptId) {
        boolean isValid;

        switch (deptId) {
            case 1:
            case 2:
            case 3:
            case 4:
                isValid = true;
                break;
            default:
                isValid = false;
        }

        return isValid;
    }

    /**
     * Returns the {@link Employee} object with the specified employee ID.
     * @param empId the employee ID to search for
     * @return the {@link Employee} object if found, otherwise null
     */
    public Employee getEmployee(int empId) {
        Employee employee = null;
        // Iterates through the list of employees
        for (Employee emp : myEmployees) {
            // If the employee ID matches the specified ID, set the employee object to that employee
            if (emp.getEmpId() == empId) {
                employee = emp;
            }
        }
        // Returns the employee object
        return employee;
    }

    /**
     * Returns the hourly rate of a department with a given department ID.
     *
     * @param deptId The ID of the department to search for.
     * @return The hourly rate of the department with the given ID. Returns null if the department is not found.
     */
    public Double getDeptRate(int deptId) {
        for (Department dept : departmentList) {
            if (dept.getDeptId() == deptId) {
                return dept.getHourlyRate();
            }
        }
        return null;
    }

}
