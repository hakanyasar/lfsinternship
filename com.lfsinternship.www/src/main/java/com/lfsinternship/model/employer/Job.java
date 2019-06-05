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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.lfsinternship.model.Internship;
import com.lfsinternship.model.Location;
import com.lfsinternship.model.User;

@Entity
@NamedQueries({
	@NamedQuery(name = "Job.findById",
			query = "SELECT j FROM Job j WHERE j.jobId = :jobId"),
	@NamedQuery(name = "Job.findByEmployeeId",
			query = "SELECT j FROM Job j LEFT JOIN j.employees e WHERE e.employeeId = :employeeId"),
	@NamedQuery(name = "Job.findByInternshipId",
			query = "SELECT j FROM Job j LEFT JOIN j.internships i WHERE i.internshipId = :internshipId"),
	@NamedQuery(name = "Job.findByDepartmentOfCompanyId",
			query = "SELECT j FROM Job j LEFT JOIN j.departmentOfCompany doc WHERE doc.departmentOfCompanyId = :departmentOfCompanyId"),
	@NamedQuery(name = "Job.Count",
			query = "SELECT COUNT(j) FROM Job j")
})
public class Job {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobId;
	
	private String jobName;
	
	@Lob
	private String descriptionOfJob;
	
	private double minSalary;
	
	private double maxSalary;
	
	private String numberOfEmployee;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<Employee> employees = new ArrayList<Employee>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "job_location", joinColumns = @JoinColumn(name = "jobId", referencedColumnName = "jobId"), inverseJoinColumns = @JoinColumn(name = "locationId", referencedColumnName = "locationId"))
	private List<Location> locations = new ArrayList<Location>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departmentOfCompanyId", referencedColumnName = "departmentOfCompanyId")
	private DepartmentOfCompany departmentOfCompany;
	
	@OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
	private List<Internship> internships = new ArrayList<Internship>();
	
	public Job() {

	}

	public Job(String jobName, String descriptionOfJob, double minSalary, double maxSalary, String numberOfEmployee) {
		this.jobName = jobName;
		this.descriptionOfJob = descriptionOfJob;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.numberOfEmployee = numberOfEmployee;
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}
	
	public void addInternship(Internship internship) {
		this.internships.add(internship);
	}
	
	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getDescriptionOfJob() {
		return descriptionOfJob;
	}

	public void setDescriptionOfJob(String descriptionOfJob) {
		this.descriptionOfJob = descriptionOfJob;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(String numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
	public DepartmentOfCompany getDepartmentOfCompany() {
		return departmentOfCompany;
	}

	public void setDepartmentOfCompany(DepartmentOfCompany departmentOfCompany) {
		this.departmentOfCompany = departmentOfCompany;
	}

	public List<Internship> getInternships() {
		return internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		return result;
	}

}
