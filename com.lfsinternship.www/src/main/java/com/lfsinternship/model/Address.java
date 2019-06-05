package com.lfsinternship.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = "Address.findById",
			query = "SELECT a FROM Address a WHERE a.addressId = :addressId"),
	@NamedQuery(name = "Address.findByUserId",
			query = "SELECT a FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.addresses a WHERE u.userId = :userId"),
	@NamedQuery(name = "Address.findWithInternshipById", 
			query = "SELECT a FROM Address a LEFT JOIN FETCH a.internship WHERE a.addressId = :addressId"),
	@NamedQuery(name = "Address.findWithUserDetailById",
			query = "SELECT a FROM Address a LEFT JOIN FETCH a.userDetail WHERE a.addressId = :addressId"),
	@NamedQuery(name = "Address.findByIntershipId", 
			query = "SELECT a FROM Internship i LEFT JOIN i.address a WHERE i.internshipId = :internshipId")
})
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	private int buildingNum;
	
	private String street;
	
	private String neighborhood;
	
	private int apartmentNum;
	
	private String city; 
	
	private int zipCode;
	//
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "address_userDetail", joinColumns = @JoinColumn(name = "addressId", referencedColumnName = "addressId"), inverseJoinColumns = @JoinColumn(name = "userDetailId", referencedColumnName = "userDetailId"))
	private UserDetail userDetail;
	
	@OneToOne(mappedBy = "address" ,fetch = FetchType.LAZY)
	private Internship internship;
	
	public Address() {

	}

	public Address(int buildingNum, String street, String neighborhood, int apartmentNum, String city, int zipCode) {
		this.buildingNum = buildingNum;
		this.street = street;
		this.neighborhood = neighborhood;
		this.apartmentNum = apartmentNum;
		this.city = city;
		this.zipCode = zipCode;
	}

	public int getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(int buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int getApartmentNum() {
		return apartmentNum;
	}

	public void setApartmentNum(int apartmentNum) {
		this.apartmentNum = apartmentNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Address [buildingNum=" + buildingNum + ", street=" + street + ", neighborhood=" + neighborhood
				+ ", apartmentNum=" + apartmentNum + ", city=" + city + ", zipCode=" + zipCode + "]";
	}
	
}
