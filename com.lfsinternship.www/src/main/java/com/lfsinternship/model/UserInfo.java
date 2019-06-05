package com.lfsinternship.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

public class UserInfo {

	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date birthOfDate;
	
	public UserInfo() {

	}

	public UserInfo(String userName, String firstName, String lastName, String email, Date birthOfDate) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.birthOfDate = birthOfDate;
	}

	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Date getBirthOfDate() {
		return birthOfDate;
	}

	public void setBirthOfDate(Date birthOfDate) {
		this.birthOfDate = birthOfDate;
	}

	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", birthOfDate=" + birthOfDate + "]";
	}
	
	
	
}
