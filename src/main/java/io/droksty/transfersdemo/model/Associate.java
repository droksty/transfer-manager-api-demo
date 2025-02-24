package io.droksty.transfersdemo.model;

import jakarta.persistence.*;

/**
 * An {@link Associate} instance represents either
 * the client or the operator of a {@link Transfer}.
 */
@Entity
@Table(name = "Associates")
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Title", unique = true, nullable = false)
    private String title;

    @Column(name = "Uid", unique = true, nullable = false)
    private String uid;

    public Associate() {}

    public Associate(Long id, String title, String uid) {
        this.id = id;
        this.title = title;
        this.uid = uid;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Associate{" +
                "id="       + id +
                ", uid="    + uid +
                ", title="  + title +
                '}';
    }
}
