package com.lumina.bill.DAO;

import com.lumina.bill.model.*;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    private List<Order> orderList;
    private List<CreditNote> creditNotes;


    public OrderDAO() {
        this.orderList = new ArrayList<>();
        this.creditNotes = new ArrayList<>();
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
            if (!order.isCancelled() && order.getStatus().equals("Pendiente") && order.getBill() == null) {
                ordersToBill.add(order);
            }
        }
        return ordersToBill;
    }


    public List<Order> getOrdersToCancel() {
        ArrayList<Order> ordersToCancel = new ArrayList<>();
        for (Order order : orderList) {
            if (order.isCancelled() && order.getCreditNote() == null) {
                ordersToCancel.add(order);
            }
        }
        return ordersToCancel;
    }

    private int getCreditNoteId() {
        int id = 0;
        if (!creditNotes.isEmpty()) {
            CreditNote creditNote = creditNotes.get(creditNotes.size() - 1);
            id = creditNote.getId();
        }
        return id + 1;
    }

    private CreditNote generateCreditNote(Order order) {

        CreditNote creditNote = new CreditNote();
        HeadCreditNote head = new HeadCreditNote();
        FootCreditNote foot = new FootCreditNote();

        head.setClient(order.getClient());
        head.setLetter(order.getBill().getHeadBill().getLetter());
        head.setEmissionDate(order.getBill().getHeadBill().getDate());
        foot.setTotal(order.getBill().getFootBill().getTotal());

        creditNote.setId(getCreditNoteId());
        creditNote.setHead(head);
        creditNote.setFoot(foot);

        return creditNote;
    }

    public void cancel(int orderId) {

        int toRemove = -1;

        for (Order order : orderList) {
            if (order.getId() == orderId) {
                if (order.getStatus().equals("Pendiente")) {
                    // orderList.remove(order); //concurrencia throw
                    toRemove = orderList.indexOf(order);
                } else {
                    CreditNote creditNote = generateCreditNote(order);
                    order.setCreditNote(creditNote);
                    this.creditNotes.add(creditNote);
                }
            }
        }
        if (toRemove != -1) {
            orderList.remove(toRemove);
        }
    }

    public List<CreditNote> getCreditNotes() {
        return this.creditNotes;
    }


}
