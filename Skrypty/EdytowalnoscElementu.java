import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class EdytowalnoscElementu {

    @Test

    public void edytowalnoscElementu() {

        // sprawdza, czy można wejść w interakcję z elementem, np. czy można kliknąć, coś wpisać

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        boolean edytowalnosc = firefox.findElement(By.id("smileImage")).isEnabled();
        System.out.println(edytowalnosc);

        System.out.println("drugi sposób: "+ firefox.findElement(By.id("fname")).isEnabled());
    }
}
