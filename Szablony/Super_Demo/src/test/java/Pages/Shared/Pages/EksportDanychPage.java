package Pages.Shared.Pages;

import Pages.Shared.AlertyFlash;
import Pages.Shared.Buttons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class EksportDanychPage {

    private WebDriver driver;
    private Buttons but;
    private AlertyFlash af;

    public EksportDanychPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.but = new Buttons(driver);
        this.af = new AlertyFlash(driver);
    }


    @FindBy(xpath = "//input[@name='type_export[typeExport]']/following-sibling::div/div/div/span")
    private WebElement typEksportu;

    public void checkTypEksportu(String eksport) {
        String typ = typEksportu.getAttribute("textContent").trim(); // trim() usuwa spacje
        Assert.assertEquals(typ,eksport);
    }

    public void generateRaport() {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickGenerateRaport();
        af.alertSukcesRaport();
    }

}
