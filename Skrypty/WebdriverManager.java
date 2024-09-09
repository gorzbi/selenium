import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {

    @Test

    public void webdriverManagerKonfiguracja() {


        // konfiguracja managera z https://github.com/bonigarcia/webdrivermanager dodano dependencie do pom

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://www.google.com/");

        WebDriverManager.chromedriver().setup();
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://www.google.com/");
    }
}
