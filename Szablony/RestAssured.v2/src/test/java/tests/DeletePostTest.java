package tests;

import endpoints.posts.DelEndpointsPosts;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import settings.Configuration;

public class DeletePostTest extends Configuration {

    @Test
    public void deletePostId() {

        int id = 10;

        Response get = DelEndpointsPosts.deletePostId(id);
        System.out.println("Tego chcę usunąć");
        get.then()
                .log()
                .body();
    }

    @Test
    public void deletePostIdCheckExsist() {

        int id = 9;

        Response get = DelEndpointsPosts.deletePostIdCheckExsist(id);
        get.then()
                .log()
                .status();
    }
}