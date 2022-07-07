/**
 * 
 */
package in.ifms.employee.service;

import java.util.List;

import in.ifms.employee.dto.EmployeeDTO;

/**
 * @author hp
 *
 */
public interface EmployeeService {

	public EmployeeDTO getEmployee(EmployeeDTO employeeDTO);

	public List<EmployeeDTO> getEmployeesList();

	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO);

	public EmployeeDTO deleteEmployee(Integer employeeId);

	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

}
