import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrawyPrzyciskMyszy {

    @Test

    public void ppm() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://www.fakenamegenerator.com/gen-random-pl-pl.php");

        /*
        // kliknięcie PPM na stronie - nieokreślone miejsce
        Actions akcja = new Actions(firefox);
        akcja.contextClick().perform(); // perform to wykonaj
        */

        // kliknięcie PPM na konkretny element
        Actions akcja = new Actions(firefox);
        akcja.contextClick(firefox.findElement(By.id("genbtn"))).perform();

    }
}
