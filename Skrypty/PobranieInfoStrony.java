import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class PobranieInfoStrony {

    @Test

    public void pobranie() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        System.out.println(firefox.getTitle()); // pobranie tytułu
        System.out.println(firefox.getCurrentUrl()); // pobranie url

        System.out.println(firefox.findElement(By.tagName("h1")).getText()); // pobranie treści dowolnie znalezionego elementu


        // lub

        WebElement txth1 = firefox.findElement(By.tagName("h1")); // do zmiennej txth1 przypisuję znacznik h1
        String tytul = txth1.getAttribute("textContent"); // do zmiennej tytuł pobieram treść zmiennej txth1
        System.out.println(tytul);

    }
}
