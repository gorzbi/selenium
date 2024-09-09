import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class SprawdzenieCheckboxa {

    @Test

    public void checkboxZaznaczony() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement checkbox = firefox.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println("Zaznaczenie checkboxa to: " + checkbox.isSelected());


        // alternatywne przedstawienie

        boolean check = checkbox.isSelected();

        if (check == true) {
            System.out.println("Checkbox jest zaznaczony");
        }
        else {
            System.out.println("Checkbox nie jest zaznaczony");
        }

    }
}
