/**
 * 
 */
package in.ifms.employee.constant;

/**
 * 
 * SystemResponseCode enum defines various status codes and messages
 * for System Response
 * 
 * 
 * @author Sharat Pradhan
 */
public enum IFMSResponseCode {

	/** general response codes */
	SUCCESS("IFMS_0000", "Success"), 
	FAILURE("IFMS_0001", "Failed to process request"),
	
	/** failure response codes */
	INVALID_EMPLOYEE("IFMS_1001", "Employee does not exist"),
	INVALID_DATA("IFMS_1002", "Incorrect input data"),
	
	/** success response codes */
	EMP_SUCCESS_CREATE("IFMS_2001", "Employee created successfully"),
	EMP_SUCCESS_UPDATE("IFMS_2002", "Employee updated successfully"),
	EMP_SUCCESS_DELETE("IFMS_2003", "Employee deleted successfully"),
	
	/** java exception/error response codes */
	DATABASE_DOWN("IFMS_3001", "Could not connect to the database"),
	DATABASE_ERROR("IFMS_3002", "Could not connect to the database"),
	
	
	;

	/** placeholder for code */
	String code;

	/** placeholder for message */
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	




	



}
