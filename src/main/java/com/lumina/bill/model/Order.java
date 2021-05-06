package com.lumina.bill.model;

public class Order {

    private int id;
    private Client client;
    private Product product;


    public Order(int id, Client client, Product product) {
        this.id = id;
        this.client = client;
        this.product = product;
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
