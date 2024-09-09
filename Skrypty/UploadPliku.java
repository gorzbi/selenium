import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UploadPliku {

    @Test

    public void upload() {

        WebDriverManager.firefoxdriver().setup();

        WebDriver firefox = new FirefoxDriver();

        firefox.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // wyszukujemy element -przycisk- odpowiadający za upload i podajemy ścieżkę do pliku
        firefox.findElement(By.id("myFile")).sendKeys("C:\\Users\\zbigniew.gornowicz\\Desktop\\test.txt");

    }
}
