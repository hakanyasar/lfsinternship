package com.lfsinternship.service;

import java.util.List;

import com.lfsinternship.model.intern.Experience;

public interface ExperienceService {

	Experience saveExperience(Experience experience);
	
	Experience updateExperience(Experience experience);
	
	Experience removeExperience(Experience experience);
	
	Experience findByExperinceId(Integer id);
	
	Experience findByStudentId(Integer id);
	
	List<Experience> findWithCv();
	
	Experience findByCvId(Integer id);
	
}
