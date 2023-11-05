package UI.pages;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicLoadingPage {

    private  WebDriver driver;
    private final By example2Link = By.linkText("Example 2: Element rendered after the fact");
    private By startButton =  By.cssSelector("div[id='start'] button");
    private By loadingIndicator = By.id("loading");
    private By helloWorldText = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {

        this.driver = driver;
    }

    public  void  clickExample2Link(){

        driver.findElement(example2Link).click();
    }
    public void clickStartButton() {
        //button[normalize-space()='Start']
        driver.findElement(startButton).click();
    }

    public void waitForLoadingToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
    }

    public String getHelloWorldText() {
        return driver.findElement(helloWorldText).getText();
    }



}

