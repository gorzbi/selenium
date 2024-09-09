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

public class SharedSteps {

    WebDriver driver;
    public SharedSteps() {

        driver = Konfig.getDriver();
    }

    @Given("Google start")
    public void google_start() {

        System.out.println("Step 1");
        GoogleSearchPage sp = new GoogleSearchPage(driver);
        sp.enterGooglePage();
        sp.acceptGooglePolicy();
    }

    @When("Get search list info")
    public void get_search_list_info() {

        System.out.println("Step 3");
        GoogleSearchResultPage rp = new GoogleSearchResultPage(driver);
        rp.getSearchResultInfo();
    }

    @Then("Get url info")
    public void get_url_info() {

        System.out.println("Step 5");
        Methods m = new Methods(driver);
        String url = m.getUrl();
        System.out.println("Bieżący url to " + url);
    }

    @And("Click first Google search result link")
    public void clickFirstGoogleSearchResultLink() {

        GoogleSearchResultPage gsrp = new GoogleSearchResultPage(driver);
        gsrp.clickFirstSearchResultLink();
    }

    @Then("Get x url info")
    public void getXUrlInfo() {

        Methods m = new Methods(driver);
        String url = m.getUrl();
        Assert.assertEquals(url,"https://www.hej.pl/","Nie ten url");
        System.out.println("Bieżący url to " + url);
    }
}
