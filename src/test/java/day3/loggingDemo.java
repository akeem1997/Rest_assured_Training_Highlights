package day3;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class loggingDemo {
	@Test()
	public void testLogs() {
		when().get("https://reqres.in/api/users?page=2").then()
		//.log().body();
		//.log().cookies();
		//.log().headers();
		.log().all();
	}

}
