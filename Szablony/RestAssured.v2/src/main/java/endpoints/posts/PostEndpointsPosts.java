package endpoints.posts;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Posts;

import static io.restassured.RestAssured.given;

public class PostEndpointsPosts {

    public static Response createPost(Posts post) {
        return given()
                .contentType(ContentType.JSON)
                // spojrzeć jaką ma nazwę header w requeście
                //.header("Authorization", ConfigReader.getToken())
                // odwołanie do body z modelu (Post)
                .body(post)
                .when()
                // znać dokładną ścieżkę
                .post("/posts");
    }
}