package hooks;

import config.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ScenarioContext;


public class Hooks {

    ScenarioContext scenarioContext;
    WebDriver driver;
    public Hooks(ScenarioContext context) {
        scenarioContext = context;
    }

    @Before
    public void initializeWebDriver() {

        // Set the system property to point to the location of chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        scenarioContext.setDriver(driver);
        driver.get(Configuration.getBaseUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            driver.quit();
        }
    }

}