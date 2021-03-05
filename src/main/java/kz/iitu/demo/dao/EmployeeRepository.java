package kz.iitu.demo.dao;

import kz.iitu.demo.entity.Employee;
import kz.iitu.demo.entity.EmployeeType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByEmplType(EmployeeType employeeType);
    Employee findEmployeesById(long id);
    List<Employee> findAll();

}
