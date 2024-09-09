import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PodwojneKlikniecie {

    @Test

    public void dwaRazy() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        /*
        // kliknięcie 2x LPM na konkretny element
        Actions akcja = new Actions(firefox);
        akcja.doubleClick(firefox.findElement(By.id("bottom"))).perform();
        */

        // kliknięcie 2x LPM na konkretny element inna wersja
        WebElement przycisk = firefox.findElement(By.id("bottom"));
        Actions akcja = new Actions(firefox);
        akcja.doubleClick(przycisk).perform();

    }
}
