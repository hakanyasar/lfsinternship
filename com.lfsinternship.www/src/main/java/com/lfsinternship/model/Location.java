package com.lfsinternship.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.lfsinternship.model.employer.Company;
import com.lfsinternship.model.employer.DepartmentOfCompany;
import com.lfsinternship.model.employer.Job;
import com.lfsinternship.model.intern.Student;

@Entity
@NamedQueries({
	@NamedQuery(name = "Location.findById", 
			query = "SELECT loc FROM Location loc WHERE loc.locationId = :locationId"),
	@NamedQuery(name = "Location.findWithIntershipByCity",
			query = "SELECT loc FROM Location loc LEFT JOIN FETCH loc.internships WHERE loc.city = :city"),
	@NamedQuery(name = "Location.findWithUserDetailById",
			query = "SELECT loc FROM Location loc LEFT JOIN FETCH loc.userDetails WHERE loc.locationId = :locationId"),
	@NamedQuery(name = "Location.findByInternshipId",
			query = "SELECT loc FROM Location loc LEFT JOIN loc.internships i WHERE i.internshipId = :internshipId"),
	@NamedQuery(name = "Location.findByCompanyId",
			query = "SELECT loc FROM Company c LEFT JOIN c.departmentOfCompanies doc LEFT JOIN doc.jobs j LEFT JOIN j.locations loc WHERE c.companyId = :companyId"),
	@NamedQuery(name = "Location.findByStudentId",
			query = "SELECT loc FROM Student s LEFT JOIN s.userDetail ud LEFT JOIN ud.location loc WHERE s.studentId = :studentId")
})
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer locationId;
	
	private String city;
	
	private String neighborhood;
	
	private int zipCode;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Internship> internships = new ArrayList<Internship>();
	
	@OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
	private List<UserDetail> userDetails = new ArrayList<UserDetail>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Job> jobs = new ArrayList<Job>();
	
	public Location() {

	}

	public Location(String city, String neighborhood, int zipCode) {
		this.city = city;
		this.neighborhood = neighborhood;
		this.zipCode = zipCode;
	}
	
	// this is already clear, I'm using this method for to add object to list that is name userDetails.
	public void addUserDetail(UserDetail userDetail) {   
		this.userDetails.add(userDetail);
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public List<Internship> getInternship() {
		return internships;
	}

	public void setInternship(List<Internship> internship) {
		this.internships = internship;
	}
	
	public List<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

 	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		return result;
	}

	
}
