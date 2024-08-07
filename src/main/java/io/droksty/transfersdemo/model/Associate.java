package io.droksty.transfersdemo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Associates")
public class Associate {

    private Long    id;
    private String  title;


    // Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "Title", unique = true, nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    // Object methods
    @Override
    public String toString() {
        return "Associate{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
