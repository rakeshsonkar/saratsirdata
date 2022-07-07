/**
 * 
 */
package in.ifms.employee.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Sharat Pradhan
 *
 *         This class is used as Request and Response body data transmission
 */
@JsonInclude(value = Include.NON_EMPTY)
public class EmployeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* place holder for employeeId */
	private Integer employeeId;

	/* place holder for employeeName */
	private String employeeName;

	/* place holder for email */
	private String email;

	/* place holder for phoneNum */
	private String phoneNum;

	/* place holder for type */
	private String type;

	/**
	 * 
	 */
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(Integer employeeId, String employeeName, String email, String phoneNum, String type) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.phoneNum = phoneNum;
		this.type = type;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, employeeId, employeeName, phoneNum, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(phoneNum, other.phoneNum)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", type=" + type + "]";
	}

}
