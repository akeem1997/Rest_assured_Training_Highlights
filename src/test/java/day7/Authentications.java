package day7;
import org.json.JSONObject;
import org.testng.Assert;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.Test;

public class Authentications {
	@Test(priority = 1)
	public void testBasicAuthentication() {
		given().auth().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority = 2)
	public void testdigestAuthentication() {
		given().auth().digest("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority = 3)
	public void testPreemptiveAuthentication() {
		given().auth().preemptive().basic("postman", "password")
		.when().get("https://postman-echo.com/basic-auth")
		.then().statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	@Test(priority = 4)
	public void testBearerTokenAuthtentication() {
		String bearerToken = "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";
		given().headers("Authorization","Bearer "+bearerToken)
		.when().get("https://api.github.com/users/repos")
		.then().statusCode(200).log().all();
		
	}
	@Test(priority = 5)
	public void testOAUTH1Authentication() {
		given().auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecrate")//this is foroAuth1.0 authentication
		.when().get("url")
		.then().statusCode(200).log().all();
		
	}@Test(priority = 5)
	public void testOAUTH2Authentication() {
		given().auth().oauth2( "accessToken")//this is foroAuth2.0 authentication
		.when().get("url")
		.then().statusCode(200).log().all();
	}
	
	@Test(priority = 6)
	public void testAPIKEYAuthentication() {
		given().queryParam("appid", "keyValue") //app id is apikey 
		.when().get("url")
		.then().statusCode(200).log().all();
	}
	
	

}
