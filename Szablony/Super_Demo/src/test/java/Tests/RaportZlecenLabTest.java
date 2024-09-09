package Tests;

import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.LAB.EksportDanychLabPage;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Filtry.FiltrySzukajZlecenie;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.Shared.Pages.EksportDanychPage;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Pages.ZleceniaTestuPage;
import Pages.Shared.Pages.WidokFiltrowZlecenPage;
import Tools.JustScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class RaportZlecenLabTest extends Konfig {


    @Test (priority = 4, testName = "raport zleceń lab", groups= {"kat2"})
    public void metodaZlecenLab() throws IOException {

        Methods shr = new Methods(driver);
        Buttons but = new Buttons(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        FiltrySzukajZlecenie fz = new FiltrySzukajZlecenie(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);

        extent=raport.createTest("Raport Zleceń Laboratorium");
        extent.info("Scenariusz - generowanie raportu zleceń lab");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.labKoordynator();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekZleceniaTestu();

        ZleceniaTestuPage ztp = new ZleceniaTestuPage(driver);
        ztp.enterEksportDanych();

        EksportDanychLabPage edlp = new EksportDanychLabPage(driver);
        fe.checkFiltrWojewodztwoEnabled();
        fe.checkFiltrPowiatBlockedEmpty();
        fe.checkFiltrPowiatUnblocked("WIELKOPOLSKIE");

        ed.checkTypEksportu("ZLECENIA_LAB");

        edlp.checkEksportZleceniaEnabled();
        edlp.checkEksportDataFieldsEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-zlecenia-lab.png"));

        fe.getMyKontekstLastReport();

        ed.generateRaport();

        bread.breadcrumbsZlecenia();

        but.enterWidokFiltrow();

        WidokFiltrowZlecenPage wfzp = new WidokFiltrowZlecenPage(driver);
        wfzp.uruchomFiltrDataOdDo();

        fz.szukajOnlyByDataZleceniaDzisiaj();

        extent.warning("Zleceń jest "+ztp.ileZlecen());
    }
}
