package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver getDriver(DriverType type) { // type to parametr z enum DriverType

        if (type==DriverType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (type==DriverType.CHROME) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }

        // alternatywne rozwiązanie
    public static WebDriver getDriver(DriverType type) {

        String error = "Browser does not exist";
        
        switch (type) {
            case DriverType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case DriverType.CHROME:
                 WebDriverManager.chromedriver().setup();
                 return new ChromeDriver();
            default:
                System.out.println("Browser does not exist");
        }
        // co tu dokładnie zwrócić jeszcze nie wiem
        return new EdgeDriver();
    }
}
