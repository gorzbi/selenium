package Pages.Su_Edytor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Su_PodgladOsobaPage {

    private WebDriver driver;

    public Su_PodgladOsobaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//a[@class='btn-link link-left action-list']")
    private WebElement powrotListaOsob;

    public void returnOsobyPage() {
        powrotListaOsob.click();
    }
}
