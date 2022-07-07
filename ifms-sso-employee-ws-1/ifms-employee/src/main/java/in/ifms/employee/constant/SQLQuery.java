/**
 * 
 */
package in.ifms.employee.constant;

/**
 * @author Sharat Pradhan
 *
 *SQLQuery enum holds Native SQL query strings as constants
 */
public enum SQLQuery {

	GET_EMPLOYEE_BY_ID("SELECT EMPLOYEE_ID, EMPLOYEE_NAME, EMAIL FROM Employee as emp where emp.EMPLOYEE_ID = ?"), 
	UPDATE_EMPLOYEE_BY_ID("UPDATE EMPLOYEE SET EMPLOYEE_NAME = ? , EMAIL = ?, PHONE_NUM = ? WHERE EMPLOYEE_ID = ?"),
	DELETE_EMPLOYEE_BY_ID("DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?"),
	SAVE_NEW_EMPLOYEE("INSERT INTO EMPLOYEE (EMPLOYEE_NAME, EMAIL, PHONE_NUM) VALUES (?, ?, ?)"),
	GET_ALL_EMPLOYEES("SELECT EMPLOYEE_ID, EMPLOYEE_NAME, EMAIL, PHONE_NUM FROM EMPLOYEE"),
	
	;
	

	/* placeholder for queryString */
	String queryString;

	private SQLQuery(String queryString) {
		this.queryString = queryString;
	}

	/**
	 * @return the queryString
	 */
	public String getQueryString() {
		return queryString;
	}

	/**
	 * @param queryString the queryString to set
	 */
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	

}
