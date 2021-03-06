/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 *SQLQuery enum holds Native SQL query strings as constants
 */
public enum SQLQuery {

	GET_EMPLOYEE_BY_ID("SELECT EMPLOYEE_ID, EMPLOYEE_NAME, EMAIL FROM Employee as emp where emp.EMPLOYEE_ID =: employeeId"), 
	UPDATE("UPDATE"),
	UPDATE_EMPLOYEE_BY_ID("UPDATE EMPLOYEE SET EMPLOYEE_NAME =: employeeName, EMAIL =: email WHERE EMPLOYEE_ID =: employeeId"),
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
