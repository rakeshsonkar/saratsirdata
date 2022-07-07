/**
 * 
 */
package in.ifms.employee.common.constants;

/**
 * @author hp
 *
 *JPQLQuery enum holds JPQL query strings as constants
 */
public enum JPQLQuery {

	GET_EMPLOYEE_BY_ID("SELECT employeeId, employeeName, email FROM Employee as emp where emp.employeeId =: employeeId"), 
	UPDATE("UPDATE");
	

	/* placeholder for queryString */
	String queryString;

	private JPQLQuery(String queryString) {
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
