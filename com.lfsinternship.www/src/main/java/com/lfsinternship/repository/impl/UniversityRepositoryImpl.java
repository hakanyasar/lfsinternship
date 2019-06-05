package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.intern.University;
import com.lfsinternship.repository.UniversityRepository;

public class UniversityRepositoryImpl implements UniversityRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public University saveUniversity(University university) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(university);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return university;
	}

	@Override
	public University updateUniversity(University university) {

		
		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(university);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return university;
	}

	@Override
	public University removeUniversity(University university) {

		try {
			
			if(this.entityManager.contains(university)) {
				this.entityManager.remove(university);
			}else {
				University tempUniversity = this.findById(university.getUniversityId());
				this.entityManager.remove(tempUniversity);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return university;
	}

	@Override
	public University findById(Integer id) {

		University university = null;
		
		try {
			
			TypedQuery<University> typedQuery = this.entityManager.createNamedQuery("University.findById", University.class);
			typedQuery.setParameter("universityId", id);
			
			university = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return university;
	}

	@Override
	public University findByCvId(Integer id) {

		University university = null;
		
		try {
			
			TypedQuery<University> typedQuery = this.entityManager.createNamedQuery("University.findByCvId", University.class);
			typedQuery.setParameter("cvId", id);
			
			university = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return university;
	}

	@Override
	public List<University> findByUserId(Integer id) {

		List<University> universities = null;
		
		try {
			
			TypedQuery<University> typedQuery = this.entityManager.createNamedQuery("University.findByUserId", University.class);
			typedQuery.setParameter("userId", id);
			
			universities = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return universities;
	}
	
	
}
