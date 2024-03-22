package io.droksty.transfersdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Providers")
@Data
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name", unique = true, nullable = false)
    private String name;
}
