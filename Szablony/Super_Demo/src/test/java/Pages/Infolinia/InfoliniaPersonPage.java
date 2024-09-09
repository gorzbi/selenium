package Pages.Infolinia;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InfoliniaPersonPage {

    private WebDriver driver;

    public InfoliniaPersonPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "person_id")
    private WebElement idOsoby;

    public void checkId(String id) {
        Wait.waitForElementToBeVisible(driver,idOsoby);
        Assert.assertEquals(idOsoby.getAttribute("value"), id);
    }

    public String checkOsobaByIdZlecenia(String idZlecenia) {
        WebElement idZlec = driver.findElement(By.xpath("//td[contains(text(),'"+idZlecenia+"')]"));
        Assert.assertTrue(idZlec.isDisplayed());
        String id = idOsoby.getAttribute("value");
        return id;
    }
}
