package com.lfsinternship.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.lfsinternship.entityFactory.EntityFactory;
import com.lfsinternship.entityFactoryImpl.EntityFactoryImpl;
import com.lfsinternship.model.employer.Employee;
import com.lfsinternship.repository.EmployeeRepository;

public class EmployeeRepositoryImpl implements EmployeeRepository{

	private EntityFactory entityFactory = new EntityFactoryImpl();
	
	private EntityManager entityManager = entityFactory.getEntityManager();
	
	private EntityTransaction transaction = entityFactory.getEntityTransaction();

	@Override
	public Employee saveEmployee(Employee employee) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.persist(employee);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		try {
			
			this.transaction.begin();
			
			this.entityManager.merge(employee);
			
			this.transaction.commit();
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
			
		}
		
		return employee;
	}

	@Override
	public Employee removeEmployee(Employee employee) {

		try {
			
			if(this.entityManager.contains(employee)) {
				this.entityManager.remove(employee);
			}else {
				Employee tempEmployee = this.findByEmployeeId(employee.getEmployeeId());
				this.entityManager.remove(tempEmployee);
			}
			
		} catch (RuntimeException e) {
			
			System.out.println("error: " + e);
			
			try {
				this.transaction.rollback();
				
			} catch (RollbackException e2) {
				System.out.println("error: " + e2);
			}
		}
		
		return employee;
	}

	@Override
	public Employee findByEmployeeId(Integer id) {

		Employee employee = null;
		
		try {
			
			TypedQuery<Employee> typedQuery = this.entityManager.createNamedQuery("Employee.findByEmployeeId", Employee.class);
			typedQuery.setParameter("employeeId", id);
			
			employee = typedQuery.getSingleResult();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return employee;
	}

	@Override
	public List<Employee> findByDepartmenOfCompanyId(Integer id) {

		List<Employee> employees = null;
		
		try {
			
			TypedQuery<Employee> typedQuery = this.entityManager.createNamedQuery("Employee.findByDepartmenOfCompanyId", Employee.class);
			typedQuery.setParameter("departmentOfCompanyId", id);
			
			employees = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return employees;
	}

	@Override
	public List<Employee> findByCompanyId(Integer id) {

		List<Employee> employees = null;
		
		try {
			
			TypedQuery<Employee> typedQuery = this.entityManager.createNamedQuery("Employee.findByCompanyId", Employee.class);
			typedQuery.setParameter("companyId", id);
			
			employees = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return employees;
	}

	@Override
	public List<Employee> findByJobId(Integer id) {

		List<Employee> employees = null;
		
		try {
			
			TypedQuery<Employee> typedQuery = this.entityManager.createNamedQuery("Employee.findByJobId", Employee.class);
			typedQuery.setParameter("jobId", id);
			
			employees = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return employees;
	}

	@Override
	public List<Employee> findByUniversityId(Integer id) {

		List<Employee> employees = null;
		
		try {
			
			TypedQuery<Employee> typedQuery = this.entityManager.createNamedQuery("Employee.findByUniversityId", Employee.class);
			typedQuery.setParameter("universityId", id);
			
			employees = typedQuery.getResultList();
			
		} catch (NoResultException e) {
			System.out.println("error: " + e);
		}
		
		return employees;
	}
	
}
