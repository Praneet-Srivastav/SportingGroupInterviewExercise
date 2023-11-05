package UI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver driver;
    private final By dynamicLoadingLink = By.linkText("Dynamic Loading");
    private final By challengingDOMLink = By.linkText("Challenging DOM");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickDynamicLoadingLink() {

        driver.findElement(dynamicLoadingLink).click();
    }

    public void clickChallengingDOMLink() {
        driver.findElement(challengingDOMLink).click();
    }
}
