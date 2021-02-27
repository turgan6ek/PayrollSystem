package kz.iitu.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeID(resultSet.getInt(1));
        employee.setFull_name(resultSet.getString(2));
        employee.setEmployeeType(EmployeeType.valueOf(resultSet.getString(3)));
        employee.setHours(resultSet.getInt(4));
        employee.setSalary(resultSet.getDouble(5));
        return employee;
    }
}
