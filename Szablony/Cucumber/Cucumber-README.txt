https://qaautomation.expert/2023/10/09/page-object-model-with-selenium-cucumber-and-testng/ 

Pluginy:
- cucumber +
- cucumber for java

Dependencje:
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.11.2</version>
    // usunąć <scope>test</scope> bo nie widzi adnotacji after/before/scenario
</dependency>

// cucumber testng bo w projekcie też korzystam z testng a nie junit
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-testng</artifactId>
    <version>7.10.1</version>
</dependency>

<dependency>
     <groupId>io.cucumber</groupId>
     <artifactId>cucumber-picocontainer</artifactId>
     <version>7.12.0</version>
</dependency>

Struktura projetku:
1. w main/java wszystkie paczki/pliki:
- pages
- tools
- konfiguracyjne
- dane
- w main folder resources/raporty

2. dla samego cucumber utworzyć ścieżki:
- src/test/java/Runner(paczka)/CucumberRunnerTest.java //tutaj wszystkie runnery
- src/test/java/StepDefinitions(paczka) // wszystkie pliki java ze skryptami wykonującymi kroki scenariuszy
- src/test stworzyć root resoruces
- w nim folder Features
- w nim wszystkie file.feature z rozpisanymi scenariuszami
- Tworzenie pliku "feature" jako new -> file.feature(rozszerzenie wpisywane ręcznie)

Ścieżka dla raportu cucumber musi mieć oznaczenie rozszerzenia pliku, np. html:src/test/resources/Raporty/cucumber.html

Runner Class:
- dla uruchamiania wielu featuers
- na różne konfiguracje różne runnery
- dla raportów
- "CucumberTestRunner.java" w StepDefinitions
- extends AbstractTestNGCucumberTests // rozszerza o możliwość odczytywania adnotacji np. @Before z pliku Konfig

@Before:
- dodać w pliku konfiguracyjnym
- dodajemy do innych adnotacji, np. @BeforeMethod
- dodajemy do takich z których metod ma korzystać
- można dodać do kilku

1. W pliku Konfig utworzyć osobną metodę do pobierania driver dla cucumber:

public static WebDriver getDriver() {
        return driver;
}

2. W plikach pages utworzyć wpisy dla drivera:
    private WebDriver driver;

    public nazwaKlasy(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

gdy dany page korzysta także z metod z innych pages
    private WebDriver driver;
    private Methods shr; // inny page
    private Buttons but; // inny page

    public nazwaKlasy(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.shr = new Methods(driver); // tworzymy wpis ze zmienną, pod którą będą metody z tego page
        this.but = new Buttons(driver); // tworzymy wpis ze zmienną, pod którą będą metody z tego page
    }

3. W plikach stepDefinitions dla każdego?? testu przed given/when/then:

a) dodać wpis dla pobierania drivera z Konfig:

    WebDriver driver;
    public nazwaKlasy() {
        driver = Konfig.getDriver(); // metoda pobierająca z klasy konfig drivera zwracającego drivera
    }

b) aby korzystać z metod wspólnych to dla gażdego given/when/then osobno się je dodaje nawet dla tego samego testu

Scenariusze w jednym pliku
Plik Features:
- mogą zawierać różne scenariusze
- kroki scenariuszy mogą być takie same
- różnica w krokach może dotyczyć np. linku w który się klika, czy jakiejś innej zmiennej akcji, np. inna liczba itp. to w każdym scenariuszu ten sam krok ale z inną wartością należy unikalnie nazwać
- krok, który zawiera na sztywno przypisaną zmienną i powtarza się w innych scenariuszach nazwę najlepiej rozpocząć od tej zmiennej bo cucumber pomyśli, że to jest zdublowany krok Gdynia szukaj / Polska szukaj
- jeśli są parametry i dla danego kroku wiecej niż jeden parametr należy oddzielać przecinkiem w scenario <>,<> i step definitions {},{}
np. 
scenario 1
given uruchom google
and Gdynia szukaj

scenario 2
given uruchom google
and Łeba szukaj

- dla powtarzającego się kroku można go zaimplementować jako background i będzie wykorzystywany w każdym scenario w tej klasie
Background:
Given uruchom google

Pliki Step Definitions:
- można stworzyć osobny plik zawierający wspólne kroki, powtarzające się w różnych scenariuszach bez zmiennych, np. uruchom google
- w jednym można zapisać wszystkie kroki z różnych scenariuszy(features): given uruchom google / and szukaj Gdynia / and szukaj Łeba
- przy większej ilości testów i tak najlepiej robić dla każdego testu w osobnym pliku mimo duplikacji kodu bo łatwiej panować nad zmianami, bo dla jednego testu będzie given uruchom Google a dla innego when uruchom Google

Pliki Runner:
- tagi można używać zarówno z poziomu features jak i scenarios
tags = "@smokeTest or @regressionTest"
@tagName: uruchomi wszystkie z tym tag
not @tagName: wykluczy wszystkie z tym tagiem
@tag1 and @tag2: uruchomi wszystkie co mają oba te tagi
@tag1 or @tag2: uruchomi wszystkie co mają jeden z tych tagów
