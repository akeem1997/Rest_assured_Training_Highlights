package day8;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class getUser {
	
	@Test
	public void tes_getUser(ITestContext context) {
		//int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
		String bearerToken = "5014aa926da2d084882ef88c47f6f89c8172279dc22ef30217c3bfc86a6b6c4b";
		given().headers("Authorization", "Bearer "+bearerToken)
		.pathParam("id",id)
		.when().get("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(200).log().all();
		
	}

}
