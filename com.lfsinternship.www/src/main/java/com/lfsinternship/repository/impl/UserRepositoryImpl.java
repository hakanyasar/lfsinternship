package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.User;
import com.lfsinternship.model.UserInfo;
import com.lfsinternship.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public User saveUser(User user) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(user);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return user;
	}

	@Override
	public User updateUser(User user) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(user);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return user;
	}

	@Override
	public User removeUser(User user) {

		try {
			
			if(this.entityManager.contains(user)) {
				this.entityManager.remove(user);
			}else {
				User tempUser = this.findById(user.getUserId());
				this.entityManager.remove(tempUser);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return user;
	}

	@Override
	public User findById(Integer id) {

		User user = null;
		
		try {
			
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findById", User.class);
			typedQuery.setParameter("userId", id);
			
			user = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return user;
	}

	@Override
	public User findByUserName(String name) {

		User user = null;
		
		try {
			
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findByUserName", User.class);
			typedQuery.setParameter("userName", name);
			
			user = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return user;
	}

	@Override
	public User findWithUserDetailsByUserName(String name) {

		User user = null;
		
		try {
			
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findWithUserDetailsByUserName", User.class);
			typedQuery.setParameter("userName", name);
			
			user = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return user;
	}

	@Override
	public int findUsersCount() {

		int count = 0;
		
		try {
			
			TypedQuery<Integer> typedQuery = this.entityManager.createNamedQuery("User.Count", Integer.class);
			
			count = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return count;
	}

	@Override
	public List<User> findAllUsers() {

		List<User> users = null;
		
		try {
			
			TypedQuery<User> typedQuery = this.entityManager.createNamedQuery("User.findAllUsers", User.class);
			
			users = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return users;
	}

	@Override
	public UserInfo findUserInfoByUserName(String name) {

		UserInfo userInfo = null;
		
		try {
			
			TypedQuery<UserInfo> typedQuery = this.entityManager.createNamedQuery("User.findUserInfoByUserName", UserInfo.class);
			typedQuery.setParameter("userName", name);
			
			userInfo = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return userInfo;
	}
	
	
}
