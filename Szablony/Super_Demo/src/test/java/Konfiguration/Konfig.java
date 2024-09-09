package Konfiguration;

import Pages.Login;
import Tools.JustScreen;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Konfig {

    protected static WebDriver driver; // stworzenie pola wykorzystywanego w innych metodach w innych klasach, protected jest dziedziczone

    // osobne wywołanie driver dla cucumber
    public static WebDriver getDriver() {
        return driver;
    }

    protected static ExtentReports raport;
    protected ExtentTest extent;


    String reportPath="src/main/resources/Raporty/";


    /*
    * wykonywane raz jako pierwsza czynność
    * inicjalizacja raportu
    */

    @BeforeSuite
    @Before
    public void start() {

        // rozwiązanie problemu z uruchamianiem na chrome
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        System.out.println("Before suit");

        raport = new ExtentReports(); // tworzymy obiekt dla raportu

        // tworzymy raporty
        ExtentSparkReporter all = new ExtentSparkReporter(reportPath+"raport.html"); // aby screeny były widoczne na raporcie wymaga głównego folderu projektu

        // filtrowanie raportu, trzeba utworzyć nowe raporty z filtrem
        ExtentSparkReporter failed = new ExtentSparkReporter(reportPath+"raport_failed.html");
        failed.filter().statusFilter().as(new Status[]{Status.FAIL});
        ExtentSparkReporter skiped = new ExtentSparkReporter(reportPath+"raport_skiped.html");
        skiped.filter().statusFilter().as(new Status[]{Status.SKIP, Status.WARNING}).apply(); // albo taki zapis

        // konfiguracja raportu all
        all.config().setTheme(Theme.DARK);
        all.config().setEncoding("utf-8");
        all.config().setReportName("Nazwa raportu");
        all.config().setDocumentTitle("Nazwa dokumentu");
        all.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");

        // dodanie wszystkich raportów all + filtrowane
        raport.attachReporter(all,failed,skiped);

    }

    // wykonywane raz jako druga czynność
    @BeforeTest
    public void startRaport() {

        System.out.println("Before test");
    }

    // wykonywane raz przed każdą klasą testową zawierającą metody testowe @Test
    @BeforeClass
    public void clas() {

        System.out.println("Before class");
    }

    /*
    * wykonywane raz przed każdą metodą testową @Test dla każdej klasy z testami
    * wybór przeglądarki
    * adres strony startowej
    */
    @BeforeMethod
    @Before
    public void takeBrowser() throws InterruptedException {

        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();

        driver = DriverEventListenerRegister.registerWebDriverListener(driver); // dla zbierania info co robi driver

        // wybór wersji środowiska
        Environment env = new Environment();
        driver.get(env.getUrlPreprod());
        //driver.get(env.getUrlTest());

        // logowanie przez PZ
        Login login = new Login(driver);
        login.loginEwp();
        login.enterKafelekPZ();
        login.login();

        // zamknięcie symphony
        // login.closeSymphony();

        System.out.println("Before method");
    }


    // ------------after

    /*
    * wykonywane raz po każdej metodzie testowej @Test dla każdej klasy z testami
    * pobranie statusu testu
    * zrobienie screena błędu
    * zamknięcie przeglądarki
    */
    @AfterMethod
    public void tearDown(Method m, ITestResult result) throws IOException {

        if (result.getStatus()==ITestResult.SUCCESS) {
            extent.pass("SUCCESS");
        } else if (result.getStatus()==ITestResult.FAILURE) {
            extent.fail("FAIL");

            //TODO komunikat wybranej część treści erroru

            // wyciągamy komunikat błędu
            String komunikat = result.getThrowable().toString();
            System.out.println("Komunikat to "+komunikat);

            //TODO random nazwa dla screenów

            // screeny w kroku raportu wraz z komunikatem
            // screen code64
            extent.fail(komunikat, JustScreen.doCapture64(driver));
            // screen metodą screenPath
            extent.fail(komunikat,(JustScreen.doScreenShot(driver,"error.png")));

        } else  {
            extent.skip("SKIP");
        }

        // przypisanie kategorii -> alternatywny sposób
        extent.assignCategory(m.getAnnotation(Test.class).groups()); // z @Test pobiera info z groups

        //driver.quit();
        System.out.println("After method");
    }

    // wykonywane raz po każdej klasie testowej zawierającej metody testowe @Test
    @AfterClass
    public void klas(){

        System.out.println("After class");
    }

    // wykonywane raz jako przedostatnia rzecz
    @AfterTest
    public void teset() {

        System.out.println("After test");
    }

    /*
     * wykonywane raz jako ostatnia czynność
     * wygenerowanie raportu
     * info systemowe do raportu
     * automatyczne otwarcie raportu
    */
    @AfterSuite
    public void generateExtentReport() throws IOException {

        // konfiguracja danych
        // pobranie info o przeglądarce i wersji

        //Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        ChromeOptions cap = new ChromeOptions();
        String browser = cap.getBrowserName()+" "+cap.getBrowserVersion();

        raport.setSystemInfo("Projekt","EWP");
        raport.setSystemInfo("Przeglądarka",browser); // z capabilites
        raport.setSystemInfo("System operacyjny", System.getProperty("os.name"));
        raport.setSystemInfo("Java", System.getProperty("java.version"));
        raport.setSystemInfo("Wersja aplikacji", "3.95");
        raport.setSystemInfo("Środowisko", "PREPROD");

        // "wyplucie" raportu
        raport.flush();

        // od razu otwiera raport w przeglądarce
        Desktop.getDesktop().browse(new File(reportPath+"raport.html").toURI());

        System.out.println("After suite");
    }
}
