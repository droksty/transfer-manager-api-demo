package io.droksty.transfersdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = true)
    private String title;

    // Avoid bidirectional mapping, for now
    /*@OneToMany(mappedBy = "client")
    private List<Transfer> transfers = new ArrayList<>();*/
}
