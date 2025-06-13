package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ScenarioContext;

import static org.junit.Assert.assertEquals;

public class MyStepdefs{
    private final ScenarioContext context;

    public MyStepdefs(ScenarioContext context) {
        this.context = context;
    }

    @When("I add {int} and {int}")
    public void iAddTwoNumbers(int a, int b) {
        int result = a + b;
        context.set("sum", result);
    }

    @Then("The result should be {int}")
    public void theResultShouldBe(int expected) {
        int actual = context.get("sum", int.class);
        assertEquals(expected, actual);
    }
}
