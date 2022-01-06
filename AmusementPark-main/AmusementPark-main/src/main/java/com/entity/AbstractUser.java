package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AbstractUser {
	
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String mobileNumber;
	private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firsrtName) {
		this.firstName = firsrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "AbstractUser [username=" + username + ", firsrtName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	

}
