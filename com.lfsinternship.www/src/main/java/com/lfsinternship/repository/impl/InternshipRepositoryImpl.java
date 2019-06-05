package com.lfsinternship.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.Internship;
import com.lfsinternship.repository.InternshipRepository;

public class InternshipRepositoryImpl implements InternshipRepository {

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Internship saveInternship(Internship internship) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(internship);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return internship;
	}

	@Override
	public Internship updateInternship(Internship internship) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(internship);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return internship;
	}

	@Override
	public Internship removeInternship(Internship internship) {

		try {
			
			if(this.entityManager.contains(internship)) {
				this.entityManager.remove(internship);
			}else {
				Internship tempInternship = this.findById(internship.getInternshipId());
				this.entityManager.remove(tempInternship);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return internship;
	}

	@Override
	public Internship findById(Integer id) {

		Internship internship = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findById", Internship.class);
			typedQuery.setParameter("internshipId", id);
			
			internship = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internship;
	}

	@Override
	public List<Internship> findByUserName(String name) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByUserName", Internship.class);
			typedQuery.setParameter("userName", name);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findByUserId(Integer id) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByUserName", Internship.class);
			typedQuery.setParameter("userId", id);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findByLocationId(Integer id) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByLocationId", Internship.class);
			typedQuery.setParameter("locationId", id);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public int findCountByLocationId(Integer id) {

		int count = 0;
		
		try {
			
			TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("Internship.findCountByLocationId", Integer.class);
			typedQuery.setParameter("locationId", id);
			
			count = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return count;
	}

	@Override
	public List<Internship> findByUpdateDate(Date updateDate) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByUpdateDate", Internship.class);
			typedQuery.setParameter("updateDate", updateDate);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findByPositionId(Integer id) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByPositionId", Internship.class);
			typedQuery.setParameter("positionId", id);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findByCvId(Integer id) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findByCvId", Internship.class);
			typedQuery.setParameter("cvId", id);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findInternships() {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findInternships", Internship.class);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findInternshipByPositionName(String name1, String name2) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findInternshipByPositionName", Internship.class);
			typedQuery.setParameter("positionName1", name1);
			typedQuery.setParameter("positionName2", name2);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}

	@Override
	public List<Internship> findInternshipByLocationName(String city1, String city2, String city3) {

		List<Internship> internships = null;
		
		try {
			
			TypedQuery<Internship> typedQuery = this.entityManager.createNamedQuery("Internship.findInternshipByLocationName", Internship.class);
			typedQuery.setParameter("city1", city1);
			typedQuery.setParameter("city2", city2);
			typedQuery.setParameter("city3", city3);
			
			internships = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return internships;
	}
	
	
	
	
}
