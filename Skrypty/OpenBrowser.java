import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class OpenBrowser {

    @Test

    public void otwarciePrzegladarki() {

        System.setProperty("webdriver.chrome.driver","C:/Users/zbigniew.gornowicz/Desktop/Selenium jars and drivers/drivers/chrome/chromedriver.exe");
        WebDriver chrome = new ChromeDriver();
        chrome.get("https://www.google.com/");

        System.setProperty("webdriver.gecko.driver","C:/Users/zbigniew.gornowicz/Desktop/Selenium jars and drivers/drivers/firefox/geckodriver.exe");
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://www.google.com/");

    }
}