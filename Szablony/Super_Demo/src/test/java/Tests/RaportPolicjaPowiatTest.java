package Tests;

import Konfiguration.Konfig;
import Pages.KP.EksportDanychKpPage;
import Pages.KP.SluzbyMundurowePage;
import Pages.Konteksty;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.Shared.Pages.EksportDanychPage;
import Pages.Shared.Pages.Kafelki;
import Tools.JustScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class RaportPolicjaPowiatTest extends Konfig {


    @Test (priority = 3, testName = "raport policja powiat", groups= {"kat3"})
    public void metodaKPPowiat() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);

        extent=raport.createTest("Raport Policja Powiat");
        extent.info("Scenariusz - generowanie raportu policja powiat");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.kpPowiat();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekSluzbyMundurowe();

        SluzbyMundurowePage smp = new SluzbyMundurowePage(driver);
        smp.enterEksportDanych();

        EksportDanychKpPage edkp = new EksportDanychKpPage(driver);

        extent.info("Zablokowany filtr województwo ma wartość "+fe.getFiltrWojewodztwoBlockedValue());
        extent.info("Zablokowany filtr powiat ma wartość "+fe.getFiltrPowiatBlockedValue());

        ed.checkTypEksportu("POLICJA");

        extent.info("Zablokowany eksport województwo to "+edkp.checkEksportWojewodztwoBlockedValue());
        extent.info("Zablokowany eksport powiat to "+edkp.checkEksportPowiatBlockedValue());

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-policja-powiat.png"));

        fe.getMyKontekstLastReport();

        ed.generateRaport();

        bread.breadcrumbsOsoby();
        smp.wyszukajOsobyKwarantannaIzolacjaPowiat("Pokaż osoby na aktywnej kwarantannie/izolacji","WIELKOPOLSKIE", "Kalisz");

        extent.warning("Osób na kw/izolacji jest "+smp.ileOsob());
    }
}
