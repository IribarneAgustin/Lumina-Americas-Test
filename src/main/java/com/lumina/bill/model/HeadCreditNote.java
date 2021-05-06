package com.lumina.bill.model;

import java.util.Date;

public class HeadCreditNote {

    private int creditNoteId;
    private Date emissionDate;
    private char letter;
    private Client client;

    public HeadCreditNote() {
    }

    public int getCreditNoteId() {
        return creditNoteId;
    }

    public void setCreditNoteId(int creditNoteId) {
        creditNoteId = creditNoteId;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
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
