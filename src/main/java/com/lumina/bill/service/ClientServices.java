package com.lumina.bill.service;

import com.lumina.bill.IService.IClientService;
import com.lumina.bill.interfaces.IClient;
import com.lumina.bill.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServices implements IClientService {

    @Autowired
    private IClient data;
    @Override
    public List<Client> list() {
        return (List<Client>) data.findAll();
    }

    @Override
    public Optional<Client> getById() {
        return Optional.empty();
    }

    @Override
    public int save(Client client) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
