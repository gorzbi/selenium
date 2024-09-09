package Pages.Shared.Listy;

import Tools.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ListOfWyszukiwanie {

    private WebDriver driver;

    public ListOfWyszukiwanie(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    // ---- listy danych po wyszukaniu

    public List<String> listOfIdOsob() {
        List<String> listaId = driver.findElements(By.xpath("//p[@class='list-cell-header' and text()='ID']/following-sibling::p"))
                .stream()
                .map(WebElement::getText)
                .toList();
        return listaId;
    }

    public List<String> listOfIdZlecen() {
        List<String> listaId = driver.findElements(By.xpath("//p[@class='list-cell-header' and text()='Id zlecenia']/following-sibling::p"))
                .stream()
                .map(WebElement::getText)
                .toList();
        return listaId;
    }

    public List<String> listOfNames() {

        Wait.waitforLocatorToBeVisible(driver,By.xpath("//p[@class='list-cell-header' and text()='Imię']/following-sibling::p"));
        List<String> listaNames = driver.findElements(By.xpath("//p[@class='list-cell-header' and text()='Imię']/following-sibling::p"))
                .stream()
                .map(WebElement::getText).toList();

        return listaNames;
    }

}
