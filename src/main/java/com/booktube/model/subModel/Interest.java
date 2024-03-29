package com.booktube.model.subModel;

import com.booktube.model.Book;
import com.booktube.model.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "INTERESTS")
public class Interest {

    @Id
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany
    @JoinColumn(name = "book_ID", updatable = false, insertable = false)
    private List<Book> books;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creationDate;

    public Interest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return Objects.equals(id, interest.id) &&
                Objects.equals(books, interest.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, books);
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + id +
                ", book=" + books +
                '}';
    }
}
