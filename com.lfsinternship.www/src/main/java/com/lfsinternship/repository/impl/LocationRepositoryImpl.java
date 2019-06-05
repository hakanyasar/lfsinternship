package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.Location;
import com.lfsinternship.repository.LocationRepository;

public class LocationRepositoryImpl implements LocationRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Location saveLocation(Location location) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(location);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return location;
	}

	@Override
	public Location updateLocation(Location location) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(location);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return location;
	}

	@Override
	public Location removeLocation(Location location) {

		try {
			
			if(this.entityManager.contains(location)) {
				this.entityManager.remove(location);
			}else {
				Location tempLocation = this.findById(location.getLocationId());
				this.entityManager.remove(tempLocation);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return location;
	}

	@Override
	public Location findById(Integer id) {

		Location location = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findById", Location.class);
			typedQuery.setParameter("locationId", id);
			
			location = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return location;
	}

	@Override
	public List<Location> findWithIntershipByCity(String city) {

		List<Location> locations = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findWithIntershipByCity", Location.class);
			typedQuery.setParameter("city", city);
			
			locations = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return locations;
	}

	@Override
	public Location findWithUserDetailById(Integer id) {

		Location location = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findWithUserDetailById", Location.class);
			typedQuery.setParameter("locationId", id);
			
			location = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return location;
	}

	@Override
	public List<Location> findByInternshipId(Integer id) {

		List<Location> locations = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findByInternshipId", Location.class);
			typedQuery.setParameter("internshipId", id);
			
			locations = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return locations;
	}

	@Override
	public List<Location> findByCompanyId(Integer id) {

		List<Location> locations = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findByCompanyId", Location.class);
			typedQuery.setParameter("companyId", id);
			
			locations = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return locations;
	}

	@Override
	public Location findByStudentId(Integer id) {

		Location location = null;
		
		try {
			
			TypedQuery<Location> typedQuery = this.entityManager.createNamedQuery("Location.findByStudentId", Location.class);
			typedQuery.setParameter("studentId", id);
			
			location = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return location;
	}
	
	
}
