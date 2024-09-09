package Pages.SzybkaWyszukiwarka;

import Konfiguration.Logger4j;
import Pages.Shared.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SzybkaWyszukiwarkaForm extends Logger4j {

    private WebDriver driver;
    private Methods shr;

    private static final Logger logger = LogManager.getLogger();

    public SzybkaWyszukiwarkaForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
    }

    @FindBy (id = "search_for_person_phone")
    private WebElement telefonInput;

    @FindBy (id = "search_for_person_surname")
    private WebElement nazwiskoInput;

    @FindBy (id = "search_for_person_pesel")
    private WebElement peselInput;

    @FindBy (id = "search_for_person_documentNumber")
    private WebElement nrDokInput;

    @FindBy (id = "search_for_person_identifierType")
    private WebElement typIdentyfikatora;

    @FindBy (id = "search_for_person_identifierNumber")
    private WebElement nrIdentyfikatoraInput;


    @FindBy (id = "search_for_person_id")
    private WebElement idOsobyInput;
    @FindBy (id = "search_for_person_orderingATestId")
    private WebElement idZleceniaInput;


    @FindBy (id = "action-save")
    private WebElement szukajButton;

    @FindBy (xpath = "//p[@class='alert alert-info' and contains(text(),'Nazwisko, Nr telefonu')]")
    private WebElement alertNazwiskoNrtel;

    @FindBy (xpath = "//p[@class='alert alert-info' and contains(text(),'Numer dokumentu, PESEL')]")
    private WebElement alertNrDokPESEL;

    @FindBy (xpath = "//div[@id='search_for_person_identifierNumber_error']/p")
    private WebElement alertNrIdentyfikatora;


    public void search() {
        szukajButton.click();
    }

    public void alertOne() {

        Assert.assertEquals(alertNazwiskoNrtel.getText(),"Jedno z pól [ Nazwisko, Nr telefonu ] jest wymagane");
    }

    public void alertTwo() {
        Assert.assertEquals(alertNrDokPESEL.getText(),"Jedno z pól [ Numer dokumentu, PESEL ] jest wymagane");
    }

    public void alertThree() {
        Assert.assertEquals(alertNrIdentyfikatora.getAttribute("textContent"),"Numer identyfikatora jest wymagane.");
    }

    public void innyTypDokAlertValidation(String typ) {
        log().info("test1");
        typIdentyfikatora.click();
        shr.stringListChoice(typ);
        szukajButton.click();
        alertThree();
    }


    public void searchPerson(String nazwisko, String pesel) {
        log().info("test2");
        nazwiskoInput.sendKeys(nazwisko);
        peselInput.sendKeys(pesel);
        szukajButton.click();
    }

    public void searchInnyPerson (String typ, String nrIdentyfikatora) {
        log().info("test3");
        typIdentyfikatora.click();
        shr.stringListChoice(typ);
        nrIdentyfikatoraInput.sendKeys(nrIdentyfikatora);
        szukajButton.click();
    }

    public void searchPersonId (String id) {
        idOsobyInput.sendKeys(id);
        szukajButton.click();
    }

    public void searchZlecenieId (String id) {
        idZleceniaInput.sendKeys(id);
        szukajButton.click();
    }

}
