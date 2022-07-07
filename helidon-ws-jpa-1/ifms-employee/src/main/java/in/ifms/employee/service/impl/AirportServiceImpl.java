/**
 * 
 */
package in.ifms.employee.service.impl;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import in.ifms.employee.repository.AirportRepository;
import in.ifms.employee.repository.entity.Airport;
import in.ifms.employee.service.AirportService;

/**
 * @author hp
 *
 */
@ApplicationScoped
public class AirportServiceImpl implements AirportService {

	@Inject
	private AirportRepository airportRepository;

	@Override
	public Airport save(Airport airport) {
		return airportRepository.createOrUpdate(airport);

	}

	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.getAllAirports();
	}

	@Override
	public void deleteByid(Long id) {
		airportRepository.deleteById(id);
	}
}
