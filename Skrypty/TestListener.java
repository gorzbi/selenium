import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {


    @Override
    public void onTestStart (ITestResult iTestResult) {

        System.out.println("Test się zaczyna");

    }

    @Override
    public void onTestSuccess (ITestResult iTestResult) {

        System.out.println("Test zakończony sukcesem");

    }

    @Override
    public void onTestFailure (ITestResult iTestResult) {

        System.out.println("Test zakończony niepowodzeniem");

        WebDriver firefox = DriverFactory.getDriver(); // łapiemy odpowiednie okno przeglądarki

        // zrobienie screena i nadanie mu odpowiedniej nazwy
        int randomNumber = (int) (Math.random()*1000);
        String nazwaScreena = "failed" + randomNumber + ".png";

        TakesScreenshot screenNazwa = (TakesScreenshot) firefox;
        File plik = screenNazwa.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(plik, new File("C:\\Users\\zbigniew.gornowicz\\Desktop\\" + nazwaScreena));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped (ITestResult iTestResult) {

        System.out.println("Test pominięty");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage (ITestResult iTestResult) {

        System.out.println("A tu nie wiem o co chodzi, jakieś procenty");

    }

    @Override
    public void onStart (ITestContext iTestContext) {

        System.out.println("Wszystko się zaczyna się");

    }

    @Override
    public void onFinish (ITestContext iTestContext) {

        System.out.println("Wszystko się kończy się");

    }

}
