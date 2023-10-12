/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.ProductDB;
import java.util.List;
import models.Product;

/**
 *
 * @author Jaymen
 */
public class ProductService {
    public Product get(Integer id) throws Exception {
        Product product = ProductDB.get(id);
        return product;
    }
    
    public List<Product> getAll() throws Exception {
        List<Product> roles = ProductDB.getAll();
        return roles;
    }
    
    public void insert(Product product) throws Exception {
        ProductDB.insert(product);
    }
    
    public void update(Product product) throws Exception {
        ProductDB.update(product);
    }
    
    public void delete(Product product) throws Exception {
        ProductDB.delete(product);
    }
}