/**
 * 
 */
package in.ifms.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ifms.employee.entity.Employee;

/**
 * @author hp
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
