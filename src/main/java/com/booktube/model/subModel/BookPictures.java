package com.booktube.model.subModel;

import javax.persistence.*;

@Embeddable
public class BookPictures {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String photo;

    public BookPictures() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "BookPictures{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                '}';
    }
}
