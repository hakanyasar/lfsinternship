package com.lfsinternship.model.employer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.lfsinternship.model.Internship;
import com.lfsinternship.model.Location;
import com.lfsinternship.model.User;

@Entity
@NamedQueries({
	@NamedQuery(name = "DepartmentOfCompany.findById",
			query = "SELECT doc FROM DepartmentOfCompany doc WHERE doc.departmentOfCompanyId = :departmentOfCompanyId"),
	@NamedQuery(name =  "DepartmentOfCompany.findByEmployeeId",
			query = "SELECT doc FROM DepartmentOfCompany doc LEFT JOIN doc.employees e WHERE e.employeeId = :employeeId"),
	@NamedQuery(name = "DepartmentOfCompany.findByCompanyId",
			query = "SELECT doc FROM DepartmentOfCompany doc LEFT JOIN doc.company c WHERE c.companyId = :companyId"),
	@NamedQuery(name = "DepartmentOfCompany.findByJobId",
			query = "SELECT doc FROM DepartmentOfCompany doc LEFT JOIN doc.jobs j WHERE j.jobId = :jobId")
})
public class DepartmentOfCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer departmentOfCompanyId;
	
	private String departmentName;
	
	private String descOfDepartment;
	
	private int numberOfJob;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	private Company company;
	
	@OneToMany(mappedBy = "departmentOfCompany", fetch = FetchType.LAZY)
	private List<Job> jobs = new ArrayList<Job>();
	
	@OneToMany(mappedBy = "departmentOfCompany", fetch = FetchType.LAZY)
	private List<Employee> employees = new ArrayList<Employee>();
	
	public DepartmentOfCompany() {

	}

	public DepartmentOfCompany(String departmentName, String descOfDepartment, int numberOfEmployee) {
		this.departmentName = departmentName;
		this.descOfDepartment = descOfDepartment;
		this.numberOfJob = numberOfJob;
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public void addJob(Job job) {
		this.jobs.add(job);
	}
	
	public Integer getDepartmentOfCompanyId() {
		return departmentOfCompanyId;
	}

	public void setDepartmentOfCompanyId(Integer departmentOfCompanyId) {
		this.departmentOfCompanyId = departmentOfCompanyId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescOfDepartment() {
		return descOfDepartment;
	}

	public void setDescOfDepartment(String descOfDepartment) {
		this.descOfDepartment = descOfDepartment;
	}

	public int getNumberOfEmployee() {
		return numberOfJob;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfJob = numberOfEmployee;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getNumberOfJob() {
		return numberOfJob;
	}

	public void setNumberOfJob(int numberOfJob) {
		this.numberOfJob = numberOfJob;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departmentOfCompanyId == null) ? 0 : departmentOfCompanyId.hashCode());
		return result;
	}
	
	
}
