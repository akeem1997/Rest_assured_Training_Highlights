package day2;

//different ways to create POST request Body
//Post request using hashMap
//Post request body creation using org.json
//Post request body creation using POJO class
//Post request body creation  external json file data
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.support.FileReader;



public class diffWaysToCreatePostReq {
	//int id;
	//Post request using hashMap
	//@Test(priority = 1)
	public void testPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("Name", "Emma");
		data.put("Location", "France");
		data.put("phone", "1212121");
		
		String courseArray[] = {"C","C++"};
		data.put("courses", courseArray);
		 given().contentType("application/json").body(data)
		.when().post("http://localhost:3000/PerformanceStudents")
		
		.then().statusCode(201)
		.body("Name", equalTo("Emma"))
		.body("Location", equalTo("France"))
		.body("phone", equalTo("1212121"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
		
		
	}
	
	//Post request body creation using org.json
	//@Test(priority = 1)
	public void testPostUsingOrgJson() {
		JSONObject data = new JSONObject();
		data.put("Name", "Obi");
		data.put("Location", "Nigeria");
		data.put("phone", "612281");
		String coursesName[] = {"C","C++","java"};
		data.put("courses", coursesName);
		 given().contentType("application/json").body(data.toString())
		.when().post("http://localhost:3000/PerformanceStudents")
		
		.then().statusCode(201)
		.body("Name", equalTo("Obi"))
		.body("Location", equalTo("Nigeria"))
		.body("phone", equalTo("612281"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.body("courses[2]", equalTo("java"))
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
		
		
	}
	//Post request body creation using POJO class
	//@Test(priority = 1)
	public void testPostUsingPojoClass() {
		pojo_PostRequest data = new pojo_PostRequest();
		data.setName("Tunde");
		data.setLocation("Spain");
		data.setPhone("123456789");
		String coursesAr[] = {"C", "C++"};
		data.setCourses(coursesAr);
		 given().contentType("application/json").body(data)
		.when().post("http://localhost:3000/PerformanceStudents")
		
		.then().statusCode(201)
		.body("name", equalTo("Tunde"))
		.body("location", equalTo("Spain"))
		.body("phone", equalTo("123456789"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
		
		
	}
	//Post request body creation  external json file data
	@Test(priority = 1)
	public void testPostUsingJsonFile() throws FileNotFoundException {
		File f = new File(".\\Body.json");
		java.io.FileReader fr = new java.io.FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		 given().contentType("application/json").body(data.toString())
		.when().post("http://localhost:3000/PerformanceStudents")
		
		.then().statusCode(201)
		.body("name", equalTo("Ariyo"))
		.body("location", equalTo("Ghana"))
		.body("phone", equalTo("2468"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		
		.header("Content-Type", "application/json; charset=utf-8")
		.log().all();
		
		
		
		
	}
	
	
	//@Test(priority = 2)
	public void deleteRecord() {
		when().delete("http://localhost:3000/PerformanceStudents/18")
		.then().statusCode(200)
		.log().all();
	}

}
