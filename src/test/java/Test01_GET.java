import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Test01_GET {

	@Test 
	void test_01_get() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
		
		
	}
	@Test
	void test_01_get2() {
		
		given().
			/*header("Content-Type", "application/json").
			param(parameterName, parrameterValues)*/
			get("https://reqres.in/api/users?page=2").
		then()
			.statusCode(200).
			body("data.id[1]", equalTo(8)).
			body("data.first_name", hasItems("Michael","Lindsay")).
			log().all();
			
		
	}
}
