package com.lfsinternship.service;

import java.util.List;

import com.lfsinternship.model.intern.University;

public interface UniversityService {

	University saveUniversity(University university);
	
	University updateUniversity(University university);
	
	University removeUniversity(University university);
	
	University findById(Integer id);
	
	University findByCvId(Integer id);
	
	List<University> findByUserId(Integer id);
	
	
}
