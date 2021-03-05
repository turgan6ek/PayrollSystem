package kz.iitu.demo.service;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;

import java.util.List;

public interface SalaryCalculatorServiceInterface {
    void create(Employee employee);
    List<Employee> findAll();
    List<Employee> getByType(EmployeeType employeeType);
    Employee findById(long id);
    void save(Employee employee);

    void changeSalary(long id, double salary);

    void changeHourRate(long id, double rate);

    void changeCommRate(long id, float rate);
}
