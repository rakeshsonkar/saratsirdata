/**
 * 
 */
package in.ifms.employee.repository;

import javax.persistence.EntityExistsException;

import in.ifms.employee.entity.Employee;

/**
 * @author hp
 *
 */
public interface EmployeeRepository {

	/**
	 * 
	 */

	public Employee getEmployeeById(Integer type);

	public Employee createOrUpdate(Employee employee);

	/**
	 * This will get Employee from the database, when employeeId is passed within a
	 * JPQL query string
	 * 
	 * @param queryStr query as String type
	 * @return Employee instance with the given employee_id
	 * @throws @{@link IllegalArgumentException}
	 */
	public Employee getByEmployeeIdJpql(String queryStr);

	/**
	 * This will get Employee from the database, when employeeId is passed within a
	 * SQL query string
	 * 
	 * @param queryStr SQL query as String type
	 * @return Employee instance with the given employeeId
	 * @throws @{@link IllegalArgumentException}
	 */
	public Employee getByEmployeeIdSql(String queryStr) throws IllegalArgumentException;

	/**
	 * This will create a new Employee in the corresponding table in the database
	 * 
	 * @param employee Employee entity instance with all valid columns
	 * @throws @{@link EntityExistsException}
	 */
	public void create(Employee employee);

	/**
	 * This will create a new Employee in the corresponding table in the database
	 * 
	 * @param employee Employee entity instance with all valid columns
	 * @throws @{@link EntityExistsException}
	 */
	public void update(Employee employee);

}
