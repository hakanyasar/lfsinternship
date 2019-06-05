package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.employer.Employee;

public interface EmployeeRepository {

	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	Employee removeEmployee(Employee employee);
	
	Employee findByEmployeeId(Integer id);
	
	List<Employee> findByDepartmenOfCompanyId(Integer id);
	
	List<Employee> findByCompanyId(Integer id);
	
	List<Employee> findByJobId(Integer id);
	
	List<Employee> findByUniversityId(Integer id);
	
}
