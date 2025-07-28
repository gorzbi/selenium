Lombok -> do generowania jakie pola formularza wypełniać w danym scenariuszu testowym -> wymagana dependencja + plugin
Wykorzystuje @Builder @Getter i odwołuje się do buildera z wybieraną listą parametrów, które chcemy wykorzystać w danym scenario + build() 

Plik testng.xml nie jest potrzebny gdy, w konfiguracji nie przypisuję do raportu autora i urządzenia. Reszta danych jest pobierana z klass @Test dla każdego testu osobbno opisanymi atrubutami, np. groups/description


Driver:
- w konfiguracji ustawić jako protected static Webdriver driver;
- w page jako pole Webdriver driver; + PageFactory.initElements dla każdego page class

/*
* screen przechowywać najlepiej w tym samym folderze co raporty tylko w podfolderze, bo raport może ich nie wczytać
* zrobić ścieżkę absolutną do zapisu screena
* zrobić ścieżkę relatywną do wczytywania screena do raportu
* obie ścieżki bo dobrze wyjaśnia to chatgpt -> extent reports save screen correctly but image is broken in report
*/

Common Causes:

    Incorrect or relative paths: The path to the screenshot may not be correctly resolved, especially if the report is opened in a browser from a different directory.
    Browser security: If the file path uses a different protocol (like file:// or uses backslashes on Windows), the browser may fail to load the image.
    Relative paths: If the screenshot is saved using a relative path but the report is opened from a different location, the link will break.

W przypadku Jenkins może być potrzebna dependencja surefire-plugin do budowania środowiska

    <dependencies>
        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>6.0.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.31.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.11.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.1.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.19.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.38</version>
            <scope>provided</scope>
        </dependency>

    </dependencies>
