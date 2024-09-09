import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitExplicit {

    @Test

    public void czekajExpicitWebDrier() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        firefox.findElement(By.id("clickOnMe")).click();

        // sprawdza wybrany element na stronie przez 10s, w ciągu tego czasu
        // co chwilę odpytuje stronę czy element już jest, błąd wyrzuci dopiero po upływie tego czasu
        // deklaruje się go do każdego elementu, na który się czeka
        WebDriverWait czekaj = new WebDriverWait(firefox, 10);
        czekaj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p"))); // podajemy warunek na co czekamy

    }
}
