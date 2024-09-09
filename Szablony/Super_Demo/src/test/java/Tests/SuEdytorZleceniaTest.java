package Tests;

import DaneTestowe.DaneSuEdytorZlecen;
import Konfiguration.Konfig;
import Pages.Konteksty;
import Pages.Shared.Breadcrumbs;
import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltrySzukajZlecenie;
import Pages.Shared.Listy.ListOfWyszukiwanie;
import Pages.Shared.Methods;
import Pages.Shared.Pages.Kafelki;
import Pages.Shared.Pages.ZleceniaTestuPage;
import Pages.Su_Edytor.Su_EditZlecenieTestuPage;
import Tools.ZapiszDane;
import org.testng.annotations.Test;

import java.util.Arrays;

public class SuEdytorZleceniaTest extends Konfig {

    @Test (priority = 9, testName = "edycja zleceń su edytor", groups= {"kat1"})
    public void metodaEdytorZleceniaSU() throws Exception {

        Methods shr = new Methods(driver);
        Breadcrumbs bread = new Breadcrumbs(driver);
        Buttons but = new Buttons(driver);
        FiltrySzukajZlecenie fz = new FiltrySzukajZlecenie(driver);
        ListOfWyszukiwanie low = new ListOfWyszukiwanie(driver);
        DaneSuEdytorZlecen dt = new DaneSuEdytorZlecen();
        ZapiszDane zd = ZapiszDane.getInstance();

        extent=raport.createTest("Edycja Zleceń przez Su Edytor");
        extent.info("Scenariusz - edycja zleceń su-edytor");

        Konteksty kontekst = new Konteksty(driver);
        kontekst.suEdytor();

        shr.akceptZgoda();

        Kafelki kaf = new Kafelki(driver);
        kaf.enterKafelekZleceniaTestu();

        ZleceniaTestuPage ztp = new ZleceniaTestuPage(driver);
/*        but.clickWyczyscKryteriaWyszukiwania();
        ztp.losujFiltr();
        but.clickSzukaj();
        extent.warning("Sprawdź wylosowanie "+zd.getInfo()+" to Id zlecenia "+low.listOfIdZlecen(), JustScreen.doFullScreen(driver,"check-filtr-su-edit-zlecenie.png"));

        fz.szukajOnlyByIdZlecenia(dt.getFiltrIdZlecenia());
        but.clickFirstArrow();
        but.clickPodglad();
        extent.warning("Sprawdź podgląd zlecenia",JustScreen.doFullScreen(driver,"podglad-zlecenia.png"));

        bread.breadcrumbsZlecenia();
*/
        fz.szukajOnlyByIdZlecenia(dt.getFiltrIdZlecenia());
        but.clickFirstArrow();
        but.clickEdit();


        Su_EditZlecenieTestuPage eztp = new Su_EditZlecenieTestuPage(driver);
        extent.warning("Sprawdź zmianę danych osoby i adresu, tablica przed zmianami: " + Arrays.toString(eztp.getTablica()));
        extent.warning("Zmiana id na "+dt.getIdOsoby());
        eztp.changeIdOsoby(dt.getIdOsoby());
        extent.warning("Tablica po zmianach: " + Arrays.toString(eztp.getTablica()));
        eztp.zapiszWithCommentValid();

        // ---- dane identyfikacyjne
        eztp.checkDataZlecenia(dt.getDataZlecenia());
        eztp.checkStatusZlecenia(dt.getStatusZlecenia());
        eztp.checkCito(dt.getCito());
        eztp.checkHis(dt.getHis());

        // ---- dane podstawowe
        eztp.checkImiePacjenta(dt.getImiePacjenta());
        eztp.checkNazwiskoPacjenta(dt.getNazwiskoPacjenta());
        eztp.checkPesel(dt.getPesel());
        eztp.checkNrDok(dt.getNrDok());
        eztp.checkZawod(dt.getZawod());
        eztp.checkNrTelPacjenta(dt.getNrTel());

        // ---- dane adresowe
        eztp.checkDodatkoweInfo(dt.getDodatkoweInfo());
        eztp.checkNrLokalu(dt.getNrLokalu());
        eztp.checkNrBudynku(dt.getNrBudynku());
        eztp.checkKodPocztowy(dt.getKodPocztowy());
        eztp.checkAdres(dt.getWojew(),dt.getPowiat(),dt.getGmina(),dt.getMiasto(),dt.getUlica(),dt.getNrBudynku(),dt.getNrLokalu(),dt.getKodPocztowy());

        // ---- dane zlecenia
        eztp.checkTypTestu(dt.getTypTestu());
        eztp.checkZrodloFinansowania(dt.getZrodloFinans());
        eztp.checkZrodloTestu(dt.getZrodloTestu());
        eztp.checkPrzyczynaTestu(dt.getPrzyczynaTestu());
        eztp.checkStanPacjenta(dt.getStanPacjenta());
        eztp.checkKodKreskowy(dt.getKodKreskowy());
        eztp.checkSugerowanaData(dt.getSugerowanaData());
        eztp.checkWidocznePM(dt.getWidocznePm());
        eztp.checkPotrzebaKaretki(dt.getPotrzebaKaretki());
        eztp.checkWyslanoKaretke(dt.getWyslanoKaretke());
        eztp.checkPunktPobran(dt.getPunktPobran());


        // ---- Dane podmiotu zlecającego
        extent.warning("Widoczność danych podmiotu zlecającego "+Arrays.toString(eztp.getTablicaDanePodmiotu()));


        // ---- dane zlecającego
        eztp.checkImieZlecajacego(dt.getImieZlecajacego());
        eztp.checkNazwiskoZlecajacego(dt.getNazwiskoZlecajacego());
        eztp.checkNrTelZlecajacego(dt.getTelZlecajacego());


        // ---- dane wprowadzającego
        eztp.checkImieWprowadzajacego(dt.getImieWprowadzajacego());
        eztp.checkNazwiskoWprowadzajacego(dt.getNazwiskoWprowadzajacego());
        eztp.checkJednostkaWprowadzajacego(dt.getJednostkaWprowadzajacego());


        // ---- dane lekarza
        eztp.checkImieLekarza(dt.getImieLekarza());
        eztp.checkNazwiskoLekarza(dt.getNazwiskoLekarza());
        eztp.checkNPWZ(dt.getNpwz());
        eztp.checkNrTelLekarza(dt.getTelefonLekarza());


        // ---- logistyka
        eztp.checkLaboratorium(dt.getLab());

        // ---- laboratorium
        eztp.checkDataPobrania(dt.getDataPobrania());
        eztp.checkNrProbki(dt.getNrProbki());
        eztp.checkRodzajMaterialu(dt.getRodzajMaterialu());
        eztp.checkDataDostarczenia(dt.getDataDostarczenia());
        eztp.checkNazwaTestu(dt.getNazwaTestu());
        eztp.checkDataWyniku(dt.getDataWyniku());
        eztp.checkWynik(dt.getWynik());
        eztp.checkPochodzenieTestu(dt.getPochodzenieTestu());
        eztp.checkKomentarzStatusu(dt.getKomentarzStatusu());


        // todo weryfikacja sekcji Zmiany zlecenia

    }
}
