package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    private WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(id = "L2AGLb")
    private WebElement zgoda;
    @FindBy(name = "q")
    private WebElement searchField;
    @FindBy(name = "btnK")
    private WebElement szukajwGoogleButton;


    public void enterGooglePage() {

        driver.get("https://www.google.pl/");
    }

    public void acceptGooglePolicy() {

        zgoda.click();
    }

    public void searchWord(String word) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(word);
        szukajwGoogleButton.click();
    }


}
