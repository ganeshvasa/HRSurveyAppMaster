package com.bbyn.rest.model;

public class SurveyQuestions {
	
	private String surveyCode;
	private String QueCode;
	private String Question;
	private String QueType;
	private String createdDate;
	private String updatedDate;
	private String status;
	public String getSurveyCode() {
		return surveyCode;
	}
	public void setSurveyCode(String surveyCode) {
		this.surveyCode = surveyCode;
	}
	public String getQueCode() {
		return QueCode;
	}
	public void setQueCode(String queCode) {
		QueCode = queCode;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getQueType() {
		return QueType;
	}
	public void setQueType(String queType) {
		QueType = queType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdateDate() {
		return updatedDate;
	}
	public void setUpdateDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
