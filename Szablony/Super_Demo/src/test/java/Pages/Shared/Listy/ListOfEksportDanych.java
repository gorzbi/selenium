package Pages.Shared.Listy;

import Pages.Shared.Buttons;
import Pages.Shared.Filtry.FiltryEksport;
import Pages.Shared.Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.*;

public class ListOfEksportDanych {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;
    private FiltryEksport fe;

    public ListOfEksportDanych(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
        this.fe = new FiltryEksport(driver);
    }


    // ---- lista

    public void checkPresentReportList() {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickSzukaj();
        System.out.println("Obecna lista zamawiających raporty to "+listOfZamawiajacy());
    }

    public void checkReportListZamawiajacyWgKontekst(String value) {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickSzukaj();
        System.out.println("Obecna lista zamawiających raporty to "+listOfZamawiajacy());
        Assert.assertTrue(listOfZamawiajacy().stream().allMatch(i -> i.startsWith(value)));
    }


    public void getListZamawiajacyRaportNazwaKontekstu() {
        but.clickWyczyscKryteriaWyszukiwania();
        String nazwaKontekstu = shr.kontekstName();
        fe.setFiltrZamawiajacyRaport(nazwaKontekstu);
        but.clickSzukaj();

        System.out.println("Lista raportów wg. mój kontekst"+listOfZamawiajacy());

        Assert.assertTrue(listOfZamawiajacy().stream().allMatch(i -> i.equals(nazwaKontekstu)));
    }

    public void checkListWojewRaport(String wojew) {
        System.out.println("Lista województw to "+listOfWojewodztwa());
        System.out.println("Wybrane województwo to "+ wojew);

        Assert.assertTrue(listOfWojewodztwa().stream().allMatch(i -> i.equals(wojew)));
    }

    public void checkListPowiatRaport(String powiat) {
        System.out.println("Lista powiatów to "+listOfPowiaty());
        System.out.println("Wybrany powiat to "+powiat);

        Assert.assertTrue(listOfPowiaty().stream().allMatch(i -> i.equalsIgnoreCase(powiat)));
    }

    public void checkListStatusReport(String value) {
        System.out.println("Lista statusów to "+listOfStatusReport());
        System.out.println("Wybrany status to "+value);

        Assert.assertTrue(listOfStatusReport().stream().allMatch(i -> i.equalsIgnoreCase(value)));
    }


    // ---- listy danych dla eksportu
    public List<String> listOfZamawiajacy() {

        List<String> listaZamawiajacy = driver.findElements(xpath("//p[@class='list-cell-header' and text()='Zamawiający']/following-sibling::p"))
                .stream()
                .map(WebElement::getText).toList();

        return listaZamawiajacy;
    }

    public List<String> listOfWojewodztwa() {

        List<String> listaWojewodztw = driver.findElements(xpath("//p[@class='list-cell-header' and text()='Województwo']/following-sibling::p"))
                .stream()
                .map(WebElement::getText).toList();

        return listaWojewodztw;
    }

    public List<String> listOfPowiaty() {

        List<String> listaPowiaty = driver.findElements(xpath("//p[@class='list-cell-header' and text()='Powiat']/following-sibling::p"))
                .stream()
                .map(WebElement::getText).toList();

        return listaPowiaty;
    }

    public List<String> listOfStatusReport() {

        List<String> listaStatusRaporty = driver.findElements(xpath("//p[@class='list-cell-header' and text()='Status']/following-sibling::p"))
                .stream()
                .map(WebElement::getText).toList();

        return listaStatusRaporty;
    }

}
