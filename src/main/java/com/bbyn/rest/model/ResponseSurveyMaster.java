package com.bbyn.rest.model;

import java.util.List;

public class ResponseSurveyMaster {

	List<SurveyMaster> surveyMasters;
	String status;
	int statusCode;
	
	
	
	
	
	public List<SurveyMaster> getSurveyMasters() {
		return surveyMasters;
	}
	public void setSurveyMasters(List<SurveyMaster> surveyMasters) {
		this.surveyMasters = surveyMasters;
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