import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Listeners(value = {TestListener.class})

public class Zadanie01 {

    // test kończy się niepowodzeniem, bo musi złapać błąd i zrobić screen
    // dlatego korzysta z listenerów, który dla fail ma robienie screena
    // musi korzystać z istniejącego okna przeglądarki dlatego DriverFactory

    @Test

    public void zadanieDrugie() {

        WebDriver firefox = DriverFactory.getDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        SoftAssert softAsercja = new SoftAssert();
        WebElement tytul = DriverFactory.firefox.findElement(By.tagName("h1"));

        // pobranie tekstu elementu widocznego na stronie - true

        softAsercja.assertTrue(tytul.getText().startsWith("Start"),"Nie zaczyna się od start");
        softAsercja.assertTrue(tytul.getText().endsWith("startowej"),"Tak się nie kończy");


        // pobranie tekstu elementu widocznego na stronie - false

        softAsercja.assertTrue(tytul.getText().startsWith("startowej"),"Nie zaczyna się od start");
        softAsercja.assertTrue(tytul.getText().endsWith("Start"),"Tak się nie kończy");

        softAsercja.assertAll();

    }
}
