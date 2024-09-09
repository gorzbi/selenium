package Tests;

import DaneTestowe.DaneRaportZlecenSanepid;
import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.Sanepid.EksportDanychSanepidZleceniaPage;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Filtry.FiltrySzukajZlecenie;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.Shared.Pages.EksportDanychPage;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Pages.WidokFiltrowZlecenPage;
import Pages.Shared.Pages.ZleceniaTestuPage;
import Tools.JustScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class RaportZlecenSanepidTest extends Konfig {

    // sanepid na podkarpackie

    @Test (priority = 6, testName = "raport zleceń sanepid", groups= {"kat1"})
    public void metodaRaportZleceniaSanepid() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        Buttons but = new Buttons(driver);
        FiltrySzukajZlecenie fz = new FiltrySzukajZlecenie(driver);

        DaneRaportZlecenSanepid dt = new DaneRaportZlecenSanepid();

        extent=raport.createTest("Raport Zleceń Sanepid");
        extent.info("Scenariusz - generowanie raportu zleceń sanepid");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.psseKoordynator();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekZleceniaTestu();

        ZleceniaTestuPage ztp = new ZleceniaTestuPage(driver);
        ztp.enterEksportDanych();

        EksportDanychSanepidZleceniaPage edszp = new EksportDanychSanepidZleceniaPage(driver);
        fe.checkFiltrWojewodztwoEnabled();
        fe.checkFiltrPowiatBlockedEmpty();
        fe.checkFiltrPowiatUnblocked("WIELKOPOLSKIE");

        ed.checkTypEksportu("ZLECENIA_LAB");

        edszp.checkEksportWojewodztwoEnabled();
        edszp.checkEksportPowiatEnabled();
        edszp.checkEksportZleceniaEnabled();
        edszp.checkEksportDataFieldsEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-zlecenia-psse.png"));

        fe.getMyKontekstLastReport();

        edszp.checkDatesOver7Days("Wszystkie", dt.getDataOver7days());
        edszp.checkDatesOver31Days(dt.getDataOver31Days());
        edszp.checkDatesOver6moths("MAŁOPOLSKIE", "Kraków",dt.getDataOver6months());

        edszp.generateRaportWojewodztwo("Wszystkie");

        bread.breadcrumbsZlecenia();
        but.enterWidokFiltrow();

        WidokFiltrowZlecenPage wfzp = new WidokFiltrowZlecenPage(driver);
        wfzp.uruchomFiltrDataOdDo();

        fz.szukajOnlyByDataZleceniaDzisiaj();

        extent.warning("Zleceń jest "+ztp.ileZlecen());
    }
}
