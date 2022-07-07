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

	GET_EMPLOYEE_BY_ID("SELECT EMP_ID, EMP_NAME, ADDRESS_ID, EMAIL FROM Employee as emp where emp.EMP_ID =: employeeId"), 
	UPDATE("UPDATE");
	

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
