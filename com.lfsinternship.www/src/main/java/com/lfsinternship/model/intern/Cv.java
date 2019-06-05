package com.lfsinternship.model.intern;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToOne;

import com.lfsinternship.model.Internship;
import com.lfsinternship.model.intern.Experience;
import com.lfsinternship.model.intern.Student;

@Entity
@NamedQueries({
	@NamedQuery(name = "Cv.findById",
			query = "SELECT c FROM Cv c WHERE c.cvId = :cvId"),
	@NamedQuery(name = "Cv.findByStudentId",
			query = "SELECT c FROM Cv c LEFT JOIN c.student s WHERE s.studentId = :studentId"),
	@NamedQuery(name = "Cv.findByInternshipId",
			query = "SELECT c FROM Cv c LEFT JOIN c.internships i WHERE i.internshipId = :internshipId"),
	@NamedQuery(name = "Cv.findByLocationId",
			query = "SELECT c FROM Cv c LEFT JOIN c.internships i LEFT JOIN i.locations loc WHERE loc.locationId = :locationId"),
	@NamedQuery(name = "Cv.findByExperienceId",
			query = "SELECT c FROM Cv c LEFT JOIN c.experience e WHERE e.experienceId = :experienceId"),
	@NamedQuery(name = "Cv.findByUserId",
			query = "SELECT c FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.internships i LEFT JOIN i.cvies c WHERE u.userId = :userId"),
	@NamedQuery(name = "Cv.findByPositionId",
			query = "SELECT c FROM Cv c LEFT JOIN c.internships i LEFT JOIN i.positions p WHERE p.positionId = :positionId"),
	@NamedQuery(name = "Cv.Count",
			query = "SELECT COUNT(c) FROM Cv c"),
	@NamedQuery(name = "Cv.findWithExperienceName",
			query = "SELECT c.cvName, e.experience FROM Cv c LEFT JOIN c.experience e")
})
public class Cv implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cvId;
	
	private String cvName;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String univercityName;
	
	private String departmentName;
	
	//this is number of compulsory internship days I mean that ones necessary :)
	private Integer compulsoryInternshipDays; 
	
	@OneToOne(mappedBy = "cv", fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private Student student;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "experienceId", referencedColumnName = "experienceId")
	private Experience experience;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Internship> internships = new ArrayList<Internship>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "universityId", referencedColumnName = "universityId")
	private University university;
	
	public Cv() {

	}

	public Cv(String cvName, String firstName, String lastName, String email, String univercityName,
			String departmentName, Integer compulsoryInternshipDays) {
		this.cvName = cvName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.univercityName = univercityName;
		this.departmentName = departmentName;
		this.compulsoryInternshipDays = compulsoryInternshipDays;
	}


	public Integer getCvId() {
		return cvId;
	}


	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}


	public String getCvName() {
		return cvName;
	}


	public void setCvName(String cvName) {
		this.cvName = cvName;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getUnivercityName() {
		return univercityName;
	}


	public void setUnivercityName(String univercityName) {
		this.univercityName = univercityName;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Integer getCompulsoryInternshipDays() {
		return compulsoryInternshipDays;
	}


	public void setCompulsoryInternshipDays(Integer compulsoryInternshipDays) {
		this.compulsoryInternshipDays = compulsoryInternshipDays;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Experience getExperience() {
		return experience;
	}


	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public List<Internship> getInternship() {
		return internships;
	}

	public void setInternship(List<Internship> internship) {
		this.internships = internship;
	}

	@Override
	public String toString() {
		return "Cv [cvId=" + cvId + ", cvName=" + cvName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", univercityName=" + univercityName + ", departmentName=" + departmentName
				+ ", compulsoryInternshipDays=" + compulsoryInternshipDays + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cvId == null) ? 0 : cvId.hashCode());
		return result;
	}
	
}
