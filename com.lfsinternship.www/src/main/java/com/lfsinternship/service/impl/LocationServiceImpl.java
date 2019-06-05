package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.Location;
import com.lfsinternship.repository.LocationRepository;
import com.lfsinternship.repository.impl.LocationRepositoryImpl;
import com.lfsinternship.service.LocationService;

public class LocationServiceImpl implements LocationService{

	private LocationRepository locationRepository  = new LocationRepositoryImpl();

	@Override
	public Location saveLocation(Location location) {

		Location tempLocation = this.locationRepository.saveLocation(location);
		
		return tempLocation;
	}

	@Override
	public Location updateLocation(Location location) {

		Location tempLocation = this.locationRepository.updateLocation(location);
		
		return tempLocation;
	}

	@Override
	public Location removeLocation(Location location) {

		Location tempLocation = this.locationRepository.removeLocation(location);
		
		return tempLocation;
	}

	@Override
	public Location findById(Integer id) {

		Location tempLocation = this.locationRepository.findById(id);
		
		return tempLocation;
	}

	@Override
	public List<Location> findWithIntershipByCity(String city) {

		List<Location> tempLocations = this.locationRepository.findWithIntershipByCity(city);
		
		return tempLocations;
	}

	@Override
	public Location findWithUserDetailById(Integer id) {

		Location tempLocation = this.locationRepository.findWithUserDetailById(id);
		
		return tempLocation;
	}

	@Override
	public List<Location> findByInternshipId(Integer id) {

		List<Location> tempLocations = this.locationRepository.findByInternshipId(id);
		
		return tempLocations;
	}

	@Override
	public List<Location> findByCompanyId(Integer id) {

		List<Location> tempLocations = this.locationRepository.findByCompanyId(id);
		
		return tempLocations;
	}

	@Override
	public Location findByStudentId(Integer id) {

		Location tempLocation = this.locationRepository.findByStudentId(id);
		
		return tempLocation;
	}
	
	
}
