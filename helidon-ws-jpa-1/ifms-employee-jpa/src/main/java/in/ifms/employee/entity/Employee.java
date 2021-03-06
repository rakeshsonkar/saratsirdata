/**
 * 
 */
package in.ifms.employee.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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

	/* reflects the EMP_ID column of the table */
	@Id
	@GeneratedValue(generator = "EMPLOYEE_ID_SEQ", strategy = GenerationType.SEQUENCE)
	// allocation size (increment size) is default to 50
	// hence must be provided
	@SequenceGenerator(name = "EMPLOYEE_ID_SEQ", allocationSize = 1)
	@Column(insertable = true, name = "EMPLOYEE_ID", nullable = false, updatable = false)
	private Integer employeeId;

	/* reflects the List of Address from address table */
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch =
	// FetchType.EAGER, targetEntity = Address.class)
	// @JoinColumn(name = "EMPLOYEE_ID")
	// @Column(nullable = false, updatable = false)
	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name="EMPLOYEE_ID") // join column is in table for 
	private List<Address> addresses;

	/* reflects the EMP_NAME column of the table */
	@Column(insertable = true, name = "EMPLOYEE_NAME", nullable = false, updatable = false)
	private String employeeName;

	/* reflects the EMAIL column of the table */
	@Column(insertable = true, name = "EMAIL", nullable = false, updatable = false)
	private String email;

	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeId
	 * @param addresses
	 * @param employeeName
	 * @param email
	 */
	public Employee(Integer employeeId, List<Address> addresses, String employeeName, String email) {
		super();
		this.employeeId = employeeId;
		this.addresses = addresses;
		this.employeeName = employeeName;
		this.email = email;
	}

	/**
	 * @return the employeeId
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}

	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", addresses=" + addresses + ", employeeName=" + employeeName
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addresses, email, employeeId, employeeName);
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
		return Objects.equals(addresses, other.addresses) && Objects.equals(email, other.email)
				&& Objects.equals(employeeId, other.employeeId) && Objects.equals(employeeName, other.employeeName);
	}
	
	

}
