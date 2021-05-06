package com.lumina.bill.DAO;

import com.lumina.bill.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private List<Product> productList;

    public ProductDAO() {
        productList = new ArrayList<>();
    }
    //Método para generar datos en memoria
    public void productsGenerator(){
        int i = 0;
        int code = 0;
        String[] names = {"Guitarra criolla","Afinador","Tambor","Bajo eléctrico","Guitarra eléctrica","Amplificador 50w","Platillo Sabian","Bombo"};
        double[] prices = {1240,10000,12500,50000,2400,8888,250000,33250};
        while (i < 8){
            code = (int) (Math.random() * 2000) + 1;
            Product newProduct = new Product(code,names[i],prices[i]);
            productList.add(newProduct);
            i++;
        }

    }

    public List<Product> getAll() {
        productsGenerator();
        return productList;
    }


}
