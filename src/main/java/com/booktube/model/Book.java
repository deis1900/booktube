package com.booktube.model;

import com.booktube.model.subModel.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID", nullable = false, unique = true)
    private Long productId;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Author> authors;

    @Column(name = "YEAR")
    private String year;

    @Column(name = "LANGUAGE")
    private String language;

    @OneToMany
    private Set<Genre> genres;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "REVUE")
    private String revue;

    @Column(name = "LENGTH")
    private String length;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos;

    @ElementCollection
    @CollectionTable(name = "PICTURES", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "PICTURES")
    private Set<BookPictures> pictures;

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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Set<BookPictures> getPictures() {
        return pictures;
    }

    public void setPictures(Set<BookPictures> pictures) {
        this.pictures = pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(productId, book.productId) &&
                Objects.equals(name, book.name) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(year, book.year) &&
                Objects.equals(language, book.language) &&
                Objects.equals(genres, book.genres) &&
                Objects.equals(description, book.description) &&
                Objects.equals(revue, book.revue) &&
                Objects.equals(length, book.length) &&
                Objects.equals(comments, book.comments) &&
                Objects.equals(videos, book.videos) &&
                Objects.equals(pictures, book.pictures) &&
                Objects.equals(scores, book.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, authors, year, language, genres, description, revue, length, comments, videos, pictures, scores);
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
                ", length='" + length + '\'' +
                ", comments=" + comments +
                ", videos=" + videos +
                ", pictures=" + pictures +
                ", scores=" + scores +
                '}';
    }
}
