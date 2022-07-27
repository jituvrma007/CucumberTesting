package com.cucumberTesting.tests.stepdef;

import com.cucumberTesting.tests.model.Posts;
import com.cucumberTesting.testware.base.ApiBaseSetup;
import com.cucumberTesting.testware.utility.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MakePostsStep extends ApiBaseSetup {

    private String makePosts ="";
    private String getPostsWithUserId ="";

    @Given("I have a service to make a post")
    public void iHaveAServiceToMakeAPost() {

        request = requestExecutor.returnRequestSpecification(common.
                returnConcatenatedBaseURI("protocol","baseUrl", "serviceUrl"));
        makePosts = apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "makePosts");
        getPostsWithUserId = apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "getPostsWithUserId");

        log.info("makePosts :: "+makePosts +"getPostsWithUserId :: "+getPostsWithUserId);
    }

    @When("the user check the posts with userId {string}")
    public void theUserCheckAllThePostsWithMyTheirUserId(String userId) {
        response = requestExecutor.executeGetRequestWithParams(request,getPostsWithUserId,new String[]{userId});
    }

    @Then("returned status code is {int}")
    public void returnedStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode(), "statusCode does not matched");
    }

    @Then("the response {string} schema should match with specification")
    public void theResponseSchemaShouldMatchWithSpecification(String format) {
        Assert.assertTrue(responseValidator.schemaValidator(response,format,
                        Constants.SCHEMA_FILE_PATH+"MakePostAPIResponseSchema.json"),
                "Schema validation is getting failed !");
    }

    @Then("all the posts made by the user with userId {string} should be returned")
    public void allThePostsMadeByTheUserWithUserIdShouldBeReturned(String userId) {
        Assert.assertEquals(String.valueOf(userId),responseValidator.jsonStringValue(response,"$.userId"),
                "posts are not coming only for the respective user");
    }

    @When("the user create a post with userId {int}, title {string} and body {string}")
    public void theUserCreateAPostWithUserIdUserIdTitleAndBody(int userId, String title, String body) {

        Posts newPosts = new Posts(title, body, userId);
        response = requestExecutor.executePostRequest(request,makePosts,newPosts.toStringJson());

    }

    @Then("The response should have userId {int}, title {string} and body {string}")
    public void theResponseShouldHaveUserIdUserIdTitleAndBody(int userId, String title, String body) {
        Assert.assertEquals(String.valueOf(userId),responseValidator.jsonStringValue(response,"$.userId"),
                "posts are not containing the userId");
        Assert.assertEquals(title,responseValidator.jsonStringValue(response,"$.title"),
                "posts are not containing the title");
        Assert.assertEquals(body,responseValidator.jsonStringValue(response,"$.body"),
                "posts are not containing the body");
    }

    @When("the admin user check for all the existing posts")
    public void theUserCheckThePostsWithEndpointPosts() {
        response = requestExecutor.executeGetRequest(request,makePosts);
    }

    @Then("more then one user's posts should be in response data")
    public void moreThenOneUserSPostsShouldBeInResponseData() {

        Assert.assertTrue(responseValidator.jsonSetOfStringValue(response,"$..userId").size()>1,
                "posts are not from more then one userId");

   }

}
