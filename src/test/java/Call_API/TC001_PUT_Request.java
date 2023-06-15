package Call_API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TC001_PUT_Request {

	@Test
	public void put_test() {
		
		  JSONObject request = new JSONObject();
		  
		  request.put("name", "Ankur");
		  request.put("job", "Engineer");
		  
		  System.out.println(request.toJSONString());
		  
		  baseURI = "https://reqres.in/api";
		  
		  given().
			  header("Content-Type","application/jason").
			  contentType(ContentType.JSON).
			  accept(ContentType.JSON).
			  body(request.toJSONString()).
		  when().
		  	 put("/users/2").
		  then().
		  	 statusCode(200).log().all();
	}
}
