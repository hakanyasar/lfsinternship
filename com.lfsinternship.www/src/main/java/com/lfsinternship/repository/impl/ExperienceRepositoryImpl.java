package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.intern.Experience;
import com.lfsinternship.repository.ExperienceRepository;

public class ExperienceRepositoryImpl implements ExperienceRepository{

	
	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Experience saveExperience(Experience experience) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(experience);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return experience;
	}

	@Override
	public Experience updateExperience(Experience experience) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(experience);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return experience;
	}

	@Override
	public Experience removeExperience(Experience experience) {

		try {
			
			if(this.entityManager.contains(experience)) {
				this.entityManager.remove(experience);
			}else {
				Experience tempExperience = this.findByExperinceId(experience.getExperienceId());
				this.entityManager.remove(tempExperience);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return experience;
	}

	@Override
	public Experience findByExperinceId(Integer id) {

		Experience experience = null;
		
		try {
			
			TypedQuery<Experience> typedQuery = this.entityManager.createNamedQuery("Experience.findByExperinceId", Experience.class);
			typedQuery.setParameter("experienceId", id);
			
			experience = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return experience;
	}

	@Override
	public Experience findByStudentId(Integer id) {

		Experience experience = null;
		
		try {
			
			TypedQuery<Experience> typedQuery = this.entityManager.createNamedQuery("Experience.findByStudentId", Experience.class);
			typedQuery.setParameter("studentId", id);
			
			experience = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return experience;
	}

	@Override
	public List<Experience> findWithCv() {

		List<Experience> experiences = null;
		
		try {
			
			TypedQuery<Experience> typedQuery = this.entityManager.createNamedQuery("Experience.findWithCv", Experience.class);
			
			experiences = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return experiences;
	}

	@Override
	public Experience findByCvId(Integer id) {

		Experience experience = null;
		
		try {
			
			TypedQuery<Experience> typedQuery = this.entityManager.createNamedQuery("Experience.findByCvId", Experience.class);
			typedQuery.setParameter("cvId", id);
			
			experience = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return experience;
	}
	
	
	
	
	
}
