package Shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Methods {

    private WebDriver driver;

    public Methods(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getUrl() {

        String url = driver.getCurrentUrl();
        return url;
    }
}
