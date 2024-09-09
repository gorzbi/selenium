package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import driver.DriverFactory;
import driver.DriverType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class Konfiguracja {
    
    // w annotiations działa capabilities -w afterSuite

    protected static WebDriver driver; // stworzenie pola wykorzystywanego w innych metodach w innych klasach, protected jest dziedziczone
    protected static ExtentReports raport;
    protected static ExtentTest extent;
    
    String reportPath="src/test/resources/Raporty/";

    @BeforeSuite
    public void initializeExtentReport() {

        raport = new ExtentReports(); // tworzymy obiekt dla raportu

        // tworzymy raporty
        ExtentSparkReporter all = new ExtentSparkReporter(reporthPath+"raport.html"); // aby screeny były widoczne na raporcie wymaga głównego folderu projektu

        // filtrowanie raportu, trzeba utworzyć nowe raporty z filtrem
        ExtentSparkReporter failed = new ExtentSparkReporter("src/resources/lis_raport_failed.html");
        failed.filter().statusFilter().as(new Status[]{Status.FAIL});
        ExtentSparkReporter skiped = new ExtentSparkReporter("src/resources/lis_raport_skiped.html");
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


    // @BeforeMethod jest uruchamiane przed każdą metodą @Test??
    // @BeforeTest uruchamiane jest przed każdą @test
    @BeforeTest
    public void beginning(ITestContext context) {

        // przed każdym @test uruchamiamy przeglądarkę i maksymalne okno
        driver = DriverFactory.getDriver(DriverType.CHROME);
        driver.manage().window().maximize();

        // pobieramy info o autorze/urzadzeniu zapisane w xml w parametrach
        String author = context.getCurrentXmlTest().getParameter("author");
        String urzadzenie = context.getCurrentXmlTest().getParameter("device");
        //String category = context.getCurrentXmlTest().getParameter("category");

        // dla każdego testu tworzymy osobny raport case z nazwą z xml <test name>
        extent = raport.createTest(context.getName(),"Opis dla wszystkich test case");

        // pobieramy z xml nazwę autora i urządzenia, wyżej przypisane do zmiennej
        extent.assignAuthor(author);
        extent.assignDevice(urzadzenie);

        /*
        * alternatywnie kategoria z pliku xml
        * nie może być jednocześnie z annotiations
        * użytego na końcu @AfterMethod
        */
        //extent.assignCategory(category);

        driver.get("https://www.google.pl/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void checkTestStatus(Method m, ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE) {

            String screenName = "fail"+Math.random()*1000+".png";

            // 1 -> screeny na górze raportu
            // FromBase64 -> screen bez podglądu, dopiero po kliknięciu
            extent.addScreenCaptureFromBase64String(capture64(), "Tytuł screena");
            // FromPath -> screen zostanie dodany na górze raportu z podglądem
            extent.addScreenCaptureFromPath(captureScreenShot(screenName));

            // 2 -> screeny w kroku raportu wraz z komunikatem
            // screen code64
            extent.fail(result.getThrowable().toString().substring(0,140), MediaEntityBuilder.createScreenCaptureFromBase64String(capture64()).build());
            // screen metodą screenPath
            extent.fail(result.getThrowable().toString().substring(0,140), MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(screenName)).build());

            // 3 -> kod błędu i screeny są osobno w kroku
            extent.fail(result.getThrowable().toString().substring(0,140));
            extent.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(capture64()).build());
            extent.fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(screenName)).build());

        } else if (result.getStatus()==ITestResult.SUCCESS) {
            extent.pass("Yeeeesss!!");
        } else {
            extent.skip("ominięte ziom!!");
        }
        // przypisanie kategorii -> alternatywny sposób
        extent.assignCategory(m.getAnnotation(Test.class).groups()); // z @Test pobiera info z groups
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
        Desktop.getDesktop().browse(new File("src/resources/lis_raport.html").toURI());
    }

    // ------------> screeny

    public static String capture64() {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        String base64 = screenshot.getScreenshotAs(OutputType.BASE64);
        return base64;
    }

    public static String captureScreenShot(String name) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File plik = screenshot.getScreenshotAs(OutputType.FILE);
        File screenPath = new File("src/resources/screeny/"+name);
        FileUtils.copyFile(plik, screenPath);
        //return screenPath.getPath(); // może pobierać błędną ścieżkę do screena
        return "screeny/"+name;
    }
}
