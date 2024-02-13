package day3;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class headersDemo {
	//@Test(priority = 1)
	public void testHeaders() {
		when().get("https://www.google.com/")
		.then().header("Content-Type", "text/html; charset=ISO-8859-1")
		.header("Content-Encoding", "gzip")
		.header("Server", "gws").log().headers();
	}
	
	@Test(priority = 2)
	public void getHeaders() {
		Response res= given().when().get("https://www.google.com/");
		//get single header info
		//String headerVal=res.getHeader("Content-Type");
		//System.out.println("The value of content type header is " +headerVal);
		//get all headers info
		Headers myHeaders= res.getHeaders();
		for(Header hd: myHeaders) {
			System.out.println(hd.getName()+"      "+hd.getValue());
			
		}
		


}
}
	

