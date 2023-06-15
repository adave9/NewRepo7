package Call_API_2;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class POST_Test {
  
  @Test
  public void psot_test() {
	  
	  JSONObject request = new JSONObject();
	  
	  request.put("BinaryPayload","MP3File.mp3");
	  
	  baseURI = "https://localhost:8080";
	  
	  given().
		  header("Content-Type","application/jason").
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  body(request.toJSONString()).
	  when().
	  	 post("/api/audios").
	  then().
	   	  statusCode(201).log().all();
  }
}
