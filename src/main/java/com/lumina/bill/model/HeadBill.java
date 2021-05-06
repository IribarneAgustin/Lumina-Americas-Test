package com.lumina.bill.model;

import java.util.Date;

public class HeadBill {

    private int billId;
    private Date date;
    private long emissionCode;
    private char letter;
    private Client client;

    public HeadBill() {
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getEmissionCode() {
        return emissionCode;
    }

    public void setEmissionCode(long emissionCode) {
        this.emissionCode = emissionCode;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
