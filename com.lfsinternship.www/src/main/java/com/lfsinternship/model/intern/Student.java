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
import com.lfsinternship.model.UserDetail;

@Entity
@NamedQueries({
	@NamedQuery(name = "Student.findById",
			query = "SELECT s FROM Student s WHERE s.studentId = :studentId"),
	@NamedQuery(name = "Student.findByCvId",
			query = "SELECT s FROM Student s LEFT JOIN s.cv c WHERE c.cvId = :cvId"),
	@NamedQuery(name = "Student.findUniversityId",
			query = "SELECT s FROM University u LEFT JOIN u.students s WHERE u.universityId = :universityId"),
	@NamedQuery(name = "Student.findStudentsNameWithExperienceName",
			query = "SELECT s.firstName, s.lastName, e.experience FROM Student s LEFT JOIN s.experience e"),
	@NamedQuery(name = "Student.findStudentsNameWithExperienceNameByStudentId",
			query = "SELECT s.firstName, s.lastName, e.experience FROM Student s LEFT JOIN s.experience e WHERE s.studentId = :studentId"),
	/*
	@NamedQuery(name = "Student.findByUserId",
			query = "SELECT s FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.student s WHERE u.userId = :userId")
	*/
})
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	private String firstName;
	
	private String lastName;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId")
	private UserDetail userDetail;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "experienceId", referencedColumnName = "experienceId")
	private Experience experience;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
	private List<Position> positions = new ArrayList<Position>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cvId", referencedColumnName = "cvId")
	private Cv cv;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "universityId", referencedColumnName = "universityId")
	private University university;
	
	public Student() {
		
	}

	public Student(String sfirstName, String slastName) {
		this.firstName = sfirstName;
		this.lastName = slastName;
	}
	
	public void addPosition(Position position) {
		this.positions.add(position);
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
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

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
