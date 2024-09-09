package Tools;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FullScreen {

    //String path="src/resources/";
    String path="src/test/resources/Raporty/";
    private static String pelnyScreen(WebDriver driver, String jira, String nazwa) throws IOException {

        String nazwaFullScreena = nazwa +".png";

        // zainicjowanie robienia screena - full web
        Screenshot fullScreen = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(5)).takeScreenshot(driver);
        File outFile = new File("src/main/resources/screeny/"+jira+"/"+nazwaFullScreena);
        File parentDir = outFile.getParentFile(); // pobranie powyższej ścieżki
        parentDir.mkdirs(); // utworzenie ścieżki, jej brakujacych folderów/podfolderów
        ImageIO.write(fullScreen.getImage(), "PNG", outFile);
        return outFile.getPath(); // pobranie pełnej ścieżki do screena
    }

    // pobranie screena
    public static Media getFullScreenshot(WebDriver driver, String jira, String nazwa) throws IOException {
        String path2 = pelnyScreen(driver, jira, nazwa);
        return MediaEntityBuilder.createScreenCaptureFromPath(path2).build();
    }
}
