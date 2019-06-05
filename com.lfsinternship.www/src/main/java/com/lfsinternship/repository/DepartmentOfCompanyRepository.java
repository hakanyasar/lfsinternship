package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.employer.DepartmentOfCompany;

public interface DepartmentOfCompanyRepository {

	DepartmentOfCompany saveDepartmentOfCompany(DepartmentOfCompany departmentOfCompany);
	
	DepartmentOfCompany updateDepartmentOfCompany(DepartmentOfCompany departmentOfCompany);
	
	DepartmentOfCompany removeDepartmentOfCompany(DepartmentOfCompany departmentOfCompany);
	
	DepartmentOfCompany findById(Integer id);
	
	DepartmentOfCompany findByEmployeeId(Integer id);
	
	List<DepartmentOfCompany> findByCompanyId(Integer id);
	
	DepartmentOfCompany findByJobId(Integer id);
	
}
