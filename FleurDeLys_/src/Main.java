//Final Project - Fleur de Lys Inn
//Object-oriented programming 1 (420-PO1-ID)
//Student: Victor Hugo Motta Machado (ID: 653227967)
//Instructor: Yves Desharnais
//Date:13 February 2023

import java.util.Scanner;

public class Main {

    /**
     * Creation of the variable that controls the continuity of use of the application.
     */
    private static boolean isContinue = true;

    /**
     * Creating the Scanner
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Main method that runs the pay system application.
     *
     * @param args array of string arguments
     */
    public static void main(String[] args) {
        int empId;
        String firstName;
        String lastName;
        int deptId;
        int weekNumber;
        double hourlyRate;
        int numberOfHours;
        double totalSales;
        double overtime;

        /**
         * Instantiating paysystem
         */
        PaySystem paySystem = new PaySystem();

        /**
         * Display menu while isContinue
         */
        while (isContinue) {
            /**
             * Display the pay system menu options
             */
            System.out.println(paySystem.displayMenu());

            /**
             * Get the option selected by the user
             */
            int option = scanner.nextInt();

            /**
             * Switch statement to call methods according to the option chosen by the user
             */
            switch (option) {
                case 1:
                    String tryAgainDept = "Y";
                    boolean isValidDept;

                    System.out.println("ID : ");
                    empId = scanner.nextInt();

                    System.out.println("First Name : ");
                    firstName = scanner.next();

                    System.out.println("Last Name : ");
                    lastName = scanner.next();

                    /**
                     * Validate the department id
                     */
                    do {
                        System.out.println("Dept ID: ");
                        deptId = scanner.nextInt();

                        isValidDept = paySystem.validateDepartment(deptId);

                        /**
                         * Ask the user to try again if the department id is invalid
                         */
                        if (!isValidDept) {
                            System.out.printf("Department id %s does not exists. Do you want to try again ? (Y / N)", deptId);
                            tryAgainDept = scanner.next();
                        }
                    } while (tryAgainDept.equalsIgnoreCase("Y") && !isValidDept);

                    /**
                     * Return to the main menu if the user does not want to try again
                     */
                    if (!tryAgainDept.equalsIgnoreCase("Y")) {
                        isToContinue();
                        break;
                    }

                    /**
                     * Create a new employee instance with the information collected using scanner
                     */
                    Employee employee = new Employee(empId, firstName, lastName, deptId);

                    /**
                     * Structure to display a success or error message for option 1.
                     */
                    boolean isAdded = paySystem.addEmployee(employee);

                    if (isAdded) {
                        System.out.printf("The employee %s was registered with success.%n", employee.getFirstName());
                    } else {
                        System.out.printf("ERROR : The employee %s has an Id already registered, please, try again.%n", employee.getFirstName());
                    }

                    isToContinue();
                    break;
                case 2:
                    /**
                     * This block of code is for the case 2 of a switch statement.
                     * It captures the employee information required for payment calculation.
                     * @param weekNumber An integer representing the week number for which the payment is being calculated.
                     * @param empId An integer representing the employee id for which the payment is being calculated.
                     * @param numberOfHours An integer representing the number of hours worked by the employee.
                     * @param totalSales A double representing the total sales made by the employee.
                     * @param overtime An integer representing the number of overtime hours worked by the employee.
                     * @param hourlyRate A double representing the hourly rate for the employee.
                     * @param pfc A double representing the PFC tax.
                     * @param ei A double representing the EI tax.
                     * @param grossSalary A double representing the gross salary of the employee.
                     * @param isValidEmp A boolean representing whether the employee id provided is valid or not.
                     * @param tryAgainEmp A String representing whether the user wants to try again in case of invalid employee id.
                     * @param empPay An object of type Employee representing the employee for whom the payment is being calculated.
                     * @param pay An object of type Pay representing the payment being calculated.
                     * @param isAddedPay A boolean representing whether the payment has been successfully added or not.
                     */
                    String tryAgainEmp = "Y";
                    boolean isValidEmp;

                    System.out.println("Week Number: ");
                    weekNumber = scanner.nextInt();

                    do {
                        System.out.println("Employee ID: ");
                        empId = scanner.nextInt();

                        isValidEmp = paySystem.validateEmployee(empId);

                        if (!isValidEmp) {
                            System.out.printf("Employee id %s does not exists. Do you want to try again ? (Y / N)", empId);
                            tryAgainEmp = scanner.next();
                        }
                    } while (tryAgainEmp.equalsIgnoreCase("Y") && !isValidEmp);

                    if (!tryAgainEmp.equalsIgnoreCase("Y")) {
                        isToContinue();
                        break;
                    }

                    System.out.println("Number of Hours Worked: ");
                    numberOfHours = scanner.nextInt();

                    if (numberOfHours > 44) {
                        overtime = numberOfHours - 44;
                        numberOfHours = 44;
                    } else {
                        overtime = 0;
                    }

                    System.out.println("Total Sales: ");
                    totalSales = scanner.nextDouble();

                    double grossSalary = 0.0;
                    Employee empPay = paySystem.getEmployee(empId);

                    hourlyRate = paySystem.getDeptRate(empPay.getDeptId());

                    switch (empPay.getDeptId()) {
                        case 1:
                        case 2:
                        case 3:
                            if (overtime == 0) {
                                grossSalary = numberOfHours * hourlyRate;
                            } else {
                                grossSalary = (numberOfHours * hourlyRate) + (overtime * hourlyRate * 1.5);
                            }
                            break;
                        case 4:
                            grossSalary = (numberOfHours * hourlyRate) + (totalSales * 0.015);
                            break;
                    }

                    double pfc = grossSalary * 0.0495 * 2;
                    double ei = grossSalary * 0.0198;

                    Pay pay = new Pay(weekNumber, empId, hourlyRate, numberOfHours, totalSales, overtime, pfc, ei, grossSalary);
                    empPay.addPay(pay);

                    boolean isAddedPay = paySystem.addPay(pay);

                    if (isAddedPay) {
                        System.out.printf("The payment for week %s for employee Id %s has been successfully registered.%n", pay.getWeekNumber(), pay.getEmpId());
                    } else {
                        System.out.printf("PROCESSING ERROR : Please, try again.%n");
                    }

                    isToContinue();
                    break;
                case 3:
                    /**
                     This block of code is responsible for showing the user the total amount of contributions to the Pension Fund of Canada (PFC).
                     It accomplishes this by invoking the PaySystem class's calculatePFC() method and displaying the result on the screen.
                     Next, the isToContinue() method is called to determine if the user wants to continue using the system.
                     */
                    System.out.printf("Total contributions to the Pension Fund of Canada is %s", paySystem.calculatePFC());

                    isToContinue();
                    break;
                case 4:
                    /**
                     This code block is responsible for showing the user the total value of contributions to the Employment Insurance (EI).
                     It accomplishes this by invoking the PaySystem class's calculateEI() method and displaying the result on the screen.
                     Next, the isToContinue() method is called to determine if the user wants to continue using the system.
                     */
                    System.out.printf("Total contributions to the Employment Insurance is %s", paySystem.calculateEI());

                    isToContinue();
                    break;
                case 5:
                    /**
                     This block of code is responsible for displaying a list of employees with a fixed hourly rate to the user.
                     It does this by invoking the displayFixEmployees() method of the PaySystem class and displaying the results on the screen.
                     Then, the isToContinue() method is called to determine if the user wants to continue using the system.
                     */
                    System.out.println("List of fixed hourly rate employees : ");

                    for (String result : paySystem.displayFixEmployees()) {
                        System.out.println(result);
                    }

                    isToContinue();
                    break;
                case 6:
                    /**
                     This code block displays a list of commission employees in the pay system.
                     The for loop iterates through the elements in the `paySystem.displayCommEmployees()` list and prints each result to the console using `System.out.println(result)`.
                     Finally, the `isToContinue()` method is called to determine if the program should continue or not.
                     */
                    System.out.println("List of commission employees : ");

                    for (String result : paySystem.displayCommEmployees()) {
                        System.out.println(result);
                    }

                    isToContinue();
                    break;
                case 7:
                    /**
                     This code block just terminates the application.
                     */
                    isContinue = false;
                    break;
                default:
                    /**
                     Structure to handle situations where the user does not choose a function from 1 to 7.
                     */
                    System.out.println("Invalid Option");
                    isToContinue();
                    break;
            }
        }

        System.out.println("------------------- END ------------------------");
    }

    /**
     Method to ask the user if he wants to continue or close the application.
     */
    private static void isToContinue() {
        System.out.println("\nDo you want to continue ? (Y / N)");
        String answer = scanner.next();

        //Personal note: this format does the same thing as an If Else statement
        isContinue = answer.equalsIgnoreCase("Y");
    }
}