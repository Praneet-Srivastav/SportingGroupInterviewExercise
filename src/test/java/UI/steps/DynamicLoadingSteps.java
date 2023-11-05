package UI.steps;

import hooks.Hooks;
import UI.pages.DynamicLoadingPage;
import UI.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ScenarioContext;


public class DynamicLoadingSteps {

    private DynamicLoadingPage dynamicLoadingPage;
    private WebDriver wd;
    private HomePage homepage;

    public DynamicLoadingSteps(ScenarioContext scenarioContext) {
        this.wd = scenarioContext.getDriver();
        homepage = new HomePage(wd);
        dynamicLoadingPage=new DynamicLoadingPage(wd);
    }

    @Given("I am on the Dynamic Loading page")
    public void iAmOnDynamicLoadingPage() {
     homepage.clickDynamicLoadingLink();
    }

    @When("I click Example 2 link")
    public void iClickExample2Link() {
        dynamicLoadingPage.clickExample2Link();
    }
    @Then("{string} should be rendered")
    public void ShouldBeRendered(String expectedText) {
        dynamicLoadingPage.clickStartButton();
        dynamicLoadingPage.waitForLoadingToDisappear();
        Assert.assertEquals(dynamicLoadingPage.getHelloWorldText(), expectedText, "Text does not match expected value");
    }


}
