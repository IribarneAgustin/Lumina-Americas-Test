package com.lumina.bill.DAO;

import com.lumina.bill.model.Client;
import com.lumina.bill.model.Order;
import com.lumina.bill.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private List<Order> orderList;


    public OrderDAO() {
        this.orderList = new ArrayList<>();
    }


    public void add(Order order) {
        if (order != null) {
            orderList.add(order);
        }
    }

    public List<Order> getAll() {
        return this.orderList;
    }


}
