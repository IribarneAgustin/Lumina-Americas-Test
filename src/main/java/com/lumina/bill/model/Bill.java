package com.lumina.bill.model;

import javax.persistence.*;

public class Bill {

    private int id;
    private HeadBill headBill;
    private BillDetails billDetails;
    private FootBill footBill;

    public Bill() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.lumina.bill.model.HeadBill getHeadBill() {
        return headBill;
    }

    public void setHeadBill(com.lumina.bill.model.HeadBill headBill) {
        this.headBill = headBill;
    }

    public BillDetails getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(BillDetails billDetails) {
        this.billDetails = billDetails;
    }

    public com.lumina.bill.model.FootBill getFootBill() {
        return footBill;
    }

    public void setFootBill(com.lumina.bill.model.FootBill footBill) {
        this.footBill = footBill;
    }
}
