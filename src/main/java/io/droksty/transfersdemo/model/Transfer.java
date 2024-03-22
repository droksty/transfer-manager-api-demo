package io.droksty.transfersdemo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Transfers", indexes = { @Index(name = "IX_PickupDate", columnList = "PickupDate") })
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer     id;

    @Column(nullable = false, name = "PickupDate")
    private LocalDate pickupDate;

    @Column(nullable = false, name = "PickupTime")
    private LocalTime pickupTime;

    @Column(name = "PassengerName")
    private String passengerName;

    @Column(name = "Pax")
    private Short pax;

    @Column(name = "Type")
    @Enumerated
    private Type type;

    @Column(nullable = false, name = "TransferFrom")
    private String transferFrom;

    @Column(nullable = false, name = "TransferTo")
    private String transferTo;

    @Column(name = "PriceTotal")
    private Float priceTotal;

    @Column(name = "PriceNet")
    private Float priceNet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(foreignKey = @ForeignKey(name="Client_Id"))
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(foreignKey = @ForeignKey(name = "Provider_Id"))
    private Provider provider;

    @Column(name = "ProviderCost")
    private Float providerCost;


    // Υποπερίπτωση όπου ένα transfer εκτελέστηκε από περισσότερους από έναν Provider ??
    /*@Column(name = "ProviderPax")
    private Short       providerPax;*/
    /*@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Transfers_Providers",
            joinColumns = @JoinColumn(
                    name = "transfer_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "provider_id",
                    referencedColumnName = "id"
            )
    )
    private List<Provider> providers = new ArrayList<>();*/
}
