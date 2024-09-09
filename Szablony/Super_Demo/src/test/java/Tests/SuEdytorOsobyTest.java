package Tests;

import DaneTestowe.DaneSuEdytorOsoby;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Listy.ListOfWyszukiwanie;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Pages.OsobyHistoryPage;
import Pages.Su_Edytor.Su_EditOsobaPage;
import Pages.Su_Edytor.Su_PodgladOsobaPage;
import Tools.ZapiszDane;
import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.Shared.Methods;
import Pages.Shared.Pages.OsobyPage;
import Tools.JustScreen;
import org.testng.annotations.Test;

public class SuEdytorOsobyTest extends Konfig {

    @Test (priority = 8, testName = "edycja osób su edytor", groups= {"kat1"})
    public void metodaEdytorOsobySU() throws Exception {

        Methods shr = new Methods(driver);
        ZapiszDane zd = ZapiszDane.getInstance();
        DaneSuEdytorOsoby dt = new DaneSuEdytorOsoby();
        ListOfWyszukiwanie low = new ListOfWyszukiwanie(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);

        extent=raport.createTest("Edycja Osób przez Su Edytor");
        extent.info("Scenariusz - edycja osób su-edytor");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.suEdytor();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekOsoby();

        OsobyPage op = new OsobyPage(driver);
        op.losujFiltr();
        extent.warning("Wylosowano filtr -> "+zd.getInfo()+ " sprawdź osobę o ID "+low.listOfIdOsob(), JustScreen.doFullScreen(driver,"osoba-"+zd.getInfo()+".png"));

        op.podgladIdOsoby(dt.getIdOsoby());

        Su_PodgladOsobaPage pop = new Su_PodgladOsobaPage(driver);
        extent.warning("Podgląd osoby", JustScreen.doFullScreen(driver,"check-su-podglad-osoby.png"));
        bread.breadcrumbsOsoby();
        op.editIdOsoby(dt.getIdOsoby());
        extent.warning("Edycja osoby", JustScreen.doFullScreen(driver,"check-su-edit-osoby.png"));

        Su_EditOsobaPage eop = new Su_EditOsobaPage(driver);

        // ---- dane podstawowe

        eop.checkEditImie("aaa");
        eop.checkEditNazwisko("bbb");
        eop.checkEditPesel("94051890143");
        eop.checkEditPlec("Nieznana");
        eop.checkEditDataUrodzenia("1985-01-01");
        eop.checkEditObywatelstwo("Niemcy");
        eop.checkEditZawod("lekarz");


/*        eop.checkEditTypDok("Inny");
        eop.checkEditKrajpDok("Niemcy");
        eop.checkEditNrpDok("xxx");*/


        eop.checkEditNrTel("+45651235");
        eop.checkEditNrTel1("+45651235");
        eop.checkEditNrTel2("+45651235");
        eop.checkEditNrTel3("+45651235");
        eop.checkEditNrTelGospodarza("+45651235");
        eop.checkEditEmail("wer@xx.pl");

        eop.checkEditZgonYes("Tak");


        // ---- dane adresowe

        eop.checkEditWojewodztwo("OPOLSKIE");
        eop.checkEditPowiat("MAŁOPOLSKIE","Kraków");
        eop.checkEditGmina("POMORSKIE","Gdynia", "Gdynia");
        eop.checkEditMiejscowosc("MAZOWIECKIE","lipski", "Lipsko", "Borowo (teryt: 140903)");
        eop.checkEditUlica("Kiepska");
        eop.checkEditNrDomu("PODKARPACKIE", "Krosno", "Krosno", "Krosno (teryt: 186101)", "17");
        eop.checkEditNrLokalu("99");
        eop.checkEditKodPocztowy("PODLASKIE", "bielski", "Wyszki", "Falki (teryt: 200308)", "17", "22-987");
        eop.checkEditDodInfo();
        eop.checkEditIdDicZdefAdres();


        // ---- kwarantanna

        eop.checkEditStatusKw("Usunięty");
        eop.checkEditNrDecyzji("123xxx");
        eop.checkEditTypKw("izolacja domowa");
        eop.checkEditDataKwOd("2022-12-31");
        eop.checkEditDataKwDo("2023-03-31");
        eop.checkEditIdZlecSkrac("qwerty","12345");
        eop.checkEditDataWynikuSkrac("2022-12-31");
        eop.checkEditIdZlecWydluz("qwerty", "54321");
        eop.checkEditZlecOsobaId("qwerty", "1234");
        eop.checkEditZlecOsobaVer("xcvb");
        eop.checkEditGabinetId("qwerty", "28");
        eop.checkEditZrKwRefId("Zleceniowa (-7)");
        eop.checkEditIdKwZrodla("qwerty", "23");
        eop.checkEditKomentarzKw("xxx");

        // ---- karta lokalizacyjna

        eop.checkEditNrKartyLokal("xxx");
        eop.checkEditNrRejPojazdu("xxx");
        eop.checkEditPrzejscieGraniczne("001 - Przejście Drogowe");
        eop.checkEditDataPrzekroczeniaGranicy("2023-01-01");
        eop.checkEditPanstwoPrzyjechano("Rosja");
        eop.checkEditStatus("Usunięty");


        // ---- historyczne zmiany

        eop.checkChangeHistoryOsoba(dt.getHistoryOsoba());
        eop.checkChangeHistoryAdres(dt.getHistoryAdres());


        // ---- zmiany

        eop.changeHistoryAll(dt.getHistoryOsoba(), dt.getHistoryAdres());

        shr.zmianaKontekstu("PSSE_18_S_KNOPOL_KRD");

        kaf.enterKafelekOsoby();

        OsobyPage osp = new OsobyPage(driver);
        osp.checkHistoryIdOsoby(dt.getIdOsoby());

        shr.changeBrowserTab();

        OsobyHistoryPage ohp = new OsobyHistoryPage(driver);
        ohp.showDanePodstawowe();
        ohp.showAdres();
        extent.warning("Sprawdź historię zmian SU -> dane podstawowe i adres", JustScreen.doFullScreen(driver,"check-su-osoby-change-history.png"));
    }
}
