package Pages.Shared.Filtry;

import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import Tools.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FiltrySzukajZlecenie {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;

    public FiltrySzukajZlecenie(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
    }


    // ---- filtry

    @FindBy(id = "filters_id")
    private WebElement filtrIdZlecenia;

    @FindBy (id = "filters_status")
    private WebElement filtrStatus;

    @FindBy (id = "filters_person_name")
    private WebElement filtrImie;

    @FindBy (id = "filters_person_surname")
    private WebElement filtrNazwisko;

    @FindBy (id = "filters_person_pesel")
    private WebElement filtrPesel;

    @FindBy (id = "filters_person_documentNumber")
    private WebElement filtrNrDok;

    @FindBy (id = "filters_orderingSource")
    private WebElement filtrZrodloTestu;

    @FindBy (id = "filters_immobilePatient")
    private WebElement filtrKaretka;

    @FindBy (id = "filters_status_group")
    private WebElement filtrGrupaStatus;

    @FindBy (id = "filters_type")
    private WebElement filtrTypTestu;

    @FindBy (id = "filters_sourceOfFunding")
    private WebElement filtrZrFinansowania;

    @FindBy (id = "filters_orderedOn_comparison")
    private WebElement filtrDataZleceniaSelect;

    @FindBy (id = "filters_orderedOn_value")
    private WebElement filtrDataZleceniaValue;


    // ---- zaawansowane filtry

    @FindBy (id = "filters_mobilePoint_comparison")
    private WebElement filtrPunktPobran;
    @FindBy (id = "filters_mobilePoint_value")
    private WebElement filtrWybierzPunktPobran;


    public void setFiltrIdZlecenia(String value) {
        filtrIdZlecenia.sendKeys(value);
    }
    public void szukajOnlyByIdZlecenia(String id) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrIdZlecenia(id);
        but.clickSzukaj();
    }


    public void setFiltrStatus(String value) {
        filtrStatus.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByStatus(String status) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrStatus(status);
        but.clickSzukaj();
    }


    public void setFiltrImie(String value) {
        filtrImie.sendKeys(value);
    }
    public void szukajOnlyByImie(String imie) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrImie(imie);
        but.clickSzukaj();
    }


    public void setFiltrNazwisko(String value) {
        filtrNazwisko.sendKeys(value);
    }
    public void szukajOnlyByNazwisko(String nazwisko) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrNazwisko(nazwisko);
        but.clickSzukaj();
    }


    public void setFiltrPesel(String value) {
        filtrPesel.sendKeys(value);
    }
    public void szukajOnlyByPesel(String pesel) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrPesel(pesel);
        but.clickSzukaj();
    }

    public void setFiltrNrDok(String value) {
        filtrNrDok.sendKeys(value);
    }
    public void szukajOnlyByNrDok(String nrDok) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrNrDok(nrDok);
        but.clickSzukaj();
    }

    public void setFiltrZrodloTestu(String value) {
        filtrZrodloTestu.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByZrodloTestu(String zrodloTestu) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrZrodloTestu(zrodloTestu);
        but.clickSzukaj();
    }

    public void setFiltrKaretka(String value) {
        filtrKaretka.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyBaKaretka(String karetka) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrKaretka(karetka);
        but.clickSzukaj();
    }

    public void setFiltrGrupaStatus(String value) {
        filtrGrupaStatus.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByGrupyStatus(String grupaStatus) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrGrupaStatus(grupaStatus);
        but.clickSzukaj();
    }

    public void setFiltrTypTestu(String value) {
        filtrTypTestu.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlyByTypTestu(String typTestu) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrTypTestu(typTestu);
        but.clickSzukaj();
    }

    public void setFiltrZrodloFinans(String value) {
        filtrZrFinansowania.click();
        shr.stringListChoice(value);
    }
    public void szukajOnlybyZrodloFinans(String zrodloFinansowania) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrZrodloFinans(zrodloFinansowania);
        but.clickSzukaj();
    }

    public void setFiltrDataZleceniaSelect(String value) {
        filtrDataZleceniaSelect.click();
        shr.stringListChoice(value);
    }
    public void setFiltrDataZleceniaValue(String value) {
        shr.clearPole(filtrDataZleceniaValue);
        filtrDataZleceniaValue.sendKeys(value);
    }
    public void szukajOnlyByDataZlecenia(String select, String data) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrDataZleceniaSelect(select);
        setFiltrDataZleceniaValue(data);
        but.clickSzukaj();
    }

    public void szukajOnlyByDataZleceniaDzisiaj() {
        but.clickWyczyscKryteriaWyszukiwania();
        Wait.waitForElementToBeVisible(driver,filtrDataZleceniaSelect);
        setFiltrDataZleceniaSelect("od/do");
        but.clickSzukaj();
    }


    public void setFiltrMyPm(String pm) {
        but.clickWyszukiwanieZaawansowane();
        filtrPunktPobran.click();
        shr.stringListChoice("takie samo jak");
        filtrWybierzPunktPobran.click();
        shr.stringListChoice(pm);
    }

    public void szukajOnlyByMyPm(String pm) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrMyPm(pm);
        but.clickSzukaj();
    }

    public void szukajByMyPmToday(String pm) {
        but.clickWyczyscKryteriaWyszukiwania();
        Wait.waitForElementToBeVisible(driver, filtrDataZleceniaSelect);
        setFiltrDataZleceniaSelect("od/do");
        setFiltrMyPm(pm);
        but.clickSzukaj();
    }

}
