/**
 * 
 */
package in.ifms.employee.service;

import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.response.IFMSResponse;

/**
 * @author hp
 *
 */
public interface EmployeeService {

	/*
	 * this service method is responsible for saving or updating the employee
	 * details
	 */
	public IFMSResponse saveOrUpdate(EmployeeDTO employeeDTO, String type);

	/*
	 * this method gets list of all available employees
	 * 
	 */
	public IFMSResponse getEmployeeList();

	/*
	 * this method gets employee details with employee ID
	 * 
	 */
	public IFMSResponse getEmployeeById(Integer employeeId);

	/*
	 * delete employee details with employee ID
	 * 
	 */
	public IFMSResponse removeEmployeeById(Integer employeeId);

}
