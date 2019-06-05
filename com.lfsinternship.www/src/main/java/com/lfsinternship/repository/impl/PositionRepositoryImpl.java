package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.intern.Position;
import com.lfsinternship.repository.PositionRepository;

public class PositionRepositoryImpl implements PositionRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Position savePosition(Position position) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(position);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return position;
	}

	@Override
	public Position updatePosition(Position position) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(position);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return position;
	}

	@Override
	public Position removePosition(Position position) {

		try {
			
			if(this.entityManager.contains(position)) {
				this.entityManager.remove(position);
			}else {
				Position tempPosition = this.findById(position.getPositionId());
				this.entityManager.remove(tempPosition);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return position;
	}

	@Override
	public List<Position> findPositions() {

		List<Position> positions = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findPositions", Position.class);
			
			positions = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return positions;
	}

	@Override
	public Position findById(Integer id) {

		Position position = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findById", Position.class);
			typedQuery.setParameter("positionId", id);
			
			position = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return position;
	}

	@Override
	public Position findWithInternshipById(Integer id) {

		Position position = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findWithInternshipById", Position.class);
			typedQuery.setParameter("positionId", id);
			
			position = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return position;
	}

	@Override
	public List<Position> findWithInternshipByPositionName(String name) {

		List<Position> positions = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findWithInternshipByPositionName", Position.class);
			typedQuery.setParameter("positionName", name);
			
			positions = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return positions;
	}

	@Override
	public Position findWithStudentById(Integer id) {

		Position position = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findWithStudentById", Position.class);
			typedQuery.setParameter("positionId", id);
			
			position = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return position;
	}

	@Override
	public List<Position> findWithStudentByPositionName(String name) {

		List<Position> positions = null;
		
		try {
			
			TypedQuery<Position> typedQuery = this.entityManager.createNamedQuery("Position.findWithStudentByPositionName", Position.class);
			typedQuery.setParameter("positionName", name);
			
			positions = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return positions;
	}
	
	
}
