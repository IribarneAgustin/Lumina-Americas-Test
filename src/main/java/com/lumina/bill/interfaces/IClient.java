package com.lumina.bill.interfaces;

import com.lumina.bill.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClient extends CrudRepository<Client, Integer> {

}
