import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.security.Key;
import java.util.List;

public class ActionsBasic {

    @Test

    public void akcje() {

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opcje = new FirefoxOptions();
        opcje.setHeadless(false);

        WebDriver firefox = new FirefoxDriver(opcje);

        firefox.get("https://testeroprogramowania.github.io/selenium");

        // klikanie w elementy strony

        /*WebElement strona = firefox.findElement(By.linkText("Podstawowa strona testowa"));
        strona.click();*/
        firefox.findElement(By.linkText("Podstawowa strona testowa")).click();

        //firefox.findElement(By.id("clickOnMe")).click();


        // wpisywanie wartości w pole
        firefox.findElement(By.id("fname")).sendKeys("Zbigniew");

        // usunięcie wartości z pola
        firefox.findElement(By.name("username")).clear();
        firefox.findElement(By.name("username")).sendKeys("Zbinio");

        /*WebElement wpisywanie = firefox.findElement(By.name("username"));
        wpisywanie.clear();
        wpisywanie.sendKeys("Zbinio");*/

        // wciśnięcie ENTER
        firefox.findElement(By.name("username")).sendKeys(Keys.ENTER);

        // obsługa alertów -> https://www.w3schools.com/js/js_popup.asp
        Alert firstAlert = firefox.switchTo().alert();
        firstAlert.accept();

        firefox.switchTo().alert().accept(); // akceptacja drugiego alertu

        // zaznaczenie checkbox
        firefox.findElement(By.cssSelector("input[type='checkbox']")).click();

        // zaznaczenie radiobutton
        firefox.findElement(By.cssSelector("input[value='male']")).click();

        // wybieranie z listy rozwijalnej
        WebElement listaAut = firefox.findElement(By.cssSelector("select")); // wybieramy najpierw listę
        Select auta = new Select(listaAut); // przypisujemy metodę select
        auta.selectByValue("saab"); // wybranie z listy
        //auta.selectByIndex(0);
        //auta.selectByVisibleText("Volvo");

        // wyciągnięcie danych z listy i wypisanie
        List<WebElement> eksportListy = auta.getOptions();
        for (WebElement pozycjaListy : eksportListy) {
            System.out.println(pozycjaListy.getText());
        }
        
        List<WebElement> grupa0 = firefox.findElements(By.name("s0"));
        for (WebElement element0 : grupa0) {
            System.out.println(element0.getAttribute("value"));
        }
        
        // wyciągnięcie danych z listy i działanie na jakimś elemencie
        firefox.findElements(By.xpath("//td[@class='day ' and text()='30']"))
               .stream()
               .filter(el -> el.isDisplayed()) // displayed to czy jest wyświetlony, enabled czy ogólnie jest dostęny
               .findFirst() // wybierz pierwszy
               .ifPresent(el -> el.click()); // jak jest wyświetlony to kliknij

        // pobranie tekstu z pola do wpisywania tekstu
        WebElement txtPola = firefox.findElement(By.cssSelector("input[name='username']"));
        System.out.println(txtPola.getAttribute("value"));

        // pobranie tekstu elementu widocznego/niewidocznego na stronie
        WebElement txtelementu1 = firefox.findElement(By.xpath("/html/body/label[1]"));
        System.out.println(txtelementu1.getAttribute("textContent"));

        WebElement txtelementu2 = firefox.findElement(By.xpath("/html/body/label[2]"));
        System.out.println(txtelementu2.getAttribute("textContent"));
        
        // pobranie fragmentu tekstu elementu widocznego/niewidocznego na stronie
        WebElement seed = firefox.findElement(By.xpath("/html/body/div[1]/div[1]/pre/code"));
        String seedtext = seed.getAttribute("textContent");
        String actualseed = seedtext.substring(14, seedtext.length()); // kopiuje od 14 znaku do końca
        String partseed = seedtext.substring(4, 8); // kopiuje od 4 do 8 znaku

        // metoda na wyczyszczenie pola
        public void clearPole(WebElement pole) {
        String s = Keys.chord(Keys.CONTROL,"a"); // zaznacz wszystko
        pole.sendKeys(s);
        pole.sendKeys(Keys.BACK_SPACE); // usuń backspace
    }
        
    }
}
