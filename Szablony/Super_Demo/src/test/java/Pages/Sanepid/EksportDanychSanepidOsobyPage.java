package Pages.Sanepid;

import Pages.Shared.AlertyFlash;
import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class EksportDanychSanepidOsobyPage {

    private WebDriver driver;

    private Methods shr;
    private Buttons but;
    private AlertyFlash af;

    public EksportDanychSanepidOsobyPage(WebDriver driver) {
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

    @FindBy (id ="export_ordering_a_test_hasQuarantine")
    private WebElement zamowOsobyzKwarantanna;

    @FindBy (id = "export_ordering_a_test_quarantineDateFrom")
    private WebElement exportDataOd;
    @FindBy (id = "export_ordering_a_test_quarantineDateTo")
    private WebElement exportDataDo;

    @FindBy (id = "export_ordering_a_test_referenceSourceId")
    private WebElement zamowPodtypKwarantanny;

    @FindBy (xpath = "//input[@value='Prześlij']")
    private WebElement przeslijRaport;


    // ---- alerty

    @FindBy (xpath = "//div[@id='export_ordering_a_test_district_error']/p")
    private WebElement powiatWalidErrorMessage;




    // ---- eksport

    public void checkEksportWojewodztwoEnabled() {
        Assert.assertTrue(zamowWojewodztwo.isEnabled());
    }

    public void checkEksportPowiatEnabled() {
        Assert.assertTrue(zamowPowiat.isEnabled());
    }

    public void checkEksportOsobyzKwarantannaEnabled() {
        Assert.assertTrue(zamowOsobyzKwarantanna.isEnabled());
    }

    public void checkEksportDataFieldsEnabled() {
        Assert.assertTrue(exportDataOd.isEnabled());
        Assert.assertTrue(exportDataDo.isEnabled());
    }

    public void checkEksportPodtypKwEnabled() {
        Assert.assertTrue(zamowPodtypKwarantanny.isEnabled());
    }

    public void checkEksportOsobyKwNIE() {
        but.clickWyczyscKryteriaWyszukiwania();

        zamowOsobyzKwarantanna.click();
        shr.stringListChoice("Nie");

        Assert.assertFalse(exportDataOd.isDisplayed());
        Assert.assertFalse(exportDataDo.isDisplayed());
    }

    public void checkEksportOsobyNiePowiatWalidationGenerateRaport(String wojew, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();

        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);

        zamowOsobyzKwarantanna.click();
        shr.stringListChoice("Nie");

        przeslijRaport.click();

        String error = powiatWalidErrorMessage.getText();
        Assert.assertEquals(error,"Powiat jest wymagane.");

        zamowPowiat.click();
        shr.stringListChoice(powiat);
        przeslijRaport.click();

        af.alertSukcesRaport();
    }

    public void checkEksportDatyOver31daysWalidationGenerateRaport(String wojew, String dataOver31days, String dataToday) {
        but.clickWyczyscKryteriaWyszukiwania();

        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);

        zamowOsobyzKwarantanna.click();
        shr.stringListChoice("Tak");
        exportDataOd.click();
        shr.clearPole(exportDataOd);
        exportDataOd.sendKeys(dataOver31days);

        przeslijRaport.click();

        String error = powiatWalidErrorMessage.getText();
        Assert.assertEquals(error,"Powiat jest wymagane.");

        exportDataOd.click();
        shr.clearPole(exportDataOd);
        exportDataOd.sendKeys(dataToday);

        przeslijRaport.click();
        af.alertSukcesRaport();
    }

    public void generateRaportWojewodztwo(String wojew) {
        but.clickWyczyscKryteriaWyszukiwania();
        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);
        przeslijRaport.click();

        af.alertSukcesRaport();
    }

    public void generateRaportPowiat(String wojew, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();
        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);
        zamowPowiat.click();
        shr.stringListChoice(powiat);
        przeslijRaport.click();

        af.alertSukcesRaport();
    }
}
