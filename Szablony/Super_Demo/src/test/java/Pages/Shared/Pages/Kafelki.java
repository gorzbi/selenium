package Pages.Shared.Pages;

import Tools.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kafelki {

    private WebDriver driver;

    public Kafelki(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//a[@href='/app/?entity=Person&action=list&menuIndex=Person&submenuIndex=-1']")
    private WebElement kafelekOsoby;

    @FindBy (xpath = "//a[@href='/app/?entity=OrderingATest&action=list&menuIndex=OrderingATest&submenuIndex=-1']")
    private WebElement kafelekZleceniaTestu;

    @FindBy(xpath = "//a[@href='/app/?variant=uniformed_services&action=list&entity=Person&is_secondary=1']")
    private WebElement kafelekSluzbyMundurowe;

    @FindBy (xpath = "//a[@href='/app/search-for-person']")
    private WebElement kafelekSzybkaWyszukiwarka;

    @FindBy (xpath = "//a[@href='/app/search-for-person?variant=search_for_person&action=list&entity=Person&is_secondary=1']")
    private WebElement kafelekSzybkaWyszukiwarkaInfolinii;

    @FindBy (xpath = "//a[@href='/app/slownik']")
    private WebElement kafelekSlowniki;


    public void enterKafelekOsoby() {
        kafelekOsoby.click();
    }

    public void enterKafelekSluzbyMundurowe() {
        kafelekSluzbyMundurowe.click();
    }

    public void enterSzybkaWyszukiwarka() {
        kafelekSzybkaWyszukiwarka.click();
    }

    public void enterSzybkaWyszukiwarkaInfolinii() {
        kafelekSzybkaWyszukiwarkaInfolinii.click();
    }

    public void enterKafelekZleceniaTestu() {
        Wait.waitForElementToBeVisible(driver, kafelekZleceniaTestu);
        kafelekZleceniaTestu.click();
    }
}
