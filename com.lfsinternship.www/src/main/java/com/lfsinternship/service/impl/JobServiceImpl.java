package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.employer.Job;
import com.lfsinternship.repository.JobRepository;
import com.lfsinternship.repository.impl.JobRepositoryImpl;
import com.lfsinternship.service.JobService;

public class JobServiceImpl implements JobService{

	private JobRepository jobRepository = new JobRepositoryImpl();

	@Override
	public Job saveJob(Job job) {

		Job tempJob = this.jobRepository.saveJob(job);
		
		return tempJob;
	}

	@Override
	public Job updateJob(Job job) {

		Job tempJob = this.jobRepository.updateJob(job);
		
		return tempJob;
	}

	@Override
	public Job removeJob(Job job) {

		Job tempJob = this.jobRepository.removeJob(job);
		
		return tempJob;
	}

	@Override
	public Job findById(Integer id) {

		Job tempJob = this.jobRepository.findById(id);
		
		return tempJob;
	}

	@Override
	public Job findByEmployeeId(Integer id) {

		Job tempJob = this.jobRepository.findByEmployeeId(id);
		
		return tempJob;
	}

	@Override
	public Job findByInternshipId(Integer id) {

		Job tempJob = this.jobRepository.findByInternshipId(id);
		
		return tempJob;
	}

	@Override
	public List<Job> findByDepartmentOfCompanyId(Integer id) {

		List<Job> tempJobs = this.jobRepository.findByDepartmentOfCompanyId(id);
		
		return tempJobs;
	}

	@Override
	public int jobCount() {

		int countJob = this.jobRepository.jobCount();
		
		return countJob;
	}
	
	
}
