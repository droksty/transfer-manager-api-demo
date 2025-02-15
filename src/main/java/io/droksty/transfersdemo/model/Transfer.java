package io.droksty.transfersdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Encapsulates a {@link Transfer} instance.<br>
 * All {@code Transfer} instances are required to have valid,
 * non-null values on their datetime and location related properties.<br>
 * Moreover, unless both properties are null, a {@code Transfer}'s
 * {@code client} should never match its {@code operator}.
 */
@Entity
@Table(name = "Transfers", indexes = { @Index(name = "ix_date", columnList = "Date") })
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(nullable = false, name = "Date")
    private LocalDate date;

    @Column(nullable = false, name = "Time")
    private LocalTime time;

    @Column(name = "Name")
    private String name;

    @Column(name = "Pax")
    private Integer pax;

    @Column(name = "Type")
    @Enumerated
    private TransferType type;

    @Column(nullable = false, name = "TransferFrom")
    private String from;

    @Column(nullable = false, name = "TransferTo")
    private String to;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Net")
    private Double net;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(foreignKey = @ForeignKey(name="ClientId"))
    private Associate client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(foreignKey = @ForeignKey(name = "OperatorId"))
    private Associate operator;

    @Column(name = "Cost")
    private Double cost;

    @Column(name = "Comments")
    private String comments;

    @Column(name = "PaidBy")
    @Enumerated
    private PayerType paidBy;

    public Transfer() {}

    public Transfer(Long id, LocalDate date, LocalTime time, String from, String to) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getPax() {
        return pax;
    }
    public void setPax(Integer pax) {
        this.pax = pax;
    }

    public TransferType getType() {
        return type;
    }
    public void setType(TransferType type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getNet() {
        return net;
    }
    public void setNet(Double net) {
        this.net = net;
    }

    public Associate getClient() {
        return client;
    }
    public void setClient(Associate client) {
        this.client = client;
    }

    public Associate getOperator() {
        return operator;
    }
    public void setOperator(Associate operator) {
        this.operator = operator;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    public PayerType getPaidBy() {
        return paidBy;
    }
    public void setPaidBy(PayerType paidBy) {
        this.paidBy = paidBy;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id="         + id +
                ", date="     + date +
                ", time="     + time +
                ", name="     + name +
                ", pax="      + pax +
                ", type="     + type +
                ", from="     + from +
                ", to="       + to +
                ", total="    + total +
                ", net="      + net +
                ", paidBy="   + paidBy +
                ", client="   + client +
                ", operator=" + operator +
                ", cost="     + cost +
                ", comments=" + comments +
                '}';
    }
}