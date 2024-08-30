package io.droksty.transfersdemo.dto;

import java.util.ArrayList;
import java.util.List;

public final class TransferListView {
    private final List<TransferDTO> transfers;
    private Double totalSales   = 0d;
    private Double totalNet     = 0d;
    private Double totalCost    = 0d;

    private TransferListView(int capacity) {
        this.transfers = new ArrayList<>(capacity);
    }

    public static TransferListView createFrom(List<TransferDTO> transferListDTO) {
        TransferListView listView = new TransferListView(transferListDTO.size());

        transferListDTO.forEach(t -> {
            listView.transfers.add(t);
            listView.setTotalSales(listView.getTotalSales() + (t.getPriceTotal() != null ? t.getPriceTotal() : 0));
            listView.setTotalNet(listView.getTotalNet() + (t.getPriceNet() != null ? t.getPriceNet() : 0));
            listView.setTotalCost(listView.getTotalCost() + (t.getOperatorCost() != null ? t.getOperatorCost() : 0));
        });

        return listView;
    }

    public List<TransferDTO> getTransfers() {
        return List.copyOf(transfers);
    }

    public double getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(Double totalSales) {
        this.totalSales = totalSales;
    }
    public double getTotalNet() {
        return totalNet;
    }
    public void setTotalNet(Double totalNet) {
        this.totalNet = totalNet;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
