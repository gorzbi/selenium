package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = {"StepDefinitions", "Konfiguration"}, // nazwa paczki a nie pliku java
        monochrome = true, // sformatowane info w konsoli
        plugin = {"pretty", "html:src/main/resources/Raporty/cucumber_second_third.html"}, // scieżka dla raportu
        tags= "@second or @third" // odpali wszystkie co mają ten tag, można stosować z poziomu features lub danego scenario

)

public class SecondThirdRunner extends AbstractTestNGCucumberTests {

}
