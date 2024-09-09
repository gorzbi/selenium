import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenyNazwaData {

    @Test

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }

    @Test

    public void robienieScreen() throws IOException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.get("https://www.fakenamegenerator.com/gen-random-pl-pl.php");


        // nadanie nazwy dla pliku i odwołanie się do wcześniejszej metody timestamp
        String nazwaScreena = "screen" + timestamp() + ".png";

        // robienie screena
        TakesScreenshot screenNazwa = (TakesScreenshot) firefox;
        File plik = screenNazwa.getScreenshotAs(OutputType.FILE);

        // zapisanie screena z nazwą
        FileUtils.copyFile(plik, new File("C:\\Users\\zbigniew.gornowicz\\Desktop\\" + nazwaScreena));

    }
}
