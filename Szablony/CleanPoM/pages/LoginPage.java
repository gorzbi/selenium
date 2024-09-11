package pages;

import dane.DaneLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    private WebDriver driver;
    private DaneLogin daneLogin;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.daneLogin = new DaneLogin();
    }

    public void login(DaneLogin dane){
        username.clear();
        username.sendKeys(dane.getUsername());
        password.clear();
        password.sendKeys(dane.getPassword());
        loginButton.click();
    }


}
