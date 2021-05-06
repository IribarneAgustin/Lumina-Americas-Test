package com.lumina.bill.controller;
import com.lumina.bill.DAO.ClientDAO;
import com.lumina.bill.DAO.OrderDAO;
import com.lumina.bill.DAO.ProductDAO;
import com.lumina.bill.model.Bill;
import com.lumina.bill.model.Client;
import com.lumina.bill.model.Order;
import com.lumina.bill.model.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping
public class OrderController {

    private OrderDAO orderDAO;
    private ClientDAO clientDAO;
    private ProductDAO productDAO;

    public OrderController(){
        this.orderDAO = new OrderDAO();
        this.clientDAO = new ClientDAO();
        this.productDAO = new ProductDAO();
    }

    //Método para cargar datos en memoria
    private void addOrders(){
        int i = 0;
        ArrayList<Client> clients = (ArrayList<Client>) clientDAO.getAll();
        ArrayList<Product> products = (ArrayList<Product>) productDAO.getAll();
        while (i < 8){
            Order newOrder = new Order(i,clients.get(i), products.get(i));
            orderDAO.add(newOrder);
            i++;
        }
    }

    @GetMapping("/")
    public ModelAndView list(){
        addOrders();
        List<Order> orders = orderDAO.getAll();
        ModelAndView model = new ModelAndView("index");
        model.addObject("orders", orders);
        return model;
    }


}
