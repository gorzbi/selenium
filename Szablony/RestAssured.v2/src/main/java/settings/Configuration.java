package settings;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class Configuration {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:3000";
    }

    public static String getToken() {
        // Tutaj możesz zaimplementować sposób na uzyskanie tokenu
        return "TwójToken";
    }
}