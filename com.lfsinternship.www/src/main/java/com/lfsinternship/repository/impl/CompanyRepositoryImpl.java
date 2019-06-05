package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.employer.Company;
import com.lfsinternship.repository.CompanyRepository;

public class CompanyRepositoryImpl implements CompanyRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Company saveCompany(Company company) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(company);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return company;
	}

	@Override
	public Company updateCompany(Company company) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(company);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return company;
	}

	@Override
	public Company removeCompany(Company company) {

		try {
			
			if(this.entityManager.contains(company)) {
				this.entityManager.remove(company);
			}else {
				Company tempCompany = this.findById(company.getCompanyId());
				this.entityManager.remove(tempCompany);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return company;
	}

	@Override
	public Company findById(Integer id) {

		Company company = null;
		
		try {
			
			TypedQuery<Company> typedQuery = this.entityManager.createNamedQuery("Company.findById", Company.class);
			typedQuery.setParameter("companyId", id);
			
			company = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return company;
	}

	@Override
	public Company findByCompanyName(String name) {

		Company company = null;
		
		try {
			
			TypedQuery<Company> typedQuery = this.entityManager.createNamedQuery("Company.findByCompanyName", Company.class);
			typedQuery.setParameter("companyName" ,name);
			
			company = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return company;
	}

	@Override
	public List<Company> findByLocationId(Integer id) {

		List<Company> companies = null;
		
		try {
			TypedQuery<Company> typedQuery = this.entityManager.createNamedQuery("Company.findByLocationId", Company.class);
			typedQuery.setParameter("locationId", id);
			
			companies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return companies;
		
	}

	@Override
	public Company findByInternshipId(Integer id) {

		Company company = null;
		
		try {
			
			TypedQuery<Company> typedQuery = this.entityManager.createNamedQuery("Company.findByInternshipId", Company.class);
			typedQuery.setParameter("internshipId", id);
			
			company = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return company;
	}

	@Override
	public List<String> findCompanyNames() {

		List<String> companies = null;
		
		try {
			TypedQuery<String> typedQuery = this.entityManager.createNamedQuery("Company.findCompanyNames", String.class);
			
			companies = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return companies;
	}
	
	
	
	
	
}
