package com.booktube.model;

import com.booktube.model.subModel.Author;
import com.booktube.model.subModel.BookPictures;
import com.booktube.model.subModel.Comment;
import com.booktube.model.subModel.Genre;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long productId;

    @Column
    private String name;

    @ManyToMany
    private List<Author> authors;

    @Column
    private String year;

    @Column(name = "LANGUAGE")
    private String language;

    @ElementCollection
    @CollectionTable(name = "GENRE", joinColumns = @JoinColumn(name = "ID"))
    private Set<Genre> genres;

    @Lob
    @Column
    private String description;

    @Column
    private String revue;

    @Column
    private String lenght;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

//    @OneToMany
//    private List<Video> videos

    @ElementCollection
    @CollectionTable(name="PICTURES", joinColumns = @JoinColumn(name="ID"))
    @Column(name="PICTURES")
    private List<BookPictures> pictures;

    @Column
    private Integer scores;

    public Book() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRevue() {
        return revue;
    }

    public void setRevue(String revue) {
        this.revue = revue;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Book{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", year='" + year + '\'' +
                ", language='" + language + '\'' +
                ", genres=" + genres +
                ", description='" + description + '\'' +
                ", revue='" + revue + '\'' +
                ", lenght='" + lenght + '\'' +
                ", comments=" + comments +
                ", scores=" + scores +
                '}';
    }
}
