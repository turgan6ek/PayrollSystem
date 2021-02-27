package kz.iitu.demo;

import javax.sql.DataSource;
import java.util.List;

public interface EmployeeDao {
    public void setDataSource(DataSource ds);
    public List<Employee> employeeList();
}
