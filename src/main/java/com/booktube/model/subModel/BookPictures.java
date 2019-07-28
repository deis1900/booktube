package com.booktube.model.subModel;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class BookPictures {

    @Column(name = "PHOTO")
    String photo;

    public BookPictures() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookPictures that = (BookPictures) o;
        return Objects.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(photo);
    }

    @Override
    public String toString() {
        return "BookPictures{" +
                "photo='" + photo + '\'' +
                '}';
    }
}
