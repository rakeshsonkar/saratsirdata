/**
 * 
 */
package in.ifms.employee.service;

import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.exception.IfmsBaseException;
import in.ifms.employee.response.IFMSResponse;

/**
 * @author Sharat Pradhan
 *
 */
public interface EmployeeService {

	/**
	 * this service method is responsible for saving or updating the employee
	 * details
	 */
	public IFMSResponse saveOrUpdate(EmployeeDTO employeeDTO) throws IfmsBaseException;

	/**
	 * this method gets list of all available employees
	 * 
	 */
	public IFMSResponse getEmployeeList() throws IfmsBaseException;

	/**
	 * this method gets employee details with employee ID
	 * 
	 */
	public IFMSResponse getEmployeeById(Integer employeeId) throws IfmsBaseException;

	/**
	 * delete employee details with employee ID
	 * 
	 */
	public IFMSResponse removeEmployeeById(Integer employeeId) throws IfmsBaseException;

}
