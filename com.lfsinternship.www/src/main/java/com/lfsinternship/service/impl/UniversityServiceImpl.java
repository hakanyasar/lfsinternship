package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.intern.University;
import com.lfsinternship.repository.UniversityRepository;
import com.lfsinternship.repository.impl.UniversityRepositoryImpl;
import com.lfsinternship.service.UniversityService;

public class UniversityServiceImpl implements UniversityService{

	private UniversityRepository universityRepository = new UniversityRepositoryImpl();

	@Override
	public University saveUniversity(University university) {

		University tempUniversity = this.universityRepository.saveUniversity(university);
		
		return tempUniversity;
	}

	@Override
	public University updateUniversity(University university) {

		University tempUniversity = this.universityRepository.updateUniversity(university);
		
		return tempUniversity;
	}

	@Override
	public University removeUniversity(University university) {

		University tempUniversity = this.universityRepository.removeUniversity(university);
		
		return tempUniversity;
	}

	@Override
	public University findById(Integer id) {

		University tempUniversity = this.universityRepository.findById(id);
		
		return tempUniversity;
	}

	@Override
	public University findByCvId(Integer id) {

		University tempUniversity = this.universityRepository.findByCvId(id);
		
		return tempUniversity;
	}

	@Override
	public List<University> findByUserId(Integer id) {

		List<University> tempUniversities = this.universityRepository.findByUserId(id);
		
		return tempUniversities;
	}
	
	
}
