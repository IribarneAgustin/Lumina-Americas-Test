package com.lumina.bill.model;

import java.time.LocalDate;
import java.util.Date;

public class HeadCreditNote {

    private LocalDate emissionDate;
    private char letter;
    private Client client;

    public HeadCreditNote() {
    }

    public LocalDate getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(LocalDate emissionDate) {
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
