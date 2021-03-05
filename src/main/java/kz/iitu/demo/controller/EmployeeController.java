package kz.iitu.demo.controller;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.service.SalaryCalculatorService;
import kz.iitu.demo.service.SalaryCalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class EmployeeController {
    Scanner scan = new Scanner(System.in).useLocale(Locale.US);
    @Autowired
    SalaryCalculatorServiceInterface salaryCalculatorServiceInterface;
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    @PostConstruct
    public void showMenu() {
        int choice = 0;
        while (choice != 6) {
            int i = 0;
            System.out.println("1. Calculate All Salaries");
            System.out.println("2. Change Hour Rate");
            System.out.println("3. Change Commission Rate");
            System.out.println("4. Change salary of employee");
            System.out.println("5. List of all employees");
            System.out.println("6. Exit");
            choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("\n==================================================================\n");
                    System.out.println("SALARIED EMPLOYEES: ");
                    List<Employee> employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED);
                    System.out.println(" --" +employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee: employees) {
                        System.out.println(i + ") " + employee.getName() + ": " + employee.getFixedSalary() + " tenges");
                        i++;
                    }
                    System.out.println("\n==================================================================\n");
                    System.out.println("HOURLY EMPLOYEES: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.HOURLY);
                    System.out.println(" --" +employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = employee.getFixedSalary();
                        int hours = employee.getHoursWorked();
                        if (hours > 40) {
                            System.out.println(i + ") " + employee.getName() + ": " + (salary * 40 + (hours - 40) * salary * employee.getHourRate()) + " (worked " + hours + " hours)");
                        }
                        else {
                            System.out.println(i + ") " + employee.getName() + ": " + salary * hours);
                        }
                        i++;
                    }
                    System.out.println("\n==================================================================\n");
                    System.out.println("COMMISSION EMPLOYEES: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.COMMISSION);
                    System.out.println(" --" +employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = (employee.getFixedSalary() * employee.getCommRate());
                        System.out.println(i + ") " + employee.getName() + ": " + df2.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println("\n==================================================================\n");
                    System.out.println("SALARIED COMMISSION EMPLOYEES: ");
                    employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED_COMMISSION);
                    System.out.println(" --" +employees.size() + " employees found.");
                    i = 1;
                    for (Employee employee: employees) {
                        double salary = ((employee.getFixedSalary() + employee.getCommRate() * employee.getFixedSalary()));
                        System.out.println(i + ") " + employee.getName() + ": " + df2.format(salary) + " tenges");
                        i++;
                    }
                    System.out.println();
                }
                break;
                case 2: {
                    System.out.println("\n==================================================================\n");
                    System.out.println("Enter the id: ");
                    int id = scan.nextInt();
                    System.out.println("Enter the new hour rate: ");
                    double rate = scan.nextDouble();
                    salaryCalculatorServiceInterface.changeHourRate(id,rate);
                    System.out.println("\n==================================================================\n");
                }
                break;
                case 3: {
                    System.out.println("\n==================================================================\n");
                    System.out.println("Enter the id: ");
                    int id = scan.nextInt();
                    System.out.println("Enter the new commission rate: ");
                    float rate = scan.nextFloat();
                    salaryCalculatorServiceInterface.changeCommRate(id,rate);
                    System.out.println("\n==================================================================\n");

                }
                break;
                case 4: {

                    System.out.println("\n==================================================================\n");
                    System.out.println("Enter the id: ");
                    int id = scan.nextInt();
                    System.out.println("Enter the new salary: ");
                    double salary = scan.nextDouble();
                    salaryCalculatorServiceInterface.changeSalary(id,salary);
                    System.out.println("\n==================================================================\n");
                }
                break;
                case 5: {
                    System.out.println("\n==================================================================\n");
                    i = 0;
                    List<Employee> employees = salaryCalculatorServiceInterface.findAll();
                    System.out.println("Total number of employees: " + employees.size());
                    for (Employee employee : employees) {
                        String name = employee.getName();
                        long id = employee.getId();
                        double salary = employee.getFixedSalary();
                        double hourRate = employee.getHourRate();
                        float commRate = employee.getCommRate();
                        System.out.println("ID: " + id+ " - " + name + " - Type : " + employee.getEmplType());
                    }
                    System.out.println("\n==================================================================\n");
                }
                break;
                default: {

                }
            }
        }
    }
}
