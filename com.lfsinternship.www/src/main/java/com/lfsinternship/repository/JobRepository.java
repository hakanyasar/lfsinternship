package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.employer.Job;

public interface JobRepository {

	Job saveJob(Job job);
	
	Job updateJob(Job job);
	
	Job removeJob(Job job);
	
	Job findById(Integer id);
	
	Job findByEmployeeId(Integer id);
	
	Job findByInternshipId(Integer id);
	
	List<Job> findByDepartmentOfCompanyId(Integer id);
	
	int jobCount();
	
}
