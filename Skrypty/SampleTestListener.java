import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(value = {TestListener.class}) // deklarujemy listę sluchaczy z klasy sluchaczy

public class SampleTestListener {

    @Test

    public void asercjaSoft() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        SoftAssert softAsercja = new SoftAssert();

        WebElement tytul = firefox.findElement(By.tagName("h1"));

        softAsercja.assertTrue(tytul.isDisplayed(),"Element nie jest wyświetlony");
        softAsercja.assertTrue(tytul.getText().startsWith("Witaj"),"Nie zaczyna się od start");
        softAsercja.assertTrue(tytul.getText().endsWith("testowej"),"tak się nie kończy");
        softAsercja.assertFalse(tytul.getText().startsWith("what"),"Błąd, jest to prawda");

        softAsercja.assertAll();
    }

}
