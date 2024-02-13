package day4;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class parsingJsonResponseTraining {
	//@Test(priority = 1)
	public void jsonResponse() {
		given().contentType("ContentType.json")
		.when().get("http://localhost:3000/PerformanceStudents/20")
		.then().statusCode(200)
		.body("book[0].author", equalTo("Niger reeves"))
		.body("book[0].category", equalTo("reference"))
		.body("book[3].category", equalTo("fiction"))
		.header("Content-Type", equalTo("application/json; charset=utf-8"));
	}
	//@Test(priority = 2)
	public void jsonResponse2() {
		
		Response res=given().contentType("ContentType.json")
		.when().get("http://localhost:3000/PerformanceStudents/20");
		Assert.assertEquals(res.getStatusCode(), 200);
		String bookname=res.jsonPath().get("book[0].author").toString();
		Assert.assertEquals(bookname, "Niger reeves");
		String name2=res.jsonPath().get("book[3].category").toString();
		Assert.assertEquals(name2, "fiction");
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(res.header("Vary"), "Origin, Accept-Encoding");
		int bookPrice=res.jsonPath().get("book[2].price");
		Assert.assertEquals(bookPrice, 120);
	}
	//@Test(priority = 3)
	public void jsonResponse3() {
		Response res= given().contentType("ContentType.json")
		.when().get("http://localhost:3000/PerformanceStudents/20");
		JSONObject jb = new JSONObject(res.asString());
		for(int i=0;i<jb.getJSONArray("book").length();i++) {
			String authorName= jb.getJSONArray("book").getJSONObject(i).get("author").toString();
			System.out.println(authorName);
			int priceName2=(Integer) jb.getJSONArray("book").getJSONObject(i).get("price");
			System.out.println(priceName2);
			String titleName=jb.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(titleName);
			String categoryName= jb.getJSONArray("book").getJSONObject(i).get("category").toString();
			System.out.println(categoryName);
			
		}
	}
	
	//@Test(priority = 4)
	public void jsonResponse4() {
		Response res= given().contentType("ContentType.json")
		.when().get("https://reqres.in/api/users?page=2");
		JSONObject rq = new JSONObject(res.asString());
		for(int i=0;i<rq.getJSONArray("data").length();i++) {
			String mails=rq.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(mails);
			String getAvatar=rq.getJSONArray("data").getJSONObject(i).get("avatar").toString();
			System.out.println(getAvatar);
			
		}
		
	}
	//@Test(priority = 5)
	public void jsonResponseObject() {
		Response res=given().contentType(ContentType.JSON)
		.when().get("http://localhost:3000/APIStudents");
		JSONArray jb = new JSONArray(res.asString());
		String name= jb.getJSONObject(4).getJSONObject("address").get("house no").toString();
		System.out.println(name);
	}
	@Test(priority = 6)
	public void getResponseArray() {
		Response res=given().contentType("ContentType.json")
		.when().get("http://localhost:3000/APIStudents");
		JSONArray jr = new JSONArray(res.asString());
		String namel=jr.getJSONObject(3).get("lastname").toString();
		System.out.println(namel);
	}

}
