package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class cookiesDemo {
	//@Test
	public void testCookies() {
		when().get("https://www.google.com/")
		.then().cookie("AEC", "Ad49MVFXSjwbcdvs7TFSlRI5DwLK5B-D_pXungEHEA1Er7TVGHlJ4jTlryw").log().all();
		
	}
	@Test(priority = 2)
	public void getCookiesinfo() {
		Response res= given()
		.when().get("https://www.google.com/");
		//get single cookie info
		//String cookie_value=res.getCookie("AEC");
		//System.out.println("value of cookie is " +cookie_value);
		
		//getAllcookiesinfo
		Map<String,String>cookies_value=res.getCookies();
		//System.out.println(cookies_value.keySet());
		for(String k:cookies_value.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.println(k +"              "+cookie_value);
			
		}
		
		
	}

}
