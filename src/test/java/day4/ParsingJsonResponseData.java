package day4;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class ParsingJsonResponseData {
	//@Test(priority = 1)
	public void testJsonResponse() {
		//approach 1
		given().contentType("ContentType.JSON")
		.when().get("http://localhost:3000/PerformanceStudents/1")
		.then().statusCode(200)
		.body("LabelArtist[4]",equalTo("Ladipoe"))
		.header("Content-Type", "application/json; charset=utf-8");
		
	}
	//approach 2
	
		//@Test(priority = 1)
		public void testJsonResponse2() {
			
			Response res=given().contentType("ContentType.JSON")
			.when().get("http://localhost:3000/PerformanceStudents/1");
			Assert.assertEquals(res.getStatusCode(),200);  //validation one
			Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8"); //validation 2
			String bookname=res.jsonPath().get("LabelArtist[4]").toString();
			Assert.assertEquals(bookname, "Ladipoe");
			
			
		}
		@Test(priority = 1)
		public void testJsonResponse3() {
			//read all title data 
			Response res=given().contentType(ContentType.JSON)
			.when().get("http://localhost:3000/PerformanceStudents/20");
			//JSONOBJECT CLASS
			
			JSONObject jo = new JSONObject(res.asString()); //converting response to  jsonobject
			//print all titles of book
			//for(int i=0;i<jo.getJSONArray("book").length();i++) {
				//String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				//System.out.println(bookTitle);
				//}
			//print single title
			boolean status=false;
			for(int i=0;i<jo.getJSONArray("book").length();i++) {
				String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
				if(bookTitle.equalsIgnoreCase("The lord of the rings")) {
					status=true;
					break;
				}
			}
			Assert.assertEquals(status, true);
			
			//validate total price of books
			double totalprice=0;
			for(int i=0;i<jo.getJSONArray("book").length();i++) {
				String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
				totalprice=totalprice+Double.parseDouble(price);
			
			
			}
			System.out.println("total price of books is "+totalprice);
			Assert.assertEquals(totalprice, 570.0);
	

}
}

