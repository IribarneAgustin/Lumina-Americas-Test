package com.lumina.bill.model;


public class BillDetails {

    private int billId;
    private Product product;
    private double unitPrice;
    private double IVAPercentage;
    private int quantity;
    private double sellPrice;
    private double netPrice;
    private double IVAAmount;

    public BillDetails() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getIVAPercentage() {
        return IVAPercentage;
    }

    public void setIVAPercentage(double IVAPercentage) {
        this.IVAPercentage = IVAPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    public double getIVAAmount() {
        return IVAAmount;
    }

    public void setIVAAmount(double IVAAmount) {
        this.IVAAmount = IVAAmount;
    }
}
