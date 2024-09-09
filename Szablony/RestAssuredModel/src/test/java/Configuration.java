import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Configuration {

    // protected bo klasy dziedziczące Configuration będą miały dostęp do tych pól

    protected static RequestSpecification request; // protected static będzie wykorzystywane we wszystkich klasach dziedzicząych
    protected static ResponseSpecification response;

    @BeforeSuite
    public void setUp() {

        request = new RequestSpecBuilder().
                setBaseUri("http://localhost:3000").
                setBasePath("posts").
                setContentType(ContentType.JSON).
                build();

        response = new ResponseSpecBuilder().
                expectContentType(ContentType.JSON).
                expectStatusCode(200).
                build();

        RequestLoggingFilter requestInfo = new RequestLoggingFilter(); // info o requescie
        ResponseLoggingFilter responseInfo = new ResponseLoggingFilter(); // info o responsie
        RestAssured.filters(requestInfo, responseInfo); // wywołanie info
    }

    // przywracanie bazy do stanu pierwotnego po wykonaniu paczki testów
    @AfterSuite
    public void returnDBjson() throws IOException {

        File plikBazy = new File(System.getProperty("user.home")+"/FakeApp/db.json"); //user.home to c:/Users/zbigniew.gornowicz + dalsza ścieżka do pliku z bazą
        Files.deleteIfExists(plikBazy.toPath());
        File plik = new File ("src/test/resources/dbCopy.json");
        Files.copy(plik.toPath(), Path.of(System.getProperty("user.home")+"/FakeApp/db.json"));

    }
}
