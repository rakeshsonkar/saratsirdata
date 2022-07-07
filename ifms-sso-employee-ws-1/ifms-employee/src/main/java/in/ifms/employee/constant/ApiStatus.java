/**
 * 
 */
package in.ifms.employee.constant;

/**
 * 
 * This enum contains API Response status as constants
 * 
 * 
 * @author Sharat Pradhan
 *
 */
public enum ApiStatus {

	/**
	 * API call is successful
	 */
	SUCCESS("SUCCESS"),

	/**
	 * API call is unsuccessful due to some error
	 */
	FAILED("FAILED"),

	/**
	 * Error occurred in API call
	 */
	ERROR("ERROR");

	private String status;

	/**
	 * @param status
	 */
	private ApiStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the status
	 */
	public String status() {
		return status;
	}

}
