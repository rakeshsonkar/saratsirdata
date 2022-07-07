/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 * SystemResponseCodes enum defines various status error codes and message 
 * for System Reponse
 */
public enum IFMSResponseCode {

	SUCCESS("IFMS_0000", "Success"), 
	FAILURE("IFMS_0001", "Failed to process request"),
	INVALID_EMPLOYEE("IFMS_0002", "Employee does not exist"),
	INVALID_DATA("IFMS_0003", "Incorrect input data"),
	EMP_SUCCESS_CREATE("IFMS_0004", "Employee created successfully"),
	EMP_SUCCESS_UPDATE("IFMS_0005", "Employee updated successfully"),
	EMP_SUCCESS_DELETE("IFMS_0006", "Employee deleted successfully"),
	
	;

	/* placeholder for code */
	String code;

	/* placeholder for message */
	String message;

	/**
	 * @param code
	 * @param message
	 */
	private IFMSResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	



}
