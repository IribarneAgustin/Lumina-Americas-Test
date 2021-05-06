package com.lumina.bill.model;



public class FootBill {

    private int billId;
    private int total;
    private int totalIVA;

    public FootBill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(int totalIVA) {
        this.totalIVA = totalIVA;
    }
}
