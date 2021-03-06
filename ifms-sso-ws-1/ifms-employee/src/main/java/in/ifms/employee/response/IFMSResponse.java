/**
 * 
 */
package in.ifms.employee.response;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import in.ifms.employee.dto.EmployeeDTO;

/**
 * @author hp
 *
 *
 *         This is the IFMSResponse class for sending System Response codes and
 *         messages as a part of HTTP Response Body
 */
@JsonInclude(value = Include.NON_EMPTY)
public class IFMSResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String responseCode;

	private String responseMessage;

	private List<EmployeeDTO> employeeList;

	/**
	 * 
	 */
	public IFMSResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param responseCode
	 * @param responseMessage
	 */
	public IFMSResponse(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	/**
	 * @param responseCode
	 * @param responseMessage
	 * @param employeeList
	 */
	public IFMSResponse(String responseCode, String responseMessage, List<EmployeeDTO> employeeList) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
		this.employeeList = employeeList;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<EmployeeDTO> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeDTO> employeeList) {
		this.employeeList = employeeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeList, responseCode, responseMessage);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IFMSResponse other = (IFMSResponse) obj;
		return Objects.equals(employeeList, other.employeeList) && Objects.equals(responseCode, other.responseCode)
				&& Objects.equals(responseMessage, other.responseMessage);
	}

	@Override
	public String toString() {
		return "IFMSResponse [responseCode=" + responseCode + ", responseMessage=" + responseMessage + ", employeeList="
				+ employeeList + "]";
	}

}
