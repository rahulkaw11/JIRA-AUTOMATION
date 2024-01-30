package JIRA.JIRA_AUTOMATION_PROJECT;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Add_Comment extends JIRA_LOGIN{

	@Test
	public void addComment() throws IOException {
		
		String issueKey = "JIRAAUTO-4";
		
		given().log().all()
		.header("Content-Type", "application/json")
		.pathParam("key", issueKey)
		.header("cookie",sessionCookie)
		.body(new String(Files.readAllBytes(Paths.get("src/test/Add_Comment.json"))))
		.when().post("rest/api/2/issue/{key}/comment")
		.then().log().all().assertThat().statusCode(201);
	}
}
