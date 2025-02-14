package io.droksty.transfersdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Encapsulates a transfer service.
 * @apiNote
 * <ul>
 *     <li>A transfer must always have non-null values on the following fields:
 *         <ol>
 *             <li>pickupDate</li>
 *             <li>pickupTime</li>
 *             <li>transferFrom</li>
 *             <li>transferTo</li>
 *         </ol>
 *     </li>
 *     <li>Unless both values are null, a transfer's client should not match its operator.</li>
 * </ul>
 */
@Entity
@Table(name = "Transfers", indexes = { @Index(name = "date", columnList = "pickupDate") })
public class Transfer {
    private Long        id;
    private LocalDate   pickupDate;
    private LocalTime   pickupTime;
    private String      passengerName;
    private Integer     totalPax;
    private Type        type;
    private String      transferFrom;
    private String      transferTo;
    private Double      priceTotal;
    private Double      priceNet;
    private Associate   client;
    private Associate   operator;
    private Double      operatorCost;
    private String      comments;
    private PayerType   paidBy;

    public Transfer() {}

    public Transfer(Long id, LocalDate pickupDate, LocalTime pickupTime,
                    String passengerName, Integer totalPax, Type type,
                    String transferFrom, String transferTo, Double priceTotal,
                    Double priceNet, Associate client, Associate operator,
                    Double operatorCost, String comments, PayerType paidBy) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.passengerName = passengerName;
        this.totalPax = totalPax;
        this.type = type;
        this.transferFrom = transferFrom;
        this.transferTo = transferTo;
        this.priceTotal = priceTotal;
        this.priceNet = priceNet;
        this.client = client;
        this.operator = operator;
        this.operatorCost = operatorCost;
        this.comments = comments;
        this.paidBy = paidBy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false, name = "PickupDate")
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    @Column(nullable = false, name = "PickupTime")
    public LocalTime getPickupTime() {
        return pickupTime;
    }
    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    @Column(name = "PassengerName")
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @Column(name = "TotalPax")
    public Integer getTotalPax() {
        return totalPax;
    }
    public void setTotalPax(Integer totalPax) {
        this.totalPax = totalPax;
    }

    @Column(name = "Type")
    @Enumerated
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    @Column(nullable = false, name = "TransferFrom")
    public String getTransferFrom() {
        return transferFrom;
    }
    public void setTransferFrom(String transferFrom) {
        this.transferFrom = transferFrom;
    }

    @Column(nullable = false, name = "TransferTo")
    public String getTransferTo() {
        return transferTo;
    }
    public void setTransferTo(String transferTo) {
        this.transferTo = transferTo;
    }

    @Column(name = "PriceTotal")
    public Double getPriceTotal() {
        return priceTotal;
    }
    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    @Column(name = "PriceNet")
    public Double getPriceNet() {
        return priceNet;
    }
    public void setPriceNet(Double priceNet) {
        this.priceNet = priceNet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(foreignKey = @ForeignKey(name="ClientId"))
    public Associate getClient() {
        return client;
    }
    public void setClient(Associate client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(foreignKey = @ForeignKey(name = "OperatorId"))
    public Associate getOperator() {
        return operator;
    }
    public void setOperator(Associate operator) {
        this.operator = operator;
    }

    @Column(name = "OperatorCost")
    public Double getOperatorCost() {
        return operatorCost;
    }
    public void setOperatorCost(Double operatorCost) {
        this.operatorCost = operatorCost;
    }

    @Column(name = "Comments")
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Column(name = "PaidBy")
    @Enumerated
    public PayerType getPaidBy() {
        return paidBy;
    }
    public void setPaidBy(PayerType paidBy) {
        this.paidBy = paidBy;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", pickupDate="     + pickupDate +
                ", pickupTime="     + pickupTime +
                ", passengerName="  + passengerName +
                ", totalPax="       + totalPax +
                ", type="           + type +
                ", transferFrom="   + transferFrom +
                ", transferTo="     + transferTo +
                ", paidBy="         + paidBy +
                ", priceTotal="     + priceTotal +
                ", priceNet="       + priceNet +
                ", client="         + client +
                ", operator="       + operator +
                ", operatorCost="   + operatorCost +
                ", comments="       + comments +
                '}';
    }
}