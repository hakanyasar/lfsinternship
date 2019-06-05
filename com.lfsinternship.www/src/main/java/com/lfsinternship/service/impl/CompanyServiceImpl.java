package com.lfsinternship.service.impl;

import java.util.List;

import com.lfsinternship.model.employer.Company;
import com.lfsinternship.repository.CompanyRepository;
import com.lfsinternship.repository.impl.CompanyRepositoryImpl;
import com.lfsinternship.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{

	private CompanyRepository companyRepository = new CompanyRepositoryImpl();

	@Override
	public Company saveCompany(Company company) {

		Company tempCompany = this.companyRepository.saveCompany(company);
		
		return tempCompany;
	}

	@Override
	public Company updateCompany(Company company) {

		Company tempCompany = this.companyRepository.updateCompany(company);
		
		return tempCompany;
	}

	@Override
	public Company removeCompany(Company company) {

		Company tempCompany = this.companyRepository.removeCompany(company);
		
		return tempCompany;
	}

	@Override
	public Company findById(Integer id) {

		Company tempCompany = this.companyRepository.findById(id);
		
		return tempCompany;
	}

	@Override
	public Company findByCompanyName(String name) {

		Company tempCompany = this.companyRepository.findByCompanyName(name);
		
		return tempCompany;
	}

	@Override
	public List<Company> findByLocationId(Integer id) {

		List<Company> tempCompanies = this.companyRepository.findByLocationId(id);
		
		return tempCompanies;
	}

	@Override
	public Company findByInternshipId(Integer id) {

		Company tempCompany = this.companyRepository.findByInternshipId(id);
		
		return tempCompany;
	}

	@Override
	public List<String> findCompanyNames() {

		List<String> tempCompanies = this.companyRepository.findCompanyNames();
		
		return tempCompanies;
	}
	
	
}
