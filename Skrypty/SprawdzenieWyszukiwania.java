import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SprawdzenieWyszukiwania {

    @Test

    public void sprawdzenieWyszukiwania() {

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

        WebElement poleszukania = firefox.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        poleszukania.sendKeys("Selenium");
        poleszukania.sendKeys(Keys.ENTER);

        // sprawdzenie czy wyszukało to co chcieliśmy - najpierw wskazujemy o który element nam chodzi
        WebElement rezultat = firefox.findElement(By.xpath("/html/body/div[7]/div/div[10]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/a/div/cite"));
        // sprawdzamy czy ten element jest widoczny
        Assert.assertTrue(rezultat.isDisplayed());

    }
}