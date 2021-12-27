package com.framework.StepDefinition;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.framework.settings.API_Endpoints;
import com.framework.settings.ObjectRepo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_Steps {
	Response response;
	JSONObject requestParams = new JSONObject();
	
	@Given("I set the base URI")
	public void i_set_the_base_URI() {
		RestAssured.baseURI = ObjectRepo.reader.getBaseURI();
	}
	
	@Then("I should get the response status as {int}")
	public void i_should_get_the_response_status_as(int responseCode) {
		Assert.assertEquals(response.getStatusCode(), responseCode);
	}

	@Then("I should get  {string} as {string} in response body")
	public void i_should_get_as_in_response_body(String key, String value) {
		JsonPath jsonPathEvaluattor = response.jsonPath();
		Assert.assertEquals(jsonPathEvaluattor.get(key).toString(), value);
	}
	
	@Then("I should get {int} {string} objects in the response")
	public void i_should_get_objects_in_response(int numberOfObjects, String objectName) {
		List<Object> jsonResponse = response.jsonPath().getList(objectName);
		Assert.assertEquals(jsonResponse.size(), numberOfObjects);
	}
	
	@SuppressWarnings("unchecked")
	@When("I add {string} as {string} to request parameters")
	public void i_add_as_to_request_parameters(String key, String value) {
		String[] keys = key.split(", ");
		String[] values = value.split(", ");
		for(int i = 0; i<keys.length; i++) {
			requestParams.put(keys[i], values[i]); 
		}
	}

	
	@When("I send the API request to get search results for additional keyword as {string}")
	public void i_send_the_api_request_to_get_search_results_for_additional_keyword_as(String keyword) {
		response = given()
				.header("Content-Type","application/json")
				.get(API_Endpoints.additionalKewWordSearch.replace("additionalKeyword", keyword)).then().extract().response();
	}
	

	
	/*
	@When("I add {string} as {int} to request parameters")
	public void i_add_as_to_request_parameters(String key, int value) {
		requestParams.put(key, value);
	}
	
	@When("I send the API {string} request to (.*) a resource")
	public void i_send_the_api_post_request_to_create_a_resource(String reqType) {
		switch(reqType) {
		case "post":
			response = given().header("Content-type", "application/json; charset=UTF-8")
			.body(requestParams.toJSONString())
			.post(GlobalTestData.pathAllResources);
			break;
		case "put":
			response = given().header("Content-type", "application/json; charset=UTF-8")
			.body(requestParams.toJSONString())
			.put(GlobalTestData.pathOneResource);
			break;
		case "patch":
			response = given().header("Content-type", "application/json; charset=UTF-8")
			.body(requestParams.toJSONString())
			.patch(GlobalTestData.pathOneResource);
			break;
		case "delete":
			response = given().header("Content-type", "application/json; charset=UTF-8")
			.delete(GlobalTestData.pathOneResource);
			break;
		}
	}
	
	*/

	
}
