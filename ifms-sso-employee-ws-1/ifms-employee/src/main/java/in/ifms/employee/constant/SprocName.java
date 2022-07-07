/**
 * 
 */
package in.ifms.employee.constant;

/**
 * @author Sharat Pradhan
 *
 *         SprocName enum holds PL/SQL Stored Procedure names
 * 
 */
public final class SprocName {

	public static final String GET_TOTAL_EMPLOYEES_BY_DEPTT = "GET_TOTAL_EMPLOYEES_BY_DEPT_PROC";
	public static final String CALL_TOTAL_EMPLOYEES_BY_DEPT = " CALL GET_TOTAL_EMPLOYEES_BY_DEPT_PROC(:dept);";

}
