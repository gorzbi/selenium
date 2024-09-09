package Pages.Shared.Pages;

import DaneTestowe.DaneSuEdytorOsoby;
import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltrySzukajOsobe;
import Pages.Shared.Listy.ListOfWyszukiwanie;
import Pages.Shared.Methods;
import Tools.ZapiszDane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OsobyPage {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private FiltrySzukajOsobe fo;

    public OsobyPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.fo = new FiltrySzukajOsobe(driver);
    }

    ListOfWyszukiwanie lw = new ListOfWyszukiwanie(driver);
    DaneSuEdytorOsoby dt = new DaneSuEdytorOsoby();
    ZapiszDane zd = ZapiszDane.getInstance();


    // ---- buttony

    @FindBy (xpath = "//a[@href='/app/?action=list&entity=ExportFile&type=OSOBY']")
    private WebElement buttonEksportDanych;


    // ---- buttony

    public void enterEksportDanych() {
        buttonEksportDanych.click();
    }


    // ---- lista wyników

    public String ileOsob() {
        return shr.iloscRekordow();
    }

    public void podgladIdOsoby(String id) {
        fo.szukajOnlyByIdOsoby(id);
        but.clickFirstArrow();
        but.clickPodglad();
    }

    public void editIdOsoby (String id) {
        fo.szukajOnlyByIdOsoby(id);
        but.clickFirstArrow();
        but.clickEdit();
    }

    public void checkHistoryIdOsoby(String id) {
        fo.szukajOnlyByIdOsoby(id);
        but.clickFirstArrow();
        but.clickHistory();
    }


    // ---- inne metody

    public void checkListOsobyImie (String imie) {
        fo.szukajOnlyByImie(imie);
        System.out.println("Wybrane imiona to "+lw.listOfNames());
        Assert.assertTrue(lw.listOfNames().stream().allMatch(i -> i.equals(imie)));
    }

    public void losujFiltr() throws Exception {

        int min = 0;
        int max = 4;
        //int r = 0;
        int r = (int)(Math.random()*(max-min+1)+min);


        switch (r) {
            case 0:
                String id = dt.getFiltrIdOsoby();
                fo.szukajOnlyByIdOsoby(id);
                zd.setInfo("ID osoby: " + id);
                break;
            case 1:
                String imie = dt.getFiltrImie();
                fo.szukajOnlyByImie(imie);
                zd.setInfo("Imię: "+imie);
                break;
            case 2:
                String nazwisko = dt.getFiltrNazwisko();
                fo.szukajOnlyByNazwisko(nazwisko);
                zd.setInfo("Nazwisko: "+nazwisko);
                break;
            case 3:
                String pesel = dt.getFiltrPesel();
                fo.szukajOnlyByPesel(pesel);
                zd.setInfo("PESEL: "+pesel);
                break;
            case 4:
                String nrDok = dt.getFiltrNrDok();
                fo.szukajOnlyByNrDok(nrDok);
                zd.setInfo("Nr Dokumentu: "+nrDok);
                break;
            default:
                throw new Exception("Wylosowano metodę " + r + " -> poza zakresem!");
        }
    }

}
