package day4;
import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class personalParsing {
	@Test(priority = 1)
	public void parseMethod() {
		given().contentType(ContentType.JSON)
		.when().get("http://localhost:3000/DevopsStudents/1785397247")
		.then().statusCode(200)
		.body("RecordLabel[0].Artist", equalTo("Kizz Daniel"))
		.body("RecordLabel[3].Artist", equalTo("Tiwa Savage"))
		.header("Content-Type", equalTo("application/json; charset=utf-8"));
		
	}
	@Test(priority = 2)
	public void parseObj() {
		Response res=given().contentType(ContentType.JSON)
		.when().get("http://localhost:3000/DevopsStudents/1785397247");
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
		String recordLab=res.jsonPath().get("RecordLabel[0].Artist").toString();
		Assert.assertEquals(recordLab, "Kizz Daniel");
		JSONObject jb = new JSONObject(res.asString());
		for(int i=0;i<jb.getJSONArray("RecordLabel").length();i++) {
			String getGenres=jb.getJSONArray("RecordLabel").getJSONObject(i).get("Genre").toString();
			System.out.println(getGenres);
			String getNet=jb.getJSONArray("RecordLabel").getJSONObject(i).get("NetWorth").toString();
			System.out.println(getNet);
			
		}
	}

}
