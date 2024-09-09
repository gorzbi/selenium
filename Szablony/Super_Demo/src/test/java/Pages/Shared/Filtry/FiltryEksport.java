package Pages.Shared.Filtry;

import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FiltryEksport {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;

    public FiltryEksport(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
    }


    @FindBy(id= "filters_orderDate_comparison")
    private WebElement filtrDataZamowSelect;

    @FindBy(id= "filters_orderDate_value")
    private WebElement filtrDataZamow;

    @FindBy(id = "filters_orderedBy")
    private WebElement filtrZamawiajacyRaport;

    @FindBy(id = "filters_voivodeship")
    private WebElement filtrWojewodztwo;

    @FindBy(xpath = "//input[@name='filters[voivodeship]']/following-sibling::div/div/div/span")
    private WebElement filtrWojewodztwoBlockedValue;

    @FindBy(id = "filters_district")
    private WebElement filtrPowiat;
    @FindBy(xpath = "//input[@name='filters[district]']/following-sibling::div/div/div/span")
    private WebElement filtrPowiatBlockedValue;
    @FindBy(xpath =  "//textarea[@name='filters[district]' and @placeholder='—']")
    private WebElement filtrPowiatBlockedEmpty;

    @FindBy(id= "filters_status")
    private WebElement filtrStatusRaportu;


    // ---- filtry

    public void setFiltrDataZamowSelect(String value){
        filtrDataZamowSelect.click();
        shr.stringListChoice(value);
    }

    public void setFiltrDataZamow(String data) {
        filtrDataZamow.click();
        shr.clearPole(filtrDataZamow);
        filtrDataZamow.sendKeys(data);
    }

    public void setFiltrZamawiajacyRaport(String value) {
        filtrZamawiajacyRaport.click();
        filtrZamawiajacyRaport.sendKeys(value);
    }

    public void checkFiltrWojewodztwoEnabled(){
        Assert.assertTrue(filtrWojewodztwo.isEnabled());
    }

    public void setFiltrWojewodztwo(String wojew) {
        filtrWojewodztwo.click();
        shr.stringListChoice(wojew);
    }

    public String getFiltrWojewodztwoBlockedValue() {
        Assert.assertFalse(filtrWojewodztwo.isEnabled());
        String wojew = filtrWojewodztwoBlockedValue.getAttribute("textContent").trim();
        System.out.println("Zablokowany filtr województwo to "+wojew);
        return wojew;
    }

    public void checkFiltrPowiatEnabled() {
        Assert.assertTrue(filtrPowiat.isEnabled());
    }

    public void setFiltrPowiat(String powiat) {
        filtrPowiat.click();
        shr.stringListChoice(powiat);
    }

    public void checkFiltrPowiatBlockedEmpty() {
        Assert.assertFalse(filtrPowiat.isEnabled());
        Assert.assertTrue(filtrPowiatBlockedEmpty.isDisplayed());
    }

    public String getFiltrPowiatBlockedValue() {
        Assert.assertFalse(filtrPowiat.isEnabled());
        String powiat = filtrPowiatBlockedValue.getAttribute("textContent").trim();
        System.out.println("Zablokowany filtr powiat to "+powiat);
        return powiat;
    }

    public void checkFiltrPowiatUnblocked(String wojew) {
        filtrWojewodztwo.click();
        shr.stringListChoice(wojew);
        Assert.assertTrue(filtrPowiat.isEnabled());
    }

    public void checkFiltrStatusRaportuEnabled() {
        filtrStatusRaportu.isEnabled();
    }

    public void setFiltrStatus(String status) {
        filtrStatusRaportu.click();
        shr.stringListChoice(status);
    }


    // ---- filtrowanie listy raportów

    public void getRaportByDataZamow(String value, String data) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrDataZamowSelect(value);
        setFiltrDataZamow(data);
        but.clickSzukaj();
    }

    public void getRaportListByZamawiajacy(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrZamawiajacyRaport(value);
        but.clickSzukaj();
    }

    public void getMyKontekstLastReport() {
        but.clickWyczyscKryteriaWyszukiwania();
        String nazwa = shr.kontekstName();
        setFiltrZamawiajacyRaport(nazwa);
        but.clickSzukaj();
        but.clickFirstArrow();
        but.clickPobierzRaport();
    }

    public void getRaportListByWojewodztwo(String wojew) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrWojewodztwo(wojew);
        but.clickSzukaj();
    }

    public void getRaportListByPowiat(String wojew, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrWojewodztwo(wojew);
        setFiltrPowiat(powiat);
        but.clickSzukaj();
    }

    public void getRaportListByStatus(String status) {
        but.clickWyczyscKryteriaWyszukiwania();
        setFiltrStatus(status);
        but.clickSzukaj();
    }

}
