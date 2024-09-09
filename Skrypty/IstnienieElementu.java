import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class IstnienieElementu {

    WebDriver firefox; // dla kilku metod należy zmienną wyciągnąć na wierzch klasy

    @Test

    public void istnienieElementu() {

        WebDriverManager.firefoxdriver().setup();
        firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        firefox.findElement(By.id("fname"));
        System.out.println(istnienie(By.id("dupa"))); // wykorzystuje metodę i sprawdza czy istnieje element
    }

    public boolean istnienie(By locator) { // dotyczy wszystkich elementów określonych przez lokator np. by id

        try {
            firefox.findElement(locator);
            return true;
                    } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
