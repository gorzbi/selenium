package Pages;

import Konfiguration.User;
import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Tools.Wait.waitforElementToBeClickable;

public class Login {

    User user = new User();

    private WebDriver driver;

    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//a[@class='btn btn-danger']")
    private WebElement zaloguj;

    @FindBy (xpath = "//ul[@id='login-list']/li[@id='go-pz']")
    private WebElement kafelekPZ;

    @FindBy(id="loginForm:login")
    private WebElement loginInput;

    @FindBy(id="loginForm:hasło")
    private WebElement passwordInput;

    @FindBy(id="loginForm:loginButton")
    private WebElement loginButton;

    @FindBy(id="overlay_form1:authenticationCodeField")
    private WebElement smsInput;

    @FindBy(id="overlay_form1:actionBtn")
    private WebElement checkSmsButton;

    @FindBy(className="closeButton")
    private WebElement closeX;


    public void loginEwp() {
        waitforElementToBeClickable(driver,zaloguj);
        zaloguj.click();
    }

    public void enterKafelekPZ() {
        Wait.waitforElementToBeClickable(driver,kafelekPZ);
        kafelekPZ.click();
    }

    public void login() {
        loginInput.sendKeys(user.getLogin());
        passwordInput.sendKeys(user.getPass());
        loginButton.click();
        smsInput.sendKeys(user.getSms());
        checkSmsButton.click();
        closeX.click();
    }

    public void closeSymphony() {

        Wait.waitforLocatorToBeVisible(driver, By.xpath("//button[@title='Close Toolbar']"));
        WebElement symphony = driver.findElement(By.xpath("//button[@title='Close Toolbar']"));
        if (symphony.isEnabled()) {
            symphony.click();
        } else {
            System.out.println("Nie ma symphony");
        }
    }
}
