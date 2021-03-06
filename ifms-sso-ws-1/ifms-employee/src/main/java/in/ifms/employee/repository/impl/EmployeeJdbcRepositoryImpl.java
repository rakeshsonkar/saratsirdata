/**
 * 
 */
package in.ifms.employee.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.ifms.employee.common.constants.SQLQuery;
import in.ifms.employee.entity.Employee;
import in.ifms.employee.repository.EmployeeJdbcRepository;

/**
 * @author hp
 *
 */
@Repository
public class EmployeeJdbcRepositoryImpl implements EmployeeJdbcRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeJdbcRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;

	/**
	 * 
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update(SQLQuery.SAVE_NEW_EMPLOYEE.getQueryString(),
				new Object[] { employee.getEmployeeName(), employee.getEmail(), employee.getPhoneNum() });
	}

	@Override
	public int update(Employee employee) {
		return jdbcTemplate.update(SQLQuery.UPDATE_EMPLOYEE_BY_ID.getQueryString(), employee.getEmployeeName(),
				employee.getEmail(), employee.getPhoneNum(), employee.getEmployeeId());
	}

	@Override
	public Employee findById(Integer employeeId) {
		return jdbcTemplate.queryForObject(SQLQuery.GET_EMPLOYEE_BY_ID.getQueryString(), new EmployeeMapper());
	}

	@Override
	public int deleteById(Integer employeeId) {
		return jdbcTemplate.update(SQLQuery.DELETE_EMPLOYEE_BY_ID.getQueryString(), Integer.valueOf(employeeId));
	}

	@Override
	public List<Employee> findAll() {
		LOGGER.info("Returning employee list");
		return jdbcTemplate.query(SQLQuery.GET_ALL_EMPLOYEES.getQueryString(), new EmployeeMapper());
	}

	@Override
	public List<Employee> findByEmployeeName(String employeeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * RowMapper implementation for Employee
	 */
	private static final class EmployeeMapper implements RowMapper<Employee> {
		//implementing the mapRow of RowMapper interface
		//to avoid the boiler-plate code for iterating the resultSet object
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
			employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
			employee.setEmail(rs.getString("EMAIL"));
			employee.setPhoneNum(rs.getString("PHONE_NUM"));
			return employee;
		}
	}

}
