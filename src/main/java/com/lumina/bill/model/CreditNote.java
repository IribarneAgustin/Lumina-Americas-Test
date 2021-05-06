package com.lumina.bill.model;

public class CreditNote {

    private int id;
    private HeadCreditNote head;
    private FootCreditNote foot;

    public CreditNote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HeadCreditNote getHead() {
        return head;
    }

    public void setHead(HeadCreditNote head) {
        this.head = head;
    }

    public FootCreditNote getFoot() {
        return foot;
    }

    public void setFoot(FootCreditNote foot) {
        this.foot = foot;
    }
}
