import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class Examples {

	//@Test
	public void test_get() {
		
		baseURI = ("http://localhost:3000/");
		
				given().
					get("/users").
				then().
					statusCode(200).log().all();
		
	}
	//@Test
	public void test_post() {
		
		JSONObject request = new JSONObject ();
		
		request.put("firstName", "Ronaldo");
		request.put("lastName", "Cristiano");
		request.put("subjectId", 2);
	
		
		baseURI = ("http://localhost:3000/");
		
		given().
		header("Cotent-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		post("/users").
	then().
		statusCode(201).log().all();
	}
	
	//@Test
	public void test_patch() {
		
		JSONObject request = new JSONObject ();
		
		request.put("firstName", "Dybala");
		request.put("lastName", "Paulo");
		request.put("subjectId", 1);
	
		
		baseURI = ("http://localhost:3000/");
		
		given().
		header("Cotent-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		patch("/users/5").
	then().
		statusCode(200).log().all();
	}
	@Test
	public void test_put() {
		
		JSONObject request = new JSONObject ();
		
		request.put("firstName", "Dybala");
		request.put("lastName", "Paulo");
		request.put("subjectId", 2);
	
		
		baseURI = ("http://localhost:3000/");
		
		given().
		header("Cotent-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().
		put("/users/5").
	then().
		statusCode(200).log().all();
	}
	@Test
	public void test_delete() {
		
		baseURI = ("http://localhost:3000/");
		
		when().
			delete("/users/5").
		then().
			statusCode(200);
	}
}
