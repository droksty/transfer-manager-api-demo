package io.droksty.transfersdemo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Encapsulates a Transfer. The following rules apply:
 * <ul>
 *     <li>
 *         A Transfer cannot have nulls on the following fields:
 *         <ul>
 *             <li>pickupDate</li>
 *             <li>pickupTime</li>
 *             <li>transferFrom</li>
 *             <li>transferTo</li>
 *         </ul>
 *     </li>
 *     <li>A Transfer may have 0 or 1 clients.</li>
 *     <li>A Transfer may have 0 or 1 operators.</li>
 *     <li>A Transfer's client should not be the same as its operator, unless both values are null.</li>
 * </ul>
 */
@Entity
@Table(name = "Transfers", indexes = { @Index(name = "IX_PickupDate", columnList = "PickupDate") })
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(nullable = false, name = "PickupDate")
    private LocalDate pickupDate;

    @Column(nullable = false, name = "PickupTime")
    private LocalTime pickupTime;

    @Column(name = "PassengerName")
    private String passengerName;

    @Column(name = "TotalPax")
    private Integer totalPax;

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
    private Associate client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(foreignKey = @ForeignKey(name = "Operator_Id"))
    private Associate operator;

    @Column(name = "OperatorCost")
    private Float operatorCost;
}
