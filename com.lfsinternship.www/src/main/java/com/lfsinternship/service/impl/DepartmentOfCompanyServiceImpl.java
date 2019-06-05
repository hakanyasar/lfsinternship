package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.employer.DepartmentOfCompany;
import com.lfsinternship.repository.DepartmentOfCompanyRepository;
import com.lfsinternship.repository.impl.DepartmentOfCompanyRepositoryImpl;
import com.lfsinternship.service.DepartmentOfCompanyService;

public class DepartmentOfCompanyServiceImpl implements DepartmentOfCompanyService{

	private DepartmentOfCompanyRepository departmentOfCompany = new DepartmentOfCompanyRepositoryImpl();

	@Override
	public DepartmentOfCompany saveDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.saveDepartmentOfCompany(departmentOfCompany);
		
		return tempDepartmentOfCompany;
	}

	@Override
	public DepartmentOfCompany updateDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.updateDepartmentOfCompany(departmentOfCompany);
		
		return tempDepartmentOfCompany;
	}

	@Override
	public DepartmentOfCompany removeDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.removeDepartmentOfCompany(departmentOfCompany);
		
		return tempDepartmentOfCompany;
	}

	@Override
	public DepartmentOfCompany findById(Integer id) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.findById(id);
		
		return tempDepartmentOfCompany;
	}

	@Override
	public DepartmentOfCompany findByEmployeeId(Integer id) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.findByEmployeeId(id);
		
		return tempDepartmentOfCompany;
	}

	@Override
	public List<DepartmentOfCompany> findByCompanyId(Integer id) {

		List<DepartmentOfCompany> tempDepartmentOfCompanies = this.departmentOfCompany.findByCompanyId(id);
		
		return tempDepartmentOfCompanies;
	}

	@Override
	public DepartmentOfCompany findByJobId(Integer id) {

		DepartmentOfCompany tempDepartmentOfCompany = this.departmentOfCompany.findByJobId(id);
		
		return tempDepartmentOfCompany;
	}
	
	
}
