package com.lumina.bill.model;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class HeadBill {

    private int billId;
    private LocalDate date;
    private UUID emissionCode;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public UUID getEmissionCode() {
        return emissionCode;
    }

    public void setEmissionCode(UUID emissionCode) {
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
