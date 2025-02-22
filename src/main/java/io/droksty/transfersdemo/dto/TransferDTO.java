package io.droksty.transfersdemo.dto;

import io.droksty.transfersdemo.model.PayerType;
import io.droksty.transfersdemo.model.TransferType;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public final class TransferDTO {
    private Long id;

    @NotNull(message = "Required field: date")
    private LocalDate date;

    @NotNull(message = "Required field: to")
    private LocalTime time;

    private String name;

    @PositiveOrZero(message = "Number of pax cannot be negative")
    private Integer pax;

    private TransferType type;

    @NotNull(message = "Required field: from")
    @Size(min = 3, max = 30, message = "Enter a value between 3 to 30 characters for field: from")
    private String from;

    @NotNull(message = "Required field: to")
    @Size(min = 3, max = 30, message = "Enter a value between 3 to 30 characters for field: to")
    private String to;

    @PositiveOrZero(message = "total cannot be negative")
    private Double total;

    @PositiveOrZero(message = "net cannot be negative")
    private Double net;

    private AssociateDTO client;
    private AssociateDTO operator;

    @PositiveOrZero(message = "cost cannot be negative")
    private Double cost;

    private String comments;
    private PayerType paidBy;

    public Long         getId() {
        return id;
    }
    public void         setId(Long id) {
        this.id = id;
    }

    public LocalDate    getDate() {
        return date;
    }
    public void         setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime    getTime() {
        return time;
    }
    public void         setTime(LocalTime time) {
        this.time = time;
    }

    public String       getName() {
        return name;
    }
    public void         setName(String name) {
        this.name = name;
    }

    public Integer      getPax()     {
        return pax;
    }
    public void         setPax(Integer pax) {
        this.pax = pax;
    }

    public TransferType getType() {
        return type;
    }
    public void         setType(TransferType type) {
        this.type = type;
    }

    public String       getFrom() {
        return from;
    }
    public void         setFrom(String from) {
        this.from = from.trim();
    }

    public String       getTo() {
        return to;
    }
    public void         setTo(String to) {
        this.to = to.trim();
    }

    public Double       getTotal() {
        return total;
    }
    public void         setTotal(Double total) {
        this.total = total;
    }

    public Double       getNet() {
        return net;
    }
    public void         setNet(Double net) {
        this.net = net;
    }

    public AssociateDTO getClient() {
        return client;
    }
    public void         setClient(AssociateDTO client) {
        this.client = client;
    }

    public AssociateDTO getOperator() {
        return operator;
    }
    public void         setOperator(AssociateDTO operator) {
        this.operator = operator;
    }

    public Double       getCost() {
        return cost;
    }
    public void         setCost(Double cost) {
        this.cost = cost;
    }

    public String       getComments() {
        return comments;
    }
    public void         setComments(String comments) {
        this.comments = comments;
    }

    public PayerType    getPaidBy() {
        return paidBy;
    }
    public void         setPaidBy(PayerType paidBy) {
        this.paidBy = paidBy;
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                "id="           + id +
                ", date="       + date +
                ", time="       + time +
                ", name="       + name +
                ", pax="        + pax +
                ", type="       + type +
                ", from="       + from +
                ", to="         + to +
                ", paidBy="     + paidBy +
                ", total="      + total +
                ", net="        + net +
                ", client="     + client +
                ", operator="   + operator +
                ", cost="       + cost +
                ", comments="   + comments +
                '}';
    }
}
