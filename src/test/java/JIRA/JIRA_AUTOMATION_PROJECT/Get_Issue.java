package JIRA.JIRA_AUTOMATION_PROJECT;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get_Issue extends JIRA_LOGIN {

	@Test
	public void getIssue() {
		
		String issueKey = "JIRAAUTO-4";
		
		given().log().all()
		.header("cookie", sessionCookie)
		.pathParam("key", issueKey)
		.queryParam("fields", "project")
		.queryParam("fields", "summary")
		.queryParam("fields", "issuetype")
		.queryParam("fields", "assignee")
		.queryParam("fields", "reporter")
		.queryParam("fields", "priority")
		.queryParam("fields", "environment")
		.queryParam("fields", "description")
		.queryParam("fields", "comment")
		.when().get("rest/api/2/issue/{key}")
		.then().log().all().assertThat().statusCode(200);
		
		
	}
}
