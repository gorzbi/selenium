import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class PolitykaCookie {

    @Test

    public void akceptacjcaCookie() {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions opcje = new FirefoxOptions();
        opcje.setHeadless(false);
        opcje.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        WebDriver firefox = new FirefoxDriver(opcje);
        firefox.manage().window().maximize();

        firefox.get("https://www.google.com/");

        // przepięcie się do okienka z polityką cookie
        firefox.switchTo().activeElement();
        // zlokalizowanie przycisku akceptacji i kliknięcie
        firefox.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div[3]/button[2]/div")).click();

        // przepięcie do pierwotnego okna
        firefox.switchTo().defaultContent();

        firefox.quit();

    }
}