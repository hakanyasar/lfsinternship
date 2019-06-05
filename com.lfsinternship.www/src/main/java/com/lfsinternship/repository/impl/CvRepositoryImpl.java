package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.intern.Cv;
import com.lfsinternship.repository.CvRepository;

public class CvRepositoryImpl implements CvRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Cv saveCv(Cv cv) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(cv);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return cv;
	}

	@Override
	public Cv updateCv(Cv cv) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(cv);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return cv;
	}

	@Override
	public Cv removeCv(Cv cv) {

		try {
			
			if(this.entityManager.contains(cv)) {
				this.entityManager.remove(cv);
			}else {
				Cv tempCv = this.findById(cv.getCvId());
				this.entityManager.remove(tempCv);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return cv;
	}

	@Override
	public Cv findById(Integer id) {

		Cv cv = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findById", Cv.class);
			typedQuery.setParameter("cvId", id);
			
			cv = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cv;
	}

	@Override
	public Cv findByStudentId(Integer id) {

		Cv cv = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByStudentId", Cv.class);
			typedQuery.setParameter("studentId", id);
			
			cv = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cv;
	}

	@Override
	public List<Cv> findByInternshipId(Integer id) {

		List<Cv> cvies = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByInternshipId", Cv.class);
			typedQuery.setParameter("internshipId", id);
			
			cvies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cvies;
	}

	@Override
	public List<Cv> findByLocationId(Integer id) {

		List<Cv> cvies = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByLocationId", Cv.class);
			typedQuery.setParameter("locationId", id);
			
			cvies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cvies;
	}

	@Override
	public Cv findByExperienceId(Integer id) {

		Cv cv = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByExperienceId", Cv.class);
			typedQuery.setParameter("experienceId", id);
			
			cv = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cv;
	}

	@Override
	public Cv findByUserId(Integer id) {

		Cv cv = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByUserId", Cv.class);
			typedQuery.setParameter("userId", id);
			
			cv = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cv;
	}

	@Override
	public List<Cv> findByPositionId(Integer id) {

		List<Cv> cvies = null;
		
		try {
			
			TypedQuery<Cv> typedQuery = this.entityManager.createNamedQuery("Cv.findByPositionId", Cv.class);
			typedQuery.setParameter("positionId", id);
			
			cvies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cvies;
	}

	@Override
	public int cvCount() {

		int count = 0;
		
		try {
			
			TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("Cv.Count", Integer.class);
			
			count = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return count;
	}

	@Override
	public List<String> findWithExperienceName() {

		List<String> cvies = null;
		
		try {
			
			TypedQuery<String> typedQuery = this.entityManager.createNamedQuery("Cv.findWithExperienceName", String.class);
			
			cvies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return cvies;
	}
	
	
}
