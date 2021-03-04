package kz.iitu.demo.controller;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.service.SalaryCalculatorService;
import kz.iitu.demo.service.SalaryCalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class EmployeeController {
    Scanner scan = new Scanner(System.in);
    @Autowired
    SalaryCalculatorServiceInterface salaryCalculatorServiceInterface;
    public void showMenu() {
        System.out.println("1. Salaried Employees");
        System.out.println("2. Salaried Employees");
        System.out.println("3. Salaried Employees");
        System.out.println("4. Salaried Employees");
        System.out.println("5. Exit");
        int choice = scan.nextInt();
        while (choice != 5) {
            switch (choice) {
                case 1: {
                    List<Employee> employees = salaryCalculatorServiceInterface.getByType(EmployeeType.SALARIED);
                    int i = 0;
                    for (Employee employee: employees) {
                        i++;
                        System.out.print(i + ") ");
                        employee.toString();
                    }
                }
                break;
                case 2: {

                }
                break;
                case 3: {

                }
                break;
                case 4: {

                }
                break;
                default: {

                }
            }
            System.out.println("1. Salaried Employees");
            System.out.println("2. Salaried Employees");
            System.out.println("3. Salaried Employees");
            System.out.println("4. Salaried Employees");
            System.out.println("5. Exit");
            choice = scan.nextInt();
        }
    }
}
