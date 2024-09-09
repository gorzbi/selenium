package StepDefinitions;

import Konfiguration.Konfig;
import Pages.GoogleSearchPage;
import Pages.GoogleSearchResultPage;
import Shared.Methods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleSimpleSearch {

    WebDriver driver;
    public GoogleSimpleSearch() {

        driver = Konfig.getDriver();
    }

    @And("Soflab search")
    public void soflab_search() {

        System.out.println("Step 2");
        GoogleSearchPage sp = new GoogleSearchPage(driver);
        sp.searchWord("Soflab");
    }

    @And("Gdynia search")
    public void gdynia_search() {

        System.out.println("Step 2");
        GoogleSearchPage sp = new GoogleSearchPage(driver);
        sp.searchWord("Gdynia");
    }


    @And("Soflab click link")
    public void soflab_click_link() {

        System.out.println("Step 4");
        GoogleSearchResultPage rp = new GoogleSearchResultPage(driver);
        rp.clickSflLink();
    }

    @And("Gdynia click link")
    public void gdynia_click_link() {

        System.out.println("Step 4");
        GoogleSearchResultPage rp = new GoogleSearchResultPage(driver);
        rp.clickGdyniaLink();
    }

    @Then("Get Soflab url info")
    public void get_soflab_url_info() {

        System.out.println("Step 5");
        Methods m = new Methods(driver);
        String url = m.getUrl();
        System.out.println("Bieżący url to " + url);
        Assert.assertEquals(url, "https://soflab.pl/", "To nie ten url");
    }

    @Then("Get Gdynia url info")
    public void get_gdynia_url_info() {

        System.out.println("Step 5");
        Methods m = new Methods(driver);
        String url = m.getUrl();
        System.out.println("Bieżący url to " + url);
        Assert.assertEquals(url, "https://www.gdynia.pl/", "To nie ten url");
    }

}
