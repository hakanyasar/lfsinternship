package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.Location;

public interface LocationRepository {

	Location saveLocation(Location location);
	
	Location updateLocation(Location location);
	
	Location removeLocation(Location location);
	
	Location findById(Integer id);
	
	List<Location> findWithIntershipByCity(String city);
	
	Location findWithUserDetailById(Integer id);
	
	List<Location> findByInternshipId(Integer id);
	
	List<Location> findByCompanyId(Integer id);
	
	Location findByStudentId(Integer id);
	
}
