package UI.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChallengingDOMPage {
    private WebDriver driver;
    private By redButton = By.cssSelector(".button.alert");
    private By greenButton = By.cssSelector(".button.success");
    private By blueButton = By.cssSelector(".button");

    public ChallengingDOMPage(WebDriver driver) {

        this.driver = driver;
    }


    public void clickRedButton() {
        driver.findElement(redButton).click();
    }

    public String getRedButtonId() {
        return driver.findElement(redButton).getAttribute("id");
    }

    public String getGreenButtonId() {
        return driver.findElement(greenButton).getAttribute("id");
    }

    public String getBlueButtonId() {
        return driver.findElement(blueButton).getAttribute("id");
    }
}
