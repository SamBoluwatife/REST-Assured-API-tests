import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.Assert;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class Test02_POST {
	//@Test
	public void test_02_post() {
		
		/*Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Boluwatife");
		map.put("job", "QA Engineer");
		
		System.out.println(map);*/
		
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
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
		
	}
	
}
