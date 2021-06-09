package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SecondTest {
	
	@Test
	public void test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		//using assert to verify conditions
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode,200);  //should pass
		//Assert.assertEquals(actualStatusCode,201);  //should fail

		
		
	}
	
	@Test
	public void test2() {
		baseURI = "https://reqres.in/api";
		//verifying whether status code is 200
		given().get("/users?page=2").then().statusCode(200);
		
		//we can also write above line as this for readability
		given().
			get("/users?page=2").
		then().
			statusCode(200);
		
		//to check data of a particular record
		given().
			get("/users?page=2").
		then().
		statusCode(200).					//to verify if status code is 200
		body("data[1].id", equalTo(8)).    //to verify value particular record
		log().all();						// to print complete response on console

	}

}
