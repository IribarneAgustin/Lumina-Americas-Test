package com.lumina.bill.DAO;

import com.lumina.bill.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    private List<Client> clientList;

    public ClientDAO() {
        clientList = new ArrayList<>();
    }

    //Método para cargar datos en memoria
    public void clientsGenerator() {
        int i = 0;
        String[] addressList = {"Constitucion 2400", "Avellaneda 2323", "Almafuerte 1500", "Roca 123", "Calle falsa 123", "Av Luro 2350", "Estacion camet 123", "Zuviria 2000"};
        String[] taxStatus = {"Responsable Inscripto", "Monotributo","IVA no responsable"};
        while (i < 8) {
            int dniRandom = (int) (Math.random() * 50000000) + 1000000;
            Client newClient = new Client(i, addressList[i], "DNI",dniRandom,taxStatus[(int) (Math.random() * 3)]);
            clientList.add(newClient);
            i++;
        }
    }

    public List<Client> getAll() {
        clientsGenerator();
        return this.clientList;
    }
}
