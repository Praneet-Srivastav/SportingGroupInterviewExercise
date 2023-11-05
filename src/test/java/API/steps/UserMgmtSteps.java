package API.steps;

import config.Configuration;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.List;
import java.util.Map;


public class UserMgmtSteps {

    private RequestSpecification request;
    private Response response;
   private String userId; // To store the user ID created in Test 3

    @Given("I have access to the User Creation API")
    public void iHaveAccessToUserCreationAPI() {
        // Set up the request specification with the base URL from the Configuration class
        request = RestAssured.given().baseUri(Configuration.getApiBaseUrl());
    }

    @When("I send a POST request to create a new user")
    public void iSendPOSTRequestToCreateUser(DataTable userData) {

        List<Map<String, String>> userRows = userData.asMaps();
        for (Map<String, String> user : userRows) {
            String id = user.get("id");
            String name = user.get("name");
            String salary = user.get("Salary");
            String age = user.get("age");

            // Create a JSON request body from the DataTable
            String requestBody = String.format(
                    "{\"id\": \"%s\", \"name\": \"%s\", \"Salary\": \"%s\", \"age\": \"%s\"}",
                    id, name, salary, age);

        response = request.header("Content-Type", "application/json")
                .body(requestBody)
                .post("/create");
        userId = response.jsonPath().getString("data.id");
    }
    }

    @Then("I should receive a response indicating that a user was created")
    public void iShouldReceiveUserCreatedResponse() {
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertNotNull(userId);
    }

    @Given("I have access to the User Deletion API")
    public void iHaveAccessToUserDeletionAPI() {
        request = RestAssured.given().baseUri(Configuration.getApiBaseUrl());
    }

    @When("I send a DELETE request to delete the {}")
    public void iSendDELETERequestToDeleteUser(String userId) {

       // slowing down the delete call to the Endpoint as we are getting too many request error (429)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //sending request to delete specified user Id
        response = request.delete("/delete/" + userId);
    }

    @Then("I should receive a response indicating that the user was deleted")
    public void iShouldReceiveUserDeletedResponse() {

        Assert.assertEquals(response.getStatusCode(),200 );
        Assert.assertEquals( response.jsonPath().getString("status"),"success");
    }
}