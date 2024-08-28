package io.droksty.transfersdemo.dto;

import io.droksty.transfersdemo.model.Type;

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
    public Double getPriceTotal() {
        return priceTotal;
    }
    public Double getPriceNet() {
        return priceNet;
    }
    public AssociateDTO getClient() {
        return client;
    }
    public AssociateDTO getOperator() {
        return operator;
    }
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
