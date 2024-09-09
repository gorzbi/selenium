import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NajechanieMyszka {

    @Test

    public void najechanie() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // najechanie myszką na konkretny element
        Actions akcja = new Actions(firefox);
        akcja.moveToElement(firefox.findElement(By.tagName("h1"))).perform();
        
    }
}
