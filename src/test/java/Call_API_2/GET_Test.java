package Call_API_2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class GET_Test {
  
  @Test
  public void get_call()
  {
	  baseURI="https://reqres.in";
	  
	  given().
	  	get("/api/users/2").
	  then().
	  	statusCode(200).
	    body("data.first_name", equalTo("Janet")).log().all();
	  
  }
}
