package com.lumina.bill.controller;
import com.lumina.bill.DAO.BillDAO;
import com.lumina.bill.model.Bill;
import com.lumina.bill.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping
public class BillController {

    private BillDAO billDAO;

    public BillController(){
        this.billDAO = new BillDAO();
    }

    @GetMapping("/addBillView")
    public String addBillView(Bill bill){
        return "/addBill";
    }

    @GetMapping("/billList")
    public ModelAndView list(){

        Bill asd = new Bill();
        asd.setId(213);
        billDAO.add(asd);
        List<Bill> bills = billDAO.getAll();
        ModelAndView model = new ModelAndView("billList");
        model.addObject("bills", bills);
        return model;
    }




}
