/**
 * 
 */
package in.ifms.employee.dto;

import java.io.Serializable;

/**
 * @author hp
 *
 */
public class AddressDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer addressId;

	private Integer employeeId;

	private String street;

	private String city;

	private String country;

	/**
	 * 
	 */
	public AddressDTO() {
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
	public AddressDTO(Integer addressId, Integer employeeId, String street, String city, String country) {
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
		return "AddressDTO [addressId=" + addressId + ", employeeId=" + employeeId + ", street=" + street + ", city="
				+ city + ", country=" + country + "]";
	}

}
