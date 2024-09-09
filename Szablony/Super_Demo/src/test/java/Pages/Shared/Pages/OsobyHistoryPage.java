package Pages.Shared.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OsobyHistoryPage {

    private WebDriver driver;

    public OsobyHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id ="extended-btn-person_basic_information")
    private WebElement arrowDanePodstawowe;

    @FindBy(id ="extended-btn-person_identifiers")
    private WebElement arrowIdentyfikatory;

    @FindBy(id ="extended-btn-person_contact")
    private WebElement arrowKontakt;

    @FindBy(id ="extended-btn-new_person_address")
    private WebElement arrowAdres;

    @FindBy(id ="extended-btn-person_death_details")
    private WebElement arrowZgon;

    @FindBy(id ="extended-btn-person_quarantine")
    private WebElement arrowKwarantanna;

    @FindBy(id ="extended-btn-localization_card")
    private WebElement arrowKartaLokal;

    public void showAllSekcje() {
        arrowDanePodstawowe.click();
        arrowIdentyfikatory.click();
        arrowKontakt.click();
        arrowAdres.click();
        arrowZgon.click();
        arrowKwarantanna.click();
        arrowKartaLokal.click();
    }

    public void showDanePodstawowe() {
        arrowDanePodstawowe.click();
    }

    public void showAdres() {
        arrowAdres.click();
    }

}
