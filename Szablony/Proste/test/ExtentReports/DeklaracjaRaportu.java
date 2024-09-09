package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.Test;

public class DeklaracjaRaportu {

    @Test
    public void test() {

        ExtentReports raport = new ExtentReports(); // tworzymy obiekt
        raport.setSystemInfo("Projekt","EWP");
        raport.setSystemInfo("Przeglądarka", "Firefox");
        raport.setSystemInfo("Wersja aplikacji", "3.87");
        raport.setSystemInfo("Środowisko", "TST");

        // konfiguracja raportu
        ExtentSparkReporter spark = new ExtentSparkReporter("C:/Users/zbigniew.gornowicz/Desktop/raport.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setEncoding("utf-8");
        spark.config().setReportName("Nazwa raportu");
        spark.config().setDocumentTitle("Nazwa dokumentu");
        spark.config().setTimeStampFormat("dd-MM-yyyy hh:mm:ss");
        raport.attachReporter(spark);

        // case 01

        ExtentTest test01 = extent.createTest("Przypadek 01")
                .assignAuthor("Autor testu") 
                .assignCategory("Kategoria testu)
                .assignDevice("Urządzenie");
        
        test01.info("Info, że zaczynam test");
        test01.pass("Pass jeśli pierwszy krok jest ok");
        test01.pass("Pass jeśli kolejny krok jest ok");
        test01.fail("Fail, że krok nie zostal wykonany więc też ok");
        test01.info("Info, że koniec testu");

        // wykonanie raportu
        extent.flush();
    }

}
