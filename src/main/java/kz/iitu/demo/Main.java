package kz.iitu.demo;

import kz.iitu.demo.config.SpringConfig;
import kz.iitu.demo.controller.EmployeeController;
import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import kz.iitu.demo.service.SalaryCalculatorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        EmployeeController employeeController = context.getBean("employeeController", EmployeeController.class);
    }
}
