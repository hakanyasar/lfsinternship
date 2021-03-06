package com.lfsinternship.repository;

import java.util.List;

import com.lfsinternship.model.employer.Company;

public interface CompanyRepository {

	Company saveCompany(Company company);
	
	Company updateCompany(Company company);
	
	Company removeCompany(Company company);
	
	Company findById(Integer id);
	
	Company findByCompanyName(String name);
	
	List<Company> findByLocationId(Integer id);
	
	Company findByInternshipId(Integer id);
	
	List<String> findCompanyNames();
	
}
