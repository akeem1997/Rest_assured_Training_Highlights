package day1;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;


public class HTTP_Practice {
	int id;
	
	@Test(priority = 1) 
		public void postUser() {
		HashMap input = new HashMap();
		input.put("FirstName", "Atinuke");
		input.put("Lastname", "Onanuga");
		input.put("Occupation", "Content Writer");
		input.put("Location", "Ikorodu");
		id = given().contentType("application/json")
		.body(input).when().post(" http://localhost:3000/PerformanceStudents")
		.jsonPath().getInt("id");
		
		
	}
	@Test(priority = 2, dependsOnMethods = {"postUser"})
	public void getUser() {
		when().get(" http://localhost:3000/PerformanceStudents/"+id)
		.then().statusCode(200)
		.log().all();
	}
	@Test(priority = 3, dependsOnMethods = {"getUser"})
	public void deleteUser() {
		when().delete(" http://localhost:3000/PerformanceStudents/"+id)
		.then().statusCode(200)
		.log().all();
	}
	

}
