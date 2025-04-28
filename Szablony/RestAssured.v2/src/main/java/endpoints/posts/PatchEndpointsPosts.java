package endpoints.posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Posts;

import static io.restassured.RestAssured.given;

public class PatchEndpointsPosts {

    public static Response updateFieldPost(Posts post, int id) {
        return given()
                .contentType(ContentType.JSON)
                .body(post)
                .when()
                .patch("/posts/" + id);
    }
}