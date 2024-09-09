package tests;

import model.Word;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomeGooglePage;
import pages.Konfiguracja;
import java.io.IOException;


public class PierwszyTest extends Konfiguracja {


    @Test (priority = 1, testName = "kurdeJuve", groups= {"kat1","kat2"})
    public void metodaJuve() {

        extent.info("to jest test Juve");

        // odwołanie się do klasy z modelu

        Word szukam = new Word();
        szukam.setSzukanyWyraz("Juventus");
    }


    @Test (priority = 2, testName = "kurdeBarca", groups = {"kat2"})
    public void metodaBarca() throws IOException {

        extent.info("to jest test Barca");

        // odwołanie się do klasy z modelu
        Word szukam = new Word();
        szukam.setSzukanyWyraz("Barcelona");

        HomeGooglePage hgp = new HomeGooglePage(driver);
        hgp.szukamySlowa(szukam);

        WebElement element = driver.findElement(By.id("elo"));
        element.click();
    }

    @Test (priority = 3, testName = "kurdeReal", groups = "kat3")
    public void metodaReal() {

        extent.info("to jest test Real");

        // odwołanie się do klasy z modelu

        Word szukam = new Word();
        szukam.setSzukanyWyraz("Real");
    }

}
