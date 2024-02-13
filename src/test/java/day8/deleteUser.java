package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class deleteUser {
	
	@Test
	public void test_deleteUser(ITestContext context) {
		String bearerToken = "5014aa926da2d084882ef88c47f6f89c8172279dc22ef30217c3bfc86a6b6c4b";
		//int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
		given().headers("Authorization", "Bearer " +bearerToken)
		.pathParam("id",id)
		.when().delete("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(204).log().all();
		
		
	}
	
	

}
