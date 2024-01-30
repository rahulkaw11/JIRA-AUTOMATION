package JIRA.JIRA_AUTOMATION_PROJECT.CRUD_OPERATIONS;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import JIRA.JIRA_AUTOMATION_PROJECT.JIRA_LOGIN;

public class Delete_Issue extends JIRA_LOGIN{

	@Test
	public void deleteIssue() {
		
		String issueKey = "JIRAAUTO-3";
		
		given().log().all()
		.header("cookie", sessionCookie)
		.pathParam("key", issueKey)
		.when().delete("rest/api/2/issue/{key}")
		.then().log().all().assertThat().statusCode(204);
	}
}
