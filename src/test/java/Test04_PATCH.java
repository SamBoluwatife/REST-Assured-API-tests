import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test04_PATCH {

	@Test
	public void test_04_patch() {
			
			JSONObject request = new JSONObject ();
			
			request.put("name", "Boluwatife");
			request.put("job", "QA Engineer");
			
			System.out.println(request);
			
			given().
				header("Cotent-Type", "application/json").
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				patch("https://reqres.in/api/users/2").
			then().
				statusCode(200).
				log().all();
		}
	
}
