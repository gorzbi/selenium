package StepDefinitions;

import DaneTestowe.DaneSzybkaWyszukiwarkaOsob;
import Konfiguration.Konfig;
import Pages.Infolinia.InfoliniaPersonPage;
import Pages.Konteksty;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Methods;
import Pages.Shared.Pages.Kafelki;
import Pages.SzybkaWyszukiwarka.SzybkaWyszukiwarkaForm;
import Pages.SzybkaWyszukiwarka.SzybkaWyszukiwarkaResult;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


public class SzybkaWyszukiwrkaOsob {

    WebDriver driver;
    public SzybkaWyszukiwrkaOsob(Konfig konfig) throws IOException {
        driver = konfig.getDriver();
    }

    @Given("kontekst Szybka Wyszukiwarka Osob")
    public void kontekst_szybka_wyszukiwarka_osob() {
        Methods shr = new Methods(driver);

        Konteksty kontekst = new Konteksty(driver);
        kontekst.wyszukiwanieOsob();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterSzybkaWyszukiwarka();
    }

    @When("sprawdzam bledne wyszukiwanie")
    public void sprawdzam_bledne_wyszukiwanie() {
        DaneSzybkaWyszukiwarkaOsob dt = new DaneSzybkaWyszukiwarkaOsob();
        Breadcrumbs bread = new Breadcrumbs(driver);

        SzybkaWyszukiwarkaForm swf = new SzybkaWyszukiwarkaForm(driver);
        swf.search();
        swf.alertOne();
        swf.alertTwo();
        swf.searchPerson(dt.getNazwisko(), dt.getPesel());

        SzybkaWyszukiwarkaResult swr = new SzybkaWyszukiwarkaResult(driver);
        swr.checkId(dt.getIdOsoby());

        bread.breadcrumbsSzybkaWysz();

        swf.innyTypDokAlertValidation("Imigrant");

        swf.searchInnyPerson(dt.getTypIdentyfikatora(),dt.getNrIdentyfikatora());

        swr.checkIdentImigrant(dt.getNrIdentyfikatora());
    }

    @And("zmieniam kontekst")
    public void zmieniam_kontekst() {
        Methods shr = new Methods(driver);
        shr.zmianaKontekstu("INFL_ART_ALL_KNOPOL_USR");
    }

    @And("sprawdzam wyszukiwanie")
    public void sprawdzam_wyszukiwanie() {
        DaneSzybkaWyszukiwarkaOsob dt = new DaneSzybkaWyszukiwarkaOsob();
        Breadcrumbs bread = new Breadcrumbs(driver);

        Kafelki kaf = new Kafelki(driver);
        kaf.enterSzybkaWyszukiwarkaInfolinii();

        SzybkaWyszukiwarkaForm swf = new SzybkaWyszukiwarkaForm(driver);
        swf.searchPersonId(dt.getIdOsoby());

        InfoliniaPersonPage ipp = new InfoliniaPersonPage(driver);
        ipp.checkId(dt.getIdOsoby());

        bread.breadcrumbsSzybkaWysz();
    }

    @Then("wyszukuje po zleceniu")
    public void wyszukuje_po_zleceniu() {
        DaneSzybkaWyszukiwarkaOsob dt = new DaneSzybkaWyszukiwarkaOsob();

        SzybkaWyszukiwarkaForm swf = new SzybkaWyszukiwarkaForm(driver);
        swf.searchZlecenieId(dt.getIdZlecenia());
    }
}
