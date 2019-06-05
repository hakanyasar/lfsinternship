package com.lfsinternship.model.intern;

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
import javax.persistence.OneToOne;

import com.lfsinternship.model.Internship;

@Entity
@NamedQueries({
	@NamedQuery(name = "Position.findPositions", 
			query = "SELECT p FROM Position p"),
	@NamedQuery(name = "Position.findById", 
			query = "SELECT p FROM Position p WHERE p.positionId = :positionId"),
	@NamedQuery(name = "Position.findWithInternshipById", 
			query = "SELECT p FROM Position p LEFT JOIN FETCH p.internships WHERE p.positionId = :positionId"),
	@NamedQuery(name = "Position.findWithInternshipByPositionName", 
			query = "SELECT p FROM Position p LEFT JOIN FETCH p.internships WHERE p.positionName = :positionName"),
	@NamedQuery(name = "Position.findWithStudentById", 
			query = "SELECT p FROM Position p LEFT JOIN FETCH p.student WHERE p.positionId = :positionId"),
	@NamedQuery(name = "Position.findWithStudentByPositionName", 
			query = "SELECT p FROM Position p LEFT JOIN FETCH p.student WHERE p.positionName = :positionName"),
})
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer positionId;
	
	@Lob
	private String positionName;
	
	@Lob
	private String positionDescription;
	
	@ManyToMany(mappedBy = "positions", fetch = FetchType.LAZY)
	private List<Internship> internships = new ArrayList<Internship>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private Student student;
	
	public Position() {

	}

	public Position(String position) {
		this.positionName = position;
	}


	public Integer getPositionId() {
		return positionId;
	}


	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public List<Internship> getInternships() {
		return internships;
	}


	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}
	

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDescription() {
		return positionDescription;
	}

	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", position=" + positionName + ", internships=" + internships
				+ ", student=" + student + "]";
	}

	
}
