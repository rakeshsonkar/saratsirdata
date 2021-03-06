/**
 * 
 */
package in.ifms.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import in.ifms.employee.common.constants.ActionType;
import in.ifms.employee.common.constants.IFMSResponseCode;
import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.entity.Employee;
import in.ifms.employee.exception.IfmsBaseException;
import in.ifms.employee.repository.EmployeeRepository;
import in.ifms.employee.response.IFMSResponse;
import in.ifms.employee.service.EmployeeService;

/**
 * @author hp
 *
 */
@Component
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * 
	 */
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IFMSResponse getEmployeeById(Integer employeeId) {
		// adding default response message
		IFMSResponse ifmsResponse = new IFMSResponse(IFMSResponseCode.FAILURE.getCode(),
				IFMSResponseCode.FAILURE.getMessage());
		EmployeeDTO employeeDTO = new EmployeeDTO();
		Optional<Employee> employeeOptional = null;
		/*
		 * the following block gets executed when passed save as type of operation to be
		 * performed with the given employee details
		 */
		if (employeeId != null) {
			// block for saving or creating a new employee
			employeeOptional = employeeRepository.findById(employeeId);
			if (employeeOptional.isPresent()) {
				Employee employee = employeeOptional.get();
				employeeDTO.setEmployeeId(employee.getEmployeeId());
				employeeDTO.setEmployeeName(employee.getEmployeeName());
				employeeDTO.setEmail(employee.getEmail());
				employeeDTO.setPhoneNum(employee.getPhoneNum());
				ifmsResponse.setEmployeeList(new ArrayList<>());
				ifmsResponse.getEmployeeList().add(employeeDTO);
			} else {
				LOGGER.error("Employee with the employee ID :: " + employeeId + " doesn't exist");
				ifmsResponse.setResponseCode(IFMSResponseCode.INVALID_EMPLOYEE.getCode());
				ifmsResponse.setResponseMessage(IFMSResponseCode.INVALID_EMPLOYEE.getMessage());
				return ifmsResponse;
			}
		} else {
			LOGGER.error("Invalid Data check for null values ");
			return ifmsResponse;
		}
		// setting the success response code
		ifmsResponse.setResponseCode(IFMSResponseCode.SUCCESS.getCode());
		ifmsResponse.setResponseMessage(IFMSResponseCode.SUCCESS.getMessage());
		LOGGER.info("Employee with the employeeId :: [" + employeeDTO.getEmployeeId() + "] retrieved");
		return ifmsResponse;
	}

	@Override
	public IFMSResponse getEmployeeList() {
		// adding default response message
		IFMSResponse ifmsResponse = new IFMSResponse(IFMSResponseCode.FAILURE.getCode(),
				IFMSResponseCode.FAILURE.getMessage());
		List<EmployeeDTO> employeeDTOList = new ArrayList<>();
		List<Employee> employeeList = employeeRepository.findAll();

		if (employeeList != null && employeeList.size() != 0) {
			ifmsResponse.setEmployeeList(new ArrayList<>());
			EmployeeDTO employeeDTOTemp = new EmployeeDTO();
			for (Employee employee : employeeList) {
				if (employee != null) {
					employeeDTOTemp = new EmployeeDTO();
					employeeDTOTemp.setEmployeeId(employee.getEmployeeId());
					employeeDTOTemp.setEmployeeName(employee.getEmployeeName());
					employeeDTOTemp.setEmail(employee.getEmail());
					employeeDTOTemp.setPhoneNum(employee.getPhoneNum());
					// add to dto list
					employeeDTOList.add(employeeDTOTemp);
				}
			}
			ifmsResponse.setEmployeeList(employeeDTOList);
		} else {
			LOGGER.error("Invalid Data check for null values ");
			return ifmsResponse;
		}
		// setting the success response code
		ifmsResponse.setResponseCode(IFMSResponseCode.SUCCESS.getCode());
		ifmsResponse.setResponseMessage(IFMSResponseCode.SUCCESS.getMessage());
		LOGGER.info("Employees list successfully retrieved");
		return ifmsResponse;
	}

	@Override
	@Transactional
	public IFMSResponse saveOrUpdate(EmployeeDTO employeeDTO, String type) {

		// adding default response message
		IFMSResponse ifmsResponse = new IFMSResponse(IFMSResponseCode.FAILURE.getCode(),
				IFMSResponseCode.FAILURE.getMessage());
		Employee employee = null;
		/*
		 * the following block gets executed when passed save as type of operation to be
		 * performed with the given employee details
		 */
		if (employeeDTO != null && type != null) {
			// block for saving or creating a new employee
			if (type.equalsIgnoreCase(ActionType.CREATE.getType()) && employeeDTO.getEmployeeName() != null
					&& employeeDTO.getEmail() != null && employeeDTO.getPhoneNum() != null) {
				LOGGER.info("Employee with the details :: " + employeeDTO.toString());
				employee = new Employee();
				employee.setEmail(employeeDTO.getEmail());
				employee.setEmployeeName(employeeDTO.getEmployeeName());
				employee.setPhoneNum(employeeDTO.getPhoneNum());
				// save from the repository
				try {
					employeeRepository.save(employee);
					LOGGER.info("Employee with the employeeId :: [" + employee.getEmployeeId() + "] created");
					ifmsResponse.setResponseCode(IFMSResponseCode.EMP_SUCCESS_CREATE.getCode());
					ifmsResponse.setResponseMessage(IFMSResponseCode.EMP_SUCCESS_CREATE.getMessage());

				} catch (IfmsBaseException ifmsBaseException) {
					LOGGER.error("Exception updating employee with employee ID :: [" + employeeDTO.getEmployeeId(),
							ifmsBaseException.getMessage());
				}
			} else if (type.equalsIgnoreCase(ActionType.UPDATE.getType())) {
				// block for updating existing employee
				// check whether employee id is valid or not
				Optional<Employee> employeeOptional = employeeRepository.findById(employeeDTO.getEmployeeId());
				if (employeeOptional.isPresent()) {
					employee = employeeOptional.get();
					employee.setEmployeeId(employee.getEmployeeId());
					// ignoring the null values
					if (employeeDTO.getEmployeeName() != null && employeeDTO.getEmployeeName().strip() != "") {
						employee.setEmployeeName(employeeDTO.getEmployeeName());
					}
					if (employeeDTO.getEmail() != null && employeeDTO.getEmail().strip() != "") {
						employee.setEmail(employeeDTO.getEmail());
					}
					if (employeeDTO.getPhoneNum() != null && employeeDTO.getPhoneNum().strip() != "") {
						employee.setPhoneNum(employeeDTO.getPhoneNum());
					}

					try {
						employeeRepository.saveAndFlush(employee);
						LOGGER.info("Employee with the employeeId :: [" + employee.getEmployeeId() + "] updated");
						ifmsResponse.setResponseCode(IFMSResponseCode.EMP_SUCCESS_UPDATE.getCode());
						ifmsResponse.setResponseMessage(IFMSResponseCode.EMP_SUCCESS_UPDATE.getMessage());
					} catch (IfmsBaseException ifmsBaseException) {
						LOGGER.error("Exception updating employee with employee ID :: [" + employeeDTO.getEmployeeId(),
								ifmsBaseException.getMessage());
					}
				} else {
					LOGGER.error(
							"Employee with the employee ID :: [" + employeeDTO.getEmployeeId() + "] doesn't exist");
					ifmsResponse.setResponseCode(IFMSResponseCode.INVALID_EMPLOYEE.getCode());
					ifmsResponse.setResponseMessage(IFMSResponseCode.INVALID_EMPLOYEE.getMessage());
					return ifmsResponse;
				}

			} else {
				LOGGER.error("Invalid request type :: " + type);
				return ifmsResponse;
			}

		} else {
			LOGGER.error("Invalid Data check for null values ");
			return ifmsResponse;
		}
		return ifmsResponse;
	}

	@Override
	public IFMSResponse removeEmployeeById(Integer employeeId) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		// adding default response message
		IFMSResponse ifmsResponse = new IFMSResponse(IFMSResponseCode.FAILURE.getCode(),
				IFMSResponseCode.FAILURE.getMessage());
		Optional<Employee> employeeOptional = null;
		/*
		 * the following block gets executed when passed save as type of operation to be
		 * performed with the given employee details
		 */
		if (employeeId != null) {
			// block for saving or creating a new employee
			employeeOptional = employeeRepository.findById(employeeId);
			if (employeeOptional.isPresent()) {
				try {
					employeeRepository.deleteById(employeeId);
					// setting the success response code
					ifmsResponse.setResponseCode(IFMSResponseCode.EMP_SUCCESS_DELETE.getCode());
					ifmsResponse.setResponseMessage(IFMSResponseCode.EMP_SUCCESS_DELETE.getMessage());
					LOGGER.info("Employee with the employeeId :: [" + employeeId + "] deleted");
				} catch (IfmsBaseException ifmsBaseException) {
					LOGGER.error("Exception deleting employee with employee ID :: [" + employeeDTO.getEmployeeId(),
							ifmsBaseException.getMessage());
				}

			} else {
				LOGGER.error("Employee with the employee ID :: " + employeeId + " doesn't exist");
				ifmsResponse.setResponseCode(IFMSResponseCode.INVALID_EMPLOYEE.getCode());
				ifmsResponse.setResponseMessage(IFMSResponseCode.INVALID_EMPLOYEE.getMessage());
				return ifmsResponse;
			}
		} else {
			LOGGER.error("Invalid Data check for null values ");
			return ifmsResponse;
		}

		return ifmsResponse;

	}

}
