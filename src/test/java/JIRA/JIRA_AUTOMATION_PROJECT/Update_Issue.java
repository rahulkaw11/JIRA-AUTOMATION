package JIRA.JIRA_AUTOMATION_PROJECT;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Update_Issue extends JIRA_LOGIN{

	@Test
	public void updateIssue() throws IOException {
		
		String issueKey = "JIRAAUTO-4";
		
		given().log().all()
		.header("cookie", sessionCookie)
		.header("Content-Type", "application/json")
		.body(new String(Files.readAllBytes(Paths.get("src/test/Update_Issue.json"))))
		.pathParam("key", issueKey)
		.when().put("rest/api/2/issue/{key}")
		.then().log().all().assertThat().statusCode(204);
		
	}
}
