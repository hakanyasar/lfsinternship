package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.intern.Cv;
import com.lfsinternship.repository.CvRepository;
import com.lfsinternship.repository.impl.CvRepositoryImpl;
import com.lfsinternship.service.CvService;

public class CvServiceImpl implements CvService{

	private CvRepository cvRepository = new CvRepositoryImpl();

	@Override
	public Cv saveCv(Cv cv) {

		Cv tempCv = this.cvRepository.saveCv(cv);
		
		return tempCv;
	}

	@Override
	public Cv updateCv(Cv cv) {

		Cv tempCv = this.cvRepository.updateCv(cv);
		
		return tempCv;
	}

	@Override
	public Cv removeCv(Cv cv) {

		Cv tempCv = this.cvRepository.removeCv(cv);
		
		return tempCv;
	}

	@Override
	public Cv findById(Integer id) {

		Cv tempCv = this.cvRepository.findById(id);
		
		return tempCv;
	}

	@Override
	public Cv findByStudentId(Integer id) {

		Cv tempCv = this.cvRepository.findByStudentId(id);
		
		return tempCv;
	}

	@Override
	public List<Cv> findByInternshipId(Integer id) {

		List<Cv> tempCvies = this.cvRepository.findByInternshipId(id);
		
		return tempCvies;
	}

	@Override
	public List<Cv> findByLocationId(Integer id) {

		List<Cv> tempCvies = this.cvRepository.findByLocationId(id);
		
		return tempCvies;
	}

	@Override
	public Cv findByExperienceId(Integer id) {

		Cv tempCv = this.cvRepository.findByExperienceId(id);
		
		return tempCv;
	}

	@Override
	public Cv findByUserId(Integer id) {

		Cv tempCv = this.cvRepository.findByUserId(id);
		
		return tempCv;
	}

	@Override
	public List<Cv> findByPositionId(Integer id) {

		List<Cv> tempCvies = this.cvRepository.findByPositionId(id);
		
		return tempCvies;
	}

	@Override
	public int cvCount() {

		int tempCv = this.cvRepository.cvCount();
		
		return tempCv;
	}

	@Override
	public List<String> findWithExperienceName() {

		List<String> tempCvies = this.cvRepository.findWithExperienceName();
		
		return tempCvies;
	}

	
}
