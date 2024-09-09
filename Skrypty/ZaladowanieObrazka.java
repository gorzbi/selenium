import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZaladowanieObrazka {

    @Test

    public void zaladowanieObrazka() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement obrazek1 = firefox.findElement(By.id("smileImage"));
        System.out.println("W pełni załadowany obrazek ma wysokość "+obrazek1.getAttribute("naturalHeight")); // pobiera oryginalną wysokość obrazka

        firefox.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement obrazek2 = firefox.findElement(By.id("smileImage"));
        String wysokosc = obrazek2.getAttribute("naturalHeight");
        System.out.println(wysokosc);

        Assert.assertEquals(wysokosc,"0"); // porównanie czy "wysokosc" ma oczekiwaną wartość = 0

    }
}
