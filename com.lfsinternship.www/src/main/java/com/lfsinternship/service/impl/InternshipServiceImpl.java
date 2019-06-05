package com.lfsinternship.service.impl;

import java.util.Date;
import java.util.List;

import com.lfsinternship.model.Internship;
import com.lfsinternship.repository.InternshipRepository;
import com.lfsinternship.repository.impl.InternshipRepositoryImpl;
import com.lfsinternship.service.InternshipService;

public class InternshipServiceImpl implements InternshipService{

	private InternshipRepository internshipRepository = new InternshipRepositoryImpl();

	@Override
	public Internship saveInternship(Internship internship) {

		Internship tempInternship = this.internshipRepository.saveInternship(internship);
		
		return tempInternship;
	}

	@Override
	public Internship updateInternship(Internship internship) {

		Internship tempInternship = this.internshipRepository.updateInternship(internship);
		
		return tempInternship;
	}

	@Override
	public Internship removeInternship(Internship internship) {

		Internship tempInternship = this.internshipRepository.removeInternship(internship);
		
		return tempInternship;
	}

	@Override
	public Internship findById(Integer id) {

		Internship tempInternship = this.internshipRepository.findById(id);
		
		return tempInternship;
	}

	@Override
	public List<Internship> findByUserName(String name) {

		List<Internship> tempInternships = this.internshipRepository.findByUserName(name);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findByUserId(Integer id) {

		List<Internship> tempInternships = this.internshipRepository.findByUserId(id);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findByLocationId(Integer id) {

		List<Internship> tempInternships = this.internshipRepository.findByLocationId(id);
		
		return tempInternships;
	}

	@Override
	public int findCountByLocationId(Integer id) {

		int countInternship = this.internshipRepository.findCountByLocationId(id);
		
		return countInternship;
	}

	@Override
	public List<Internship> findByUpdateDate(Date updateDate) {

		List<Internship> tempInternships = this.internshipRepository.findByUpdateDate(updateDate);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findByPositionId(Integer id) {

		List<Internship> tempInternships = this.internshipRepository.findByPositionId(id);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findByCvId(Integer id) {

		List<Internship> tempInternships = this.internshipRepository.findByCvId(id);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findInternships() {

		List<Internship> tempInternships = this.internshipRepository.findInternships();
		
		return tempInternships;
	}

	@Override
	public List<Internship> findInternshipByPositionName(String name1, String name2) {

		List<Internship> tempInternships = this.internshipRepository.findInternshipByPositionName(name1, name2);
		
		return tempInternships;
	}

	@Override
	public List<Internship> findInternshipByLocationName(String city1, String city2, String city3) {

		List<Internship> tempInternships = this.internshipRepository.findInternshipByLocationName(city1, city2, city3);
		
		return tempInternships;
	}
	
	
}
