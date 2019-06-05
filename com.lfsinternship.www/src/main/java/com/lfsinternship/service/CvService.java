package com.lfsinternship.service;

import java.util.List;

import com.lfsinternship.model.intern.Cv;

public interface CvService {

	Cv saveCv(Cv cv);
	
	Cv updateCv(Cv cv);
	
	Cv removeCv(Cv cv);
	
	Cv findById(Integer id);
	
	Cv findByStudentId(Integer id);
	
	List<Cv> findByInternshipId(Integer id);
	
	List<Cv> findByLocationId(Integer id);
	
	Cv findByExperienceId(Integer id);
	
	Cv findByUserId(Integer id);
	
	List<Cv> findByPositionId(Integer id);
	
	int cvCount();
	
	List<String> findWithExperienceName();
	
}
