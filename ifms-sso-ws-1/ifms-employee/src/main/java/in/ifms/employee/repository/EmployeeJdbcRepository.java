/**
 * 
 */
package in.ifms.employee.repository;

import java.util.List;

import in.ifms.employee.entity.Employee;

/**
 * @author hp
 *
 *         This is a Employee repository for performing Database operations
 *         through, JDBC Template (or) native sql queries
 */
public interface EmployeeJdbcRepository {

	/**
	 * saves the employee entity and returns the number of rows effected by this
	 * operation
	 */
	public int save(Employee employee);

	/**
	 * Updates the employee entity and returns the number of rows effected by this
	 * operation
	 */
	public int update(Employee employee);

	/**
	 * Fetches the employee entity and returns the number of rows effected by this
	 * operation
	 */
	public Employee findById(Integer employeeId);

	/**
	 * Deletes the employee entity by employeeId and returns the number of rows effected by this
	 * operation
	 */
	public int deleteById(Integer employeeId);

	/**
	 * Gets the list of all Employees available
	 */
	public List<Employee> findAll();

	/**
	 * Gets the list of employee entity by employeeName
	 */
	public List<Employee> findByEmployeeName(String employeeName);

	/**
	 * Gets the list of employee entity by email
	 * 
	 */
	public List<Employee> findByEmail(String email);

}
