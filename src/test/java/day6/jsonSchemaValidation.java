package day6;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class jsonSchemaValidation {
	
	@Test(priority = 1)
	public void JsonSchemaval() {
		given()
		.when().get("http://localhost:3000/DevopsStudents/1785397247")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
		
	}

}
