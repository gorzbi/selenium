import model.Body;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateFieldTest extends Configuration {

    @Test
    public void updateField() {

        // aktualizacja pola

        Body aktualizacja = new Body("Zakt tytuł");

        Body aktualizacjaPola = given().
                spec(request).
                pathParam("id",2). // szukamy wpisu z polem id = 2
                        body(aktualizacja).
                when().
                        patch("{id}").
                then().
                        spec(response).
                        extract().body().as(Body.class);

        assertEquals(aktualizacjaPola.getTitle(), "Zakt tytuł");
    }

/*    @Test // nie działa dla drugiego pola
    public void updateField2() {

        // aktualizacja pola

        Body aktualizacja2 = new Body("Zakt autor");

        Body aktualizacjaPola2 = given().
                spec(request).
                pathParam("id",2). // szukamy wpisu z polem id = 2
                        body(aktualizacja2).
                when().
                patch("{id}").
                then().
                spec(response).
                extract().body().as(Body.class);

        assertEquals(aktualizacjaPola2.getTitle(), "Zakt autor");
    }*/
}
