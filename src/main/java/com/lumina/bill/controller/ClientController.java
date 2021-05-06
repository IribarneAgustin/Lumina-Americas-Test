package com.lumina.bill.controller;
import com.lumina.bill.IService.IClientService;
import com.lumina.bill.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping
public class ClientController {

    @Autowired
    private IClientService service;

    @GetMapping("/clientList")
    public String list(Model model){
        List<Client> clients = service.list();
        model.addAttribute("clients",clients);
        return "index";
    }
}
