package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Konfiguracja {

    private WebDriver driver; // stworzenie pola wykorzystywanego w innych metodach w innych klasach, protected jest dziedziczone
    protected static ExtentReports raport; // tworzymy zmienną dla raportu, która będzie używana w innych klasach
    private static ExtentSparkReporter spark; // // tworzymy zmienną dla konfiguracji raportu
    ExtentTest test;

    @BeforeSuite
    // @BeforeSuit uruchamiane jest raz (przed paczką?)
    public void extentRaport() {
        raport = new ExtentReports(); // tworzymy obiekt
        raport.setSystemInfo("Projekt","EWP");
        raport.setSystemInfo("Przeglądarka", "Firefox");
        raport.setSystemInfo("Wersja aplikacji", "3.87");
        raport.setSystemInfo("Środowisko", "TST");

        // konfiguracja raportu
        spark = new ExtentSparkReporter("src/resources/raport.html"); // aby screeny były widoczne na raporcie wymaga głównego folderu projektu
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName("Nazwa raportu");
        spark.config().setDocumentTitle("Nazwa dokumentu");
        raport.attachReporter(spark);
    }

    @AfterSuite
    public void wyplujRaport() {
        raport.flush();
    }

    // wybór przeglądarki i uruchomienie adresu startowego
    // @BeforeMethod jest uruchamiane przed każdą metodą @Test
    @BeforeMethod
    public void beginning() {

        driver = DriverFactory.getDriver(DriverType.CHROME); // wybranie typu z DriverType
        driver.manage().window().maximize();

        driver.get("https://www.google.pl/");
    }

    @AfterMethod
    public void end() {
        driver.quit();
    }
}
