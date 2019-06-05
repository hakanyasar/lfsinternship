package com.lfsinternship.model.intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.lfsinternship.model.UserDetail;
import com.lfsinternship.model.util.UniversityType;

@Entity
@NamedQueries({
	@NamedQuery(name = "University.findById",
			query = "SELECT u FROM University u WHERE u.universityId = :universityId"),
	@NamedQuery(name = "University.findByCvId",
			query = "SELECT u FROM University u LEFT JOIN u.cv c WHERE c.cvId = :cvId"),
	@NamedQuery(name = "University.findByUserId",
			query = "SELECT u FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.universities uni WHERE u.userId = :userId")
})
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer universityId;
	
	private String universityName;
	
	private int numberOfFaculty;
	
	private int numberOfProf;
	
	private Long numberOfBooksInLib;
	
	@ElementCollection
	@JoinTable(name = "university_universityTypes", joinColumns = @JoinColumn(name = "universityId", referencedColumnName = "universityId"))
	@MapKeyColumn(name = "universityType")
	@Column(name = "universityName")
	private Map<UniversityType, String> universityTypes = new HashMap<UniversityType, String>();
	
	@OneToOne(mappedBy = "university", fetch = FetchType.LAZY)
	private Cv cv;
	
	@OneToMany(mappedBy = "university", fetch = FetchType.LAZY)
	private List<Student> students = new ArrayList<Student>();
	
	@ManyToMany(mappedBy = "universities", fetch = FetchType.LAZY)
	private List<UserDetail> userDetails = new ArrayList<UserDetail>();
	
	public University() {

	}

	public University(String universityName, int numberOfFaculty, int numberOfProf, Long numberOfBooksInLib) {
		this.universityName = universityName;
		this.numberOfFaculty = numberOfFaculty;
		this.numberOfProf = numberOfProf;
		this.numberOfBooksInLib = numberOfBooksInLib;
	}

	public Integer getUniversityId() {
		return universityId;
	}

	public void setUniversityId(Integer universityId) {
		this.universityId = universityId;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public int getNumberOfFaculty() {
		return numberOfFaculty;
	}

	public void setNumberOfFaculty(int numberOfFaculty) {
		this.numberOfFaculty = numberOfFaculty;
	}

	public int getNumberOfProf() {
		return numberOfProf;
	}

	public void setNumberOfProf(int numberOfProf) {
		this.numberOfProf = numberOfProf;
	}

	public Long getNumberOfBooksInLib() {
		return numberOfBooksInLib;
	}

	public void setNumberOfBooksInLib(Long numberOfBooksInLib) {
		this.numberOfBooksInLib = numberOfBooksInLib;
	}

	public Map<UniversityType, String> getUniversityTypes() {
		return universityTypes;
	}

	public void setUniversityTypes(Map<UniversityType, String> universityTypes) {
		this.universityTypes = universityTypes;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<UserDetail> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<UserDetail> userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "University [universityName=" + universityName + ", numberOfFaculty=" + numberOfFaculty
				+ ", numberOfProf=" + numberOfProf + ", numberOfBooksInLib=" + numberOfBooksInLib + ", universityTypes="
				+ universityTypes + "]";
	}
	
	
}
