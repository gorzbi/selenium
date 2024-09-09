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

public class RaportPolicjaWojewTest extends Konfig {


    @Test (priority = 2, testName = "raport policja województwo", groups= {"kat3"})
    public void metodaKPWojew() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);

        extent=raport.createTest("Raport Policja Województwo");
        extent.info("Scenariusz - generowanie raportu policja województwo");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.kpWojew();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekSluzbyMundurowe();

        SluzbyMundurowePage smp = new SluzbyMundurowePage(driver);
        smp.enterEksportDanych();

        EksportDanychKpPage edkp = new EksportDanychKpPage(driver);

        extent.info("Zablokowany filtr województwa ma wartość "+fe.getFiltrWojewodztwoBlockedValue());
        fe.checkFiltrPowiatEnabled();

        ed.checkTypEksportu("POLICJA");

        extent.info("Zablokowany eksport województwo to "+edkp.checkEksportWojewodztwoBlockedValue());
        edkp.checkEksportPowiatEnabled();
        edkp.checkEksportPodtypKwEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-policja-wojew.png"));

        fe.getMyKontekstLastReport();

        ed.generateRaport();

        bread.breadcrumbsOsoby();
        smp.wyszukajOsobyKwarantannaIzolacjaWojewodztwo("Pokaż osoby na aktywnej kwarantannie/izolacji","DOLNOŚLĄSKIE");

        extent.warning("Osób na kw/izolacji "+smp.ileOsob());
    }
}
