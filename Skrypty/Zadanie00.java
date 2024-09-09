import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Zadanie00 {

    @Test

    public void zadaniePierwsze() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // pobranie tekstu elementu widocznego na stronie
        WebElement txth1 = firefox.findElement(By.tagName("h1"));
        System.out.println(txth1.getAttribute("textContent"));

        // najechanie myszką na konkretny element
        Actions akcja = new Actions(firefox);
        akcja.moveToElement(firefox.findElement(By.tagName("h1"))).perform();

        // kliknięcie w przycisk click me!
        firefox.findElement(By.id("clickOnMe")).click();

        // zatwierdzenie alertu
        Alert firstAlert = firefox.switchTo().alert();
        firstAlert.accept();

        // wpisanie imienia w pole
        firefox.findElement(By.id("fname")).sendKeys("Zbig");

        // pobranie info z tabelki z kolumny savings
        WebElement txttable = firefox.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]"));
        System.out.println(txttable.getAttribute("textContent"));

        // wyciągnięcie danych z listy i wypisanie
        WebElement listaAut = firefox.findElement(By.cssSelector("select"));
        Select auta = new Select(listaAut);
        auta.selectByValue("saab");

        List<WebElement> eksportListy = auta.getOptions();
        for (WebElement pozycjaListy : eksportListy) {
            System.out.println(pozycjaListy.getText());
        }

        // zaznaczenie checkbox
        firefox.findElement(By.cssSelector("input[type='checkbox']")).click();

        // zaznaczenie radiobutton
        firefox.findElement(By.cssSelector("input[value='male']")).click();

        // usunięcie wartości z pola
        firefox.findElement(By.name("username")).clear();
        firefox.findElement(By.name("username")).sendKeys("Zbinio");

        // kliknięcie w przycisk submit
        firefox.findElement(By.cssSelector("input[value='Submit']")).click();

        // zatwierdzenie alertu
        Alert secondAlert = firefox.switchTo().alert();
        secondAlert.accept();
        Alert thirdAlert = firefox.switchTo().alert();
        thirdAlert.accept();

        // przełączenie się do nowego okna
        String obecneOkno = firefox.getWindowHandle();
        firefox.findElement(By.id("newPage")).click();

        Set<String> wszystkieOkna = firefox.getWindowHandles();
        for (String window: wszystkieOkna) {
            if(!window.equals(obecneOkno)) {
                firefox.switchTo().window(window);
            }
        }

        firefox.manage().window().maximize();
        firefox.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        firefox.findElement(By.id("L2AGLb")).click();

        firefox.findElement(By.name("q")).sendKeys("Zbinio");

        // pobranie info o stronie
        System.out.println(firefox.getTitle());
        System.out.println(firefox.getCurrentUrl());

    }
}
