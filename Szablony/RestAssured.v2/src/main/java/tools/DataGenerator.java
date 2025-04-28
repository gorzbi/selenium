package tools;

import com.github.javafaker.Faker;
import models.Posts;

public class DataGenerator {

    public static Posts generateRandomPost() {

        Faker fake = new Faker();
        Posts post = new Posts();

        post.setTitle("Title: " + fake.lorem().word());
        post.setAuthor("Author: " + fake.name().fullName());

        return post;
    }

    public static Posts generateTitle() {

        Faker fake = new Faker();
        Posts post = new Posts();

        post.setTitle("Title: " + fake.lorem().word());

        return post;
    }

    public static Posts generateAuthor() {

        Faker fake = new Faker();
        Posts post = new Posts();

        post.setAuthor("Author: " + fake.lorem().word());

        return post;
    }

    public static Posts generateRandomData(String data) {

        Faker fake = new Faker();
        Posts post = new Posts();

        switch (data) {
            case "author":
                post.setAuthor("Author: " + fake.name().fullName());
                break;
            case "title":
                post.setTitle("Title: " + fake.lorem().word());
                break;
            default:
                System.out.println("Nie ma takiego pola");
        }
        return post;
    }
}