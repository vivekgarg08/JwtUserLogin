package com.vivek.userLoginModel;

import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vivek.userLoginUtil.CustomLocalDateTimeSerializer;
import com.vivek.userLoginUtil.CustomerDateAndTimeDeserialize;




@Entity
@Table(name = "userInfo")
public class Users {
	@Id
	private String userID;
	@NotBlank
	private String firstName;
	private String lastName;
	@JsonDeserialize(using=CustomerDateAndTimeDeserialize.class)
	@NotNull(message="date can't be null")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotBlank
	private String emailID;
	@NotBlank
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
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
	
	
	public Date getDob() {
		return dob;
	}
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class )
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	public Users() {
		
	}
	public Users(String userID, String firstName, String lastName, Date dob, String emailID) {
		super();
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailID = emailID;
	}
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", emailID=" + emailID + "]";
	}

}
