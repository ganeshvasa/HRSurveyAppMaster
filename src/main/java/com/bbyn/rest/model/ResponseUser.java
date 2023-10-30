package com.bbyn.rest.model;

public class ResponseUser {

	UserProfile userProfile;
	String status;
	int statusCode;
	
	
	
	public UserProfile getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	

//	@Override
//	public String toString() {
//		return "{\"status\": "+ status + ", 	\"statusCode\": "+ statusCode + "}";
//	}
}