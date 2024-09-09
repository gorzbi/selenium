package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

    private WebDriver driver;

    public GoogleSearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='LHJvCe']")
    private WebElement searchResultInfo;

    //@FindBy(xpath = "//a[@jsname='UWckNb']/h3[@class='LC20lb MBeuO DKV0Md']")
    @FindBy(xpath = "//a[@jsname='UWckNb']/h3[contains(text(),'Soflab Technology: Profesjonalne Testy Oprogramowania ...')]")
    private WebElement sflLink;

    @FindBy(xpath = "//a[@jsname='UWckNb']/h3[contains(text(),'Serwis internetowy Miasta Gdynia')]")
    private WebElement gdynialLink;

    @FindBy(xpath = "(//a[@jsname='UWckNb']/h3)[1]")
    private WebElement firstResultSearchLink;



    public void getSearchResultInfo() {

        String info = searchResultInfo.getText();
        System.out.println("Info to " + info);
    }

    public void clickSflLink() {

        sflLink.click();
    }

    public void clickGdyniaLink() {

        gdynialLink.click();
    }

    public void clickFirstSearchResultLink() {

        firstResultSearchLink.click();
    }

}
