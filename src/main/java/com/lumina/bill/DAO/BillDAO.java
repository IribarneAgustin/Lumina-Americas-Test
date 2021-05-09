package com.lumina.bill.DAO;

import com.lumina.bill.interfaces.IBillDAO;
import com.lumina.bill.model.Bill;

import java.util.ArrayList;
import java.util.List;

public class BillDAO implements IBillDAO {

    private List<Bill> billList;

    public BillDAO() {
        this.billList = new ArrayList<>();
    }

    public Bill getById(int id) {
        Bill toSearch = new Bill();
        for (Bill bill : billList) {
            if (bill.getId() == id) {
                toSearch = bill;
            }
        }
        return toSearch;
    }


    private int getNextId() {
        int id = 0;
        if (!billList.isEmpty()) {
            Bill bill = billList.get(billList.size() - 1);
            id = bill.getId();
        }
        return id + 1;
    }

    public void add(Bill bill) {
        if (bill != null) {
            bill.setId(getNextId());
            billList.add(bill);
        }

    }

    public List<Bill> getAll() {
        return this.billList;
    }


}
