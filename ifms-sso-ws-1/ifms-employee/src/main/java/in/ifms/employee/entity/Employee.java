/**
 * 
 */
package in.ifms.employee.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author hp
 *
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* reflects the EMPLOYEE_ID column of the table */
	@Id
	@GeneratedValue(generator = "EMPLOYEE_ID_SEQ", strategy = GenerationType.SEQUENCE)
	// allocation size (increment size) is default to 50
	// hence must be provided
	@SequenceGenerator(name = "EMPLOYEE_ID_SEQ", allocationSize = 1)
	@Column(insertable = true, name = "EMPLOYEE_ID", nullable = false, updatable = false)
	private Integer employeeId;

	/* reflects the EMPLOYEE_NAME column of the table */
	@Column(insertable = true, name = "EMPLOYEE_NAME", nullable = false, length = 20)
	private String employeeName;

	/* reflects the EMAIL column of the table */
	@Column(insertable = true, name = "EMAIL", nullable = false, length = 30)
	private String email;

	/* reflects the PHONE_NUM column of the table */
	@Column(insertable = true, name = "PHONE_NUM", nullable = false, length = 20)
	private String phoneNum;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeName
	 * @param email
	 * @param phoneNum
	 */
	public Employee(String employeeName, String email, String phoneNum) {
		super();
		this.employeeName = employeeName;
		this.email = email;
		this.phoneNum = phoneNum;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, employeeId, employeeName, phoneNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(email, other.email) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName) && Objects.equals(phoneNum, other.phoneNum);
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", phoneNum=" + phoneNum + "]";
	}

}
