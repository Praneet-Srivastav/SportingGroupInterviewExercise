package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Scenario scenario;
    private Map<String, Object> context;
    private WebDriver driver;

    public ScenarioContext() {
        this.context = new HashMap<>();
    }

    public void setContext(String key, Object value) {
        context.put(key, value);
    }
    public Object getContext(String key) {
        return context.get(key);
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
}
