package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.employer.DepartmentOfCompany;
import com.lfsinternship.repository.DepartmentOfCompanyRepository;

public class DepartmentOfCompanyRepositoryImpl implements DepartmentOfCompanyRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public DepartmentOfCompany saveDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(departmentOfCompany);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return departmentOfCompany;
	}

	@Override
	public DepartmentOfCompany updateDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(departmentOfCompany);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return departmentOfCompany;
	}

	@Override
	public DepartmentOfCompany removeDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		try {
			
			if(this.entityManager.contains(departmentOfCompany)) {
				this.entityManager.remove(departmentOfCompany);
			}else {
				DepartmentOfCompany tempDepofcomp = this.findById(departmentOfCompany.getDepartmentOfCompanyId());
				this.entityManager.remove(tempDepofcomp);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return departmentOfCompany;
	}

	@Override
	public DepartmentOfCompany findById(Integer id) {

		DepartmentOfCompany departmentOfCompany = null;
		
		try {
			
			TypedQuery<DepartmentOfCompany> typedQuery = this.entityManager.createNamedQuery("DepartmentOfCompany.findById", DepartmentOfCompany.class);
			typedQuery.setParameter("departmentOfCompanyId", id);
			
			departmentOfCompany = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return departmentOfCompany;
	}

	@Override
	public DepartmentOfCompany findByEmployeeId(Integer id) {

		DepartmentOfCompany departmentOfCompany = null;
		
		try {
			
			TypedQuery<DepartmentOfCompany> typedQuery = this.entityManager.createNamedQuery("DepartmentOfCompany.findByEmployeeId", DepartmentOfCompany.class);
			typedQuery.setParameter("employeeId", id);
			
			departmentOfCompany = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return departmentOfCompany;
	}

	@Override
	public List<DepartmentOfCompany> findByCompanyId(Integer id) {

		List<DepartmentOfCompany> departmentOfCompanies = null;
		
		try {
			
			TypedQuery<DepartmentOfCompany> typedQuery = this.entityManager.createNamedQuery("DepartmentOfCompany.findByCompanyId", DepartmentOfCompany.class);
			typedQuery.setParameter("companyId", id);
			
			departmentOfCompanies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return departmentOfCompanies;
	}

	@Override
	public DepartmentOfCompany findByJobId(Integer id) {

		DepartmentOfCompany departmentOfCompany = null;
		
		try {
			
			TypedQuery<DepartmentOfCompany> typedQuery = this.entityManager.createNamedQuery("DepartmentOfCompany.findByJobId", DepartmentOfCompany.class);
			typedQuery.setParameter("jobId", id);
			
			departmentOfCompany = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return departmentOfCompany;
	}
	
	
}
