import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AsercjaSoft {

    @Test

    public void asercjaSoft() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        // nawet jeśli asercja zakończy się failem, to test nie zostanie przerwany i na końcu wyświetli wynik, co się udało, a co nie

        SoftAssert softAsercja = new SoftAssert();

        WebElement tytul = firefox.findElement(By.tagName("h1"));

        softAsercja.assertTrue(tytul.isDisplayed(),"Element nie jest wyświetlony"); // sprawdza czy prawdą jest, że jest wyświetlona treść ze zmiennej tytul2, jak nie to wyświetli komunikat
        softAsercja.assertTrue(tytul.getText().startsWith("Start"),"Nie zaczyna się od start"); // czy prawdą jest że pobrany tekst ze zmiennej tytul2 zaczyna się od ...
        softAsercja.assertTrue(tytul.getText().endsWith("testowej"),"tak się nie kończy"); // czy kończy się na ....
        softAsercja.assertFalse(tytul.getText().startsWith("Witaj"),"Błąd, jest to prawda"); // czy nie prawdą jest, że zaczyna się na ....

        softAsercja.assertAll(); // musi wykonać na koniec wszystkie asercje
    }
}
