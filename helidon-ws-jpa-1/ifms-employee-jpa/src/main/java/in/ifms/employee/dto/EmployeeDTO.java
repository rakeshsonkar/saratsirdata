package in.ifms.employee.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

import in.ifms.employee.response.IFMSResponse;

/**
 * @author hp
 *
 */
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* placeholder for employeeId */
	@JsonProperty(value = "employeeId", defaultValue = "0", access = Access.READ_WRITE)
	private Integer employeeId;

	/* placeholder for employeeId */
	private String employeeName;

	/* placeholder for employeeId */
	private String email;

	/* placeholder for addressDTOList */
	private List<AddressDTO> addressDTOList;

	/* placeholder for type */
	private String type;

	private IFMSResponse ifmsResponse;

	/**
	 * 
	 */
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ifmsResponse
	 */
	public EmployeeDTO(IFMSResponse ifmsResponse) {
		super();
		this.ifmsResponse = ifmsResponse;
	}

	/**
	 * @param employeeId
	 * @param employeeName
	 * @param email
	 * @param addressDTOList
	 * @param type
	 * @param ifmsResponse
	 */
	public EmployeeDTO(Integer employeeId, String employeeName, String email, List<AddressDTO> addressDTOList,
			String type, IFMSResponse ifmsResponse) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.addressDTOList = addressDTOList;
		this.type = type;
		this.ifmsResponse = ifmsResponse;
	}

	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	@JsonSetter("employeeId")
	public void setEmployeeId(Object employeeId) {
		if (Objects.isNull(employeeId)) {
			this.employeeId = 0;
		} else if (employeeId.toString().equals("")) {
			this.employeeId = 0;
		}
		this.employeeId = Integer.valueOf(employeeId.toString());
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the addressDTOList
	 */
	public List<AddressDTO> getAddressDTOList() {
		return addressDTOList;
	}

	/**
	 * @param addressDTOList the addressDTOList to set
	 */
	public void setAddressDTOList(List<AddressDTO> addressDTOList) {
		this.addressDTOList = addressDTOList;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the ifmsResponse
	 */
	public IFMSResponse getIfmsResponse() {
		return ifmsResponse;
	}

	/**
	 * @param ifmsResponse the ifmsResponse to set
	 */
	public void setIfmsResponse(IFMSResponse ifmsResponse) {
		this.ifmsResponse = ifmsResponse;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", addressDTOList=" + addressDTOList + ", type=" + type + ", ifmsResponse=" + ifmsResponse + "]";
	}

}
