package com.lumina.bill.IService;

import com.lumina.bill.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    public List<Client> list();
    public Optional<Client>getById();
    public int save(Client client);
    public void delete(int id);

}
