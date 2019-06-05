package com.lfsinternship.service;

import java.util.Date;
import java.util.List;

import com.lfsinternship.model.Internship;

public interface InternshipService {

	Internship saveInternship(Internship internship);
	
	Internship updateInternship(Internship internship);
	
	Internship removeInternship(Internship internship);
	
	Internship findById(Integer id);
	
	List<Internship> findByUserName(String name);
	
	List<Internship> findByUserId(Integer id);
	
	List<Internship> findByLocationId(Integer id);
	
	int findCountByLocationId(Integer id);
	
	List<Internship> findByUpdateDate(Date updateDate);
	
	List<Internship> findByPositionId(Integer id);
	
	List<Internship> findByCvId(Integer id);
	
	List<Internship> findInternships();
	
	List<Internship> findInternshipByPositionName(String name1, String name2);
	
	List<Internship> findInternshipByLocationName(String city1, String city2, String city3);
	
}
