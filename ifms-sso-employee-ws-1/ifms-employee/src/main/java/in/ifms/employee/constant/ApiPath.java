/**
 * 
 */
package in.ifms.employee.constant;

/**
 * @author Sharat Pradhan
 *
 *         ApiPath holds constants for end-point path names
 * 
 */
public final class ApiPath {

	/** base path for employee module */
	public static final String EMPLOYEE_BASE_PATH = "/employee";

	/** path for employee module create or update api service */
	public static final String EMPLOYEE_CREATE_UPDATE = "/service/create-update";

	/** path for employee module list all employees api service */
	public static final String EMPLOYEE_LIST_ALL = "/get/all";

	/** path for employee module SEARCH BY ID api service */
	public static final String EMPLOYEE_SEARCH_ID = "search/{id}";

	/** path for employee module DELETE BY ID api service */
	public static final String EMPLOYEE_DELETE_ID = "/delete/{id}";

}
