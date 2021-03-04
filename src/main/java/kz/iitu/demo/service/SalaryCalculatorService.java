package kz.iitu.demo.service;

import kz.iitu.demo.dao.EmployeeRepository;
import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryCalculatorService  implements SalaryCalculatorServiceInterface{
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }
    @Override
    public List<Employee> getByType(EmployeeType employeeType) {
        return employeeRepository.findEmployeesByEmplType(employeeType);
    }

}
