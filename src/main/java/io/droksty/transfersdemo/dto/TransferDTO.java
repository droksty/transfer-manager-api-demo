package io.droksty.transfersdemo.dto;

import io.droksty.transfersdemo.model.Associate;
import io.droksty.transfersdemo.model.Type;

import java.time.LocalDate;
import java.time.LocalTime;

public final class TransferDTO {
    private final Long            id;
    private final LocalDate       pickupDate;
    private final LocalTime       pickupTime;
    private final String          passengerName;
    private final Integer         totalPax;
    private final Type            type;
    private final String          transferFrom;
    private final String          transferTo;
    private final Float           priceTotal;
    private final Float           priceNet;
    private final Associate       client;
    private final Associate       operator;
    private final Float           operatorCost;

    public TransferDTO(Long id, LocalDate pickupDate, LocalTime pickupTime,
                       String passengerName, Integer totalPax, Type type,
                       String transferFrom, String transferTo, Float priceTotal,
                       Float priceNet, Associate client, Associate operator,
                       Float operatorCost) {
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
    }

    public Long getId() {
        return id;
    }
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    public LocalTime getPickupTime() {
        return pickupTime;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public Integer getTotalPax()     {
        return totalPax;
    }
    public Type getType() {
        return type;
    }
    public String getTransferFrom() {
        return transferFrom;
    }
    public String getTransferTo() {
        return transferTo;
    }
    public Float getPriceTotal() {
        return priceTotal;
    }
    public Float getPriceNet() {
        return priceNet;
    }
    public Associate getClient() {
        return client;
    }
    public Associate getOperator() {
        return operator;
    }
    public Float getOperatorCost() {
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
