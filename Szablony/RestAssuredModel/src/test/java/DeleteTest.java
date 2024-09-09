import io.restassured.http.ContentType;
import model.Body;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteTest extends Configuration {

    @Test
    public void delPost() {

        // pojedynczy post
        given()
                .pathParam("id",11) // szukamy wpisu z polem id = 1
                .spec(request). // pobranie ustawień dla requeta
        when()
                .delete("{id}"). // odwołanie się do pathParam
        then()
                //.spec(response);// pobranie ustawień dla response
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().body().as(Body.class);
    }
}

