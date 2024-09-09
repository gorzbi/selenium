package pages;

import model.Word;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tools.Wait;

public class HomeGooglePage {

    @FindBy(id = "L2AGLb")
    private WebElement zgoda;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement szukajwGoogleButton;

    @FindBy(name = "btnI")
    private WebElement szczesliwyTrafButton;

    @FindBy(xpath = "//div[@class='uU7dJb']")
    private WebElement stopkaKraj;

    private WebDriver driver;

    public HomeGooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /*
     * metoda, która kończy się przejściem na inną podstronę to
     * nazwa klasy, to podstrona, do której przechodzimy,
     * nazwa metody dowolna,
     * zwraca nowy obiekt podstrony, do której przechodzimy
     */
    public ResultPage findWord(Word wyraz) { // jako parametr podajemy klasę z modelu z którego chcemy korzystać
        /*
        * dzięki zmiennej "wyraz" dostajemy się do pola z modelu i do metody z tej klasy
        * wartość szukanego słowa podajemy w klasie testowej gdzie tą metodę będziemy wywoływać
        */
        Wait.waitforElementToBeClickable(driver, zgoda); // z klasy Wait wyciągamy metodę - czekamy na możliwość kliknięcia w element
        zgoda.click();
        searchField.sendKeys(wyraz.getSzukanyWyraz());
        searchField.sendKeys(Keys.ENTER);
        return new ResultPage(driver);
        /*
         * przekazujemy driver jako parametr do konstruktora tej metody w tamtej klasie
         */
    }


    public WebElement getStopkaKraj() {
        return stopkaKraj;
        /*
         * lepiej jest zwracać element tekstowy,
         * bo później można wiele różnych operacji w samym teście na nim wykonać
         * */
    }

    // sprawdzenie
    public boolean checkGoogleHomePage() {

        boolean check;

        if (stopkaKraj.getText().equalsIgnoreCase("Polska")) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }
}