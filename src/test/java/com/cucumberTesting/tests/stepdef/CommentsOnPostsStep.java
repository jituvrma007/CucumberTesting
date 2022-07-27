package com.cucumberTesting.tests.stepdef;

import com.cucumberTesting.tests.model.Comment;
import com.cucumberTesting.testware.base.ApiBaseSetup;
import com.cucumberTesting.testware.utility.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class CommentsOnPostsStep extends ApiBaseSetup {

    private String commentOnPosts ="";
    private String getCommentsOnPostsUsingPostIdAndId = "";

    @Given("I have a service to make a comment on a post")
    public void iHaveAServiceToMakeACommentOnAPost() {

        request = requestExecutor.returnRequestSpecification(common.
                returnConcatenatedBaseURI("protocol","baseUrl", "serviceUrl"));
        commentOnPosts = apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "commentOnPosts");
        getCommentsOnPostsUsingPostIdAndId =  apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "getCommentsOnPostsUsingPostIdAndId");

        log.info("commentOnPosts :: "+commentOnPosts +"getCommentsOnPostsUsingPostIdAndId :: "+getCommentsOnPostsUsingPostIdAndId);

    }

    @When("I request list of existing comments")
    public void iRequestListOfExistingComments() {
        response = requestExecutor.executeGetRequest(request,commentOnPosts);
    }

    @Then("The returned status code is {int}")
    public void theReturnedStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode(), "statusCode does not matched");
    }

    @When("I filter the comments api response with postId {string} and id {string}")
    public void iFilterTheCommentsApiResponseWithPostIdAndId(String postId, String id) {
        response = requestExecutor.executeGetRequestWithParams(request,getCommentsOnPostsUsingPostIdAndId,new String[]{postId, id});

    }
    @Then("Comments api response for the respective postId {string} and id {string} should be returned")
    public void allCommentsForTheRespectivePostIdAndIdShouldBeReturned(String postId, String id) {
        Assert.assertEquals(Integer.valueOf(postId),responseValidator.jsonListOfStringValue(response,"$..postId").get(0),
                "comments are not coming only for the respective posts");
        Assert.assertEquals(Integer.valueOf(id),responseValidator.jsonListOfStringValue(response,"$..id").get(0),
                "comments are not coming only for the respective posts");
    }

    @Then("Comments api response should have name as {string}")
    public void theCommentsApiResponseShouldHaveNameAs(String name) {
        Assert.assertEquals(name, responseValidator.jsonListOfStringValue(response,"$..name").get(0),
                "name is not matched with the API response");
    }

    @Then("Comments api response should have email as {string}")
    public void commentsApiResponseShouldHaveEmailAs(String email) {
        Assert.assertEquals(email, responseValidator.jsonListOfStringValue(response,"$..email").get(0),
                "email is not matched with the API response");

    }

    @Then("Comments api response should have body as {string}")
    public void commentsApiResponseShouldHaveBodyAs(String body) {
        Assert.assertEquals(body, responseValidator.jsonListOfStringValue(response,"$..body").get(0),
                "body is not matched with the API response");
    }

    @When("I post a comment on postId {int} and body {string}")
    public void iPostACommentOnPostIdAnd(int postId, String body) {
        Comment newComment = new Comment(postId, body);
        response = requestExecutor.executePostRequest(request,commentOnPosts,newComment.toStringJson());
    }

    @Then("The response should include postId {int} and body {string}")
    public void theResponseShouldIncludePostIdPostIdAndBody(int postId, String body) {
        Assert.assertEquals(String.valueOf(postId),responseValidator.jsonStringValue(response,"$.postId"),
                "postId is not matched for the created comment");

        Assert.assertEquals(body,responseValidator.jsonStringValue(response,"$.body"),
                "body is not matched for the created comment");
    }

    @When("Trying to delete the existing comment with postId {string} and id {string}")
    public void tryingToDeleteTheExistingCommentWithPostIdAndId(String postId, String id) {
        response = requestExecutor.executeDeleteRequestWithParams(request,getCommentsOnPostsUsingPostIdAndId,new String[]{postId, id});
    }

    @Then("Comments api response {string} schema should match with specification format")
    public void commentsApiResponseSchemaShouldMatchWithSpecificationFormat(String format) {
        Assert.assertTrue(responseValidator.schemaValidator(response,format,
                        Constants.SCHEMA_FILE_PATH+"CommentsDetailAPIResponseSchema.json"),
                "Schema validation is getting failed !");
    }
}
