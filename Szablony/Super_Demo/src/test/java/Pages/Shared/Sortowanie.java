package Pages.Shared;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Sortowanie {

    private WebDriver driver;
    private Methods shr;
    private Buttons but;

    public Sortowanie(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver);
        this.but = new Buttons(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-default btn-icon']")
    private WebElement kierunekSortowania;

    @FindBy (xpath = "//span[@class='vs__selected' and contains(text(),'Sortuj')]")
    private WebElement typSortowania;



    public void sortowanieDataMalejaco() {
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickSzukaj();
    }

    public void sortowanieDataRosnaco() {
        kierunekSortowania.click();
    }

    public void changeTypSortowanie(String value){
        typSortowania.click();
        shr.stringListChoice(value);
    }

    public void changeSortowanieKierunek() {
        kierunekSortowania.click();
    }


    public void checkSortowanieAll() {
        // 1a -> sortowanie Data malejąco od razu
        but.clickWyczyscKryteriaWyszukiwania();
        but.clickSzukaj();
        // 1b -> sortowanie Data rosnąco
        kierunekSortowania.click();

        // 2a -> sortowanie ID malejąco
        typSortowania.click();
        shr.stringListChoice("ID");
        // 2b -> sortowanie ID rosnąc
        kierunekSortowania.click();

        // 3a -> sortowanie Zamawiający malejąco
        typSortowania.click();
        shr.stringListChoice("Zamawiający");
        // 3b -> sortowanie Zamawiający rosnąco
        kierunekSortowania.click();

        // 4a -> sortowanie Województwo malejąco
        typSortowania.click();
        shr.stringListChoice("Województwo");
        // 4b -> sortowanie Województwo rosnąco
        kierunekSortowania.click();

        // 5a -> sortowanie Status malejąco
        typSortowania.click();
        shr.stringListChoice("Status");
        // 5b -> sortowanie Status rosnąco
        kierunekSortowania.click();

        // 6a -> sortowanie Powiat malejąco
        typSortowania.click();
        shr.stringListChoice("Powiat");
        // 6b -> sortowanie Powiat rosnąco
        kierunekSortowania.click();
    }

    public void returnToBasicSortowanie() {
        typSortowania.click();
        shr.stringListChoice("Data zamówienia");
    }

}
