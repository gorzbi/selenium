package settings;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import tools.Screen;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Konfiguration {

    protected static WebDriver driver;
    protected static ExtentReports raport;
    protected static ExtentTest extent;

    String reportPath="src/main/resources/raporty/";

    // uruchomione raz przed wszystkimi testami
    @BeforeSuite
    public void initializeExtentReport() {

        raport = new ExtentReports(); // tworzymy obiekt dla raportu

        // raport całkowity
        ExtentSparkReporter all = new ExtentSparkReporter(reportPath+"raport.html"); // aby screeny były widoczne na raporcie wymaga głównego folderu projektu

        // raport z filtrem
        ExtentSparkReporter failed = new ExtentSparkReporter(reportPath+"raport_failed.html");
        failed.filter().statusFilter().as(new Status[]{Status.FAIL});
        ExtentSparkReporter skiped = new ExtentSparkReporter(reportPath+"raport_skiped.html");
        skiped.filter().statusFilter().as(new Status[]{Status.SKIP, Status.WARNING}).apply(); // albo taki zapis

        // konfiguracja raportu all
        all.config().setTheme(Theme.DARK);
        all.config().setEncoding("utf-8");
        all.config().setReportName("Wszystko");
        all.config().setDocumentTitle("Nazwa dokumentu"); // wyświetla się w przeglądarce jako title
        all.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");

        failed.config().setTheme(Theme.STANDARD);
        failed.config().setEncoding("utf-8");
        failed.config().setReportName("Błędy");
        failed.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");


        // dodanie wszystkich raportów all + filtrowane
        raport.attachReporter(all,failed,skiped);
    }


    // uruchamiane przed każdym @Test
    @BeforeMethod
    public void openBrowser(ITestContext context, Method m) {

        // przypisanie nazwy testu z @Test pobiera info z testName
        extent = raport.createTest(m.getAnnotation(Test.class).testName());

        // przypisanie informacji z @Test, pobiera info z ustawionej labelki (groups/description)
        // gdy któryś test nie ma takiej informacji w raporcie będzie wyświetlona jako pusta
        extent.assignCategory(m.getAnnotation(Test.class).groups());
        extent.info(m.getAnnotation(Test.class).description());

        // pobieramy info o autorze/urzadzeniu zapisane w xml w parametrach
        String author = context.getCurrentXmlTest().getParameter("author");
        String urzadzenie = context.getCurrentXmlTest().getParameter("device");

        // pobieramy z xml nazwę autora i urządzenia, wyżej przypisane do zmiennej
        extent.assignAuthor(author);
        extent.assignDevice(urzadzenie);

        driver = DriverFactory.getDriver(DriverType.FIREFOX);
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void checkTestStatus(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE) {

            // 1 -> screeny na górze raportu
            // FromBase64 -> screen bez podglądu, dopiero po kliknięciu
            extent.addScreenCaptureFromBase64String(Screen.capture64(driver), "Tytuł screena");
            // FromPath -> screen zostanie dodany na górze raportu z podglądem
            extent.addScreenCaptureFromPath(Screen.takeScreenshot(driver));

            // 2 -> screeny w kroku raportu wraz z komunikatem
            // screen code64
            extent.fail(result.getThrowable().toString().substring(0,140), MediaEntityBuilder.createScreenCaptureFromBase64String(Screen.capture64(driver)).build());
            // screen metodą screenPath
            extent.fail(result.getThrowable().toString().substring(0,140), MediaEntityBuilder.createScreenCaptureFromPath(Screen.takeScreenshot(driver)).build());

            // 3 -> kod błędu i screeny są osobno w kroku
            extent.fail(result.getThrowable().toString().substring(0,140));
            extent.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Screen.capture64(driver)).build());
            extent.fail(MediaEntityBuilder.createScreenCaptureFromPath(Screen.takeScreenshot(driver)).build());

        } else if (result.getStatus()==ITestResult.SUCCESS) {
            extent.pass("Yeeeesss!!");
        } else {
            extent.skip("ominięte ziom!!");
        }
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    @AfterSuite
    public void generateExtentReport() throws IOException {

        // konfiguracja danych
        // pobranie info o przeglądarce i wersji
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browser = cap.getBrowserName()+" "+cap.getBrowserVersion();

        raport.setSystemInfo("Projekt","EWP");
        raport.setSystemInfo("Przeglądarka",browser); // z capabilites
        raport.setSystemInfo("System operacyjny", System.getProperty("os.name"));
        raport.setSystemInfo("Java", System.getProperty("java.version"));
        raport.setSystemInfo("Wersja aplikacji", "3.87");
        raport.setSystemInfo("Środowisko", "TST");

        // wyplucie raportu
        raport.flush();

        // od razu otwiera raport w przeglądarce
        Desktop.getDesktop().browse(new File(reportPath+"raport.html").toURI());
    }
}
