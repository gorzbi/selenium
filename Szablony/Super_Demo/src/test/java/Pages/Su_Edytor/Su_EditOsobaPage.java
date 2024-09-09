package Pages.Su_Edytor;

import Pages.Shared.Methods;
import Tools.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Su_EditOsobaPage {

    private WebDriver driver;
    private Methods shr;

    public Su_EditOsobaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
    }

    // ---- dane podstawowe

    @FindBy (id = "historySelectTypePerson")
    private WebElement historiaZmianOsoba;

    @FindBy (id = "su_person_name")
    private WebElement imie;

    @FindBy (id = "su_person_surname")
    private WebElement nazwisko;

    @FindBy (id = "action-save")
    private WebElement zapisz;

    @FindBy (id = "su_person_pesel")
    private WebElement pesel;

    @FindBy (id = "su_person_sex")
    private WebElement plec;

    @FindBy (id = "su_person_dateOfBirth")
    private WebElement dataUrodzenia;

    @FindBy (id = "su_person_nationality")
    private WebElement obywatelstwo;

    @FindBy (id = "su_person_documentType")
    private WebElement typDokumentu;

    @FindBy (id = "su_person_countryOfDocument")
    private WebElement krajDokumentu;

    @FindBy (id = "su_person_documentNumber")
    private WebElement nrDokumentu;

    @FindBy (id = "su_person_phone")
    private WebElement tel;

    @FindBy (id = "su_person_phone1")
    private WebElement tel1;

    @FindBy (id = "su_person_phone2")
    private WebElement tel2;

    @FindBy (id = "su_person_phone3")
    private WebElement tel3;

    @FindBy (id = "su_person_email")
    private WebElement email;

    @FindBy (id = "su_person_contactPhone")
    private WebElement nrTelGospodarza;

    @FindBy (id = "su_person_medicalProfession")
    private WebElement zawod;

    @FindBy (id = "su_person_death")
    private WebElement zgon;

    @FindBy (id = "su_person_deathDetails_dateOfDeath")
    private WebElement dataZgonu;
    @FindBy (id = "su_person_deathDetails_dateOfDeath_error")
    private WebElement validKomentDataZgonu;

    @FindBy (id = "su_person_deathDetails_initialCause")
    private WebElement przyczynaWyjsciowaZgonu;
    @FindBy (id = "su_person_deathDetails_initialCause_error")
    private WebElement validKomentPrzyczynaWyjsciowaZgonu;

    @FindBy (id = "su_person_deathDetails_secondaryCause")
    private WebElement przyczynaWtornaZgonu;
    @FindBy (id = "su_person_deathDetails_secondaryCause_error")
    private WebElement validKomentPrzyczynaWtornaZgonu;

    @FindBy (id = "su_person_deathDetails_immediateCause")
    private WebElement przyczynaBezposredniaZgonu;
    @FindBy (id = "su_person_deathDetails_immediateCause_error")
    private WebElement validKomentPrzyczynaBezposredniaZgonu;

    @FindBy (id = "su_person_deathDetails_comorbidities")
    private WebElement chorobyWspoistniejace;

    @FindBy (id = "su_person_introducingUserTeryt")
    private WebElement uzytkownikWprowadzil;


    // ---- dane adresowe

    @FindBy (id = "historySelectTypeAddress")
    private WebElement historiaZmianAdres;

    @FindBy (id = "voivodeship_select")
    private WebElement wojewodztwo;

    @FindBy (id = "district_select")
    private WebElement powiat;
    @FindBy (id = "district_select_error")
    private WebElement validKomentPowiat;

    @FindBy (id = "commune_select")
    private WebElement gmina;
    @FindBy (id = "commune_select_error")
    private WebElement validKomentGmina;

    @FindBy (id = "place_select")
    private WebElement miejscowosc;
    @FindBy (id = "place_select_error")
    private WebElement validKomentMiejscowosc;

    @FindBy (id = "street")
    private WebElement ulica;

    @FindBy (id = "houseNo")
    private WebElement nrDomu;
    @FindBy (id = "houseNo_error")
    private WebElement validKomentNrDomu;

    @FindBy (id = "apartmentNo")
    private WebElement nrLokalu;

    @FindBy (id = "zipCode")
    private WebElement kodPocztowy;
    @FindBy (id = "zipCode_error")
    private WebElement validKomentKodPocztowy;

    @FindBy (id = "su_person_extendedPersonAddress_additionalInfo")
    private WebElement dodInfo;

    @FindBy (id = "su_person_extendedPersonAddress_definedAddressId")
    private WebElement idDicZdefiniowaneAdresy;


    // ---- kwarantanna

    @FindBy (id = "su_person_quarantines_0_status")
    private WebElement statusKw;

    @FindBy (id = "su_person_quarantines_0_decisionNumber")
    private WebElement nrDecyzji;

    @FindBy (id = "su_person_quarantines_0_type")
    private WebElement typKw;

    @FindBy (id = "su_person_quarantines_0_dateFrom")
    private WebElement dataKwOd;

    @FindBy (id = "su_person_quarantines_0_dateTo")
    private WebElement dataKwDo;

    @FindBy (id = "su_person_quarantines_0_abbreviatingOrderId")
    private WebElement idZleceniaSkracajacego;
    @FindBy (id = "su_person_quarantines_0_abbreviatingOrderId_error")
    private WebElement validKomentIdZlecSkrac;

    @FindBy (id = "su_person_quarantines_0_abbreviatingResultDate")
    private WebElement dataWynikuSkracajacego;

    @FindBy (id = "su_person_quarantines_0_extendingOrderId")
    private WebElement idZleceniaWydluzajacego;
    @FindBy (id = "su_person_quarantines_0_extendingOrderId_error")
    private WebElement validKomentIdZleceniaWydluz;

    @FindBy (id = "su_person_quarantines_0_orderingPerson")
    private WebElement zlecOsobaId;
    @FindBy (id = "su_person_quarantines_0_orderingPerson_error")
    private WebElement validKomentZlecOsobaId;

    @FindBy (id = "su_person_quarantines_0_orderingPersonVerify")
    private WebElement zlecOsobaVer;

    @FindBy (id = "su_person_quarantines_0_office")
    private WebElement gabinetId;
    @FindBy (id = "su_person_quarantines_0_office_error")
    private WebElement validKomentGabinetId;

    @FindBy (id = "su_person_quarantines_0_referenceSourceId")
    private WebElement zrKwRefId;

    @FindBy (id = "su_person_quarantines_0_idQuarantineSource")
    private WebElement idKwZr;
    @FindBy (id = "su_person_quarantines_0_idQuarantineSource_error")
    private WebElement validKomentIdKwZrodla;

    @FindBy (id = "su_person_quarantines_0_comment")
    private WebElement komentarzKw;


    // ---- karta lokalizacyjna

    @FindBy (id = "su_person_locationCards_0_localId")
    private WebElement nrKartyLokal;

    @FindBy (id = "su_person_locationCards_0_vehicleRegistrationNumber")
    private WebElement nrRejPojazdu;

    @FindBy (id = "su_person_locationCards_0_borderCrossing")
    private WebElement przejscieGraniczne;

    @FindBy (id = "su_person_locationCards_0_arriveDate")
    private WebElement dataPrzekroczeniaGranicy;

    @FindBy (id = "su_person_locationCards_0_arriveCountry")
    private WebElement panstwoPrzyjechano;

    @FindBy (id = "su_person_locationCards_0_status")
    private WebElement status;


    @FindBy (id = "su_person_comment")
    private WebElement komentarz;

    @FindBy (id = "su_person_comment_error")
    private WebElement walidationKomentarz;

    @FindBy (xpath = "//input[@class='btn btn-primary']")
    private WebElement takZapiszZmiany;

    @FindBy (xpath = "//div[@class='alert alert-success']")
    private WebElement komunikatDaneZapisane;



    public void checkEditImie(String value) {
        imie.clear();
        imie.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNazwisko(String value) {
        nazwisko.clear();
        nazwisko.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditPesel(String value) {
        shr.clearPole(pesel);
        pesel.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditPlec(String value) {
        plec.click();
        shr.stringListChoice(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDataUrodzenia (String value) {
        shr.clearPole(dataUrodzenia);
        dataUrodzenia.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditObywatelstwo (String value) {
        obywatelstwo.click();
        shr.stringListChoice(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditTypDok(String value) {
        typDokumentu.click();
        shr.stringListChoice(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditKrajpDok(String value) {
        krajDokumentu.click();
        shr.stringListChoice(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrpDok(String value) {
        nrDokumentu.clear();
        nrDokumentu.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrTel(String value) {
        tel.clear();
        tel.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrTel1(String value) {
        tel1.clear();
        tel1.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrTel2(String value) {
        tel2.clear();
        tel2.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrTel3(String value) {
        tel3.clear();
        tel3.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditEmail(String value) {
        email.clear();
        email.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrTelGospodarza(String value) {
        nrTelGospodarza.clear();
        nrTelGospodarza.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditZawod(String value) {
        zawod.click();
        shr.stringListChoice(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditZgonYes(String value) {
        zgon.click();
        shr.stringListChoice(value);
        zapisz.click();
        Assert.assertTrue(dataZgonu.isEnabled());
        Assert.assertTrue(validKomentDataZgonu.isDisplayed());

        Assert.assertTrue(przyczynaWyjsciowaZgonu.isEnabled());
        Assert.assertTrue(validKomentPrzyczynaWyjsciowaZgonu.isDisplayed());

        Assert.assertTrue(przyczynaWtornaZgonu.isEnabled());
        Assert.assertTrue(validKomentPrzyczynaWtornaZgonu.isDisplayed());

        Assert.assertTrue(przyczynaBezposredniaZgonu.isEnabled());
        Assert.assertTrue(validKomentPrzyczynaBezposredniaZgonu.isDisplayed());

        Assert.assertTrue(chorobyWspoistniejace.isEnabled());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());

        driver.navigate().refresh();
    }

    public void checkEditUserWprowadzil(String value) {
        uzytkownikWprowadzil.clear();
        uzytkownikWprowadzil.sendKeys(value);
        zapisz.click();
        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void getDataOsoba() {
        String imieNow = imie.getAttribute("value");
        String nazwiskoNow = nazwisko.getAttribute("value");
        String peselNow = pesel.getAttribute("value");
        String plecNow = plec.getAttribute("value");
        String dataurNow = dataUrodzenia.getText();
        String obywatelNow = obywatelstwo.getAttribute("value");
        String typDokNow = typDokumentu.getAttribute("value");
        String krajDokNow = krajDokumentu.getAttribute("value");
        String nrDokNow = nrDokumentu.getAttribute("value");
        String telNow = tel.getAttribute("value");
        String emailNow = email.getAttribute("value");
        String telKontaktNow = nrTelGospodarza.getAttribute("value");
        String zawodNow = zawod.getAttribute("value");
    }

    public void checkChangeHistoryOsoba(String data) {
        String imieNow = imie.getAttribute("value");
        String nazwiskoNow = nazwisko.getAttribute("value");
        String peselNow = pesel.getAttribute("value");
        String plecNow = plec.getAttribute("value");
        String dataurNow = dataUrodzenia.getText();
        String obywatelNow = obywatelstwo.getAttribute("value");
        String typDokNow = typDokumentu.getAttribute("value");
        String krajDokNow = krajDokumentu.getAttribute("value");
        String nrDokNow = nrDokumentu.getAttribute("value");
        String telNow = tel.getAttribute("value");
        String emailNow = email.getAttribute("value");
        String telKontaktNow = nrTelGospodarza.getAttribute("value");
        String zawodNow = zawod.getAttribute("value");

        historiaZmianOsoba.click();
        shr.stringListChoice(data);

        System.out.println("Imię: "+imieNow+ " -> "+imie.getAttribute("value"));
        Assert.assertNotEquals(imieNow,imie.getAttribute("value"));
        System.out.println("Nazwisko: "+nazwiskoNow+ " -> "+nazwisko.getAttribute("value"));
        Assert.assertNotEquals(nazwiskoNow,nazwisko.getAttribute("value"));
/*        System.out.println("Pesel: "+peselNow+ " -> "+pesel.getAttribute("value"));
        Assert.assertNotEquals(peselNow,pesel.getAttribute("value"));
        System.out.println("Płeć: "+plecNow+ " -> "+plec.getAttribute("value"));
        Assert.assertNotEquals(plecNow,plec.getAttribute("value"));
        System.out.println("Data ur: "+dataurNow+ " -> "+dataUrodzenia.getAttribute("value"));
        Assert.assertNotEquals(dataurNow,dataUrodzenia.getAttribute("value"));*/
        System.out.println("Obywatelstwo: "+obywatelNow+ " -> "+obywatelstwo.getAttribute("value"));
        Assert.assertNotEquals(obywatelNow,obywatelstwo.getAttribute("value"));
        System.out.println("Typ dokumentu: "+typDokNow+ " -> "+typDokumentu.getAttribute("value"));
        Assert.assertNotEquals(typDokNow,typDokumentu.getAttribute("value"));
        System.out.println("Kraj dokumentu: "+krajDokNow+ " -> "+krajDokumentu.getAttribute("value"));
        Assert.assertNotEquals(krajDokNow,krajDokumentu.getAttribute("value"));
        System.out.println("Nr dokumentu: "+nrDokNow+ " -> "+nrDokumentu.getAttribute("value"));
        Assert.assertNotEquals(nrDokNow,nrDokumentu.getAttribute("value"));
        System.out.println("Nr tel: "+telNow+ " -> "+tel.getAttribute("value"));
        Assert.assertNotEquals(telNow,tel.getAttribute("value"));
        System.out.println("Email: "+emailNow+ " -> "+email.getAttribute("value"));
        Assert.assertNotEquals(emailNow,email.getAttribute("value"));
        System.out.println("Tel kontakt: "+telKontaktNow+ " -> "+ nrTelGospodarza.getAttribute("value"));
        Assert.assertNotEquals(telKontaktNow, nrTelGospodarza.getAttribute("value"));
        System.out.println("Zawód: "+zawodNow+ " -> "+zawod.getAttribute("value"));
        Assert.assertNotEquals(zawodNow,zawod.getAttribute("value"));
    }

    // ---- adres

    public void checkEditWojewodztwo(String wojew) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        zapisz.click();

        Assert.assertTrue(validKomentPowiat.isDisplayed());
        Assert.assertTrue(validKomentGmina.isDisplayed());
        Assert.assertTrue(validKomentMiejscowosc.isDisplayed());
        Assert.assertTrue(validKomentNrDomu.isDisplayed());
        Assert.assertTrue(validKomentKodPocztowy.isDisplayed());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditPowiat(String wojew, String pow) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        powiat.click();
        shr.stringListChoice(pow);
        zapisz.click();

        Assert.assertTrue(validKomentGmina.isDisplayed());
        Assert.assertTrue(validKomentMiejscowosc.isDisplayed());
        Assert.assertTrue(validKomentNrDomu.isDisplayed());
        Assert.assertTrue(validKomentKodPocztowy.isDisplayed());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditGmina(String wojew, String pow, String gm) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        powiat.click();
        shr.stringListChoice(pow);
        gmina.click();
        shr.stringListChoice(gm);
        zapisz.click();

        Assert.assertTrue(validKomentMiejscowosc.isDisplayed());
        Assert.assertTrue(validKomentNrDomu.isDisplayed());
        Assert.assertTrue(validKomentKodPocztowy.isDisplayed());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditMiejscowosc(String wojew, String pow, String gm, String city) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        powiat.click();
        shr.stringListChoice(pow);
        gmina.click();
        shr.stringListChoice(gm);
        miejscowosc.click();
        shr.stringListChoice(city);
        zapisz.click();

        Assert.assertTrue(validKomentNrDomu.isDisplayed());
        Assert.assertTrue(validKomentKodPocztowy.isDisplayed());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditUlica(String ul) {
        ulica.sendKeys(ul);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrDomu(String wojew, String pow, String gm, String city, String dom) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        powiat.click();
        shr.stringListChoice(pow);
        gmina.click();
        shr.stringListChoice(gm);
        miejscowosc.click();
        shr.stringListChoice(city);
        nrDomu.sendKeys(dom);
        zapisz.click();

        Assert.assertTrue(validKomentKodPocztowy.isDisplayed());

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrLokalu(String nrLok) {
        nrLokalu.sendKeys(nrLok);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditKodPocztowy(String wojew, String pow, String gm, String city, String dom, String kod) {
        wojewodztwo.click();
        shr.stringListChoice(wojew);
        powiat.click();
        shr.stringListChoice(pow);
        gmina.click();
        shr.stringListChoice(gm);
        miejscowosc.click();
        shr.stringListChoice(city);
        nrDomu.sendKeys(dom);
        kodPocztowy.sendKeys(kod);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDodInfo () {
        dodInfo.clear();
        dodInfo.sendKeys("xxx");
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditIdDicZdefAdres () {
        idDicZdefiniowaneAdresy.sendKeys("yyy");
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkChangeHistoryAdres(String data) {
        String wojewodztwoNow = wojewodztwo.getAttribute("value");
        String powiatNow = powiat.getAttribute("value");
        String gminaNow = gmina.getAttribute("value");
        String miejscowoscNow = miejscowosc.getAttribute("value");
        String ulicaNow = ulica.getAttribute("value");
        String nrDomuNow = nrDomu.getAttribute("value");
        String nrLokaluNow = nrLokalu.getAttribute("value");
        String kodPocztowyNow = kodPocztowy.getAttribute("value");
        String dodInfoNow = dodInfo.getAttribute("value");
        String idDicZdefAdresNow = idDicZdefiniowaneAdresy.getAttribute("value");

        historiaZmianAdres.click();
        shr.stringListChoice(data);
        Wait.waitForNotEmptyElement(driver,kodPocztowy);

        System.out.println("Województwo: "+wojewodztwoNow+ " -> "+wojewodztwo.getAttribute("value"));
        Assert.assertNotEquals(wojewodztwoNow,wojewodztwo.getAttribute("value"));
        System.out.println("Powiat: "+powiatNow+ " -> "+powiat.getAttribute("value"));
        Assert.assertNotEquals(powiatNow,powiat.getAttribute("value"));
        System.out.println("Gmina: "+gminaNow+ " -> "+gmina.getAttribute("value"));
        Assert.assertNotEquals(gminaNow,gmina.getAttribute("value"));
        System.out.println("Miejscowość: "+miejscowoscNow+ " -> "+miejscowosc.getAttribute("value"));
        Assert.assertNotEquals(miejscowoscNow,miejscowosc.getAttribute("value"));
        System.out.println("Ulica: "+ulicaNow+ " -> "+ulica.getAttribute("value"));
        Assert.assertNotEquals(ulicaNow,ulica.getAttribute("value"));
        System.out.println("Nr domu: "+nrDomuNow+ " -> "+nrDomu.getAttribute("value"));
        Assert.assertNotEquals(nrDomuNow,nrDomu.getAttribute("value"));
        System.out.println("Nr lokalu: "+nrLokaluNow+ " -> "+nrLokalu.getAttribute("value"));
        Assert.assertNotEquals(nrLokaluNow,nrLokalu.getAttribute("value"));
        System.out.println("Kod pocztowy: "+kodPocztowyNow+ " -> "+kodPocztowy.getAttribute("value"));
        Assert.assertNotEquals(kodPocztowyNow,kodPocztowy.getAttribute("value"));
        System.out.println("Dodatkowe info: "+dodInfoNow+ " -> "+dodInfo.getAttribute("value"));
        Assert.assertNotEquals(dodInfoNow,dodInfo.getAttribute("value"));
        //System.out.println("ID dic zdef adresy: "+idDicZdefAdresNow+ " -> "+idDicZdefiniowaneAdresy.getAttribute("value"));
        //Assert.assertNotEquals(idDicZdefAdresNow,idDicZdefiniowaneAdresy.getAttribute("value"));

    }

    // ---- kwarantanna

    public void checkEditStatusKw(String value) {
        statusKw.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrDecyzji(String value) {
        nrDecyzji.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditTypKw(String value) {
        typKw.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDataKwOd(String value) {
        shr.clearPole(dataKwOd);
        dataKwOd.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDataKwDo(String value) {
        shr.clearPole(dataKwDo);
        dataKwDo.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditIdZlecSkrac(String value, String id) {
        idZleceniaSkracajacego.clear();
        idZleceniaSkracajacego.sendKeys(value);
        Assert.assertTrue(validKomentIdZlecSkrac.isDisplayed());

        idZleceniaSkracajacego.clear();
        idZleceniaSkracajacego.sendKeys(id);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDataWynikuSkrac(String value) {
        shr.clearPole(dataWynikuSkracajacego);
        dataWynikuSkracajacego.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditIdZlecWydluz(String value, String id) {
        idZleceniaWydluzajacego.clear();
        idZleceniaWydluzajacego.sendKeys(value);
        Assert.assertTrue(validKomentIdZleceniaWydluz.isDisplayed());

        idZleceniaWydluzajacego.clear();
        idZleceniaWydluzajacego.sendKeys(id);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditZlecOsobaId(String value, String id) {
        zlecOsobaId.clear();
        zlecOsobaId.sendKeys(value);
        Assert.assertTrue(validKomentZlecOsobaId.isDisplayed());

        zlecOsobaId.clear();
        zlecOsobaId.sendKeys(id);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditZlecOsobaVer(String value) {
        zlecOsobaVer.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditGabinetId(String value, String id) {
        gabinetId.clear();
        gabinetId.sendKeys(value);
        Assert.assertTrue(validKomentGabinetId.isDisplayed());

        gabinetId.clear();
        gabinetId.sendKeys(id);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditZrKwRefId(String value) {
        zrKwRefId.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditIdKwZrodla(String value, String id) {
        idKwZr.clear();
        idKwZr.sendKeys(value);
        Assert.assertTrue(validKomentIdKwZrodla.isDisplayed());

        idKwZr.clear();
        idKwZr.sendKeys(id);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditKomentarzKw(String value){
        shr.clearPole(komentarzKw);
        komentarzKw.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    // ---- karta lokalizacyjna

    public void checkEditNrKartyLokal(String value) {
        nrKartyLokal.clear();
        nrKartyLokal.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditNrRejPojazdu(String value) {
        nrRejPojazdu.clear();
        nrRejPojazdu.sendKeys(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditPrzejscieGraniczne(String value) {
        przejscieGraniczne.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditDataPrzekroczeniaGranicy(String data) {
        shr.clearPole(dataPrzekroczeniaGranicy);
        dataPrzekroczeniaGranicy.sendKeys(data);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditPanstwoPrzyjechano(String value) {
        panstwoPrzyjechano.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void checkEditStatus(String value) {
        status.click();
        shr.stringListChoice(value);
        zapisz.click();

        Wait.waitForElementToBeVisible(driver, walidationKomentarz);
        Assert.assertTrue(walidationKomentarz.isDisplayed());
        driver.navigate().refresh();
    }

    public void changeHistoryAll(String dataOsoba, String dataAdres) {
        historiaZmianOsoba.click();
        shr.stringListChoice(dataOsoba);

        historiaZmianAdres.click();
        shr.stringListChoice(dataAdres);
        Wait.waitForNotEmptyElement(driver,kodPocztowy);

        komentarz.clear();
        komentarz.sendKeys("test regresja");

        zapisz.click();
        Wait.waitForElementToBeVisible(driver, takZapiszZmiany);
        takZapiszZmiany.click();

        Assert.assertTrue(komunikatDaneZapisane.isDisplayed());
    }

}
