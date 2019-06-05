package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.employer.Job;
import com.lfsinternship.repository.JobRepository;

public class JobRepositoryImpl implements JobRepository{
	
	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Job saveJob(Job job) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(job);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return job;
	}

	@Override
	public Job updateJob(Job job) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(job);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return job;
	}

	@Override
	public Job removeJob(Job job) {

		try {
			
			if(this.entityManager.contains(job)) {
				this.entityManager.remove(job);
			}else {
				Job tempJob = this.findById(job.getJobId());
				this.entityManager.remove(tempJob);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return job;
	}

	@Override
	public Job findById(Integer id) {

		Job job = null;
		
		try {
			
			TypedQuery<Job> typedQuery = this.entityManager.createNamedQuery("Job.findById", Job.class);
			typedQuery.setParameter("jobId", id);
			
			job = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return job;
	}

	@Override
	public Job findByEmployeeId(Integer id) {

		Job job = null;
		
		try {
			
			TypedQuery<Job> typedQuery = this.entityManager.createNamedQuery("Job.findByEmployeeId", Job.class);
			typedQuery.setParameter("employeeId", id);
			
			job = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return job;
	}

	@Override
	public Job findByInternshipId(Integer id) {

		Job job = null;
		
		try {
			
			TypedQuery<Job> typedQuery = this.entityManager.createNamedQuery("Job.findByInternshipId", Job.class);
			typedQuery.setParameter("internshipId", id);
			
			job = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return job;
	}

	@Override
	public List<Job> findByDepartmentOfCompanyId(Integer id) {

		List<Job> jobs = null;
		
		try {
			
			TypedQuery<Job> typedQuery = this.entityManager.createNamedQuery("Job.findByDepartmentOfCompanyId", Job.class);
			typedQuery.setParameter("departmentOfCompanyId", id);
			
			jobs = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return jobs;
	}

	@Override
	public int jobCount() {

		int jobCount = 0;
		
		try {
			
			TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("Job.Count", Integer.class);
			
			jobCount = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return jobCount;
	}
	
	
}
