import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class CssSelectory {

    @Test

    public void testowanieSelektora() {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions opcje = new FirefoxOptions();
        opcje.setHeadless(true);

        WebDriver firefox = new FirefoxDriver(opcje);

        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // odszukanie elementu przez id
        firefox.findElement(By.cssSelector("#clickOnMe")); // przed nazwą wpisuje się #

        // odszukanie przez klasę
        firefox.findElement(By.cssSelector(".topSecret")); // przez nazwą wpisuje się .

        // odszukanie przez tagName
        firefox.findElement(By.cssSelector("input")); // zwróci pierwszy input ze strony

        // odszukanie po atrybucie, np. name/id/a/klasa itp. i jego nazwie np. fname
        firefox.findElement(By.cssSelector("[name='fname']"));
        firefox.findElement(By.cssSelector("[type='checkbox']"));

        // adresowanie szukania
        firefox.findElement(By.cssSelector("div ul")); // wszystkie ul w div (także te głębiej zagnieżdżone)
        firefox.findElement(By.cssSelector("div > ul")); // bezpośredni ul w div (bez zagnieżdżonych)
        firefox.findElement(By.cssSelector("label + form")); // pierwszy form na stronie, który następuje po label (nie w label)
        firefox.findElement(By.cssSelector("label ~ form")); // wszystkie form po label

        firefox.findElement(By.cssSelector("[name='fname']")); // element z atrybutem name o nazwie fname
        firefox.findElement(By.cssSelector("input[name='fname']")); // input z atrybutem name o nazwie fname
        firefox.findElement(By.cssSelector("input[name*='nam']")); // input z atrybutem name o nazwie z ciągiem znaków nam
        firefox.findElement(By.cssSelector("input[name^='fn']")); // input z atrybutem name, którego nazwa zaczyna się od fn
        firefox.findElement(By.cssSelector("input[name$='me']")); // input z atrybutem name, którego nazwa kończy się na me

        firefox.findElement(By.cssSelector("a[href*='google']")); // link, który w adresie ma "google" (nie w nazwie tylko centralnie w linku)

        // adresowanie szukania - dzieci
        firefox.findElement(By.cssSelector("li:first-child")); // odnajduje pierwszy element li, który jest czyimś dzieckiem
        firefox.findElement(By.cssSelector("li:last-child")); // ostatni element li jakiegoś rodzica
        firefox.findElement(By.cssSelector("li:nth-child(1)")); // który element li (numerowanie od 1)

    }
}
