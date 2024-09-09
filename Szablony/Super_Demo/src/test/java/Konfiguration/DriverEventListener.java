package Konfiguration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class DriverEventListener implements WebDriverListener {

    private Logger log = LogManager.getLogger(DriverEventListener.class);

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        log.info("Trying to find WebElement with locator "+locator.toString());
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        log.info("Found WebElement");
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        log.info("Trying to find WebElement list with locator " + locator.toString());
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        log.info("Found WebElements list");
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverListener.super.beforeClick(element);
        log.info("Trying to click WebElement "+element);
    }

    @Override
    public void afterClick(WebElement element) {
        WebDriverListener.super.afterClick(element);
        log.info("Clicked WebElement");
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.beforeSendKeys(element, keysToSend);
        if (keysToSend == null) {
            log.info("Trying to clear field with location " + element.getLocation());
        } else {
            log.info("Trying to type text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverListener.super.afterSendKeys(element, keysToSend);
        if (keysToSend == null) {
            log.info("Cleared field with location " + element.getLocation());
        } else {
            log.info("Typed text " + Arrays.toString(keysToSend));
        }
    }

    @Override
    public void beforeClear(WebElement element) {
        WebDriverListener.super.beforeClear(element);
        log.info("Trying to clear WebElement");
    }

    @Override
    public void afterClear(WebElement element) {
        WebDriverListener.super.afterClear(element);
        log.info("Cleared WebElement " + element);
    }

    @Override
    public void beforeFindElement(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElement(element, locator);
        log.info("Trying to find WebElement with locator " + locator.toString());
    }

    @Override
    public void afterFindElement(WebElement element, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(element, locator, result);
        log.info("Found WebElement with locator " + locator.toString());
    }

    @Override
    public void beforeFindElements(WebElement element, By locator) {
        WebDriverListener.super.beforeFindElements(element, locator);
        log.info("Trying to find WebElement list with locator " + locator.toString());
    }

    @Override
    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(element, locator, result);
        log.info("Found WebElements list with locator " + locator.toString());
    }

}
