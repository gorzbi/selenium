import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class WyszukiwanieGoogle {

    @Test

    public void wyszukiwanieGoogle() {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions opcje = new FirefoxOptions();
        opcje.setHeadless(false);
        opcje.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

        WebDriver firefox = new FirefoxDriver(opcje);
        firefox.manage().window().maximize();

        firefox.get("https://www.google.com/");

        firefox.switchTo().activeElement();
        firefox.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/span/div/div/div[3]/button[2]/div")).click();

        firefox.switchTo().defaultContent();

        // odszukanie przeglądarki
        WebElement poleszukania = firefox.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));

        // wpisanie wartości
        poleszukania.sendKeys("Selenium");

        // wciśnięcie ENTER
        poleszukania.sendKeys(Keys.ENTER);

    }
}