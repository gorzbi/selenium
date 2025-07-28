package pages;

import data.LoginDataBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageBuilder {

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "error")
    private WebElement errorElement;

    @FindBy(xpath = "//h3[contains(text(),'do not match any user')]")
    private WebElement wrongLoginErrorMessage;

    @FindBy(xpath = "//h3[contains(text(),'Sorry, this user has been locked out.')]")
    private WebElement blockedLoginErrorMessage;

    @FindBy(xpath = "//h3[contains(text(),'Username is required')]")
    private WebElement emptyUsernameErrorMessage;

    @FindBy(xpath = "//h3[contains(text(),'Password is required')]")
    private WebElement emptyPasswordErrorMessage;

    WebDriver driver;

    public LoginPageBuilder(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // każde pole z if bo sprawdza czy wpisano wartość czy jest puste, potrzebne dla testów, które jakieś pole mają zostawić puste
    // jedna metoda wykorzystująca data z polami tego formularza do różnych kombinacji testów formularza

    public void login(LoginDataBuilder data){
        if (data.getUsername() != null) {
            usernameInput.clear();
            usernameInput.sendKeys(data.getUsername());
        }

        if (data.getPassword() != null) {
            passwordInput.clear();
            passwordInput.sendKeys(data.getPassword());
        }

        loginButton.click();
    }

    public void checkWrongPasswordErrorMessage() {
        Assert.assertTrue(wrongLoginErrorMessage.isDisplayed());
    }

    public void checkBlockedErrorMessage() {
        Assert.assertTrue(blockedLoginErrorMessage.isDisplayed());
    }

    public void checkEmptyUsernameErrorMessage() {
        Assert.assertTrue(emptyUsernameErrorMessage.isDisplayed());
    }

    public void checkEmptyPasswordErrorMessage() {
        Assert.assertTrue(emptyPasswordErrorMessage.isDisplayed());
    }
}