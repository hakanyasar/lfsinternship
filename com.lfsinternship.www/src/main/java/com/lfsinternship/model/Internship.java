package com.lfsinternship.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.lfsinternship.model.employer.Job;
import com.lfsinternship.model.intern.Cv;
import com.lfsinternship.model.intern.Position;

@Entity
@NamedQueries({
	@NamedQuery(name = "Internship.findById", 
			query = "SELECT i FROM Internship i LEFT JOIN FETCH i.positions LEFT JOIN FETCH i.locations WHERE i.internshipId = :internshipId"),
	@NamedQuery(name = "Internship.findByUserName", 
			query = "SELECT i FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.internships i WHERE u.userName = :userName"),
	@NamedQuery(name = "Internship.findByUserId", 
			query = "SELECT i FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.internships i WHERE u.userId = :userId"),
	@NamedQuery(name = "Internship.findByLocationId", 
			query = "SELECT i FROM Location loc LEFT JOIN loc.internships i WHERE loc.locationId = :locationId"),
	@NamedQuery(name = "Internship.findCountByLocationId",
			query = "SELECT COUNT(i) FROM Internship i LEFT JOIN i.locations loc WHERE loc.locationId = :locationId"),
	@NamedQuery(name = "Internship.findByUpdateDate", 
			query = "SELECT i FROM Internship i WHERE i.updateDate > :updateDate"),
	@NamedQuery(name = "Internship.findByPositionId",
			query = "SELECT i FROM Position p LEFT JOIN p.internships i WHERE p.positionId = :positionId"),
	@NamedQuery(name = "Internship.findByCvId",
			query = "SELECT i FROM Cv c LEFT JOIN c.internships i WHERE c.cvId = :cvId"),
	@NamedQuery(name = "Internship.findInternships", 
			query = "SELECT i FROM Internship i"),
	@NamedQuery(name = "Internship.findInternshipByPositionName",
			query = "SELECT i FROM Internship i LEFT JOIN i.positions p WHERE p.positionName IN(:positionName1, :positionName2)"),
	//we say to db in here, fetch i objects that has position name equals positionName1 and positionName2  
	@NamedQuery(name = "Internship.findInternshipByLocationName",
			query = "SELECT i FROM Internship i LEFT JOIN i.locations loc WHERE loc.city IN(:city1, :city2, :city3)")
	//for instance, internships in Istanbul, Ankara, Izmir come in this query's result 
})
public class Internship implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer internshipId;
	
	private String title;
	
	@Lob
	private String description;
	
	@Lob
	private String qualificatios;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date addDate = new Date();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	private boolean isApprove = false;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date removeDate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "internship_position", joinColumns = @JoinColumn(name = "internshipId", referencedColumnName = "internshipId"), inverseJoinColumns = @JoinColumn(name = "positionId", referencedColumnName = "positionId"))
	private List<Position> positions;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "internship_userDetail", joinColumns = @JoinColumn(name = "internshipId", referencedColumnName = "internshipId"), inverseJoinColumns = @JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId"))
	private UserDetail userDetail;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ýnternship_cv", joinColumns = @JoinColumn(name = "internshipId", referencedColumnName = "internshipId"), inverseJoinColumns = @JoinColumn(name = "cvId", referencedColumnName = "cvId"))
	private List<Cv> cvies = new ArrayList<Cv>();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "internship_location", joinColumns = @JoinColumn(name = "internshipId", referencedColumnName = "internshipId"), inverseJoinColumns = @JoinColumn(name = "locationId", referencedColumnName = "locationId"))
	private List<Location> locations = new ArrayList<Location>();
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId", referencedColumnName = "addressId")
	private Address address;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jobId", referencedColumnName = "jobId")
	private Job job;
	
	public Internship() {

	}

	public Internship(String title, String description, String qualificatios, Date addDate, Date updateDate,
			boolean isApprove, Date removeDate, UserDetail userDetail) {
		this.title = title;
		this.description = description;
		this.qualificatios = qualificatios;
		this.addDate = addDate;
		this.updateDate = updateDate;
		this.isApprove = isApprove;
		this.removeDate = removeDate;
		this.userDetail = userDetail;
	}

	public Integer getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(Integer internshipId) {
		this.internshipId = internshipId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQualificatios() {
		return qualificatios;
	}

	public void setQualificatios(String qualificatios) {
		this.qualificatios = qualificatios;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isIsApprove() {
		return isApprove;
	}

	public void setIsApprove(boolean isApprove) {
		isApprove = isApprove;
	}

	public Date getRemoveDate() {
		return removeDate;
	}

	public void setRemoveDate(Date removeDate) {
		this.removeDate = removeDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public List<Cv> getCvies() {
		return cvies;
	}

	public void setCvies(List<Cv> cvies) {
		this.cvies = cvies;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isApprove() {
		return isApprove;
	}

	public void setApprove(boolean isApprove) {
		this.isApprove = isApprove;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Internship [title=" + title + ", description=" + description + ", qualificatios=" + qualificatios
				+ ", addDate=" + addDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
