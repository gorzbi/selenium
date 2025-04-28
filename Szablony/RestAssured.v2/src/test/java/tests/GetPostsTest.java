package tests;

import endpoints.posts.GetEndpointsPosts;
import models.Posts;
import org.hamcrest.Matchers;
import settings.Configuration;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GetPostsTest extends Configuration {

    @Test
    public void getAllPosts() {

        Response response = GetEndpointsPosts.getAllPosts();
        Assert.assertEquals(response.statusCode(), 200, "Nieautoryzowany dostęp lub inne błędy");
        response.then().log().body();
    }

    @Test
    public void getPostById() {

        Response response = GetEndpointsPosts.getPostById(2);
        response.then().log().body();
    }

    @Test
    public void getPostByIdPathParam() {

        Response response = GetEndpointsPosts.getPostByIdPathParam(2);
        response.then().log().body();
    }

    @Test
    public void getPostByParam() {

        String pole = "title";
        String value = "json-server";

        Response response = GetEndpointsPosts.getPostByParam(pole, value);
        response.then().log().body();
    }

    @Test
    public void getPostByParamList() {

        String pole = "title";
        List<String> values = Arrays.asList("json-server", "aaaa");

        Response response = GetEndpointsPosts.getPostByParamList(pole, values);
        response.then().log().body();
    }

    @Test
    public void getPostAndCheckBody() {

        String expectedBody = "{\n" +
                "  \"title\": \"Title: voluptatem\",\n" +
                "  \"author\": \"Author: Marcelino Prohaska\",\n" +
                "  \"id\": 2\n" +
                "}";

        Response response = GetEndpointsPosts.getPostById(2);
        response.then().log().body()
                .body(Matchers.equalTo(expectedBody)) // sprawdza całe ciało odpowiedzi
                .statusCode(200) // oczekuję, że będzie status = 200
                .body(Matchers.containsStringIgnoringCase("marc"))// czy istnieje taki string w odp
                .body("title",Matchers.equalTo("Title: voluptatem")) // czy istnieje taki tytuł
                .body("id",Matchers.equalTo(2)).and().body("title",Matchers.equalTo("Title: voluptatem")); // oba warunki muszą być spełnione
    }

    @Test
    public void getPostAndAssertBody() {

        Response response = GetEndpointsPosts.getPostById(2);

        // Sprawdź odpowiedź i wyciągnij jako obiekt
        Posts post = response.then().log().body()
                .statusCode(200)
                .extract()
                .as(Posts.class); // <-- tutaj zapisujemy obiekt odpowiedzi!

        // Alternatywna walidacja jako zwykłe asercje
        Assert.assertEquals(post.getAuthor(), "Author: Marcelino Prohaska");
        Assert.assertEquals(post.getId(), "2");
        Assert.assertEquals(post.getTitle(), "Title: voluptatem");
    }
}