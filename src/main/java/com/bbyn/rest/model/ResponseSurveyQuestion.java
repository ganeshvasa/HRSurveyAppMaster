package com.bbyn.rest.model;

import java.util.List;

public class ResponseSurveyQuestion {

	List<SurveyQuestions> surveyQuestions;
	String status;
	int statusCode;
	
	
	
	
	

	public List<SurveyQuestions> getSurveyQuestions() {
		return surveyQuestions;
	}
	public void setSurveyQuestions(List<SurveyQuestions> surveyQuestions) {
		this.surveyQuestions = surveyQuestions;
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