package Tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class JustScreen {

    //String path="src/resources/";
    private String path="src/main/resources/Raporty/Screeny/";

    public static String capture64(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String base64 = screenshot.getScreenshotAs(OutputType.BASE64);
        return base64;
    }

    public static Media doCapture64(WebDriver driver) throws IOException {
        String path = capture64(driver);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(path).build();
    }

    // ---- screen bez jira

    public static String screenShot(WebDriver driver, String name) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File plik = screenshot.getScreenshotAs(OutputType.FILE);
        //File screenPath = new File("src/resources/screeny/"+name);
        File screenPath = new File("src/main/resources/Raporty/Screeny/"+name);
        FileUtils.copyFile(plik, screenPath);
        return "screeny/"+name;
    }

    public static Media doScreenShot(WebDriver driver, String nazwa) throws IOException {
        String path = screenShot(driver, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }


    // ---- fullscreen bez jira

    private static String fullScreen(WebDriver driver, String nazwa) throws IOException {

        // zainicjowanie robienia screena - full web
        Screenshot fullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5)).takeScreenshot(driver);
        //File outFile = new File("src/resources/screeny/"+nazwa);
        File outFile = new File("src/main/resources/Raporty/Screeny/"+nazwa);
        File parentDir = outFile.getParentFile(); // pobranie powyższej ścieżki
        parentDir.mkdirs(); // utworzenie ścieżki, jej brakujacych folderów/podfolderów
        ImageIO.write(fullScreen.getImage(), "PNG", outFile);
        return "screeny/"+nazwa; // pobranie pełnej ścieżki do screena
    }

    // pobranie screena
    public static Media doFullScreen(WebDriver driver, String nazwa) throws IOException {
        String path = fullScreen(driver, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }
}
