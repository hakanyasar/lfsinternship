package com.lfsinternship.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lfsinternship.model.employer.Company;
import com.lfsinternship.model.intern.Student;
import com.lfsinternship.model.intern.University;
import com.lfsinternship.model.util.PhoneType;

@Entity
@NamedQueries({
	@NamedQuery(name = "UserDetail.findById", 
			query = "SELECT ud FROM UserDetail ud WHERE ud.userDetailId = :userDetailId"),
	@NamedQuery(name = "UserDetail.findByUserName", 
			query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.user u WHERE u.userName = :userName"),
	@NamedQuery(name = "UserDetail.findWithAddressByUserName", 
			query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.addresses WHERE ud.user.userName = :userName"),
	@NamedQuery(name = "UserDetail.findWithInternshipsByUserName", 
			query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.internships WHERE ud.user.userName = :userName"),
	@NamedQuery(name = "UserDetail.findWithUniversityByUserName", 
			query = "SELECT ud FROM UserDetail ud LEFT JOIN FETCH ud.universities WHERE ud.user.userName = :userName"),
	@NamedQuery(name = "UserDetail.findWithLocationByUserName", 
			query = "SeLECT ud FROM UserDetail ud LEFT JOIN FETCH ud.location WHERE ud.user.userName = :userName"),
	@NamedQuery(name = "UserDetail.findUserInfoByCompanyId", 
			query = "SELECT new com.lfsinternship.model.UserInfo(ud.user.userName, ud.firstName, ud.lastName, ud.user.emailAddress, ud.birthDate) FROM UserDetail ud WHERE ud.company.companyId = :companyId"),
	@NamedQuery(name = "UserDetail.findUserInfoByStudentId", 
			query = "SELECT new com.lfsinternship.model.UserInfo(ud.user.userName, ud.firstName, ud.lastName, ud.user.emailAddress, ud.birthDate) FROM UserDetail ud WHERE ud.student.studentId = :studentId"),
	
	// there are erros here because of attribute of nullable company and student classes so one of them can be null and query can bum.
	/* 
	@NamedQuery(name = "UserDetail.findByCompanyId", query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.company c WHERE c.companyId = :companyId"),
	@NamedQuery(name = "UserDetail.findByCompanyName", query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.company c WHERE c.companyName = :companyName"),
	@NamedQuery(name = "UserDetail.findByStudentId", query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.student s WHERE s.studentId = :studentId"),
	@NamedQuery(name = "UserDetail.findByStudentName", query = "SELECT ud FROM UserDetail ud LEFT JOIN ud.student s WHERE s.firstName = :firstName"),
	*/
	
})
public class UserDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userDetailId;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	@ElementCollection
	@JoinTable(name = "userDetail_phoneNumber", joinColumns = @JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId"))
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneNumbers = new HashMap<PhoneType, String>();
	
	@OneToMany(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private List<Address> addresses = new ArrayList<Address>();

	//@Basic(optional = true)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private Student student;
	
	//@Basic(optional = true)
	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	@JoinColumn(name = "companyId", referencedColumnName = "companyId")
	private Company company;
	
	@OneToMany(mappedBy = "userDetail", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Internship> internships = new ArrayList<Internship>();
	
	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "userDetail_university", joinColumns = @JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId"), inverseJoinColumns = @JoinColumn(name = "universityId", referencedColumnName = "universityId"))
	private List<University> universities = new ArrayList<University>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locationId", referencedColumnName = "locationId")
	private Location location;
	
	public UserDetail() {

	}

	public UserDetail(String firstName, String lastName, Date birthDate, Map<PhoneType, String> phoneNumbers,
			List<Internship> internships) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.phoneNumbers = phoneNumbers;
		this.internships = internships;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}


	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}


	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}


	public List<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public List<Internship> getInternships() {
		return internships;
	}


	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public List<University> getUniversities() {
		return universities;
	}

	public void setUniversities(List<University> universities) {
		this.universities = universities;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
