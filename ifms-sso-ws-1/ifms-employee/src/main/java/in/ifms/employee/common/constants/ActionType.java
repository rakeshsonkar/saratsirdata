/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 * ActionType enum contains various action types for performing the type of operation to be performed on the database
 */
public enum ActionType {

	SAVE("SAVE"), 
	UPDATE("UPDATE"),
	DELETE("DELETE"),
	GET("GET"),
	RETRIEVE("Retrieve"),
	CREATE("Create"),
	
	;

	/* placeholder for type */
	String type;

	ActionType(String type) {
		this.type = type;
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

}
