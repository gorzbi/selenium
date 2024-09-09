package Pages.KP;

import Pages.Shared.AlertyFlash;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.Shared.Buttons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class EksportDanychKpPage {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private FiltryEksport fe;
    private ListOfEksportDanych led;
    private AlertyFlash af;

    public EksportDanychKpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.fe = new FiltryEksport(driver);
        this.led = new ListOfEksportDanych(driver);
        this.af = new AlertyFlash(driver);
    }

    // ---- zamów eksport

    @FindBy (id = "export_ordering_a_test_voivodeship")
    private WebElement zamowWojewodztwo;
    @FindBy (xpath = "//input[@name='export_ordering_a_test[voivodeship]']/following-sibling::div/div/div/span")
    private WebElement zamowWojewodztwoBlockedValue;
    @FindBy (id = "export_ordering_a_test_district")
    private WebElement zamowPowiat;
    @FindBy (xpath = "//textarea[@name='export_ordering_a_test[district]' and @placeholder='—']")
    private WebElement zamowPowiatBlockedEmpty;
    @FindBy (xpath = "//input[@name='export_ordering_a_test[district]']/following-sibling::div/div/div/span")
    private WebElement zamowPowiatBlockedValue;
    @FindBy (id = "export_ordering_a_test_referenceSourceId")
    private WebElement zamowPodtypKwarantanny;


    // ---- eksport

    public void checkEksportWojewodztwoEnabled() {
        Assert.assertTrue(zamowWojewodztwo.isEnabled());
    }

    public String checkEksportWojewodztwoBlockedValue() {
        Assert.assertFalse(zamowWojewodztwo.isEnabled());
        String wojew = zamowWojewodztwoBlockedValue.getAttribute("textContent").trim();
        System.out.println("Zablokowany eksport województwa to "+wojew);
        return wojew;
    }

    public void checkEksportPowiatBlockedEmpty() {
        Assert.assertFalse(zamowPowiat.isEnabled());
        Assert.assertTrue(zamowPowiatBlockedEmpty.isDisplayed());
    }

    public String checkEksportPowiatBlockedValue() {
        Assert.assertFalse(zamowPowiat.isEnabled());
        String powiat = zamowPowiatBlockedValue.getAttribute("textContent").trim();
        System.out.println("Zablokowany eksport powiat to "+powiat);
        return powiat;
    }

    public void checkEksportPowiatUnlocked(String value) {
        zamowWojewodztwo.click();
        shr.stringListChoice(value);

        Assert.assertTrue(zamowPowiat.isEnabled());
    }

    public void checkEksportPowiatEnabled() {
        Assert.assertTrue(zamowPowiat.isEnabled());
    }

    public void checkEksportPodtypKwEnabled() {
        but.clickWyczyscKryteriaWyszukiwania();
        Assert.assertTrue(zamowPodtypKwarantanny.isEnabled());
    }


    // ---- generowanie raportów

    public void generateRaportSelectKwarantanna(String kwarantanna) {
        but.clickWyczyscKryteriaWyszukiwania();
        zamowPodtypKwarantanny.click();
        shr.stringListChoice(kwarantanna);
        but.clickGenerateRaport();
        af.alertSukcesRaport();
    }

    public void generateRaportWojewodztwo(String wojew) {
        but.clickWyczyscKryteriaWyszukiwania();
        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);
        but.clickGenerateRaport();
        af.alertSukcesRaport();
    }

    public void generateRaportPowiat(String wojew, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();
        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);
        zamowPowiat.click();
        shr.stringListChoice(powiat);
        but.clickGenerateRaport();
        af.alertSukcesRaport();
    }

    // ---- sprawdzenie listy raportów

    public void checkListWojewRaport(String wojew) {
        fe.getRaportListByWojewodztwo(wojew);
        led.checkListWojewRaport(wojew);
    }

    public void checkListPowiatRaport(String wojew, String powiat) {
        fe.getRaportListByPowiat(wojew, powiat);
        led.checkListPowiatRaport(powiat);
    }

    public void checkListStatusReport(String status) {
        fe.getRaportListByStatus(status);
        led.checkListStatusReport(status);
    }
}
