package JIRA.JIRA_AUTOMATION_PROJECT;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Create_Issue extends JIRA_LOGIN{

	@Test
	public void createIssue() throws IOException {

		//CREATE A ISSUE
		given().log().all()
		.header("Content-Type", "application/json")
		.header("cookie", sessionCookie)
		.body(new String(Files.readAllBytes(Paths.get("src/test/Create_Issue_Body.json"))))
		.when().post("rest/api/2/issue")
		.then().log().all().assertThat().statusCode(201);

	}
}
