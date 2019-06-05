package com.lfsinternship.model.employer;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lfsinternship.model.Address;
import com.lfsinternship.model.intern.Cv;
import com.lfsinternship.model.Internship;
import com.lfsinternship.model.User;

@Entity
@NamedQueries({
	@NamedQuery(name = "Employee.findByEmployeeId",
			query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId"),
	@NamedQuery(name = "Employee.findByDepartmenOfCompanyId",
			query = "SELECT e FROM DepartmentOfCompany doc LEFT JOIN doc.employees e WHERE doc.departmentOfCompanyId = :departmentOfCompanyId"),
	@NamedQuery(name = "Employee.findByCompanyId",
			query = "SELECT e FROM Company c LEFT JOIN c.departmentOfCompanies doc LEFT JOIN doc.employees e WHERE c.companyId = :companyId"),
	@NamedQuery(name = "Employee.findByJobId",
			query = "SELECT e FROM Job j LEFT JOIN j.employees e WHERE j.jobId = :jobId"),
	@NamedQuery(name = "Employee.findByUniversityId",
			query = "SELECT e FROM University u LEFT JOIN u.cv c LEFT JOIN c.internships i LEFT JOIN i.job j LEFT JOIN j.employees e WHERE u.universityId = :universityId")
})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeId;
	
	private String employeeFirstName;
	
	private String employeeLastName;
	
	private String phoneNumber;
	
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date birthOfDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfStart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobId", referencedColumnName = "jobId")
	private Job job;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentId", referencedColumnName = "departmentOfCompanyId")
	private DepartmentOfCompany departmentOfCompany;
    
	public Employee() {

	}


	public Employee(String employeeFirstName, String employeeLastName, String phoneNumber, String email,
			Date birthOfDate, Date dateOfStart, Job job, DepartmentOfCompany departmentOfCompany) {
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.birthOfDate = birthOfDate;
		this.dateOfStart = dateOfStart;
		this.job = job;
		this.departmentOfCompany = departmentOfCompany;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeFirstName() {
		return employeeFirstName;
	}


	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}


	public String getEmployeeLastName() {
		return employeeLastName;
	}


	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getBirthOfDate() {
		return birthOfDate;
	}


	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}


	public Date getDateOfStart() {
		return dateOfStart;
	}


	public void setDateOfStart(Date dateOfStart) {
		this.dateOfStart = dateOfStart;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}


	public DepartmentOfCompany getDepartmentOfCompany() {
		return departmentOfCompany;
	}


	public void setDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {
		this.departmentOfCompany = departmentOfCompany;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		return result;
	}
	
}
