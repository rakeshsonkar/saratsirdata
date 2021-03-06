/**
 * 
 */
package in.ifms.employee.controller;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.service.EmployeeService;

/**
 * @author hp
 *
 */
@Singleton
@Path("/employee")
public class EmployeeController {

	@Inject
	private EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	/**
	 * 
	 */
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	//@GET
	//get not allowed
	@Path("/employee/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public EmployeeDTO getEmployeeDetails(@PathParam("id") String requestStr) {
		LOGGER.info("EndPoint :: /employee requested with Employe ID :: " +requestStr);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setType(requestStr);
		employeeDTO = employeeService.getEmployee(employeeDTO);
		return employeeDTO;
	}

	@POST
	@Path("/service")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public EmployeeDTO getEmployee(@RequestBody EmployeeDTO employeeDTO) {
		LOGGER.info("EndPoint :: /employee/service accessed with Employee Details :: " + employeeDTO.toString());
		employeeDTO = employeeService.getEmployee(employeeDTO);
		return employeeDTO;
	}
	
	@POST
	@Path("/service/create")
	@Produces(value = MediaType.APPLICATION_JSON)
	@Consumes(value = MediaType.APPLICATION_JSON)
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		LOGGER.info("EndPoint :: /employee/service/create accessed with Employee Details :: " + employeeDTO.toString());
		employeeDTO = employeeService.addEmployee(employeeDTO);
		return employeeDTO;
	}

	
	//dummy end point for testing
	@GET
	@Path("/dummy")
	@Produces("application/json")
	public String getResponse() {
		LOGGER.info("EndPoint :: /employee/dummy accessed");
		return "{101 : john}";
	}

}
