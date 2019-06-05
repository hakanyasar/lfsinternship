package com.lfsinternship.model.employer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lfsinternship.model.Address;
import com.lfsinternship.model.Internship;
import com.lfsinternship.model.Location;
import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.util.PhoneType;

@Entity
@NamedQueries({
	@NamedQuery(name = "Company.findById", 
			query = "SELECT c FROM Company c WHERE c.companyId = :companyId"),
	@NamedQuery(name = "Company.findByCompanyName",
			query = "SELECT c FROM Company c WHERE c.companyName = :companyName"),
	@NamedQuery(name = "Company.findByLocationId",
			query = "SELECT c FROM Company c LEFT JOIN c.userDetail ud LEFT JOIN ud.location loc WHERE loc.locationId = :locationId"),
	// there is nullable stuff in here
	//@NamedQuery(name = "Company.findByUserId",
	//		query = "SELECT c FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.company c WHERE u.userId = :userId"),
	@NamedQuery(name = "Company.findByInternshipId",
			query = "SELECT c FROM Company c LEFT JOIN c.userDetail ud LEFT JOIN ud.internships i WHERE i.internshipId = :internshipId"),
	@NamedQuery(name = "Company.findCompanyNames",
			query = "SELECT c.companyName FROM Company c")
})
public class Company implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	private String companyName;
	
	private String missionAndVision;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date yearOfEstablishment;
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<DepartmentOfCompany> departmentOfCompanies = new ArrayList<DepartmentOfCompany>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId")
	private UserDetail userDetail;

	public Company() {

	}

	public Company(String companyName, String missionAndVision, Date yearOfEstablishment) {
		this.companyName = companyName;
		this.missionAndVision = missionAndVision;
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public void addDepartment(DepartmentOfCompany departmentOfCompany) {
		this.departmentOfCompanies.add(departmentOfCompany);
	}
	
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getMissionAndVision() {
		return missionAndVision;
	}

	public void setMissionAndVision(String missionAndVision) {
		this.missionAndVision = missionAndVision;
	}

	public Date getYearOfEstablishment() {
		return yearOfEstablishment;
	}

	public void setYearOfEstablishment(Date yearOfEstablishment) {
		this.yearOfEstablishment = yearOfEstablishment;
	}

	public List<DepartmentOfCompany> getDepartmentOfCompany() {
		return departmentOfCompanies;
	}

	public void setDepartmentOfCompany(List<DepartmentOfCompany> departmentOfCompanies) {
		this.departmentOfCompanies = departmentOfCompanies;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	public List<DepartmentOfCompany> getDepartmentOfCompanies() {
		return departmentOfCompanies;
	}

	public void setDepartmentOfCompanies(List<DepartmentOfCompany> departmentOfCompanies) {
		this.departmentOfCompanies = departmentOfCompanies;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", missionAndVision="
				+ missionAndVision + ", yearOfEstablishment=" + yearOfEstablishment + ", departmentOfCompanies="
				+ departmentOfCompanies + ", userDetail=" + userDetail + "]";
	}
	
}
