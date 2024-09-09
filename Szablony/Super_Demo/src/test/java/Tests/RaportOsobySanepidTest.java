package Tests;

import DaneTestowe.DaneRaportOsobySanepid;
import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.Sanepid.EksportDanychSanepidOsobyPage;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Filtry.FiltrySzukajOsobe;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.Shared.Pages.EksportDanychPage;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Pages.OsobyPage;
import Tools.JustScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class RaportOsobySanepidTest extends Konfig {

    // sanepid na podkarpackie

    @Test (priority = 7, testName = "raport osób sanepid", groups= {"kat1"})
    public void metodaRaportOsobySanepid() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        FiltrySzukajOsobe fo = new FiltrySzukajOsobe(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        DaneRaportOsobySanepid dt = new DaneRaportOsobySanepid();

        extent=raport.createTest("Raport Osób Sanepid");
        extent.info("Scenariusz - generowanie raportu osób sanepid");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.psseKoordynator();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekOsoby();

        OsobyPage op = new OsobyPage(driver);
        op.enterEksportDanych();

        EksportDanychSanepidOsobyPage edsop = new EksportDanychSanepidOsobyPage(driver);
        fe.checkFiltrWojewodztwoEnabled();
        fe.checkFiltrPowiatBlockedEmpty();
        fe.checkFiltrPowiatUnblocked("POMORSKIE");

        ed.checkTypEksportu("OSOBY");

        edsop.checkEksportWojewodztwoEnabled();
        edsop.checkEksportPowiatEnabled();
        edsop.checkEksportOsobyzKwarantannaEnabled();
        edsop.checkEksportDataFieldsEnabled();
        edsop.checkEksportPodtypKwEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-osoby-psse.png"));

        fe.getMyKontekstLastReport();

        //shr.changeBrowserTab();

        edsop.checkEksportOsobyKwNIE();
        edsop.checkEksportOsobyNiePowiatWalidationGenerateRaport("POMORSKIE", "lęborski");
        edsop.checkEksportDatyOver31daysWalidationGenerateRaport("MAZOWIECKIE",dt.getDataOver31Days(),dt.getDataToday());

        bread.breadcrumbsOsoby();

        fo.szukajOnlyByPowiat("POMORSKIE", "Gdynia");
        extent.warning("Wszystkich osób z Gdynia jest "+op.ileOsob());
    }
}
