package JIRA.JIRA_AUTOMATION_PROJECT;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

public class Add_Attachment extends JIRA_LOGIN{
	
	@Test
	public void addAttachment() {
		
		String issueKey = "JIRAAUTO-4";
		File attachmentFile = new File("src/test/testing_tools.png");
		
		given().log().all()
		.pathParam("key", issueKey)
		.header("cookie", sessionCookie)
		.header("X-Atlassian-Token","no-check")
		.header("Content-Type","multipart/form-data")
		.multiPart("file", attachmentFile)
		.when().post("rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
	}

}
