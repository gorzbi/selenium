package Pages.Su_Edytor;

import Pages.Shared.Methods;
import Tools.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;

public class Su_EditZlecenieTestuPage {

    private WebDriver driver;
    private Methods shr;

    public Su_EditZlecenieTestuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
    }

    // ---- dane identyfikacyjne

    @FindBy (id = "su_ordering_a_test_personSearchBy")
    private WebElement szukajOsobaAtrybutSelect;

    @FindBy (id = "personSearchBy_value")
    private WebElement atrybutValue;

    @FindBy (id = "su_ordering_a_test_orderedOn")
    private WebElement dataZlecenia;

    @FindBy (id = "su_ordering_a_test_status")
    private WebElement statusZlecenia;

    @FindBy (id = "su_ordering_a_test_commission_cito")
    private WebElement cito;

    @FindBy (id = "su_ordering_a_test_commission_hisId")
    private WebElement idHis;


    // ---- dane podstawowe

    @FindBy (id = "su_ordering_a_test_person")
    private WebElement idOsoby;

    @FindBy (id = "su_ordering_a_test_personData_nameO")
    private WebElement imiePacjenta;

    @FindBy (id = "su_ordering_a_test_personData_surnameO")
    private WebElement nazwiskoPacjenta;

    @FindBy (id = "su_ordering_a_test_personData_peselO")
    private WebElement pesel;

    @FindBy (id = "su_ordering_a_test_personData_documentNumberO")
    private WebElement nrDokumentu;

    @FindBy (id = "su_ordering_a_test_personData_medicalProfessionO")
    private WebElement zawod;

    @FindBy (id = "su_ordering_a_test_personData_phone1O")
    private WebElement nrTelPacjenta;


    // ---- dane adresowe

    @FindBy (id = "voivodeship_select")
    private WebElement wojewodztwo;

    @FindBy (id = "district_select")
    private WebElement powiat;

    @FindBy (id = "commune_select")
    private WebElement gmina;

    @FindBy (id = "place_select")
    private WebElement miasto;

    @FindBy (id = "street")
    private WebElement ulica;

    @FindBy (id = "houseNo")
    private WebElement nrBudynku;

    @FindBy (id = "apartmentNo")
    private WebElement nrLokalu;

    @FindBy (id = "zipCode")
    private WebElement kodPocztowy;

    @FindBy (id = "additionalInfo")
    private WebElement dodatkoweInfo;


    // ---- dane zlecenia testu

    @FindBy (id = "su_ordering_a_test_type")
    private WebElement typTestu;

    @FindBy (id = "su_ordering_a_test_sourceOfFunding")
    private WebElement zrodloFinansowania;

    @FindBy (id = "su_ordering_a_test_orderingSource")
    private WebElement zrodloTestu;

    @FindBy (id = "su_ordering_a_test_testReason")
    private WebElement przyczynaTestu;

    @FindBy (id = "su_ordering_a_test_personState")
    private WebElement stanPacjenta;

    @FindBy (id = "su_ordering_a_test_barCode")
    private WebElement kodKreskowy;

    @FindBy (id = "su_ordering_a_test_suggestedDraftDate")
    private WebElement sugerowanaData;

    @FindBy (id = "su_ordering_a_test_visibleByPm")
    private WebElement zlecenieWidocznePm;

    @FindBy (id = "su_ordering_a_test_immobilePatient")
    private WebElement potrzebaKaretki;

    @FindBy (id = "su_ordering_a_test_ambulanceSent")
    private WebElement wyslanoKaretke;

    @FindBy (id = "su_ordering_a_test_mobilePoint")
    private WebElement punktPobran;


    // ---- dane podmiotu zlecającego
    @FindBy (xpath = "//span[@data-for='Nazwa']")
    private WebElement nazwaPodmiotu;

    @FindBy (xpath = "//span[@data-for='Adres']")
    private WebElement adresPodmiotu;

    @FindBy (xpath = "//span[@data-for='Numer księgi rejestrowej']")
    private WebElement nrKsiegiPodmiotu;

    @FindBy (xpath = "//span[@data-for='REGON']")
    private WebElement regonPodmiotu;

    @FindBy (xpath = "//span[@data-for='EWP_ID']")
    private WebElement ewpIdPodmiotu;

    @FindBy (xpath = "//span[@data-for='Email']")
    private WebElement emailPodmiotu;

    @FindBy (xpath = "//span[@data-for='Nr telefonu']")
    private WebElement telefonPodmiotu;


    // ---- dane Zlecającego

    @FindBy (id = "su_ordering_a_test_orderedByFirstName")
    private WebElement imieZlecajacego;

    @FindBy (id = "su_ordering_a_test_orderedByLastName")
    private WebElement nazwiskoZlecajacego;

    @FindBy (id = "su_ordering_a_test_orderedByPhone")
    private WebElement nrTelZlecajacego;

    // ---- dane Wprowadzającego
    @FindBy (id = "su_ordering_a_test_addedByUserFirstName")
    private WebElement imieWprowadzajacego;

    @FindBy (id = "su_ordering_a_test_addedByUserLastName")
    private WebElement nazwiskoWprowadzajacego;

    @FindBy (id = "su_ordering_a_test_userOrganizationalUnit")
    private WebElement jednostkaWprowadzajacego;


    // ---- dane lekarza

    @FindBy (id = "su_ordering_a_test_consultantFirstName")
    private WebElement imieLekarza;

    @FindBy (id = "su_ordering_a_test_consultantLastName")
    private WebElement nazwiskoLekarza;

    @FindBy (id = "su_ordering_a_test_consultantPwzNumber")
    private WebElement npwz;

    @FindBy (id = "su_ordering_a_test_consultantPhoneNumber")
    private WebElement nrTelLekarza;


    // ---- Logistyka

    @FindBy (id = "su_ordering_a_test_lab")
    private WebElement laboratorium;

    // ---- dane laboratorium

    @FindBy (id = "su_ordering_a_test_dateSampleReceipt")
    private WebElement dataPobrania;

    @FindBy (id = "su_ordering_a_test_laboratorySampleNumber")
    private WebElement nrProbki;

    @FindBy (id = "su_ordering_a_test_material")
    private WebElement rodzajMaterialu;

    @FindBy (id = "su_ordering_a_test_dateDeliveryOfTheLaboratory")
    private WebElement dataDostarczenia;

    @FindBy (id = "su_ordering_a_test_antigenTest")
    private WebElement nazwaTestu;

    @FindBy (id = "su_ordering_a_test_dateResult")
    private WebElement dataWyniku;

    @FindBy (id = "su_ordering_a_test_result")
    private WebElement wynik;

    @FindBy (id = "su_ordering_a_test_sourceOfTest")
    private WebElement pochodzenieTestu;

    @FindBy (id = "su_ordering_a_test_statusComment")
    private WebElement komentarzStatusu;

    // ---- komentarz

    @FindBy (id = "su_ordering_a_test_comment")
    private WebElement komentarz;

    @FindBy (id = "su_ordering_a_test_comment_error")
    private WebElement walidationKomentarz;

    @FindBy (id = "action-save")
    private WebElement zapisz;

    public void zapiszWithCommentValid() {
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkValidKomentDisplayed() {
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    // ---- dane identyfikacyjne

    public void changeIdOsoby (String id) {
        atrybutValue.click();
        atrybutValue.sendKeys(id);
        shr.intListChoice(1);
    }

    public String[] getTablica() {
        String [] array = new String[] {getIdOsoby(), getImiePacjenta(), getNazwiskoPacjenta(), getPesel(), getNrDok(), getZawod(), getNrTelPacjenta(), getWojewodztwo(), getPowiat(), getGmina(), getMiasto(), getUlica(), getNrBudynku(), getNrLokalu(), getKodPocztowy(), getDodatkoweInfo()};
        System.out.println(Arrays.toString(array));
        return array;
    }

    public void checkChangePerson(String id) {
        boolean different = false;
        String [] przed = getTablica();
        changeIdOsoby(id);
        Wait.waitForNotEmptyElement(driver, kodPocztowy);
        String [] po = getTablica();
        for (int i = 0; i < przed.length; i++) {
            if (przed[i] != po[i]) {
                different = true;
            }
        }
    }


    public void setOsobyPoAtrybucie (String atrybut, String value) {
        szukajOsobaAtrybutSelect.click();
        shr.stringListChoice(atrybut);
        atrybutValue.sendKeys(value);
    }

    public void checkSzukajOsobyPoAtrybucie (String atrybut, String value) {
        setOsobyPoAtrybucie(atrybut, value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setDataZlecenia (String data) {
        dataZlecenia.click();
        shr.clearPole(dataZlecenia);
        dataZlecenia.sendKeys(data);
    }

    public void checkDataZlecenia (String data) {
        setDataZlecenia(data);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setStatusZlecenia (String status) {
        statusZlecenia.click();
        shr.stringListChoice(status);
    }

    public void checkStatusZlecenia (String status) {
        setStatusZlecenia(status);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setCito (String value) {
        cito.click();
        shr.stringListChoice(value);
    }

    public void checkCito (String value) {
        setCito(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setHis (String value) {
        idHis.clear();
        idHis.sendKeys(value);
    }

    public void checkHis (String value) {
        setHis(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane podstawowe

    public String getIdOsoby () {
        String id = idOsoby.getAttribute("value");
        System.out.println("ID Osoby to -> "+id);
        return id;
    }

    public String getImiePacjenta() {
        return imiePacjenta.getAttribute("value");
    }

    public void setImiePacjenta (String imie) {
        imiePacjenta.clear();
        imiePacjenta.sendKeys(imie);
    }

    public void checkImiePacjenta (String imie) {
        setImiePacjenta(imie);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getNazwiskoPacjenta() {
        return nazwiskoPacjenta.getAttribute("value");
    }

    public void setNazwiskoPacjenta (String nazwisko) {
        nazwiskoPacjenta.clear();
        nazwiskoPacjenta.sendKeys(nazwisko);
    }

    public void checkNazwiskoPacjenta (String nazwisko) {
        setNazwiskoPacjenta(nazwisko);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getPesel() {
        return pesel.getAttribute("value");
    }

    public void setPesel (String value) {
        pesel.clear();
        pesel.sendKeys(value);
    }

    public void checkPesel (String value) {
        setPesel(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getNrDok() {
        return nrDokumentu.getAttribute("value");
    }

    public void setNrDok (String value) {
        nrDokumentu.clear();
        nrDokumentu.sendKeys(value);
    }

    public void checkNrDok (String value) {
        setNrDok(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getZawod() {
        return zawod.getAttribute("value");
    }

    public void setZawod (String value) {
        zawod.click();
        shr.stringListChoice(value);
    }

    public void checkZawod (String value) {
        setZawod(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getNrTelPacjenta() {
        return nrTelPacjenta.getAttribute("value");
    }

    public void setNrTelPacjenta (String value) {
        nrTelPacjenta.clear();
        nrTelPacjenta.sendKeys(value);
    }

    public void checkNrTelPacjenta (String value) {
        setNrTelPacjenta(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane adresowe

    public String getWojewodztwo() {
        return wojewodztwo.getAttribute("value");
    }

    public void setWojewodztwo (String value) {
        wojewodztwo.click();
        shr.stringListChoice(value);
    }

    public String getPowiat() {
        return powiat.getAttribute("value");
    }

    public void setPowiat (String value) {
        powiat.click();
        shr.stringListChoice(value);
    }

    public String getGmina() {
        return gmina.getAttribute("value");
    }

    public void setGmina (String value) {
        gmina.click();
        shr.stringListChoice(value);
    }

    public String getMiasto() {
        return miasto.getAttribute("value");
    }

    public void setMiasto (String value) {
        miasto.click();
        shr.stringListChoice(value);
    }

    public String getUlica() {
        return ulica.getAttribute("value");
    }

    public void setUlica (String value) {
        ulica.clear();
        ulica.sendKeys(value);
    }

    public void checkAdres (String wojew, String powiat, String gmina, String miasto, String ulica, String budynek, String lokal, String kod) {
        setWojewodztwo(wojew);
        setPowiat(powiat);
        setGmina(gmina);
        setMiasto(miasto);
        setUlica(ulica);
        setNrBudynku(budynek);
        setNrLokalu(lokal);
        setKodPocztowy(kod);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getNrBudynku() {
        return nrBudynku.getAttribute("value");
    }

    public void setNrBudynku (String value) {
        nrBudynku.clear();
        nrBudynku.sendKeys(value);
    }

    public void checkNrBudynku (String value) {
        setNrBudynku(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getNrLokalu() {
        return nrLokalu.getAttribute("value");
    }

    public void setNrLokalu (String value) {
        nrLokalu.clear();
        nrLokalu.sendKeys(value);
    }

    public void checkNrLokalu (String value) {
        setNrLokalu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getKodPocztowy() {
        return kodPocztowy.getAttribute("value");
    }

    public void setKodPocztowy (String value) {
        kodPocztowy.clear();
        kodPocztowy.sendKeys(value);
    }

    public void checkKodPocztowy (String value) {
        setKodPocztowy(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public String getDodatkoweInfo() {
        return dodatkoweInfo.getAttribute("value");
    }

    public void setDodatkoweInfo (String value) {
        dodatkoweInfo.clear();
        dodatkoweInfo.sendKeys(value);
    }

    public void checkDodatkoweInfo (String value) {
        setDodatkoweInfo(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane zlecenia testu

    public void setTypTestu (String typ) {
        typTestu.click();
        shr.stringListChoice(typ);
    }
    public void checkTypTestu (String typ) {
        setTypTestu(typ);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setZrodloFinansowania (String zrodlo) {
        zrodloFinansowania.click();
        shr.stringListChoice(zrodlo);
    }

    public void checkZrodloFinansowania (String zrodlo) {
        setZrodloFinansowania(zrodlo);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setZrodloTestu (String zrodlo) {
        zrodloTestu.click();
        shr.stringListChoice(zrodlo);
    }

    public void checkZrodloTestu (String value) {
        setZrodloTestu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setPrzyczynaTestu (String value) {
        przyczynaTestu.click();
        shr.stringListChoice(value);
    }

    public void checkPrzyczynaTestu (String value) {
        setPrzyczynaTestu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setStanPacjenta(String value) {
        stanPacjenta.click();
        shr.stringListChoice(value);
    }
    public void checkStanPacjenta(String value) {
        setStanPacjenta(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setKodKreskowy(String kod) {
        kodKreskowy.clear();
        kodKreskowy.sendKeys(kod);
    }

    public void checkKodKreskowy(String kod) {
        setKodKreskowy(kod);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setSugerowanaData(String data) {
        sugerowanaData.click();
        shr.clearPole(sugerowanaData);
        sugerowanaData.sendKeys(data);
    }

    public void checkSugerowanaData(String data) {
        setSugerowanaData(data);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setWidocznePM(String value) {
        zlecenieWidocznePm.click();
        shr.stringListChoice(value);
    }

    public void checkWidocznePM(String value) {
        setWidocznePM(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setPotrzebaKaretki(String value) {
        potrzebaKaretki.click();
        shr.stringListChoice(value);
    }

    public void checkPotrzebaKaretki(String value) {
        setPotrzebaKaretki(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setWyslanoKaretke(String value) {
        wyslanoKaretke.click();
        shr.stringListChoice(value);
    }

    public void checkWyslanoKaretke(String value) {
        setWyslanoKaretke(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setPunktPobran(String value) {
        punktPobran.click();
        shr.stringListChoice(value);
    }

    public void checkPunktPobran(String value) {
        setPunktPobran(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane podmiotu zlecającego

    public String getNazwaPodmiotu() {
        String podmiot = nazwaPodmiotu.getAttribute("textContent");
        System.out.println("Nazwa podmiotu to -> "+podmiot);
        return podmiot;
    }

    public String getAdresPodmiotu() {
        String adres = adresPodmiotu.getAttribute("textContent");
        System.out.println("Adres podmiotu to -> "+adres);
        return adres;
    }

    public String getKsiegaPodmiotu() {
        String ksiega = nrKsiegiPodmiotu.getAttribute("textContent");
        System.out.println("Nr księgi podmiotu to -> "+ksiega);
        return ksiega;
    }

    public String getRegonPodmiotu() {
        String regon = regonPodmiotu.getAttribute("textContent");
        System.out.println("Regon podmiotu to -> "+regon);
        return regon;
    }

    public String getIdPodmiotu() {
        String id = ewpIdPodmiotu.getAttribute("textContent");
        System.out.println("Adres podmiotu to -> "+id);
        return id;
    }

    public String getEmailPodmiotu() {
        String email = emailPodmiotu.getAttribute("textContent");
        System.out.println("Adres podmiotu to -> "+email);
        return email;
    }

    public String getNrTelPodmiotu() {
        String telefon = telefonPodmiotu.getAttribute("textContent");
        System.out.println("Adres podmiotu to -> "+telefon);
        return telefon;
    }

    public String [] getTablicaDanePodmiotu() {
        String [] array = new String[] {getNazwaPodmiotu(),getAdresPodmiotu(),getKsiegaPodmiotu(),getRegonPodmiotu(),getIdPodmiotu(),getEmailPodmiotu(),getNrTelPodmiotu()};
        System.out.println("Dane podmiotu zlecającego "+Arrays.toString(array));
        return array;
    }

    // ---- dane zlecającego

    public void setImieZlecajacego (String imie) {
        imieZlecajacego.clear();
        imieZlecajacego.sendKeys(imie);
    }

    public void checkImieZlecajacego (String imie) {
        setImieZlecajacego(imie);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNazwiskoZlecajacego (String nazwisko) {
        nazwiskoZlecajacego.clear();
        nazwiskoZlecajacego.sendKeys(nazwisko);
    }

    public void checkNazwiskoZlecajacego (String nazwisko) {
        setNazwiskoZlecajacego(nazwisko);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNrTelZlecajacegoZlecajacego (String value) {
        nrTelZlecajacego.clear();
        nrTelZlecajacego.sendKeys(value);
    }

    public void checkNrTelZlecajacego (String value) {
        setNrTelZlecajacegoZlecajacego(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane wprowadzającego

    public void setImieWprowadzajacego (String imie) {
        imieWprowadzajacego.clear();
        imieWprowadzajacego.sendKeys(imie);
    }

    public void checkImieWprowadzajacego (String imie) {
        setImieWprowadzajacego(imie);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNazwiskoWprowadzajacego (String nazwisko) {
        nazwiskoWprowadzajacego.clear();
        nazwiskoWprowadzajacego.sendKeys(nazwisko);
    }

    public void checkNazwiskoWprowadzajacego (String nazwisko) {
        setNazwiskoWprowadzajacego(nazwisko);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setJednostkaWprowadzajacego (String value) {
        jednostkaWprowadzajacego.clear();
        jednostkaWprowadzajacego.sendKeys(value);
    }

    public void checkJednostkaWprowadzajacego (String value) {
        setJednostkaWprowadzajacego(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- dane lekarza

    public void setImieLekarza(String imie) {
        imieLekarza.clear();
        imieLekarza.sendKeys(imie);
    }

    public void checkImieLekarza (String value) {
        setImieLekarza(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNazwiskoLekarza(String nazwisko) {
        nazwiskoLekarza.clear();
        nazwiskoLekarza.sendKeys(nazwisko);
    }

    public void checkNazwiskoLekarza (String value) {
        setNazwiskoLekarza(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNPWZ(String value) {
        npwz.clear();
        npwz.sendKeys(value);
    }

    public void checkNPWZ (String value) {
        setNPWZ(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNrTelLekarza(String value) {
        nrTelLekarza.clear();
        nrTelLekarza.sendKeys(value);
    }

    public void checkNrTelLekarza (String value) {
        setNrTelLekarza(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }


    // ---- logistyka

    public String getLaboratorium(String value) {
        String lab = laboratorium.getAttribute("textContent");
        return lab;
    }

    public void setLaboratorium(String value) {
        laboratorium.click();
        shr.stringListChoice(value);
    }

    public void checkLaboratorium (String value) {
        setLaboratorium(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }



    // ---- laboratorium

    public void setDataPobrania(String data) {
        dataPobrania.click();
        shr.clearPole(dataPobrania);
        dataPobrania.sendKeys(data);
    }

    public void checkDataPobrania (String value) {
        setDataPobrania(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNrProbki(String value) {
        nrProbki.clear();
        nrProbki.sendKeys(value);
    }

    public void checkNrProbki (String value) {
        setNrProbki(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setRodzajMaterialu(String value) {
        rodzajMaterialu.click();
        shr.stringListChoice(value);
    }

    public void checkRodzajMaterialu(String value) {
        setRodzajMaterialu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setDataDostarczenia(String data) {
        dataDostarczenia.click();
        shr.clearPole(dataDostarczenia);
        dataDostarczenia.sendKeys(data);
    }

    public void checkDataDostarczenia (String value) {
        setDataDostarczenia(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setNazwaTestu(String nazwa) {
        nazwaTestu.click();
        shr.stringListChoice(nazwa);
    }

    public void checkNazwaTestu (String value) {
        setNazwaTestu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setDataWyniku(String data) {
        dataWyniku.click();
        shr.clearPole(dataWyniku);
        dataWyniku.sendKeys(data);
    }

    public void checkDataWyniku (String value) {
        setDataWyniku(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setWynik(String value) {
        wynik.click();
        shr.stringListChoice(value);
    }

    public void checkWynik (String value) {
        setWynik(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setPochodzenieTestu(String value) {
        pochodzenieTestu.click();
        shr.stringListChoice(value);
    }

    public void checkPochodzenieTestu (String value) {
        setPochodzenieTestu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

    public void setKomentarzStatusu(String value) {
        komentarzStatusu.click();
        shr.stringListChoice(value);
    }

    public void checkKomentarzStatusu (String value) {
        setKomentarzStatusu(value);
        zapisz.click();
        checkValidKomentDisplayed();
    }

}
