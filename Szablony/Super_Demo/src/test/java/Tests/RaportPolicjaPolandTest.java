package Tests;

import DaneTestowe.DaneRaportPolicjiPoland;
import Konfiguration.Konfig;
import Pages.KP.EksportDanychKpPage;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Enum.DataChoice;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Filtry.FiltrySzukajOsobe;
import Pages.Shared.Listy.ListOfEksportDanych;
import Pages.Shared.Methods;
import Pages.KP.SluzbyMundurowePage;
import Pages.Konteksty;
import Pages.Shared.Enum.StatusRaport;
import Pages.Shared.Enum.Wojewodztwa;
import Pages.Shared.Pages.EksportDanychPage;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Sortowanie;
import Tools.JustScreen;
import org.testng.annotations.Test;

import java.io.IOException;

public class RaportPolicjaPolandTest extends Konfig {


    @Test (priority = 1, testName = "raport policja poland", groups= {"kat3"})
    public void metodaKpAll() throws IOException {

        Methods shr = new Methods(driver);
        FiltryEksport fe = new FiltryEksport(driver);
        FiltrySzukajOsobe fo = new FiltrySzukajOsobe(driver);
        EksportDanychPage ed = new EksportDanychPage(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        ListOfEksportDanych led = new ListOfEksportDanych(driver);
        Sortowanie sor = new Sortowanie(driver);
        DaneRaportPolicjiPoland dt = new DaneRaportPolicjiPoland();

        extent=raport.createTest("Raport Policja Poland");
        extent.info("Scenariusz - generowanie raportu policja all");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.kpPoland();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekSluzbyMundurowe();

        SluzbyMundurowePage smp = new SluzbyMundurowePage(driver);
        smp.enterEksportDanych();

        EksportDanychKpPage edkp = new EksportDanychKpPage(driver);
        fe.checkFiltrWojewodztwoEnabled();
        fe.checkFiltrPowiatBlockedEmpty();
        fe.checkFiltrPowiatUnblocked("WIELKOPOLSKIE");
        fe.checkFiltrStatusRaportuEnabled();

        ed.checkTypEksportu("POLICJA");

        edkp.checkEksportWojewodztwoEnabled();
        edkp.checkEksportPowiatBlockedEmpty();
        edkp.checkEksportPowiatUnlocked(Wojewodztwa.dolnoslaskie.getName());
        edkp.checkEksportPodtypKwEnabled();

        led.checkPresentReportList();
        extent.warning("Zweryfikować listę raportów i ustawienia", JustScreen.doFullScreen(driver,"raporty-policja.png"));

        fe.getMyKontekstLastReport();

        fe.getRaportByDataZamow(DataChoice.taka_sama_lub_pozniej.getDataChoice(),dt.getDataRaportu());
        extent.warning("Zweryfikować listę raportów pod względem daty", JustScreen.doFullScreen(driver,"report_list_with_date.png"));

        led.checkReportListZamawiajacyWgKontekst("KP");

        edkp.checkListWojewRaport(Wojewodztwa.dolnoslaskie.getName());
        edkp.checkListPowiatRaport(Wojewodztwa.dolnoslaskie.getName(), "głogowski");

        edkp.checkListStatusReport(StatusRaport.uszkodzony.getStatus());


        // sortowanie
        sor.sortowanieDataMalejaco();
        extent.warning("Sortowanie data malejąco", JustScreen.doFullScreen(driver,"Sortowanie_data_malejaco.png"));

        sor.sortowanieDataRosnaco();
        extent.warning("Sortowanie data rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_data_rosnaco.png"));

        sor.changeTypSortowanie("ID");
        extent.warning("Sortowanie id malejąco",JustScreen.doFullScreen(driver,"Sortowanie_id_malejaco.png"));

        sor.changeSortowanieKierunek();
        extent.warning("Sortowanie id rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_id_rosnaco.png"));

        sor.changeTypSortowanie("Zamawiający");
        extent.warning("Sortowanie zamawiający malejąco",JustScreen.doFullScreen(driver,"Sortowanie_zamawiajacy-malejaco.png"));

        sor.changeSortowanieKierunek();
        extent.warning("Sortowanie zamawiający rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_zamawiajacy_rosnaco.png"));

        sor.changeTypSortowanie("Województwo");
        extent.warning("Sortowanie województwo malejąco",JustScreen.doFullScreen(driver,"Sortowanie_wojewodztwo_malejaco.png"));

        sor.changeSortowanieKierunek();
        extent.warning("Sortowanie województwo rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_wojewodztwo_rosnaco.png"));

        sor.changeTypSortowanie("Status");
        extent.warning("Sortowanie status malejąco",JustScreen.doFullScreen(driver,"Sortowanie_status_malejaco.png"));

        sor.changeSortowanieKierunek();
        extent.warning("Sortowanie status rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_status_rosnaco.png"));

        sor.changeTypSortowanie("Powiat");
        extent.warning("Sortowanie powiat malejąco",JustScreen.doFullScreen(driver,"Sortowanie_powiat_malejaco.png"));

        sor.changeSortowanieKierunek();
        extent.warning("Sortowanie powiat rosnąco",JustScreen.doFullScreen(driver,"Sortowanie_powiat_rosnaco.png"));

        sor.returnToBasicSortowanie();

        edkp.generateRaportSelectKwarantanna(dt.getSelectTypRaportu());

        bread.breadcrumbsOsoby();
        fo.szukajOnlyByKwarantanna("Pokaż osoby na aktywnej kwarantannie/izolacji");

        extent.warning("Osób na kw/izolacji "+smp.ileOsob());
    }
}
