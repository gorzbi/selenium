import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenyNazwa {

    @Test

    public void robienieScreen() throws IOException {

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://testeroprogramowania.github.io/selenium");

        // zrobienie screena
        TakesScreenshot screen = (TakesScreenshot) firefox;

        // zapisanie screena
        File srcFile = screen.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("C:\\Users\\zbigniew.gornowicz\\Desktop\\screen01.png"));
        // FileUtils.copyFile(srcFile, new File("src\test\java\screen01.png")); - zapisuje tu w projekcie
        // FileUtils.copyFile(srcFile, new File("src\test\folder\screen01.png")); - zapisuje tu w projekcie w folderze - folder trzeba najpierw stowrzyć i oznaczyć jako resources root
    }
}
