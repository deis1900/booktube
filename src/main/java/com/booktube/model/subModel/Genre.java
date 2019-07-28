package com.booktube.model.subModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GENRE")
public class Genre {

    @Id
    @Column(name = "GENRE_ID")
    private Integer id;

    @Column(name = "GENRE")
    private String genre;

    @Enumerated(EnumType.STRING)
    private Subsection subsection;

    public Genre() {
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Subsection getSubsection() {
        return subsection;
    }

    public void setSubsection(Subsection subsection) {
        this.subsection = subsection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre1 = (Genre) o;
        return Objects.equals(genre, genre1.genre) &&
                subsection == genre1.subsection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, subsection);
    }

    @Override
    public String toString() {
        return "Genre{" +
                ", genre='" + genre + '\'' +
                ", subsection=" + subsection +
                '}';
    }
}

