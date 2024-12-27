package io.droksty.transfersdemo.dto;

import io.droksty.transfersdemo.model.Type;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public final class TransferDTO {
    private final Long          id;
    private final LocalDate     pickupDate;
    private final LocalTime     pickupTime;
    private final String        passengerName;
    private final Integer       totalPax;
    private final Type          type;
    private final String        transferFrom;
    private final String        transferTo;
    private final Double        priceTotal;
    private final Double        priceNet;
    private final AssociateDTO  client;
    private final AssociateDTO  operator;
    private final Double        operatorCost;

    public TransferDTO(Long id, LocalDate pickupDate, LocalTime pickupTime,
                       String passengerName, Integer totalPax, Type type,
                       String transferFrom, String transferTo, Double priceTotal,
                       Double priceNet, AssociateDTO client, AssociateDTO operator,
                       Double operatorCost) {
        this.id = id;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
        this.passengerName = passengerName;
        this.totalPax = totalPax;
        this.type = type;
        this.transferFrom = transferFrom == null ? null : transferFrom.trim();
        this.transferTo = transferTo == null? null : transferTo.trim();
        this.priceTotal = priceTotal;
        this.priceNet = priceNet;
        this.client = client;
        this.operator = operator;
        this.operatorCost = operatorCost;
    }

    public Long getId() {
        return id;
    }

    @NotNull(message = "Invalid pickupDate: pickupDate is null")
    public LocalDate getPickupDate() {
        return pickupDate;
    }

    @NotNull(message = "Invalid pickupTime: pickupTime is null")
    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public String getPassengerName() {
        return passengerName;
    }

    @PositiveOrZero(message = "Invalid totalPax: totalPax cannot be a negative number")
    public Integer getTotalPax()     {
        return totalPax;
    }

    public Type getType() {
        return type;
    }

    @NotNull(message = "Invalid transferFrom: transferFrom cannot be null")
    @Size(min = 3, max = 30, message = "Invalid transferFrom: Must be between 3 to 30 characters long.")
    public String getTransferFrom() {
        return transferFrom;
    }

    @NotNull(message = "Invalid transferTo: transferTo cannot be null")
    @Size(min = 3, max = 30, message = "Invalid transferTo: Must be between 3 to 30 characters long.")
    public String getTransferTo() {
        return transferTo;
    }

    @PositiveOrZero(message = "Invalid priceTotal: priceTotal cannot be negative")
    public Double getPriceTotal() {
        return priceTotal;
    }

    @PositiveOrZero(message = "Invalid priceNet: priceNet cannot be negative")
    public Double getPriceNet() {
        return priceNet;
    }

    public AssociateDTO getClient() {
        return client;
    }

    public AssociateDTO getOperator() {
        return operator;
    }

    @PositiveOrZero(message = "Invalid operatorCost: operatorCost cannot be negative")
    public Double getOperatorCost() {
        return operatorCost;
    }

    @Override
    public String toString() {
        return "TransferDTO{" +
                "id=" + id +
                ", pickupDate=" + pickupDate +
                ", pickupTime=" + pickupTime +
                ", passengerName='" + passengerName + '\'' +
                ", totalPax=" + totalPax +
                ", type=" + type +
                ", transferFrom='" + transferFrom + '\'' +
                ", transferTo='" + transferTo + '\'' +
                ", priceTotal=" + priceTotal +
                ", priceNet=" + priceNet +
                ", client=" + client +
                ", operator=" + operator +
                ", operatorCost=" + operatorCost +
                '}';
    }
}
