package Call_API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;

public class TC001_GET_Request {

  @BeforeClass
  public void beforeClass() {
  }

	/*  @Test
	  public void test1() {
		  //Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		 Response response = get("https://reqres.in/api/users?page=2");
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getTime());
		 System.out.println(response.getHeader("content-type"));
		 System.out.println(response.getStatusLine());
		 System.out.println(response.getBody().asString());
		 
		 Assert.assertEquals(response.getStatusCode(),200);
	  }
	  
	  @Test
	  public void test2() {
		  
		  given().
		  	get("https://reqres.in/api/users?page=2").
		  then().
		  	statusCode(200).
		  	body("data[1].id",equalTo(8)).log().all();
	  }*/
	  
	  
	 @Test
	  public void get_test() {
		
		  baseURI = "https://reqres.in/api";
		  
		  given().
		  	 get("/users?page=2").
		  then().
		  	 statusCode(200).
		  	 body("data[11].first_name",equalTo("George")).
		  	 body("data.first_name",hasItems("George","Rachael"));
	  }
	  
	  @Test 
	  public void post_test() {
		
		  String id = UUID.randomUUID().toString();
		  
		  String fileUri = "http://localhost/api/playback/" + id;

		  System.out.println("FileURI : "+fileUri);
		  
		  Map<String,Object> map = new HashMap<String, Object>();
		  
		  //map.put("name", "Ankur");
		  //map.put("name","Amogh");
		  //System.out.println(map);
		  
		  JSONObject request = new JSONObject(map);
		  
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
		  	 post("/users").
		  then().
		  	 statusCode(201).log().all();
		  
	  }
	  
  @AfterTest
  public void afterTest() {
  }

}
