package Pages.Sanepid;

import Pages.Shared.AlertyFlash;
import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EksportDanychSanepidZleceniaPage {


    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private AlertyFlash af;

    public EksportDanychSanepidZleceniaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.af = new AlertyFlash(driver);
    }



    // ---- zamów eksport

    @FindBy (id = "export_ordering_a_test_voivodeship")
    private WebElement zamowWojewodztwo;

    @FindBy (id = "export_ordering_a_test_district")
    private WebElement zamowPowiat;

    @FindBy (id = "export_ordering_a_test_exportFileParam")
    private WebElement exportFiltrujPoDatach;
    @FindBy (xpath = "//span[@class='vs__selected' and contains(text(),'zlecenia')]")
    private WebElement exportFiltrujPoDatach_Zlecenia;

    @FindBy (id = "export_ordering_a_test_dateFrom")
    private WebElement exportDataOd;
    @FindBy (id = "export_ordering_a_test_dateTo")
    private WebElement exportDataDo;


    // ---- alerty

    @FindBy (xpath = "//div[@id='export_ordering_a_test_dateTo_error']/p")
    private WebElement dataWalidErrorMessage;


    // ---- eksport

    public void checkEksportZleceniaEnabled() {
        Assert.assertTrue(exportFiltrujPoDatach_Zlecenia.isDisplayed());
    }

    public void checkEksportDataFieldsEnabled() {
        Assert.assertTrue(exportDataOd.isEnabled());
        Assert.assertTrue(exportDataDo.isEnabled());
    }

    public void checkEksportWojewodztwoEnabled() {
        Assert.assertTrue(zamowWojewodztwo.isEnabled());
    }

    public void checkEksportPowiatEnabled() {
        Assert.assertTrue(zamowPowiat.isEnabled());
    }

    public void checkDatesOver7Days(String wojew, String data) {
        but.clickWyczyscKryteriaWyszukiwania();

        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);

        exportDataOd.click();
        shr.clearPole(exportDataOd);
        exportDataOd.sendKeys(data);

        but.clickGenerateRaport();

        String error = dataWalidErrorMessage.getText();
        System.out.println(error);
        Assert.assertEquals(error, "Dla raportów dla całej Polski raport może dotyczyć nie więcej niż 7 dni.");
    }

    public void checkDatesOver31Days(String data) {
        but.clickWyczyscKryteriaWyszukiwania();

        exportDataOd.click();
        shr.clearPole(exportDataOd);
        exportDataOd.sendKeys(data);

        but.clickGenerateRaport();

        String error = dataWalidErrorMessage.getText();
        Assert.assertEquals(error,"Dla raportów dla województwa raport może dotyczyć nie więcej niż 31 dni.");
    }

    public void checkDatesOver6moths(String wojew, String powiat, String data) {
        but.clickWyczyscKryteriaWyszukiwania();

        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);

        zamowPowiat.click();
        shr.stringListChoice(powiat);

        exportDataOd.click();
        shr.clearPole(exportDataOd);
        exportDataOd.sendKeys(data);

        but.clickGenerateRaport();

        String error = dataWalidErrorMessage.getText();
        Assert.assertEquals(error,"Maksymalny okres raportu może wynosić pół roku");
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
}
