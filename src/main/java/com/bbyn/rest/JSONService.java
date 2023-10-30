package com.bbyn.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.bbyn.rest.client.MYSQLDML;
import com.bbyn.rest.model.ResponseGeneric;
import com.bbyn.rest.model.ResponseSurveyMaster;
import com.bbyn.rest.model.ResponseSurveyQuestion;
import com.bbyn.rest.model.ResponseUser;
import com.bbyn.rest.model.SurveyQuestions;
import com.bbyn.rest.model.UserProfile;


@Path("/json/hrapp")
public class JSONService {

	@GET
	@Path("/get")
	@Produces("application/json")
	public String getProductInJSON() {

		
		return "Success"; 

	}
	
	@POST
	@Path("/validateUser")
	@Consumes("application/json")
	public String validateUser(UserProfile userProfile) throws JsonGenerationException, JsonMappingException, IOException {

				
		ResponseUser response = MYSQLDML.getUser(userProfile.getEmpID(), userProfile.getPassword());
		System.out.println("Get User Response:"+response);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(response);
		return json;
		
	}
	
	@POST
	@Path("/getSurveyMaster")
	@Produces("application/json")
	public String surveyMaster() throws JsonGenerationException, JsonMappingException, IOException {

				
		ResponseSurveyMaster response = MYSQLDML.getSurveyMaster();
		System.out.println("Get User Response:"+response);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(response);
		return json;
		
	}
	
	@POST
	@Path("/getSurveyQuestions")
	@Produces("application/json")
	public String getSurveyQuestions() throws JsonGenerationException, JsonMappingException, IOException {

				
		ResponseSurveyQuestion response = MYSQLDML.getSurveyQuestions();
		System.out.println("Get User Response:"+response);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(response);
		return json;
		
	}

	
	@POST
	@Path("/updateQuestion")
	@Consumes("application/json")
	public String updateQuestion(SurveyQuestions surveyQuestions) throws JsonGenerationException, JsonMappingException, IOException {

		
		ResponseGeneric response = MYSQLDML.updateQuestion(surveyQuestions.getSurveyCode(), surveyQuestions.getQueCode(), surveyQuestions.getQuestion());
		System.out.println("Get User Response:"+response);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(response);
		return json;
		
	}
	
	@POST
	@Path("/disableQuestion")
	@Consumes("application/json")
	public String disableQuestion(SurveyQuestions surveyQuestions) throws JsonGenerationException, JsonMappingException, IOException {

		
		ResponseGeneric response = MYSQLDML.deleteQuestion(surveyQuestions.getSurveyCode(), surveyQuestions.getQueCode());
		System.out.println("Get User Response:"+response);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(response);
		return json;
		
	}
	
	
	
}