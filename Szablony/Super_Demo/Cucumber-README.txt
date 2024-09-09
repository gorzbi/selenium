Pluginy:
- cucumber +
- cucumber for java

Dependencje:
<dependency>
    <groupId>io.cucumber</groupId>
    <artifactId>cucumber-java</artifactId>
    <version>7.11.2</version>
    <scope>test</scope>
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

Utworzyć ścieżki:
src/test/:
- java/StepDefinitions
- resources/Features

Ścieżka dla raportu cucumber musi mieć oznaczenie rozszerzenia pliku, np. html:src/test/resources/Raporty/cucumber.html

Tworzenie pliku "feature" jako new -> file.feature
Klasy dla definition steps normalne klasy java

Runner Class:
- dla uruchamiania wielu featuers
- na różne konfiguracje różne runnery
- dla raportów
- "CucumberTestRunner.java" w StepDefinitions
- extends AbstractTestNGCucumberTests // rozszerza o możliwość odczytywania adnotacji np. @Before

@Before:
- dodać w pliku konfiguracyjnym
- dodajemy do innych adnotacji, np. @BeforeMethod
- dodajemy do takich z których metod ma korzystać
- można dodać do kilku

W pliku Konfig utworzyć osobną metodę do pobierania driver dla cucumber:

public static WebDriver getDriver() {
        return driver;
}

W plikach stepDefinitions dla każdego testu.feature przed given/when/then:

1. dodać wpis dla pobierania drivera z Konfig:

WebDriver driver;
public SzybkaWyszukiwrkaOsob(Konfig konfig) throws IOException {
     driver = konfig.getDriver();
}

2. aby korzystać z metod wspólnych to dla gażdego given/when/then osobno się je dodaje nawet dla tego samego testu
