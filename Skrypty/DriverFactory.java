import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    
    public static WebDriver getDriver(String name) { // w innej metodzie możemy wywołać i podać parametr nazwę przeglądarki
    
    if (name.equals("firefox")) {
        WebDriverManager.firefoxdriver().setup();
        retunr new FirefoxDriver();    
    } else {
    WebDriverManager.chromedriver().setup();
        return new ChromeDrive();
    }
    }
    
    -------------------w innej klasie odwołanie by było następujące-------
        
        protected WebDriver driver;
        
        public void setup()
        driver = DriverDirectory.getDriver("firefox");
    
    --------sprawdzenie czy okno przeglądarki jest już otwarte

    public static WebDriver firefox;

    // sprawdza czy jest już otwarte okno przeglądarki, jeśli tak to na nim działa, jak nie to je otwiera

    public static WebDriver getDriver() {
        if (firefox==null) {
            WebDriverManager.firefoxdriver().setup();
            firefox = new FirefoxDriver();
        }
        return firefox;
    }
}
