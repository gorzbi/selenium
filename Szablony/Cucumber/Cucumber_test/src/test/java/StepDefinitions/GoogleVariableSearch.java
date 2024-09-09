package StepDefinitions;

import Konfiguration.Konfig;
import Pages.GoogleSearchPage;
import Pages.GoogleSearchResultPage;
import Shared.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleVariableSearch {

    WebDriver driver;
    public GoogleVariableSearch() {

        driver = Konfig.getDriver();
    }


    @And("Search {}")
    // ilość {} odpowiada ilości parametrów w scenario
    // jeśli jest więcej niż 1 paramter oddzielamy "," -> @And("Search {},{},{}")
    
    public void search(String city) {
        // parametry nazywać dokładnie tak samo jak w scenario lub bez nazwy gdy w scenario jest jeden paramtetr

        System.out.println("Step 2");
        GoogleSearchPage sp = new GoogleSearchPage(driver);
        sp.searchWord(city);
    }

}
