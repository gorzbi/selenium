package Pages.Shared.Pages;

import DaneTestowe.DaneSuEdytorZlecen;
import Pages.Shared.Filtry.FiltrySzukajZlecenie;
import Pages.Shared.Methods;
import Tools.ZapiszDane;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZleceniaTestuPage {

    private WebDriver driver;
    private Methods shr;
    private FiltrySzukajZlecenie fz;

    public ZleceniaTestuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.fz = new FiltrySzukajZlecenie(driver);
    }


    // ---- buttony

    @FindBy (xpath = "//a[@href='/app/?action=list&entity=ExportFile&type=ZLECENIA_LAB']")
    private WebElement buttonEksportDanych;


    public void enterEksportDanych() {
        buttonEksportDanych.click();
    }


    public String ileZlecen() {
        return shr.iloscRekordow();
    }


    public void losujFiltr() throws Exception {

        DaneSuEdytorZlecen dt = new DaneSuEdytorZlecen();
        ZapiszDane zd = ZapiszDane.getInstance();

        int min = 0;
        int max = 10;
        //int r = 5;
        int r = (int)(Math.random()*(max-min+1)+min);


        switch (r) {
            case 0:
                String id = dt.getFiltrIdZlecenia();
                fz.szukajOnlyByIdZlecenia(id);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po ID zlecenia");
                zd.setInfo("Id osoby "+id);
                break;
            case 1:
                String status = dt.getFiltrStatus();
                fz.szukajOnlyByStatus(status);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po statusie");
                zd.setInfo("status "+status);
                break;
            case 2:
                String imie = dt.getFiltrImie();
                fz.szukajOnlyByImie(imie);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po imieniu");
                zd.setInfo("imię osoby "+imie);
                break;
            case 3:
                String nazwisko = dt.getFiltrNazwisko();
                fz.szukajOnlyByNazwisko(nazwisko);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po nazwisku");
                zd.setInfo("nazwisko osoby "+nazwisko);
                break;
            case 4:
                String pesel = dt.getFiltrPesel();
                fz.szukajOnlyByPesel(pesel);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Pesel");
                zd.setInfo("pesel "+pesel);
                break;
            case 5:
                String nrDok = dt.getFiltrNrDok();
                fz.szukajOnlyByNrDok(nrDok);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po nr dok");
                zd.setInfo("nr dokumentu "+nrDok);
                break;
            case 6:
                String zrodloTestu = dt.getFiltrZrodloTestu();
                fz.szukajOnlyByZrodloTestu(zrodloTestu);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Źródło testu");
                zd.setInfo("źródło testu "+zrodloTestu);
                break;
            case 7:
                String karetka = dt.getFiltrPotrzebaKaretki();
                fz.szukajOnlyBaKaretka(karetka);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Potrzeba karetki");
                zd.setInfo("karetka "+karetka);
                break;
            case 8:
                String grupaStatus = dt.getFiltrGrupyStatusow();
                fz.szukajOnlyByGrupyStatus(grupaStatus);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Grupie statusów");
                zd.setInfo("grupa statusów "+grupaStatus);
                break;
            case 9:
                String typTestu = dt.getFiltrTypTestu();
                fz.szukajOnlyByTypTestu(typTestu);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Typ testu");
                zd.setInfo("typ testu "+typTestu);
                break;
            case 10:
                String zrFinans = dt.getFiltrZrodloFinansowania();
                fz.szukajOnlybyZrodloFinans(zrFinans);
                System.out.println("Wylosowano metodę "+ r +" -> Szukaj po Źródło finansowania");
                zd.setInfo("źródło finansowania "+zrFinans);
                break;
            default:
                throw new Exception("Wylosowano metodę " + r + " -> poza zakresem!");
        }
    }
}
