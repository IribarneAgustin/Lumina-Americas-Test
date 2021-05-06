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

    public void add(Bill bill){

        if(bill != null)
        {
            billList.add(bill);
        }

    }

    public List<Bill> getAll(){
        return this.billList;
    }




}
