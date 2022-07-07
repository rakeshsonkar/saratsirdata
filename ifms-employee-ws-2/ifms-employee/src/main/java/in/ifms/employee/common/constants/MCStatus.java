/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 * MCStatus enum defines various status codes and description for mca
 */
public enum MCStatus {

	PENDING("0", "Created but pending, partially created"), 
	SUBMIT_FOR_APPROVAL("0", "Submitted for approval"), 
	ACTIVE("0", "Active"), 
	NON_ACTIVE("0", "Not active"),
	
	;

	/* placeholder for code */
	String code;

	/* placeholder for description */
	String description;

	/**
	 * @param code
	 * @param description
	 */
	private MCStatus(String code, String description) {
		this.code = code;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
