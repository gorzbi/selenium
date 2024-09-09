package Pages.PM;

import Pages.Shared.AlertyFlash;
import Pages.Shared.Buttons;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EksportDanychPmPage {


    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private AlertyFlash af;

    public EksportDanychPmPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.af = new AlertyFlash(driver);
    }


    //---- zamów eksport

    @FindBy (id = "export_ordering_a_test_exportFileParam")
    private WebElement exportFiltrujPoDatach;
    @FindBy (xpath = "//span[@class='vs__selected' and contains(text(),'zlecenia')]")
    private WebElement exportFiltrujPoDatach_Zlecenia;

    @FindBy (id = "export_ordering_a_test_dateFrom")
    private WebElement exportDataOd;
    @FindBy (id = "export_ordering_a_test_dateTo")
    private WebElement exportDataDo;

    @FindBy (id = "export_ordering_a_test_voivodeship")
    private WebElement zamowWojewodztwo;

    @FindBy (id = "export_ordering_a_test_district")
    private WebElement zamowPowiat;

    @FindBy (xpath = "//textarea[@name='export_ordering_a_test[district]' and @placeholder='—']")
    private WebElement zamowPowiatBlockedEmpty;


    // ---- eksport

    public void checkEksportZleceniaEnabled() {
        Assert.assertTrue(exportFiltrujPoDatach_Zlecenia.isDisplayed());
    }

    public void checkEksportWojewodztwoEnabled() {
        Assert.assertTrue(zamowWojewodztwo.isEnabled());
    }

    public void checkEksportPowiatBlockedEmpty() {
        Assert.assertFalse(zamowPowiat.isEnabled());
        Assert.assertTrue(zamowPowiatBlockedEmpty.isDisplayed());
    }

    public void checkEksportPowiatUnlocked(String wojew) {
        zamowWojewodztwo.click();
        shr.stringListChoice(wojew);

        Assert.assertTrue(zamowPowiat.isEnabled());
    }

    public void checkEksportDataFieldsEnabled() {
        Assert.assertTrue(exportDataOd.isEnabled());
        Assert.assertTrue(exportDataDo.isEnabled());
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
