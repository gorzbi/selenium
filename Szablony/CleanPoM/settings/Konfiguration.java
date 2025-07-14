package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class Konfiguration {

    protected static WebDriver driver;

    @BeforeMethod
    public void openBrowser() throws InterruptedException {

        //driver = DriverFactory.alternativeGetDriver(DriverType.FIREFOX);
        driver = DriverFactory.getDriver(DriverType.FIREFOX);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}
