package Pages.Shared;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Methods {

    private WebDriver driver;

    public Methods(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String kontekstName () {
        WebElement kontextName = driver.findElement(By.xpath("//p[@class='user-context-name']"));
        return kontextName.getText();
    }


    public void changeBrowserTab() {
        // przełącza do ostatnio otwartej zakładki
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
    }

    public void zmianaKontekstu(String nazwaKontekstu) {
        WebElement kontekstMenu = driver.findElement(By.xpath("//div[@class='user-dropdown']/div[1]"));
        kontekstMenu.click();
        WebElement listaKontekstow = driver.findElement(By.id("contextList"));
        listaKontekstow.click();
        stringListChoice(nazwaKontekstu);
        akceptZgoda();
    }

    public void akceptZgoda() {
        WebElement akcept = driver.findElement(By.xpath("//button[@class='btn btn-primary modal-submit' and text()='Oświadczam']"));
        Wait.waitForElementToBeVisible(driver, akcept);
        akcept.click();
    }

    public void clearPole(WebElement pole) {
        String s = Keys.chord(Keys.CONTROL,"a"); // zaznacz wszystko
        pole.sendKeys(s);
        pole.sendKeys(Keys.BACK_SPACE); // usuń backspace
    }


    // ---- wybór z listy przez index i string

    public void stringListChoice(String value){
        // normalize-space usuwa spacje na początku i końcu
        Wait.waitForLocatorToExist(driver,By.xpath("//*[@class='vs__dropdown-menu']/li[normalize-space(text())='"+value+"']"));
        driver.findElement(By.xpath("//*[@class='vs__dropdown-menu']/li[normalize-space(text())='"+value+"']")).click();
    }

    public void intListChoice(int value){

        Wait.waitForLocatorToExist(driver,By.xpath("//*[@class='vs__dropdown-menu']/li["+value+"]"));
        driver.findElement(By.xpath("//*[@class='vs__dropdown-menu']/li["+value+"]")).click();
    }


    public String iloscRekordow() {
        driver.findElement(By.xpath("//p[@class='grid-result-counter no-margin']/button")).click();
        Wait.waitForLocatorToExist(driver,By.id("gridCounter"));
        String iloscRekordow = driver.findElement(By.id("gridCounter")).getText();
        System.out.println("Rekordów jest: "+iloscRekordow);
        return iloscRekordow;
    }

}
