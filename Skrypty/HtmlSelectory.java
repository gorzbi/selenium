import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.List;

public class HtmlSelectory {

    @Test

    public void testowanieSelektora() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize();

        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // odszukanie elementu przez id
        firefox.findElement(By.id("clickOnMe"));

        // odszukanie elementu przez name
        firefox.findElement(By.name("fname"));

        // odszukanie elementu przez class - nazwa klasy - odszuka chyba pierwszy element z tej klasy
        firefox.findElement(By.className("tableHeader"));

        // odszukanie elementu konkretnego rodzaju, np. input - znajdzie pierwszy input na stronie
        firefox.findElement(By.tagName("input"));
        
        firefox.findElement(By.tagName("h1"));

        // odszukanie elementu konkretnego rodzaju, np. input - wszystkie inputy
        List<WebElement> inputs = firefox.findElements(By.tagName("input")); // lista inputów
        // firefox.findElements(By.tagName("input"));
        System.out.println("Ilość inputów na stronie to: " + inputs.size()); // ilość elementów listy "inputs"
        // System.out.println(firefox.findElements(By.tagName("input")).size());

        // odszukanie elementu po pełnej nazwie linku - anchor text
        firefox.findElement(By.linkText("Visit W3Schools.com!"));

        // odszukanie elementu po fragmencie nazwy linku - anchor text
        firefox.findElement(By.partialLinkText("W3Schoo"));


    }
}
