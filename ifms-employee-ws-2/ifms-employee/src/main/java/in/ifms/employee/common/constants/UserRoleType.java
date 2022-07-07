/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 * UserRoleType enum defines various User roles type codes and description for the system users
 */
public enum UserRoleType {

	ADMIN("0", "Admin"), 
	MAKER("1", "Maker"), 
	CHECKER("2", "Checker"), 
	APPROVER("3", "Approver"),
	
	;

	/* placeholder for code */
	String code;

	/* placeholder for description */
	String description;

	/**
	 * @param code
	 * @param description
	 */
	private UserRoleType(String code, String description) {
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
