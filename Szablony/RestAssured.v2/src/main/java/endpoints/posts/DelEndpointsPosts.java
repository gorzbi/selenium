package endpoints.posts;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DelEndpointsPosts {

    public static Response deletePostId(int id) {

        return given()
                .when()
                .delete("/posts/" + id);
    }

    public static Response deletePostIdCheckExsist(int id) {

        Response getResponse = given()
                .when()
                .get("/posts/" + id);

        if (getResponse.statusCode() == 200) {
            System.out.println("Zasób istnieje – usuwam go");
            return given()
                    .when()
                    .delete("/posts/" + id);
        } else {
            System.out.println("Zasób nie istnieje");
            return getResponse;
        }
    }
}