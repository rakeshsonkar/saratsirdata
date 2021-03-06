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
@Table(name = "ADDRESS")
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* reflects the EMP_ID column of the table */
	@Id
	@GeneratedValue(generator = "ADDRESS_ID_SEQ", strategy = GenerationType.SEQUENCE)
	// allocation size (increment size) is default to 50
	// hence must be provided
	@SequenceGenerator(name = "ADDRESS_ID_SEQ", allocationSize = 1)
	@Column(insertable = true, name = "ADDRESS_ID", nullable = false, updatable = false)
	private Integer addressId;
	
	@Column(insertable = true, name = "EMPLOYEE_ID")
	private Integer employeeId;

	/* reflects the EMPLOYEE_ID column of the table */
	// @ManyToOne
	// @JoinColumn(referencedColumnName = "EMPLOYEE_ID", table = "EMPLOYEE")
	// @ManyToOne(targetEntity = Employee.class, fetch = FetchType.LAZY, optional =
	// true)
	// @JoinColumn(name = "EMPLOYEE_ID", insertable = false, updatable = false)
	/*
	 * @Column(name = "EMPLOYEE_ID", nullable = false) private Integer employeeId;
	 */

	/* reflects the STREET column of the table */
	@Column(insertable = true, name = "STREET", nullable = false, updatable = true)
	private String street;

	/* reflects the CITY column of the table */
	@Column(insertable = true, name = "CITY", nullable = false, updatable = true)
	private String city;

	/* reflects the COUNTRY column of the table */
	@Column(insertable = true, name = "COUNTRY", nullable = false, updatable = true)
	private String country;

	// private Employee employee;

	/**
	 * 
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param addressId
	 * @param employeeId
	 * @param street
	 * @param city
	 * @param country
	 */
	public Address(Integer addressId, Integer employeeId, String street, String city, String country) {
		super();
		this.addressId = addressId;
		this.employeeId = employeeId;
		this.street = street;
		this.city = city;
		this.country = country;
	}

	/**
	 * @return the addressId
	 */
	public Integer getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", employeeId=" + employeeId + ", street=" + street + ", city="
				+ city + ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, city, country, employeeId, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(street, other.street);
	}



}
