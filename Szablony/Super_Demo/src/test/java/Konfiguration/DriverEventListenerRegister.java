package Konfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class DriverEventListenerRegister {
    public synchronized static WebDriver registerWebDriverListener(WebDriver driver) {

        DriverEventListener del = new DriverEventListener();
        EventFiringDecorator evd = new EventFiringDecorator((WebDriverListener) del);
        return evd.decorate(driver);
    }
}
