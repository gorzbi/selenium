import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenyRandomNazwa {

    @Test

    public void robienieScreen() throws IOException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();

        // zrobienie screena i nadanie mu odpowiedniej nazwy
        int randomNumber = (int) (Math.random()*1000);
        String nazwaScreena = "screen" + randomNumber + ".png";

        firefox.get("https://www.fakenamegenerator.com/gen-random-pl-pl.php");

        TakesScreenshot screenNazwa = (TakesScreenshot) firefox;
        File plik = screenNazwa.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(plik, new File("C:\\Users\\zbigniew.gornowicz\\Desktop\\" + nazwaScreena));

    }
}
