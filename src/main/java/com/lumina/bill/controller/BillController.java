package com.lumina.bill.controller;

import com.lumina.bill.DAO.BillDAO;
import com.lumina.bill.DAO.ClientDAO;
import com.lumina.bill.DAO.OrderDAO;
import com.lumina.bill.DAO.ProductDAO;
import com.lumina.bill.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;


@Controller
@RequestMapping
public class BillController {

    private BillDAO billDAO;
    private OrderDAO orderDAO;
    private ClientDAO clientDAO;
    private ProductDAO productDAO;


    public BillController() {
        this.billDAO = new BillDAO();
        this.orderDAO = new OrderDAO();
        this.clientDAO = new ClientDAO();
        this.productDAO = new ProductDAO();
        addOrders();
    }

    //Método para cargar datos en memoria
    @GetMapping("/addOrders")
    private void addOrders() {
        int i = 0;
        ArrayList<Client> clients = (ArrayList<Client>) clientDAO.getAll();
        ArrayList<Product> products = (ArrayList<Product>) productDAO.getAll();
        while (i < 8) {
            Order newOrder = new Order(i, clients.get(i), products.get(i), (int) (Math.random() * 5) + 1);
            if (i % 2 == 0) {
                newOrder.setCancelled(true);
            }
            orderDAO.add(newOrder);
            i++;
        }
    }

    @GetMapping("/")
    public ModelAndView listOrders() {
        List<Order> orders = orderDAO.getAll();
        ModelAndView model = new ModelAndView("index");
        model.addObject("orders", orders);
        return model;
    }

    @GetMapping("/ordersToCancel")
    public ModelAndView ordersToCancel() {
        ArrayList<Order> ordersToCancel = (ArrayList<Order>) orderDAO.getOrdersToCancel();
        ModelAndView model = new ModelAndView("toCancelList");
        model.addObject("orders", ordersToCancel);
        return model;
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(int orderId) {
        orderDAO.cancel(orderId);
        ArrayList<Order> ordersToCancel = (ArrayList<Order>) orderDAO.getOrdersToCancel();
        ModelAndView model = new ModelAndView("toCancelList");
        model.addObject("orders", ordersToCancel);
        return model;
    }

    @GetMapping("/creditNotes")
    public ModelAndView creditNotes() {
        ArrayList<CreditNote> creditNotes = (ArrayList<CreditNote>) orderDAO.getCreditNotes();
        ModelAndView model = new ModelAndView("creditNotes");
        model.addObject("creditNotes", creditNotes);
        return model;
    }


    private char generateLetter(Client client) {
        char letter = ' ';
        if (client != null) {
            if (client.getTaxStatus().equals("Responsable Inscripto") == true) {
                letter = 'A';
            } else if (client.getTaxStatus().equals("Monotributo") == true) {
                letter = 'B';
            } else {
                letter = 'X';
            }
        }
        return letter;
    }

    private double generatePercentage(Client client) {
        double percentage = 0;
        if (client != null) {
            if (client.getTaxStatus().equals("Responsable Inscripto") == true) {
                percentage = 10.05;
            } else if (client.getTaxStatus().equals("Monotributo") == true) {
                percentage = 21;
            } else {
                percentage = 70;
            }
        }
        return percentage;
    }

    private HeadBill generateHead(Client client) {

        HeadBill head = new HeadBill();
        head.setDate(LocalDate.now());
        head.setEmissionCode(UUID.randomUUID());
        head.setLetter(generateLetter(client));
        head.setClient(client);

        return head;

    }

    private double generateIVAAmount(double netPrice, double IVAPercentage) {
        return (netPrice * IVAPercentage) / 100;
    }

    private BillDetails generateDetails(Order order) {

        BillDetails details = new BillDetails();
        details.setProduct(order.getProduct());
        details.setUnitPrice(order.getProduct().getPrice());
        details.setQuantity(order.getQuantity());
        details.setNetPrice(order.getQuantity() * order.getProduct().getPrice());
        details.setIVAPercentage(generatePercentage(order.getClient()));
        details.setIVAAmount(generateIVAAmount(details.getNetPrice(), generatePercentage(order.getClient())));
        details.setSellPrice(details.getNetPrice() + details.getIVAAmount());

        return details;

    }

    private FootBill generateFoot(BillDetails details) {
        FootBill foot = new FootBill();
        if (details != null) {
            foot.setTotal(details.getNetPrice() + details.getIVAAmount());
            foot.setTotalIVA(details.getIVAAmount());
        }
        return foot;
    }


    public void addBill(Order order) {
        if (order != null) {
            Bill bill = new Bill();
            bill.setHeadBill(generateHead(order.getClient()));
            bill.setBillDetails(generateDetails(order));
            bill.setFootBill(generateFoot(bill.getBillDetails()));
            order.setBill(bill);
            order.setStatus("Facturado");
            order.setCancelled(true); // Cancelar toda factura agregada
            this.billDAO.add(bill);

        }
    }

    @GetMapping("/addBills")
    public String addBills() {
        List<Order> orders = orderDAO.getOrdersToBill();
        for (Order order : orders) {
            addBill(order);
        }
        return "redirect:/";
    }

    @GetMapping("/addBill")
    public String addBill(int orderId) {
        Order order = orderDAO.getById(orderId);
        addBill(order);
        return "redirect:/";
    }


    @GetMapping("/billList")
    public ModelAndView list() {
        List<Bill> bills = billDAO.getAll();
        ModelAndView model = new ModelAndView("billList");
        model.addObject("bills", bills);
        return model;
    }

    // Método para escribir archivo

    private void wirteFile(ArrayList<Bill> bills, ArrayList<CreditNote> notes) {

        try {
            FileWriter writer = new FileWriter("src\\main\\resources\\static\\workDay.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("Facturas del dia");
            bufferedWriter.newLine();
            for (Bill bill : bills) {

                Integer dni = bill.getHeadBill().getClient().getDni();
                String dniType = bill.getHeadBill().getClient().getDniType();
                Character letter = bill.getHeadBill().getLetter();
                Integer nro = bill.getId();
                LocalDate emissionDate = bill.getHeadBill().getDate();
                Double total = bill.getFootBill().getTotal();

                String toWrite = "Cliente: " + dni + "-" + dniType + "- Tipo:" + letter + "- Nro:" + nro + "- Fecha: " + emissionDate + " - $" + total;
                bufferedWriter.newLine();
                bufferedWriter.write(toWrite);

            }

            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("Notas de crédito del dia");
            bufferedWriter.newLine();

            for (CreditNote creditNote : notes) {

                Integer dni = creditNote.getHead().getClient().getDni();
                String dniType = creditNote.getHead().getClient().getDniType();
                Character letter = creditNote.getHead().getLetter();
                Integer nro = creditNote.getId();
                LocalDate emissionDate = creditNote.getHead().getEmissionDate();
                Double total = creditNote.getFoot().getTotal();

                String toWrite = "Cliente: " + dni + "-" + dniType + "- Tipo:" + letter + "- Nro:" + nro + "- Fecha: " + emissionDate + " - $" + total;
                bufferedWriter.newLine();
                bufferedWriter.write(toWrite);

            }

            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/workDay")
    public String workDay() {
        LocalDate date = LocalDate.now();
        ArrayList<Bill> billsOfTheDay = (ArrayList<Bill>) billDAO.getByDate(date);
        ArrayList<CreditNote> notesOfTheDay = (ArrayList<CreditNote>) orderDAO.getNotesByDate(date);
        wirteFile(billsOfTheDay, notesOfTheDay);
        return "redirect:/file/workDay.txt";

    }

    // Método para descargar archivo generado

    @RequestMapping("/file/{fileName}")
    @ResponseBody
    public void show(@PathVariable("fileName") String fileName, HttpServletResponse response) {

        response.setHeader("Content-Disposition", "attachment; filename=" +fileName);
        response.setHeader("Content-Transfer-Encoding", "binary");
        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream("src\\main\\resources\\static\\"+fileName);
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) > 0) {
                bos.write(buf,0,len);
            }
            bos.close();
            response.flushBuffer();
        }
        catch(IOException e) {
            e.printStackTrace();

        }
    }


}
