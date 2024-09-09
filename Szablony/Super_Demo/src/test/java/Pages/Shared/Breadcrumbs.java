package Pages.Shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Breadcrumbs {

    private WebDriver driver;

    public Breadcrumbs(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[text()='Strona główna']")
    private WebElement mainPage;

    @FindBy(xpath = "//a[text()='Osoby']")
    private WebElement osobyPage;

    @FindBy(xpath = "//a[text()='Zlecenia testu']")
    private WebElement zleceniaPage;

    @FindBy(xpath = "//a[text()='Szybka wyszukiwarka osób']")
    private WebElement szybkaWyszukiwarkaPage;

    public void breadcrumbsMainPage() {
        mainPage.click();
    }

    public void breadcrumbsOsoby() {
        osobyPage.click();
    }

    public void breadcrumbsZlecenia() {
        zleceniaPage.click();
    }

    public void breadcrumbsSzybkaWysz() {
        szybkaWyszukiwarkaPage.click();
    }

}
