package com.booktube.model.subModel;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME_AUTHOR")
    private String  nameAuthor;

    @Column(name = "SURNAME_AUTHOR")
    private String surnameAuthor;

    @Column(name = "YEARS_OF_LIFE")
    private String yearsOfLife;

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
