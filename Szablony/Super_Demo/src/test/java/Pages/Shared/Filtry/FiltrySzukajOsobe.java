package Pages.Shared.Filtry;

import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FiltrySzukajOsobe {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;

    public FiltrySzukajOsobe(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
    }


    // ---- filtry podstawowe

    @FindBy (id ="filters_id")
    private WebElement filtrID;

    @FindBy (id = "filters_name")
    private WebElement filtrImie;

    @FindBy (id = "filters_surname")
    private WebElement filtrNazwisko;

    @FindBy (id = "filters_pesel")
    private WebElement filtrPesel;

    @FindBy (id = "filters_documentNumber")
    private WebElement filtrNrDok;

    @FindBy (id = "filters_phone")
    private WebElement filtrNrTel;

    @FindBy(id = "filters_quarantine_isActive")
    private WebElement filtrKwarantanna;


    // ---- wyszukiwanie zaawansowane

    @FindBy(id = "filters_address_voivodeship")
    private WebElement filtrWojewodztwo;

    @FindBy(id = "filters_address_district")
    private WebElement filtrPowiat;


    // ---- filtry po dodaniu

    @FindBy (id = "filters_quarantine_type")
    private WebElement filtrTypKwarantanny;

    @FindBy (id = "filters_quarantine_referenceSourceId")
    private WebElement filtrPodtypKwarantanny;



    public void setFiltrID(String value) {
        filtrID.sendKeys(value);
    }
    public void szukajOnlyByIdOsoby(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrID(value);
        but.clickSzukaj();
    }


    public void setFiltrImie(String value) {
        filtrImie.sendKeys(value);
    }
    public void szukajOnlyByImie(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrImie(value);
        but.clickSzukaj();
    }


    public void setFiltrNazwisko(String value) {
        filtrNazwisko.sendKeys(value);
    }
    public void szukajOnlyByNazwisko(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrNazwisko(value);
        but.clickSzukaj();
    }


    public void setFiltrPesel(String value) {
        filtrPesel.sendKeys(value);
    }
    public void szukajOnlyByPesel(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrPesel(value);
        but.clickSzukaj();
    }


    public void setFiltrNrDok(String value) {
        filtrNrDok.sendKeys(value);
    }
    public void szukajOnlyByNrDok(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrNrDok(value);
        but.clickSzukaj();
    }


    public void setFiltrKwarantanna(String value) {
        filtrKwarantanna.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByKwarantanna(String kw) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrKwarantanna(kw);
        but.clickSzukaj();
    }


    public void setFiltrWojewodztwo(String value) {
        filtrWojewodztwo.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByWojewodztwo(String wojew) {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickWyszukiwanieZaawansowane();
        setFiltrWojewodztwo(wojew);
        but.clickSzukaj();
    }



    public void setFiltrPowiat(String value) {
        filtrPowiat.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByPowiat(String wojew, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickWyszukiwanieZaawansowane();
        setFiltrWojewodztwo(wojew);
        setFiltrPowiat(powiat);
        but.clickSzukaj();
    }

}
