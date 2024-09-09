package Pages;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Konteksty {
    private WebDriver driver;

    public Konteksty(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/58206']")
    private WebElement kontekstWyszukiwanieOsob;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/83200']")
    private WebElement kontekstKpPoland;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/83211']")
    private WebElement kontekstKpDolnoslaskie;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/83202']")
    private WebElement kontekstKpKalisz;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/72342']") // tst 70093 pre 72342
    private WebElement kontekstLabKoordynator;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/68464']")
    private WebElement kontekstPM;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/68400']") // pre 68400
    private WebElement kontekstPsseKoordynator;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/68498']")
    private WebElement kontekstWsseKoordynator;

    @FindBy (xpath = "//a[@href='/app/zmiana-kontekstu/58207']")
    private WebElement kontekstSU_Edytor;


    public void wyszukiwanieOsob() {
        Wait.waitforElementToBeClickable(driver,kontekstWyszukiwanieOsob);
        kontekstWyszukiwanieOsob.click();
    }

    public void kpPoland() {
        Wait.waitforElementToBeClickable(driver,kontekstKpPoland);
        kontekstKpPoland.click();
    }

    public void kpWojew() {
        Wait.waitforElementToBeClickable(driver, kontekstKpDolnoslaskie);
        kontekstKpDolnoslaskie.click();
    }

    public void kpPowiat() {
        Wait.waitforElementToBeClickable(driver, kontekstKpKalisz);
        kontekstKpKalisz.click();
    }

    public void labKoordynator() {
        Wait.waitforElementToBeClickable(driver, kontekstLabKoordynator);
        kontekstLabKoordynator.click();
    }

    public void PM() {
        Wait.waitforElementToBeClickable(driver, kontekstPM);
        kontekstPM.click();
    }

    public void psseKoordynator() {
        Wait.waitforElementToBeClickable(driver, kontekstPsseKoordynator);
        kontekstPsseKoordynator.click();
    }

    public void wsseKoordynator() {
        Wait.waitforElementToBeClickable(driver, kontekstWsseKoordynator);
        kontekstWsseKoordynator.click();
    }

    public void suEdytor() {
        Wait.waitforElementToBeClickable(driver, kontekstSU_Edytor);
        kontekstSU_Edytor.click();
    }

}
