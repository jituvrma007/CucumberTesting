package com.cucumberTesting.tests.stepdef;

import com.cucumberTesting.tests.model.User;
import com.cucumberTesting.testware.base.ApiBaseSetup;
import com.cucumberTesting.testware.utility.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LisOfUsersStep extends ApiBaseSetup{

    private String listOfUsersAPI ="";
    private String detailOfExistingUserFromUserIdAPI = "";

    @Given("^I have a service to request list of users$")
    public void iHaveAServiceToRequestListOfUsers() {
        request = requestExecutor.returnRequestSpecification(common.
                returnConcatenatedBaseURI("protocol","baseUrl", "serviceUrl"));
        listOfUsersAPI = apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "ListOfUsers");
        detailOfExistingUserFromUserIdAPI = apiDetailReader.returnCompleteUri
                ("jsonPlaceholderTypicodeCom","jsonPlaceholderTypicodeCom", "detailOfExistingUserFromUserId");

        log.info("listOfUsersAPI :: "+listOfUsersAPI +"detailOfExistingUserFromUserIdAPI :: "+detailOfExistingUserFromUserIdAPI);

    }

    @When("^I request list of users$")
    public void iRequestListOfUsers() {
        response = requestExecutor.executeGetRequest(request,listOfUsersAPI);
    }

    @When("I input a userId {string}")
    public void iInputAUserId(String userId) {
        response =  requestExecutor.executeGetRequestWithParams(request,detailOfExistingUserFromUserIdAPI,new String[]{userId});
    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
       Assert.assertEquals(statusCode,response.getStatusCode(), "statusCode does not matched");
    }

    @Then("I should have the response code {int}")
    public void iShouldHaveTheResponseCodeResponseCode(int statusCode ) {
            Assert.assertEquals(statusCode,response.getStatusCode(), "statusCode does not matched");
    }

    @Then("The response should have username as {string}")
    public void theResponseShouldHaveUsernameAsUsername(String username) {
        Assert.assertEquals(username, responseValidator.jsonStringValue(response,"$.username"),
                "username is not matched with the API response");
    }

    @Then("The response should have name as {string}")
    public void theResponseShouldHaveNameAsName(String name) {
        Assert.assertEquals(name, responseValidator.jsonStringValue(response,"$.name"),
                "name is not matched with the API response");

    }

    @Then("The response has email as {string}")
    public void theResponseHasEmailAsEmail(String email) {
        Assert.assertEquals(email, responseValidator.jsonStringValue(response,"$.email"),
                "email is not matched with the API response");
    }

    @Then("The response of {string} schema should match with specification format")
    public void  theResponseOfSchemaShouldMatchWithSpecificationFormat(String format) {
        Assert.assertTrue(responseValidator.schemaValidator(response,format,
                Constants.SCHEMA_FILE_PATH+"UserDetailAPIResponseSchema.json"),"Schema validation is getting failed !");
    }

    @When("creating new user with the provided name {string}, username {string}, phone {string}, email {string}, website {string}")
    public void creatingNewUserWithTheProvidedNameUsernamePhoneEmailWebsite(String name, String username, String phone, String email, String website) {
        User newUser = new User(name,username, email, phone, website);
        response = requestExecutor.executePostRequest(request,listOfUsersAPI,newUser.toStringJson());
    }

    @Then("The response should have provided name {string}, username {string}, phone {string}, email {string}, website {string}")
    public void theResponseShouldHaveProvidedNameUsernamePhoneEmailWebsite(String name, String username, String phone, String email, String website) {

        Assert.assertEquals(name,responseValidator.jsonStringValue(response,"$.name"),
                "name are not containing the userId");
        Assert.assertEquals(username,responseValidator.jsonStringValue(response,"$.username"),
                "username are not containing the title");
        Assert.assertEquals(phone,responseValidator.jsonStringValue(response,"$.phone"),
                "phone are not containing the body");
        Assert.assertEquals(email,responseValidator.jsonStringValue(response,"$.email"),
                "email are not containing the body");
        Assert.assertEquals(website,responseValidator.jsonStringValue(response,"$.website"),
                "website are not containing the body");
    }
}
