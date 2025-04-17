// rozwiązanie problemu z uruchamianiem na chrome

W @BeforeSuite / @Before

    public void start() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
      }

// ---------------------------------------------------klucz ssh z github--------------------------------------------------

odpalić git bash w folderze gdzie jest projekt i plik git
wykonać komendy

generowanie:
ssh-keygen -t ed25519 -C "your_email@example.com"

install: 
cat ~/.ssh/id_ed25519.pub | clip -> kopiuje zawartość do schowka

wkleić w github >> settings >> ssh and gpg keys (new ssh key)
https://github.com/settings/keys

// ---------------------------------------------------dependencje--------------------------------------------------

    <dependencies>
    
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.3.0</version>
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
            <scope>GET</scope>
        </dependency>

        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.2.1</version>
            <scope>GET</scope>
        </dependency>

        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>5.0.9</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.17.2</version>
        </dependency>

        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.17.2</version>
        </dependency>

        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>5.2.2</version>
        </dependency>

        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.2</version>
        </dependency>

        <dependency>
            <groupId>ru.yandex.qatools.ashot</groupId>
            <artifactId>ashot</artifactId>
            <version>1.5.4</version>
        </dependency>

        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>5.1.1</version>
            <scope>GET</scope>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.13.3</version>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.24</version>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.9.0</version>
        </dependency>

        <dependency>
            <groupId>com.apple</groupId>
            <artifactId>AppleJavaExtensions</artifactId>
            <version>1.4</version>
        </dependency>

    </dependencies>
