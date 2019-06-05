package com.lfsinternship.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.UserInfo;
import com.lfsinternship.repository.UserDetailRepository;

public class UserDetailRepositoryImpl implements UserDetailRepository{


	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public UserDetail saveUserDetail(UserDetail userDetail) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(userDetail);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return userDetail;
	}

	@Override
	public UserDetail updateUserDetail(UserDetail userDetail) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(userDetail);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return userDetail;
	}

	@Override
	public UserDetail removeUserDetail(UserDetail userDetail) {

		try {
			
			if(this.entityManager.contains(userDetail)) {
				this.entityManager.remove(userDetail);
			}else {
				UserDetail tempUserDetail = this.findById(userDetail.getUserDetailId());
				this.entityManager.remove(tempUserDetail);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findById(Integer id) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findById", UserDetail.class);
			typedQuery.setParameter("userDetailId", id);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findByUserName(String name) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findByUserName", UserDetail.class);
			typedQuery.setParameter("userName", name);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findWithAddressByUserName(String name) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithAddressByUserName", UserDetail.class);
			typedQuery.setParameter("userName", name);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findWithInternshipsByUserName(String name) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithInternshipsByUserName", UserDetail.class);
			typedQuery.setParameter("userName", name);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findWithUniversityByUserName(String name) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithUniversityByUserName", UserDetail.class);
			typedQuery.setParameter("userName", name);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserDetail findWithLocationByUserName(String name) {

		UserDetail userDetail = null;
		
		try {
			
			TypedQuery<UserDetail> typedQuery = this.entityManager.createNamedQuery("UserDetail.findWithLocationByUserName", UserDetail.class);
			typedQuery.setParameter("userName", name);
			
			userDetail = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userDetail;
	}

	@Override
	public UserInfo findUserInfoByCompanyId(Integer id) {

		UserInfo userInfo = null;
		
		try {
			
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("UserDetail.findUserInfoByCompanyId", UserInfo.class);
			typedQuery.setParameter("companyId", id);
			
			userInfo = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userInfo;
	}

	@Override
	public UserInfo findUserInfoByStudentId(Integer id) {

		UserInfo userInfo = null;
		
		try {
			
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("UserDetail.findUserInfoByStudentId", UserInfo.class);
			typedQuery.setParameter("studentId", id);
			
			userInfo = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userInfo;
	}
	
	
}
