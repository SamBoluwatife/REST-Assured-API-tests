import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class Test05_DELETE {

	@Test
	public void test_05_delete() {
			
			when().
				delete("https://reqres.in/api/users/2").
			then().
				statusCode(204).
				log().all();
		}
	
}
