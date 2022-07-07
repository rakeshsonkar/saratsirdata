/**
 * 
 */
package in.ifms.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.ifms.employee.constant.SprocName;
import in.ifms.employee.entity.Employee;

/**
 * @author Sharat Pradhan
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	/**
	 * calling sproc directly by using the Query annotation
	 */
	@Query(value = SprocName.CALL_TOTAL_EMPLOYEES_BY_DEPT, nativeQuery = true)
	List<Employee> findEmployeeByDepartment(@Param("dept") String department);

}
