package io.droksty.transfersdemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Associates")
@Data
public class Associate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Title", unique = true, nullable = false)
    private String title;
}
