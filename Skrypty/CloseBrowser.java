import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CloseBrowser {

    @Test

    public void zamknijPrzegladarke() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://www.google.com/");

        firefox.quit(); // zamyka wszystkie otwarte okna
        firefox.close(); // zamyka pierwsze okno (na pewno jedno)

    }
}