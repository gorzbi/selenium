import model.Body;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateTest extends Configuration {

    @Test
    public void updatePost() {

        // aktualizacja całego posta, wszystkie pola

        Body aktualizacja = new Body("Nowy tytuł", "Nowy autor"); // dla klasy body utworzono konstruktory z parametrami, które przekazywane są w requescie

        Body aktualizacjaPosta = given().
                                spec(request).
                                pathParam("id",3). // szukamy wpisu z polem id = 2
                                body(aktualizacja).
                        when().
                                put("{id}").
                        then().
                                spec(response).
                                extract().body().as(Body.class);

        assertEquals(aktualizacja,aktualizacjaPosta);
    }
}
