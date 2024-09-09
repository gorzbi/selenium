package Tests;

import DaneTestowe.DaneSzybkaWyszukiwarkaOsob;
import Konfiguration.Konfig;
import Pages.Infolinia.InfoliniaPersonPage;
import Pages.Konteksty;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Methods;
import Pages.Shared.Pages.Kafelki;
import Pages.SzybkaWyszukiwarka.SzybkaWyszukiwarkaForm;
import Pages.SzybkaWyszukiwarka.SzybkaWyszukiwarkaResult;
import org.testng.annotations.Test;

public class SzybkaWyszukiwarkaOsobTest extends Konfig {


    @Test (testName = "szybkaWyszukiwarkaOsob", groups= {"kat1","kat2"})
    public void metodaSzybkaWyszukiwarka() {

        Methods shr = new Methods(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        DaneSzybkaWyszukiwarkaOsob dt = new DaneSzybkaWyszukiwarkaOsob();

        extent=raport.createTest("Szybka Wyszukiwarka Osób");
        extent.info("Scenariusz - szybka wyszukiwarka osób");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.wyszukiwanieOsob();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterSzybkaWyszukiwarka();

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

        shr.zmianaKontekstu("INFL_ART_ALL_KNOPOL_USR");

        kaf.enterSzybkaWyszukiwarkaInfolinii();

        swf.searchPersonId(dt.getIdOsoby());

        InfoliniaPersonPage ipp = new InfoliniaPersonPage(driver);
        ipp.checkId(dt.getIdOsoby());

        bread.breadcrumbsSzybkaWysz();

        swf.searchZlecenieId(dt.getIdZlecenia());

        extent.pass("ID zlecenia "+dt.getIdZlecenia()+" to osoba o ID "+ipp.checkOsobaByIdZlecenia(dt.getIdZlecenia()));
    }
}
