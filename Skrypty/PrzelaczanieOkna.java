import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PrzelaczanieOkna {
    
    // przełączenie do nowo otwartej zakładki w przeglądarce
    
    public void changeBrowserTab(WebDriver driver) {
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
    }


    @Test

    public void akcje() {

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        String obecneOkno = firefox.getWindowHandle(); // pobiera nazwę obecnego okna
        firefox.findElement(By.id("newPage")).click(); // tu się otworzy nowe okno

        // przełączanie się do nowego okna
        Set<String> wszystkieOkna = firefox.getWindowHandles();
        for (String window: wszystkieOkna) {
            if(!window.equals(obecneOkno)) {
                firefox.switchTo().window(window);
            }
        }

        firefox.manage().window().maximize();
        firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // trzeba odczekać aż załaduje się element
        firefox.findElement(By.id("L2AGLb")).click();

        firefox.findElement(By.name("q")).sendKeys("Zbinio");
    }
}
