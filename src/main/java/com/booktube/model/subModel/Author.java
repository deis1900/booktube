package com.booktube.model.subModel;

import com.booktube.model.Book;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AUTHORS")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "NAME_AUTHOR")
    private String  nameAuthor;

    @Column(name = "SURNAME_AUTHOR")
    private String surnameAuthor;

    @Column(name = "YEARS_OF_LIFE")
    private String yearsOfLife;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    List<Book> bookList;

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public String getYearsOfLife() {
        return yearsOfLife;
    }

    public void setYearsOfLife(String yearsOfLife) {
        this.yearsOfLife = yearsOfLife;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(nameAuthor, author.nameAuthor) &&
                Objects.equals(surnameAuthor, author.surnameAuthor) &&
                Objects.equals(yearsOfLife, author.yearsOfLife) &&
                Objects.equals(bookList, author.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameAuthor, surnameAuthor, yearsOfLife, bookList);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", surnameAuthor='" + surnameAuthor + '\'' +
                ", yearsOfLife='" + yearsOfLife + '\'' +
                '}';
    }
}
