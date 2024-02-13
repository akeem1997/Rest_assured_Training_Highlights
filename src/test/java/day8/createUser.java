package day8;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class createUser {
	@Test
	public void test_createUser(ITestContext context) {
		Faker faker = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "5014aa926da2d084882ef88c47f6f89c8172279dc22ef30217c3bfc86a6b6c4b";
		int id= given().headers("Authorization", "Bearer "+bearerToken).contentType("application/json").body(data.toString())
		.when().post("https://gorest.co.in/public/v2/users")
		.jsonPath().getInt("id");
		System.out.println("Generated id is "+id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
		
		
		
	}

}
