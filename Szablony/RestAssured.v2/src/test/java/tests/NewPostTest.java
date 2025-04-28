package tests;

import endpoints.posts.PostEndpointsPosts;
import io.restassured.response.Response;

import models.Posts;
import org.testng.annotations.Test;
import settings.Configuration;
import tools.DataGenerator;

public class NewPostTest extends Configuration {

    @Test
    public void createNewPost() {

        // tworzymy nowy obiekt modelu Posts przez generator danych
        Posts generate = DataGenerator.generateRandomPost();

        Response response = PostEndpointsPosts.createPost(generate);
        response.then()
                .statusCode(201)
                .log().body();
    }

    @Test
    public void createNewPost_AltVersion() {

        // tworzymy nowy obiekt modelu Posts
        Posts body = new Posts();
            body.setTitle("aaaa");
            body.setAuthor("bbbb");

        Response response = PostEndpointsPosts.createPost(body);
                response.then()
                    .statusCode(201)
                    .log().body();
    }
}