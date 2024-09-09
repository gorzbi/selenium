package Tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screen {

    // metody do robienia screena i zapisu
    private static String zrzutEkranu(WebDriver driver, String jira, String nazwa) throws IOException {

        // nadanie nazwy dla screena
        String nazwaScreena = nazwa+".png";

        // zrobienie screena
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File plik = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/main/resources/screeny/"+jira+"/"+nazwaScreena;
        FileUtils.copyFile(plik, new File(path));
        return path;
    }

    // pobranie screena
    public static Media getScreenshot(WebDriver driver, String jira, String nazwa) throws IOException {

        String path = zrzutEkranu(driver, jira, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

}
