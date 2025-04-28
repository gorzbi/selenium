package tests;

import endpoints.posts.GetEndpointsPosts;
import endpoints.posts.PatchEndpointsPosts;
import endpoints.posts.PutEndpointsPosts;
import io.restassured.response.Response;
import models.Posts;
import org.testng.annotations.Test;
import settings.Configuration;
import tools.DataGenerator;

public class UpdatePostTest extends Configuration {

    @Test
    public void updatePost() {

        // odwołujemy się do obiektu z modelu Posts przetwarzając go generatorem
        Posts body = DataGenerator.generateRandomPost();
        int id = 2;

        Response get = GetEndpointsPosts.getPostById(id);
        System.out.println("Przed update");
        get.then()
                .log()
                .body();

        Response update = PutEndpointsPosts.updatePost(body, id);
        System.out.println("Po update full post");
        update.then()
                .log()
                .body();
    }

    @Test
    public void updatePost_AltVersion() {

        // odwołujemy się do obiektu z modelu Posts tworząc nowy, a jednocześnie przetwarzając manualnie istniejący
        Posts alt = new Posts();
        alt.setAuthor("ccc");
        alt.setTitle("dddd");

        int id = 3;

        Response get = GetEndpointsPosts.getPostById(id);
        System.out.println("Przed update");
        get.then()
                .log()
                .body();

        Response update = PutEndpointsPosts.updatePost(alt, id);
        System.out.println("Po update alternatywna wersja full post");
        update.then()
                .log()
                .body();
    }

    @Test
    public void updateFieldPost() {

        String pole = "title";
        Posts data = DataGenerator.generateRandomData(pole);
        int id = 4;

        Response get = GetEndpointsPosts.getPostById(id);
        System.out.println("Przed update");
        get.then()
                .log()
                .body();

        Response update = PatchEndpointsPosts.updateFieldPost(data, id);
        System.out.println("Dokonano update pola -> " + pole);
        update.then()
                .log().body();
    }
}