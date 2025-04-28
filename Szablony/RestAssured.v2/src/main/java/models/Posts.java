package models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

// żeby PATCH robił update wybranego pola, a nie wstawiał NULL do pozostałych
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Posts {

    private String id;
    private String title;
    private String author;


    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }


    // obie override służą do porównywania tego obiektu Posts, gdy będą istnieć dwa
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return Objects.equals(title, posts.title) && Objects.equals(author, posts.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}