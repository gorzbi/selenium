import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class iframe {
    @Test

    public void iframe() {

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        // przełączenie się do iframe

        /*firefox.switchTo().frame(0); // bo jest to pierwszy iframe na tej stronie
        firefox.findElement(By.id("fname")).sendKeys("Zbig");

        // powrót do pierwszego okna

        firefox.switchTo().defaultContent();*/

        // drugi sposób przez atrybut
        WebElement iframe = firefox.findElement(By.cssSelector("[src='basics.html']"));
        firefox.switchTo().frame(iframe); // wywołanie zlokalizowanego elementu iframe
        firefox.findElement(By.id("fname")).sendKeys("Zbig");
    }
}
