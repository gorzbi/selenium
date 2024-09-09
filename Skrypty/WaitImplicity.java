import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitImplicity {

    @Test

    public void czekajImplicity() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        // sprawdza każdy wyszukiwany element na całej stronie przez 10s, w ciągu tego czasu
        // co chwilę odpytuje stronę czy element już jest, błąd wyrzuci dopiero po upływie tego czasu
        // deklaruje się go raz na daną podstronę
        firefox.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); -> tego używać

        firefox.findElement(By.id("clickOnMe")).click();
        firefox.findElement(By.cssSelector("p"));

    }
}
