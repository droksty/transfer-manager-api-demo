package io.droksty.transfersdemo.dto;

import io.droksty.transfersdemo.model.PayerType;
import io.droksty.transfersdemo.model.Type;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public final class TransferDTO {
    private Long          id;
    private LocalDate     pickupDate;
    private LocalTime     pickupTime;
    private String        passengerName;
    private Integer       totalPax;
    private Type          type;
    private String        transferFrom;
    private String        transferTo;
    private Double        priceTotal;
    private Double        priceNet;
    private AssociateDTO  client;
    private AssociateDTO  operator;
    private Double        operatorCost;
    private String        comments;
    private PayerType     paidBy;

    public Long         getId() {
        return id;
    }
    public void         setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Invalid pickupDate: pickupDate is null")
    public LocalDate    getPickupDate() {
        return pickupDate;
    }
    public void         setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    @NotNull(message = "Invalid pickupTime: pickupTime is null")
    public LocalTime    getPickupTime() {
        return pickupTime;
    }
    public void         setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String       getPassengerName() {
        return passengerName;
    }
    public void         setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    @PositiveOrZero(message = "Invalid totalPax: totalPax cannot be a negative number")
    public Integer      getTotalPax()     {
        return totalPax;
    }
    public void         setTotalPax(Integer totalPax) {
        this.totalPax = totalPax;
    }

    public Type         getType() {
        return type;
    }
    public void         setType(Type type) {
        this.type = type;
    }

    @NotNull(message = "Invalid transferFrom: transferFrom cannot be null")
    @Size(min = 3, max = 30, message = "Invalid transferFrom: Must be between 3 to 30 characters long.")
    public String       getTransferFrom() {
        return transferFrom;
    }
    public void         setTransferFrom(String transferFrom) {
        this.transferFrom = transferFrom.trim();
    }

    @NotNull(message = "Invalid transferTo: transferTo cannot be null")
    @Size(min = 3, max = 30, message = "Invalid transferTo: Must be between 3 to 30 characters long.")
    public String       getTransferTo() {
        return transferTo;
    }
    public void         setTransferTo(String transferTo) {
        this.transferTo = transferTo.trim();
    }

    @PositiveOrZero(message = "Invalid priceTotal: priceTotal cannot be negative")
    public Double       getPriceTotal() {
        return priceTotal;
    }
    public void         setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    @PositiveOrZero(message = "Invalid priceNet: priceNet cannot be negative")
    public Double       getPriceNet() {
        return priceNet;
    }
    public void         setPriceNet(Double priceNet) {
        this.priceNet = priceNet;
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

    @PositiveOrZero(message = "Invalid operatorCost: operatorCost cannot be negative")
    public Double       getOperatorCost() {
        return operatorCost;
    }
    public void         setOperatorCost(Double operatorCost) {
        this.operatorCost = operatorCost;
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
                "id="               + id +
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
