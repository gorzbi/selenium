import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class BrowserConfiguration {

    @Test

    public void konfiguracjaPrzegladarki() {

        WebDriverManager.firefoxdriver().setup();

        // ustawianie konfiguracji

        FirefoxOptions opcje = new FirefoxOptions();
        opcje.setHeadless(false); // dla true nie będzie widać jak przeglądarka się otwiera i co jest na niej wykonywane
        opcje.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); // co ma zrobić gdy pojawi się niespodziewany alert, np. zaakceptować

        WebDriver firefox = new FirefoxDriver(opcje);

        firefox.get("https://www.google.com/");

        firefox.quit();

    }
}