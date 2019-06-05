package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.employer.Employee;
import com.lfsinternship.repository.EmployeeRepository;
import com.lfsinternship.repository.impl.EmployeeRepositoryImpl;
import com.lfsinternship.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

	@Override
	public Employee saveEmployee(Employee employee) {

		Employee tempEmployee = this.employeeRepository.saveEmployee(employee);
		
		return tempEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {

		Employee tempEmployee = this.employeeRepository.updateEmployee(employee);
		
		return tempEmployee;
	}

	@Override
	public Employee removeEmployee(Employee employee) {

		Employee tempEmployee = this.employeeRepository.removeEmployee(employee);
		
		return tempEmployee;
	}

	@Override
	public Employee findByEmployeeId(Integer id) {

		Employee tempEmployee = this.employeeRepository.findByEmployeeId(id);
		
		return tempEmployee;
	}

	@Override
	public List<Employee> findByDepartmenOfCompanyId(Integer id) {

		List<Employee> tempEmployees = this.employeeRepository.findByDepartmenOfCompanyId(id);
		
		return tempEmployees;
	}

	@Override
	public List<Employee> findByCompanyId(Integer id) {

		List<Employee> tempEmployees = this.employeeRepository.findByCompanyId(id);
		
		return tempEmployees;
	}

	@Override
	public List<Employee> findByJobId(Integer id) {

		List<Employee> tempEmployees = this.employeeRepository.findByJobId(id);
		
		return tempEmployees;
	}

	@Override
	public List<Employee> findByUniversityId(Integer id) {

		List<Employee> tempEmployees = this.employeeRepository.findByUniversityId(id);
		
		return tempEmployees;
	}
	
	
}
