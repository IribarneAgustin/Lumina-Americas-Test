package com.lumina.bill.model;

public class Order {

    private int id;
    private Client client;
    private Product product;
    private int quantity;
    private String status; //Pendiente o  facturado
    private boolean cancelled;
    private Bill bill;



    public Order(int id, Client client, Product product, int quantity) {
        this.id = id;
        this.client = client;
        this.product = product;
        this.quantity = quantity;
        this.status = "Pendiente";
        this.cancelled = false;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
