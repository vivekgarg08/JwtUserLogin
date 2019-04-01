package com.vivek.userLoginModel;

public class JwtUser {
	private String userID;
	private String role;
	private String userName;
	
	public String getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
