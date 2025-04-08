@BeforeSuite – uruchamiane raz przed całą suite testów, np. połączenie z bazą danych.
@BeforeTest – uruchamiane przed blokiem testowym w pliku XML, który może zawierać wiele klas.
@BeforeClass – uruchamiane raz przed wszystkimi metodami testowymi w danej klasie.
@BeforeMethod – uruchamiane przed każdą metodą testową oznaczoną jako @Test

Driver:
- w konfiguracji ustawić jako protected static Webdriver driver;
- w page jako pole Webdriver driver; + PageFactory.initElements dla każdego page class

Pliki:
I. main:

1. java:
a) paczka dane:
- klasa z danymi
b) paczka pages:
- klasy z page -> elementy i metody
c) paczka settings:
- klasa DriverFactory
- klasa DriverType
- klasa Konfiguracja

d) paczka Tools

2. resources

II. tests:

1. java
a) paczka testów
- klasa test1 (może zawierać w sobie testy)
- klasa test2 (może zawierać w sobie testy)
a) paczka testów
- klasa test1 (może zawierać w sobie testy)
- klasa test2 (może zawierać w sobie testy)


    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.9.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.24.0</version>
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.10.2</version>
            <scope>compile</scope>
        </dependency>

        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.16.1</version>
        </dependency>

    </dependencies>
