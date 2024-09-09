import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class GetTest extends Configuration {

    @Test
    public void getPost() {

        // pojedynczy post
        given()
                .pathParam("id",1) // szukamy wpisu z polem id = 1
                .spec(request). // pobranie ustawień dla requeta
        when()
                .get("{id}"). // odwołanie się do pathParam
        then()
                .spec(response)// pobranie ustawień dla response
                .assertThat().body("title",equalTo("hej"))
                .assertThat().body("author",equalTo("hejbody"));

        // wszystkie posty
/*        given()
                .spec(request). // pobranie ustawień dla requeta
        when()
                .get(). // wszystko
        then()
                .spec(response)// pobranie ustawień dla response
                // pierwszy post
                .assertThat().body("title[0]",equalTo("hej"))
                .assertThat().body("author[0]",equalTo("hejbody")).
        and()
                //drugi post
                .assertThat().body("title[1]",equalTo("what"))
                .assertThat().body("author[1]",equalTo("zbig")).
        and()
                //trzeci post
                .assertThat().body("title[2]",equalTo("new"))
                .assertThat().body("author[2]",equalTo("post"));
        */
    }
}

