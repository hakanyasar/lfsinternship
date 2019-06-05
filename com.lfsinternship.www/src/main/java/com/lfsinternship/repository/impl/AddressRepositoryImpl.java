package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.Address;
import com.lfsinternship.repository.AddressRepository;

public class AddressRepositoryImpl implements AddressRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();
	
	
	@Override
	public Address saveAddress(final Address address) {

		
		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(address);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			//we need rollback when any error occur this is it
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return address;
	}

	@Override
	public Address updateAddress(final Address address) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(address);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return address;
	}

	@Override
	public Address removeAddress(final Address address) {

		try {
			
			if(this.entityManager.contains(address)) {
				this.entityManager.remove(address);
			}else {
				Address tempAddress = this.findById(address.getAddressId());
				this.entityManager.remove(tempAddress);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return address;
	}

	@Override
	public Address findById(final Integer id) {

		Address address = null;
		
		try {
			
			TypedQuery<Address> typedQuery = this.entityManager.createNamedQuery("Address.findById", Address.class);
			typedQuery.setParameter("addressId", id);
			
			address = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return address;
	}

	@Override
	public List<Address> findByUserId(final Integer id) {

		List<Address> addresses = null;
		
		try {
			TypedQuery<Address> typedQuery = this.entityManager.createNamedQuery("Address.findByUserId", Address.class);
			typedQuery.setParameter("userId", id);
			
			addresses = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return addresses;
	}

	@Override
	public Address findWithInternshipById(final Integer id) {
		
		Address address = null;
		
		try {
			
			TypedQuery<Address> typedQuery = this.entityManager.createNamedQuery("Address.findWithInternshipById", Address.class);
			typedQuery.setParameter("addressId", id);
			
			address = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return address;
	}

	@Override
	public Address findWithUserDetailById(final Integer id) {
		
		Address address = null;
		
		try {
			
			TypedQuery<Address> typedQuery = this.entityManager.createNamedQuery("findWithUserDetailById", Address.class);
			typedQuery.setParameter("addressId", id);
			
			address = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return address;
	}

	@Override
	public Address findByIntershipId(Integer id) {

		Address address = null;
		
		try {
			
			TypedQuery<Address> typedQuery = this.entityManager.createNamedQuery("Address.findByIntershipId", Address.class);
			typedQuery.setParameter("internshipId", id);
			
			address = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return address;
	}
	

}
