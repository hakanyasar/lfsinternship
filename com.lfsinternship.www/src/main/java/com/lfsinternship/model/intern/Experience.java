package com.lfsinternship.model.intern;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "Experience.findByExperinceId",
			query = "SELECT e FROM Experience e WHERE e.experienceId = :experienceId"),
	@NamedQuery(name = "Experience.findByStudentId",
			query = "SELECT e FROM Experience e LEFT JOIN e.student s WHERE s.studentId = :studentId"),
	@NamedQuery(name = "Experience.findWithCv",
			query = "SELECT e FROM Cv c LEFT JOIN c.experience e"),
	/* nullable error
	@NamedQuery(name = "Experience.findByUserId",
			query = "SELECT c FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.student s LEFT JOIN s.experience e WHERE u.userId = :userId"),
	*/
	@NamedQuery(name = "Experience.findByCvId",
			query = "SELECT e FROM Experience e LEFT JOIN e.cv c WHERE c.cvId = :cvId")
})
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer experienceId;
	
	@Lob
	private String experience;
	
	@OneToOne(mappedBy = "experience", fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	private Student student;
	
	@OneToOne(mappedBy = "experience", fetch = FetchType.LAZY)
	private Cv cv;
	
	public Experience() {

	}

	public Experience(String experiences) {
		this.experience = experiences;
	}

	public Integer getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(Integer experienceId) {
		this.experienceId = experienceId;
	}

	public String getExperiences() {
		return experience;
	}

	public void setExperiences(String experiences) {
		this.experience = experiences;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	@Override
	public String toString() {
		return "Experience [experienceId=" + experienceId + ", experiences=" + experience + "]";
	}
	
}
