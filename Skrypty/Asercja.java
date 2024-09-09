import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Asercja {

    @Test

    public void asercja() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        String tytul = firefox.findElement(By.tagName("h1")).getText(); // do zmiennej tytuł pobieram treść szukanego elementu
        System.out.println(tytul);

        Assert.assertEquals(tytul,"Witaj na stronie testowej","Nazwa nie OK"); // porównanie co jest w zmiennej tytul i co oczekujemy, treść gdy nie są równe

        // alternatywny zapis 1

        WebElement tytul2 = firefox.findElement(By.tagName("h1"));
        System.out.println("Alternatywny zapis 1: "+tytul2.getText());

        Assert.assertTrue(tytul2.isDisplayed(),"Element nie jest wyświetlony"); // sprawdza czy prawdą jest, że jest wyświetlona treść ze zmiennej tytul2, jak nie to wyświetli komunikat

        Assert.assertTrue(tytul2.getText().startsWith("Witaj"),"nie"); // czy prawdą jest że pobrany tekst ze zmiennej tytul2 zaczyna się od ...
        Assert.assertTrue(tytul2.getText().endsWith("testowej"),"tak się nie kończy"); // czy kończy się na ....

        Assert.assertFalse(tytul2.getText().startsWith("Witaj"),"Błąd, jest to prawda"); // czy nie prawdą jest, że zaczyna się na ....

    }
}
