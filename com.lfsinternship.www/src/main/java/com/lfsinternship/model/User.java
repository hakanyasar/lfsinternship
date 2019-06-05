package com.lfsinternship.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	
	@NamedQuery(name = "User.findById", 
			query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.userId = :userId"),
	@NamedQuery(name = "User.findByUserName", 
			query = "SELECT u FROM User u WHERE u.userName = :userName"),
	@NamedQuery(name = "User.findWithUserDetailsByUserName", 
			query = "SELECT u FROM User u LEFT JOIN FETCH u.userDetail WHERE u.userName = :userName"),
	@NamedQuery(name = "User.Count", 
			query = "SELECT COUNT(u) FROM User u"),
	@NamedQuery(name = "User.findAllUsers", 
			query = "SELECT u FROM User u"),
	@NamedQuery(name = "User.findUserInfoByUserName", 
			query = "SELECT new com.lfsinternship.model.UserInfo(u.userName, u.userDetail.firstName, u.userDetail.lastName, u.emailAddress, u.userDetail.birthDate) FROM User u WHERE u.userName = :userName")
	
	/*
	 * @NamedQuery(name = "User.findCompanyByUserName",
				query = "SELECT c FROM User u LEFT JOIN u.userDetail ud LEFT JOIN ud.company c WHERE u.UserName = :userName")
	*/
})

public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	private String emailAddress;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private UserDetail userDetail;
	
	public User() {

	}

	public User(String userName, String password, Date creationDate) {
		this.userName = userName;
		this.password = password;
		this.creationDate = creationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	
}
