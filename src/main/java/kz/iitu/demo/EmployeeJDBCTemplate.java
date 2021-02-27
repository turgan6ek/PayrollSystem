package kz.iitu.demo;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeJDBCTemplate implements EmployeeDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Employee> employeeList() {
        String query = "SELECT * FROM employees";
        List<Employee> employees = jdbcTemplate.query(query, new EmployeeMapper());
        return employees;
    }
}
