/**
 * 
 */
package in.ifms.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.response.IFMSResponse;
import in.ifms.employee.service.EmployeeService;

/**
 * @author hp
 *
 */
@RestController
@RequestMapping(value = "/employee", produces = "application/json")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	/**
	 * 
	 */
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Request mapping for creating new employees or updating existing employees by
	 * using POST method
	 */
	@RequestMapping(value = "/{type}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<IFMSResponse> createOrUpdateEmployee(@RequestBody EmployeeDTO employeeDTO,
			@PathVariable("type") String type) {
		LOGGER.info("EndPoint :: /employee/" + type + " requested with Employee details :: " + employeeDTO.toString());
		return new ResponseEntity<IFMSResponse>(employeeService.saveOrUpdate(employeeDTO, type), HttpStatus.OK);
	}

	/** Request mapping for getting list of employees using GET method */
	@RequestMapping(value = "/get/all", method = RequestMethod.GET)
	public ResponseEntity<IFMSResponse> getEmployees() {
		LOGGER.info("EndPoint :: /employee/get/all requested ");
		return new ResponseEntity<IFMSResponse>(employeeService.getEmployeeList(), HttpStatus.OK);
	}

	/** Request mapping for getting list of employees using GET method */
	@RequestMapping(value = "search/{id}", method = RequestMethod.GET)
	public ResponseEntity<IFMSResponse> getEmployees(@PathVariable("id") Integer id) {
		LOGGER.info("EndPoint :: /employee/search/{id} requested with employeeId :: " + id);
		return new ResponseEntity<IFMSResponse>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	/** Request mapping for deleting an employee using GET method */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<IFMSResponse> removeEmployee(@PathVariable("id") Integer id) {
		LOGGER.info("EndPoint :: /employee/delete/{id} requested with employeeId :: " + id);
		return new ResponseEntity<IFMSResponse>(employeeService.removeEmployeeById(id), HttpStatus.OK);
	}

}
