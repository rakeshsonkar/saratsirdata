package in.ifms.employee.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.ifms.employee.common.constants.ActionType;
import in.ifms.employee.common.constants.IFMSResponseCode;
import in.ifms.employee.dto.AddressDTO;
import in.ifms.employee.dto.EmployeeDTO;
import in.ifms.employee.entity.Address;
import in.ifms.employee.entity.Employee;
import in.ifms.employee.exception.IfmsBaseException;
import in.ifms.employee.repository.EmployeeRepository;
import in.ifms.employee.response.IFMSResponse;
import in.ifms.employee.service.EmployeeService;

@Dependent
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * placeholder for EmployeeRepository
	 */
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	/**
	 * 
	 */
	public EmployeeServiceImpl() {
	}

	@Inject
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDTO getEmployee(EmployeeDTO employeeDTO) {
		Employee employee = null;
		employeeDTO.setIfmsResponse(
				new IFMSResponse(IFMSResponseCode.FAILURE.getCode(), IFMSResponseCode.FAILURE.getMessage()));
		if (employeeDTO != null && employeeDTO.getEmployeeId() != null) {
			LOGGER.info("Employee with employeeId :: " + employeeDTO.getEmployeeId());
			try {
				employee = employeeRepository.getEmployeeById(employeeDTO.getEmployeeId());
				if (employee != null) {
					List<AddressDTO> addressDTOList = new ArrayList<>();
					// iterating the address list and adding each address
					if (Objects.nonNull(employee.getAddresses())) {
						AddressDTO addressDTO = null;
						for (Address address : employee.getAddresses()) {
							if (Objects.nonNull(address)) {
								addressDTO = new AddressDTO();
								// copy from address entity to dto
								addressDTO.setAddressId(address.getAddressId());
								// addressDTO.setEmployeeId(address.getEmployeeId());
								addressDTO.setStreet(address.getStreet());
								addressDTO.setCity(address.getCity());
								addressDTO.setCountry(address.getCountry());
								// add to the list
								addressDTOList.add(addressDTO);
							}
						}
						// set addresses to DTO
						employeeDTO.setAddressDTOList(addressDTOList);
					}
					// copy remaining fields to the dto
					employeeDTO.setEmail(employee.getEmail());
					employeeDTO.setEmployeeId(employee.getEmployeeId());
					employeeDTO.setEmployeeName(employee.getEmployeeName());
					// setting the success response code
					employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.SUCCESS.getCode());
					employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.SUCCESS.getMessage());
				} else {
					// null data -employee does not exist with the given id
					LOGGER.error("Employee with employeeId :: " + employeeDTO.getEmployeeId() + " :: does not exist");
					employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.INVALID_EMPLOYEE.getCode());
					employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.INVALID_EMPLOYEE.getMessage());
					return employeeDTO;
				}
			} catch (IllegalArgumentException illegalArgumentException) {
				LOGGER.error("Invalid employeeId :: " + employeeDTO.getEmployeeId(),
						illegalArgumentException.getMessage());
				employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.FAILURE.getCode());
				employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.FAILURE.getMessage());
			} catch (EntityNotFoundException entityNotFoundException) {
				LOGGER.error("Employee with employeeId :: " + employeeDTO.getEmployeeId() + " does not exist",
						entityNotFoundException.getMessage());
				employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.INVALID_EMPLOYEE.getCode());
				employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.INVALID_EMPLOYEE.getMessage());
			}
		} else {
			employeeDTO = new EmployeeDTO();
			employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.FAILURE.getCode());
			employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.FAILURE.getMessage());
			LOGGER.error("Invalid Data check for null values ");
		}
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getEmployeesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		// adding default response message
		employeeDTO.setIfmsResponse(
				new IFMSResponse(IFMSResponseCode.FAILURE.getCode(), IFMSResponseCode.FAILURE.getMessage()));
		Employee employee = new Employee();
		/*
		 * the following block gets executed when passed save as type of operation to be
		 * performed with the given employee details
		 */
		if (employeeDTO != null && employeeDTO.getType() != null
				&& employeeDTO.getType().equalsIgnoreCase(ActionType.UPDATE.getType())) {
			LOGGER.info("Employee with the details :: " + employeeDTO.toString());
			employee.setEmail(employeeDTO.getEmail());
			employee.setEmployeeName(employeeDTO.getEmployeeName());
			if (Objects.nonNull(employeeDTO.getAddressDTOList()) && employeeDTO.getAddressDTOList().size() != 0) {
				List<Address> addressList = new ArrayList<>();
				Address address = null;
				for (AddressDTO addressDTO : employeeDTO.getAddressDTOList()) {
					if (Objects.nonNull(addressDTO)) {
						address = new Address();
						// address.setEmployeeId(employee.getEmployeeId());
						address.setStreet(addressDTO.getStreet());
						address.setCity(addressDTO.getCity());
						address.setCountry(addressDTO.getCountry());
						// add address to the entity address list
						addressList.add(address);
					}
				}
				employee.setAddresses(addressList);
			}
			// save from the repository
			try {
				employeeRepository.createOrUpdate(employee);
			} catch (IfmsBaseException ifmsBaseException) {
				LOGGER.error("Invalid Data check for null values ");
			}

		} else {
			LOGGER.error("Invalid Data check for null values ");
			return employeeDTO;
		}
		// setting the success response code
		employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.SUCCESS.getCode());
		employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.SUCCESS.getMessage());
		return employeeDTO;
	}

	@Override
	public EmployeeDTO deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
		// adding default response message
		employeeDTO.setIfmsResponse(
				new IFMSResponse(IFMSResponseCode.FAILURE.getCode(), IFMSResponseCode.FAILURE.getMessage()));
		Employee employee = new Employee();
		/*
		 * the following block gets executed when passed save as type of operation to be
		 * performed with the given employee details
		 */
		if (employeeDTO != null && employeeDTO.getType() != null
				&& employeeDTO.getType().equalsIgnoreCase(ActionType.SAVE.getType())) {
			LOGGER.info("Employee with the details :: " + employeeDTO.toString());
			employee.setEmail(employeeDTO.getEmail());
			employee.setEmployeeName(employeeDTO.getEmployeeName());
			if (Objects.nonNull(employeeDTO.getAddressDTOList()) && employeeDTO.getAddressDTOList().size() != 0) {
				List<Address> addressList = new ArrayList<>();
				Address address = null;
				for (AddressDTO addressDTO : employeeDTO.getAddressDTOList()) {
					if (Objects.nonNull(addressDTO)) {
						address = new Address();
						// address.setEmployeeId(employee.getEmployeeId());
						address.setStreet(addressDTO.getStreet());
						address.setCity(addressDTO.getCity());
						address.setCountry(addressDTO.getCountry());
						// add address to the entity address list
						addressList.add(address);
					}
				}
				employee.setAddresses(addressList);
			}
			// save from the repository
			try {
				employeeRepository.createOrUpdate(employee);
			} catch (IfmsBaseException ifmsBaseException) {
				LOGGER.error("Invalid Data check for null values ");
			}

		} else {
			LOGGER.error("Invalid Data check for null values ");
			return employeeDTO;
		}
		// setting the success response code
		employeeDTO.getIfmsResponse().setResponseCode(IFMSResponseCode.SUCCESS.getCode());
		employeeDTO.getIfmsResponse().setResponseMessage(IFMSResponseCode.SUCCESS.getMessage());
		return employeeDTO;
	}

}
