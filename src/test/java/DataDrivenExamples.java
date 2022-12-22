import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenExamples extends DataForTests{
	
	@Test (dataProvider = "DataForPost")
		public void data_driven_example(String firstName, String lastName, int subjectId) {
	JSONObject request = new JSONObject ();
			
			request.put("firstName", firstName);
			request.put("lastName", lastName);
			request.put("subjectId", subjectId);
		
			
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

	
	@Test(dataProvider = "DeleteData")
	public void data_for_delete (int userId) {
			baseURI = ("http://localhost:3000/");
		
			when().
				delete("/users/"+userId).
			then().
				statusCode(200);
	}


	
	@Parameters({"userId"})
	@Test
	public void data_for_delete2 (int userId) {
			baseURI = ("http://localhost:3000/");
		
			when().
				delete("/users/"+userId).
			then().
				statusCode(200);
	}
}
