package Pages.Shared.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WidokFiltrowZlecenPage {

    private WebDriver driver;

    public WidokFiltrowZlecenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//button[@class='btn btn-outline-primary mr-auto']")
    private WebElement przywrocUstawienia;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    private WebElement zapiszUstawienia;

    String CITO = "//li[@data-key='commission']";
    String dataZlecenia = "//li[@data-key='orderedOn']";
    String wylacz = "/button[contains(@aria-label,'do wyłączonych')]";
    String wlaczUp = "/button[contains(@aria-label,'do zawsze widocznych')]";
    String wlaczDown = "/button[contains(@aria-label,'do widocznych po rozwinięciu')]";


    public void uruchomFiltrDataOdDo() {
        przywrocUstawienia.click(); // ustawienia fabryczne
        driver.findElement(By.xpath(CITO+wylacz)).click(); // usuwa CITO
        driver.findElement(By.xpath(dataZlecenia+wlaczUp)).click(); // dodaje Data zlecenia
        zapiszUstawienia.click(); // zapisuje układ filtrów
    }
}
