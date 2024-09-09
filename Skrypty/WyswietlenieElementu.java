import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WyswietlenieElementu {

    @Test

    public void wyswietlenieElementu() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        boolean wyswietlenie = firefox.findElement(By.id("clickOnMe")).isDisplayed();
        System.out.println(wyswietlenie);

        System.out.println("drugi sposób: "+ firefox.findElement(By.id("clickOnMe")).isDisplayed());
    }
}
