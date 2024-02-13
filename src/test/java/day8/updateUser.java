package day8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updateUser {
	@Test
	public void test_updateUser(ITestContext context) {
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "5014aa926da2d084882ef88c47f6f89c8172279dc22ef30217c3bfc86a6b6c4b";
		//int id=(Integer) context.getAttribute("user_id");
		int id=(Integer) context.getSuite().getAttribute("user_id");
	 given().headers("Authorization", "Bearer "+bearerToken).contentType("application/json").pathParam("id", id).body(data.toString())
		.when().put("https://gorest.co.in/public/v2/users/{id}")
		
		.then().log().all();
		
		
	}

}
