package Pages.Shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertyFlash {

    private WebDriver driver;

    public AlertyFlash(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // ---- alerty

    @FindBy(xpath = "//p[@class='title' and contains(text(),'Pomyślnie zlecono eksport danych')]")
    private WebElement alertSukcesZleceniaRaportu;

    @FindBy (xpath = "//p[@class='title' and contains(text(),'Zlecenie eksportu danych się nie powiodło')]")
    private WebElement alertFailZleceniaRaportu;

    public void alertSukcesRaport() {
        alertSukcesZleceniaRaportu.isDisplayed();
    }

    public void alertFailRaport() {
        alertFailZleceniaRaportu.isDisplayed();
    }
}
