package io.droksty.transfersdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Transfers", indexes = {
        @Index(name = "Date_idx", columnList = "pickup_date"),
})
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) private LocalDate pickupDate;
    @Column(nullable = false) private LocalTime pickupTime;
    @Column(nullable = false) private String    passengerName;
    @Column(nullable = false) private Short     pax;
    @Column(nullable = false) private Type      type;
    @Column(nullable = false) private String    transferFrom;
    @Column(nullable = false) private String    transferTo;
    @Column(nullable = false) private Float     priceTotal;
    @Column(nullable = false) private Float     priceNet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(foreignKey = @ForeignKey(name="Client_FK_Id"))
    private Client client;


    // Υποπεριπτώσεις όπου ένα transfer εκτελείται από περισσότερα από ένα οχήματα / οδηγούς ??
    /*private List<String> vehicles;
    private List<String> drivers;*/
}
