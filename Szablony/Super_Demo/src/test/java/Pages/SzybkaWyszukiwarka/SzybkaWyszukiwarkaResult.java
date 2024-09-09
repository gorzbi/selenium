package Pages.SzybkaWyszukiwarka;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SzybkaWyszukiwarkaResult {

    private WebDriver driver;

    public SzybkaWyszukiwarkaResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    String idZlecenia ="11";

    @FindBy(xpath = "//span[@data-for='person_id']")
    private WebElement idOsoby;

    @FindBy (xpath = "//p[@class='list-cell-value']")
    private WebElement identValue;
    @FindBy(xpath = "//p[@class='list-cell-header' and text()='Identyfikator imigranta']/following-sibling::p")
    private WebElement identyfikatorImigranta;


    public void checkId(String id) {
        Wait.waitForElementToBeVisible(driver,idOsoby);
        Assert.assertEquals(idOsoby.getText(), id);
    }

    public void checkIdentImigrant(String ident) {
        Wait.waitForElementToBeVisible(driver,identyfikatorImigranta);
        Assert.assertEquals(identyfikatorImigranta.getAttribute("textContent"), ident);
    }

    public String checkOsbaByIdZlecenia(String idZlecenia) {
        WebElement idZlec = driver.findElement(By.xpath("//td[contains(text(),'"+idZlecenia+"')]"));
        Assert.assertTrue(idZlec.isDisplayed());
        String id = idOsoby.getText();
        return id;
    }
}
