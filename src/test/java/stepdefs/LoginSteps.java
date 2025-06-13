package stepdefs;

import clients.LoginClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojo.LoginRequest;
import pojo.LoginResponse;
import utils.ApiResponse;
import utils.ScenarioContext;

import static org.junit.Assert.*;

public class LoginSteps {
    private final ScenarioContext context;
    private LoginClient loginClient;

    public LoginSteps(ScenarioContext context, LoginClient loginClient) {
        this.context = context;
        this.loginClient = loginClient;
    }

    @When("I login with {string} and {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        ApiResponse<LoginResponse> loginResponse = loginClient.login(loginRequest);
        context.set("loginResponse", loginResponse);
    }

    @Then("I should see status code as {int}")
    public void iShouldSeeStatusCodeAs(int expectedStatus) {
        ApiResponse<LoginResponse> loginResponse = context.get("loginResponse", ApiResponse.class);
        assertEquals("Status code mismatch", expectedStatus, loginResponse.getStatusCode());
    }


    @And("I should get valid response with Authorization and success message as {string}")
    public void iShouldGetValidResponseWithAuthorizationAndSuccessMessageAs(String message) {
        ApiResponse<LoginResponse> loginResponse = context.get("loginResponse", ApiResponse.class);
        assertEquals(loginResponse.getBody().getSuccess(), message);
        assertTrue(loginResponse.getBody().getAuthorization().length() > 10);
    }

    @And("I should get error response with message as {string}")
    public void iShouldGetErrorResponseMessageAs(String message) {
        ApiResponse<LoginResponse> loginResponse = context.get("loginResponse", ApiResponse.class);
        assertTrue(loginResponse.getRawBody().contains(message));
    }
}
