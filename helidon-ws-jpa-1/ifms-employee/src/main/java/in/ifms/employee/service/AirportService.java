/**
 * 
 */
package in.ifms.employee.service;

import java.util.List;

import in.ifms.employee.repository.entity.Airport;

/**
 * @author hp
 *
 */
public interface AirportService {
	public Airport save(Airport airport);

	public List<Airport> getAllAirports();

	public void deleteByid(Long id);
}
