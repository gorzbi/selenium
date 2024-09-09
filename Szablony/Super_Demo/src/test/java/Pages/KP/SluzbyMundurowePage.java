package Pages.KP;

import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltrySzukajOsobe;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SluzbyMundurowePage {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private FiltrySzukajOsobe fo;

    public SluzbyMundurowePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.fo = new FiltrySzukajOsobe(driver);
    }

    @FindBy(xpath = "//a[@href='/app/?action=list&entity=ExportFile&type=POLICJA']")
    private WebElement buttonEksportDanych;


    public void enterEksportDanych() {
        buttonEksportDanych.click();
    }

    public void wyszukajOsobyKwarantannaIzolacjaWojewodztwo(String value, String wojewodztwo) {
        but.clickWyczyscKryteriaWyszukiwania();
        fo.setFiltrKwarantanna(value);
        but.clickWyszukiwanieZaawansowane();
        fo.setFiltrWojewodztwo(wojewodztwo);
        but.clickSzukaj();
    }

    public void wyszukajOsobyKwarantannaIzolacjaPowiat(String value, String wojewodztwo, String powiat) {
        but.clickWyczyscKryteriaWyszukiwania();
        fo.setFiltrKwarantanna(value);
        but.clickWyszukiwanieZaawansowane();
        fo.setFiltrWojewodztwo(wojewodztwo);
        fo.setFiltrPowiat(powiat);
        but.clickSzukaj();
    }

    public String ileOsob() {
        return shr.iloscRekordow();
    }
}
