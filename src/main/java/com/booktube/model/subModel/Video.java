package com.booktube.model.subModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Video")
public class Video {

    @Id
    private Long id;

    @Column
    private String video;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creationDate;

    public Video() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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
        Video video1 = (Video) o;
        return Objects.equals(id, video1.id) &&
                Objects.equals(video, video1.video) &&
                Objects.equals(creationDate, video1.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, video, creationDate);
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", video='" + video + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
