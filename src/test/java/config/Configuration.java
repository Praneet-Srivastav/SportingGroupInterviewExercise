package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("ApplicationBaseUrl");
    }
    public static String getApiBaseUrl() {
        return properties.getProperty("ApiEndpointBaseURL");
    }

    public static String getWebDriverPath() {
        return properties.getProperty("WebdriverPath");
    }


    public static int getTimeoutSeconds() {
        return Integer.parseInt(properties.getProperty("timeout.seconds"));
    }

}
