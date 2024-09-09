import io.restassured.http.ContentType;
import model.Body;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class AddTest extends Configuration {

    @Test
    public void newPost() {

        // aktualizacja całego posta, wszystkie pola

        Body aktualizacja = new Body("New title", "New autor"); // dla klasy body utworzono konstruktory z parametrami, które przekazywane są w requescie

        Body nowyPost = given().
                                spec(request).
                                body(aktualizacja).
                        when().
                                post().
                        then().
                                // spec(response). -> nie możemy użyć bo w response zdefiniowaliśmy że kod to 200 a tu dostaniemy 201
                                statusCode(201).
                                contentType(ContentType.JSON).
                                extract().body().as(Body.class);

        assertEquals(aktualizacja,nowyPost);
    }
}
