package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {

    @FindBy(id = "result-stats")
    private WebElement iloscWynikowWyszukiwania;


    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    // sprawdzenie
    public boolean checkResultPage() {

        boolean check;

        if (iloscWynikowWyszukiwania.isDisplayed()) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}
