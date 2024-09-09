import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowSize {

    @Test

    public void wielkoscOkna() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver firefox = new FirefoxDriver();
        firefox.manage().window().maximize(); // maksymalna wielkość okna
        firefox.manage().window().setSize(new Dimension(500,500)); // okno o określonej wielkości

    }
}
