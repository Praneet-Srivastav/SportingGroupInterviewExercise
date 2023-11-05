package UI.steps;

import UI.pages.ChallengingDOMPage;
import UI.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ScenarioContext;

public class ChallengingDomSteps {
    private WebDriver wd;
    private HomePage homepage;
    private final ChallengingDOMPage challengingDOMPage;
    private ScenarioContext sc;

    public ChallengingDomSteps(ScenarioContext scenarioContext) {
         this.wd = scenarioContext.getDriver();
        this.sc = scenarioContext;
        homepage = new HomePage(wd);
        challengingDOMPage = new ChallengingDOMPage(wd);
    }

    @Given("I am on the Challenging DOM page")
    public void iAmOnChallengingDOMPage() {
        homepage.clickChallengingDOMLink();
    }

    @When("I click the red button")
    public void iClickTheRedButton() {
        //Collect the initial Ids to compare later on
        String initialRedButtonId = challengingDOMPage.getRedButtonId();
        String initialGreenButtonId = challengingDOMPage.getGreenButtonId();
        String initialBlueButtonId = challengingDOMPage.getBlueButtonId();

        //store the ids to scenarios context to use in next step
        sc.setContext("initialRedButtonId", initialRedButtonId);
        sc.setContext("initialGreenButtonId", initialGreenButtonId);
        sc.setContext("initialBlueButtonId", initialBlueButtonId);
        //click the red button
        challengingDOMPage.clickRedButton();
    }


    @Then("the red blue and green button IDs should change")
    public void the_red_blue_and_green_button_i_ds_should_change() {
        {
            // Retrieve the updated button IDs
            String updatedRedButtonId = challengingDOMPage.getRedButtonId();
            String updatedGreenButtonId = challengingDOMPage.getGreenButtonId();
            String updatedBlueButtonId = challengingDOMPage.getBlueButtonId();

            // Retrieve the initial button IDs from the scenario context
            String initialRedButtonId = (String) sc.getContext("initialRedButtonId");
            String initialGreenButtonId = (String) sc.getContext("initialGreenButtonId");
            String initialBlueButtonId = (String) sc.getContext("initialBlueButtonId");

            // Assert that the button IDs have changed
            Assert.assertNotEquals(initialRedButtonId, updatedRedButtonId, "Red button ID should change");
            Assert.assertNotEquals(initialGreenButtonId, updatedGreenButtonId, "Green button ID should change");
            Assert.assertNotEquals(initialBlueButtonId, updatedBlueButtonId, "Blue button ID should change");

        }
    }
}
