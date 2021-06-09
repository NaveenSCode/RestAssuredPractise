/// GET and POST

package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class ThirdTest {

	//@Test
	public void testGetRequest() {
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].first_name",equalTo("Lindsay")). // checks second reecord has first name Lindsay
			body("data.first_name",hasItems("George","Rachel")); //checks if given records are present in first name field in response
	}
	
	@Test
	public void testPostRequest() {
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Virat");
		map.put("job", "cricketer");
		System.out.println(map);
		
		JSONObject request = new JSONObject(map);   // to convert map into json request format
		
		// if you want to create request without using map
		//request.put("name", "sachin");
		//request.put("job", "cricketer");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		//creation of post request
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").  //specifying header
			contentType(ContentType.JSON).				//specifying conten type
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).  //to verify status code to be 201
			log().all();   //to print response on console
		
	}
}
