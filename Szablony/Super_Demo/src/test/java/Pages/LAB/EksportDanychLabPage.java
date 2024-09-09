package Pages.LAB;

import Pages.Shared.Methods;
import Pages.Shared.Pages.EksportDanychPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EksportDanychLabPage {

    private WebDriver driver;
    private Methods shr;
    private EksportDanychPage ed;

    public EksportDanychLabPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.ed = new EksportDanychPage(driver);
    }


    // ---- zamów eksport

    @FindBy (id = "export_ordering_a_test_exportFileParam")
    private WebElement exportFiltrujPoDatach;
    @FindBy (xpath = "//span[@class='vs__selected' and contains(text(),'zlecenia')]")
    private WebElement exportFiltrujPoDatach_Zlecenia;

    @FindBy (id = "export_ordering_a_test_dateFrom")
    private WebElement exportDataOd;

    @FindBy (id = "export_ordering_a_test_dateTo")
    private WebElement exportDataDo;


    // ---- eksport

    public void checkEksportZleceniaEnabled() {
        Assert.assertTrue(exportFiltrujPoDatach_Zlecenia.isEnabled());
    }

    public void checkEksportDataFieldsEnabled() {
        Assert.assertTrue(exportDataOd.isEnabled());
        Assert.assertTrue(exportDataDo.isEnabled());
    }
}
