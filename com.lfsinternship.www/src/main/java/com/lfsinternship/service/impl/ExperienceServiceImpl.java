package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.intern.Experience;
import com.lfsinternship.repository.ExperienceRepository;
import com.lfsinternship.repository.impl.ExperienceRepositoryImpl;
import com.lfsinternship.service.ExperienceService;

public class ExperienceServiceImpl implements ExperienceService{

	private ExperienceRepository experienceRepository = new ExperienceRepositoryImpl();

	@Override
	public Experience saveExperience(Experience experience) {

		Experience tempExperience = this.experienceRepository.saveExperience(experience);
		
		return tempExperience;
	}

	@Override
	public Experience updateExperience(Experience experience) {

		Experience tempExperience = this.experienceRepository.updateExperience(experience);
		
		return tempExperience;
	}

	@Override
	public Experience removeExperience(Experience experience) {

		Experience tempExperience = this.experienceRepository.removeExperience(experience);
		
		return tempExperience;
	}

	@Override
	public Experience findByExperinceId(Integer id) {

		Experience tempExperience = this.experienceRepository.findByExperinceId(id);
		
		return tempExperience;
	}

	@Override
	public Experience findByStudentId(Integer id) {

		Experience tempExperience = this.experienceRepository.findByStudentId(id);
		
		return tempExperience;
	}

	@Override
	public List<Experience> findWithCv() {

		List<Experience> tempExperiences = this.experienceRepository.findWithCv();
		
		return tempExperiences;
	}

	@Override
	public Experience findByCvId(Integer id) {

		Experience tempExperience = this.experienceRepository.findByCvId(id);
		
		return tempExperience;
	}
	
	
}
