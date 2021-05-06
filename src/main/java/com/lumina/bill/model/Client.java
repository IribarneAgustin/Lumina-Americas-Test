package com.lumina.bill.model;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String dniType; //DNI, CUIT, ETC
    private int dni;
    private String taxStatus;

    public Client(int id, String address, String dniType, int dni, String taxStatus) {
        this.id = id;
        this.address = address;
        this.dniType = dniType;
        this.dni = dni;
        this.taxStatus = taxStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDniType() {
        return dniType;
    }

    public void setDniType(String dniType) {
        this.dniType = dniType;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
