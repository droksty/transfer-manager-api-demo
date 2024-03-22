package io.droksty.transfersdemo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Title", unique = true, nullable = false)
    private String title;


    // Avoid bidirectional mapping, for now
    /*@OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Transfer> transfers = new ArrayList<>();*/
}
