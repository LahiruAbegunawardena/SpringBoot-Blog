package com.springboot.blog.Books;
import javax.persistence.*;

@Entity
@Table(name="book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer book_id;
    private String book_name;
    private String author_name;
    private String description;

    public BookModel(){}
    public BookModel(int book_id, String book_name, String author_name, String description) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author_name = author_name;
        this.description = description;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
