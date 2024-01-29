package JIRA.JIRA_AUTOMATION_PROJECT;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class JIRA_LOGIN {

	String username = "rahulkawatghare05";
	String password = "Rahul@123";
	String jSessionId = "";
	String value = "";
	String sessionCookie = "";
	
	public JIRA_LOGIN () {
		
		RestAssured.baseURI = "http://localhost:8080/";
		
		String response =
		given().log().all()
		.header("Content-Type", "application/json")
		.body("{ \"username\": \""+username+"\", \"password\": \""+password+"\" }")
		.when()
		.post("rest/auth/1/session")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asPrettyString();

		
		JsonPath js = new JsonPath(response);
		jSessionId = js.getString("session.name");
		value = js.getString("session.value");
		
		sessionCookie = jSessionId + "=" + value;
	}
}
