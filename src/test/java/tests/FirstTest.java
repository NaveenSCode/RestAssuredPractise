package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {
	
	@Test
	public void test1() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
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

}
