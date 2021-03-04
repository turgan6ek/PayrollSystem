package kz.iitu.demo.service;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;

import java.util.List;

public interface SalaryCalculatorServiceInterface {
    void create(Employee employee);

    List<Employee> getByType(EmployeeType employeeType);
}
