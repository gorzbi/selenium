package tests;

import model.Word;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.Konfiguracja;

public class PierwszyTest extends Konfiguracja {

    private WebDriver driver;

    @Test (priority = 1)
    public void testJuve() {

        // odwołanie się do klasy z modelu

        Word szukam = new Word();
        szukam.setSzukanyWyraz("Juventus");
    }

    @Test (priority = 2)
    public void testBarca() {

        // odwołanie się do klasy z modelu

        Word szukam = new Word();
        szukam.setSzukanyWyraz("Barcelona");

        WebElement element = driver.findElement(By.id("elo"));
        element.click();
    }
}
