package endpoints.posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Posts;

import static io.restassured.RestAssured.given;

public class PutEndpointsPosts {

    public static Response updatePost(Posts post, int id) {
        return given()
                .contentType(ContentType.JSON)
                .body(post)
                .when()
                .put("/posts/" + id);
    }
}