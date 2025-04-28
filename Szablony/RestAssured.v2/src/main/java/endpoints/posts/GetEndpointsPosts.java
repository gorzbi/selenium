package endpoints.posts;

import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetEndpointsPosts {

    public static Response getAllPosts() {
        return given()
                .when()
                .get("/posts/");
    }

    public static Response getPostById(int id) {
        return given()
                .when()
                .get("/posts/" + id);
    }

    // alternatywnie z pathParam
    public static Response getPostByIdPathParam(int id) {
        return given()
                .pathParam("id",id)
                .when()
                .get("/posts/{id}");
    }

    // filtrowanie -> 1 parametr z 1 wartością
    public static Response getPostByParam(String pole, String value) {
        return given()
                .queryParams(pole, value)
                .when()
                .get("/posts");
    }

    // filtrowanie -> 1 parametr + różne wartości
    public static Response getPostByParamList(String pole, List<String> values) {

        return given()
                .queryParam(pole, values)
                .when()
                .get("/posts");
    }
}