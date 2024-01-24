package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;
import TestData.apiResources;
import TestData.TestDataBuild;
import TestData.Utilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import static 

public class StepDefination extends Utilities{
	
	
	RequestSpecification request;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id; // declaring it static so it can be used across test cases....
	
	
	
	
	@Given("Add place Payload with {string} {string}")
	public void add_place_payload_with(String name, String address) throws IOException {
	    
		/*
		--Extends Utilities to use requestSpecification()
		--All test related data will be retrieved from TestDataBuild class object
		
		*/
		request = given().spec(requestSpecification()).body(data.AddPlacePayLoad(name,address));
		
	    
	}
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resourse, String httpMethod) {
	    // Write code here that turns the phrase above into concrete actions
		
		apiResources api = apiResources.valueOf(resourse);// enum class object to get resouse api dynamically
		System.out.println(api.getResource());
		if (httpMethod.equalsIgnoreCase("post"))
			response = request.when().post(api.getResource());// making request and getting response
		if (httpMethod.equalsIgnoreCase("get"))
			response = request.when().get(api.getResource());// making request and getting response
		
	}

	@Then("The api call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer statuscode) {
		
		assertEquals(statuscode.intValue(),response.getStatusCode()); 
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
	   
		assertEquals(getJsonKeyValue(response.asPrettyString(),key),value);
		
	}
	@Then("verify that {string} place has been created by {string}")
	public void verify_that_place_has_been_created_by(String ExpectedName, String Api) throws IOException {
		
		
		place_id = getJsonKeyValue(response.asPrettyString(),"place_id");	
		
		request = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(Api,"get");
		the_api_call_got_success_with_status_code(200);
		in_response_body_is("name",ExpectedName);
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification()).body(data.DelPlacePayLoad(place_id));
	   
	}
}
