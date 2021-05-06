package com.lumina.bill.model;

import javax.persistence.*;

public class Bill {

    private int id;
    private HeadBill HeadBill;
    private BillDetails billDetails;
    private FootBill FootBill;

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.lumina.bill.model.HeadBill getHeadBill() {
        return HeadBill;
    }

    public void setHeadBill(com.lumina.bill.model.HeadBill headBill) {
        HeadBill = headBill;
    }

    public BillDetails getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }

    public com.lumina.bill.model.FootBill getFootBill() {
        return FootBill;
    }

    public void setFootBill(com.lumina.bill.model.FootBill footBill) {
        FootBill = footBill;
    }
}
