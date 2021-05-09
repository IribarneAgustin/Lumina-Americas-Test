package com.lumina.bill.DAO;

import com.lumina.bill.model.Bill;
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

    public Order getById(int id) {
        Order toSearch = null;
        for (Order order : orderList) {
            if (order.getId() == id) {
                toSearch = order;
            }
        }
        return toSearch;
    }


    public void add(Order order) {
        if (order != null) {
            orderList.add(order);
        }
    }

    public List<Order> getAll() {
        return this.orderList;
    }

    public List<Order> getOrdersToBill() {
        ArrayList<Order> ordersToBill = new ArrayList<>();
        for (Order order : orderList) {
            if (order.isCancelled() == false && order.getStatus().equals("Pendiente") && order.getBill() == null) {
                ordersToBill.add(order);
            }
        }
        return ordersToBill;
    }

    public List<Order> getOrdersToCancel() {

        ArrayList<Order> ordersToCancel = new ArrayList<>();
        for (Order order : orderList) {
            if (order.isCancelled()) {
                ordersToCancel.add(order);
            }
        }
        return ordersToCancel;

    }


}
