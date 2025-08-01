package Konfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(DriverType type) {

        if (type == DriverType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (type == DriverType.CHROME) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }

    public static WebDriver alternativeGetDriver(DriverType type) {

        switch (type) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            case EDGE:
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException("Nie ma takiej przeglądarki: " + type);
        }
    }

}
