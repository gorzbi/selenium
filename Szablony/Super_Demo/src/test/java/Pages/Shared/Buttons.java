package Pages.Shared;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Buttons {

    private WebDriver driver;

    public Buttons(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    // ---- filtry

    @FindBy(xpath = "//button[@class='btn btn-outline-primary advanced-search']")
    private WebElement buttonWyszukiwanieZaawansowane;

    @FindBy(xpath = "//a[contains(text(),'Wyczyść')]")
    private WebElement buttonWyczyscKryteriaWyszukiwania;

    @FindBy (xpath = "//a[contains(text(),'Ustaw widok')]")
    private WebElement buttonUstawWidokFiltrow;

    @FindBy (xpath = "//input[@value='Szukaj']")
    private WebElement buttonSzukaj;



    // ---- eksport danych

    @FindBy (xpath = "//input[@value='Prześlij']")
    private WebElement buttonPrzeslijRaport;

    @FindBy (xpath = "//a[@class='btn btn-primary action-show']")
    private WebElement buttonPobierzRaport;


    // ---- lista

    @FindBy (xpath = "(//button[@class='e-arrow-box show-details-trigger'])[1]")
    private WebElement buttonArrowFirst;

    // ---- filtry metody

    public void clickWyczyscKryteriaWyszukiwania() {
        buttonWyczyscKryteriaWyszukiwania.click();
    }

    public void enterWidokFiltrow() {
        buttonUstawWidokFiltrow.click();
    }

    public void clickSzukaj() {
        buttonSzukaj.click();
    }

    public void clickWyszukiwanieZaawansowane() {
        buttonWyszukiwanieZaawansowane.click();
    }

    public void clickFirstArrow() {
        Wait.waitForElementToBeVisible(driver,buttonArrowFirst);
        buttonArrowFirst.click();
    }

    public void clickGenerateRaport() {
        buttonPrzeslijRaport.click();
    }

    public void clickPobierzRaport() {
        Wait.waitForElementToBeVisible(driver, buttonPobierzRaport);
        buttonPobierzRaport.isEnabled();
        buttonPobierzRaport.click();
    }

    public void clickHistory() {
        WebElement hist = driver.findElement(By.xpath("(//a[contains(text(),'Historia')])[1]"));
        Wait.waitForElementToBeVisible(driver, hist);
        hist.click();
    }

    public void clickPodglad() {
        WebElement poka = driver.findElement(By.xpath("(//a[contains(text(),'Pokaż')])[1]"));
        Wait.waitForElementToBeVisible(driver, poka);
        poka.click();
    }

    public void clickEdit() {
        WebElement edit =  driver.findElement(By.xpath("(//a[contains(text(),'Edytuj')])[1]"));
        Wait.waitForElementToBeVisible(driver, edit);
        edit.click();
    }

}
