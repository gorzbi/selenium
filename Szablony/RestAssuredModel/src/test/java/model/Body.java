package model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) // aby pomijać null
public class Body {

    // domyślnie są to wartości = null
    private Integer id;
    private String title;
    private String author;

    // pusty konstruktor nazwa jak nazwa tej klasy
    public Body() {
    }

    // konstruktor z jednym polem
    public Body(String title) {
        this.title = title; // dla nowo tworzonego obiektu pole title ma mieć przypisaną wartość z parametru title
    }

/*    // konstruktor z innym polem nie działa dla tego drugiego
    public Body(String author) {
        this.author = author;
    }*/


    public Body(String title, String author) {
        this.title = title;
        this.author = author;
    }


    // getter i setter alt + insert

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // porównywanie obiektów alt + insert equals() hash code()
    // bez id, bo id jest nadawane po utworzeniu elementu i nie jest znane podczas dodawania elementu, gdy robimy porównanie

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(title, body.title) && Objects.equals(author, body.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
