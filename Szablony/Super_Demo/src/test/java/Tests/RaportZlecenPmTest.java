package Tests;

import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.PM.EksportDanychPmPage;
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

public class RaportZlecenPmTest extends Konfig {


    @Test (priority = 5, testName = "raport zleceń pm", groups= {"kat1"})
    public void metodaZlecenPm() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        Buttons but = new Buttons(driver);
        FiltrySzukajZlecenie fz = new FiltrySzukajZlecenie(driver);

        extent=raport.createTest("Raport Zleceń Punkt Pobrań");
        extent.info("Scenariusz - generowanie raportu zleceń PM");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.PM();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekZleceniaTestu();

        ZleceniaTestuPage ztp = new ZleceniaTestuPage(driver);
        ztp.enterEksportDanych();

        EksportDanychPmPage edpp = new EksportDanychPmPage(driver);
        fe.checkFiltrWojewodztwoEnabled();
        fe.checkFiltrPowiatBlockedEmpty();
        fe.checkFiltrPowiatUnblocked("WIELKOPOLSKIE");

        ed.checkTypEksportu("ZLECENIA_LAB");

        edpp.checkEksportWojewodztwoEnabled();
        edpp.checkEksportPowiatBlockedEmpty();
        edpp.checkEksportPowiatUnlocked("POMORSKIE");
        edpp.checkEksportZleceniaEnabled();

        edpp.checkEksportDataFieldsEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-zlecenia-pm.png"));

        fe.getMyKontekstLastReport();

        ed.generateRaport();

        bread.breadcrumbsZlecenia();

        but.enterWidokFiltrow();

        WidokFiltrowZlecenPage wfzp = new WidokFiltrowZlecenPage(driver);
        wfzp.uruchomFiltrDataOdDo();

        fz.szukajByMyPmToday("Mednovation Sp. z o. o. (punkt pobrań w Giżycku)"); // tst Badaj To Sp. z o.o. (punkt wymazowy Śląskich Laboratoriów Analitycznych) pre Mednovation Sp. z o. o. (punkt pobrań w Giżycku)

        extent.warning("Zleceń jest "+ztp.ileZlecen());
    }
}
