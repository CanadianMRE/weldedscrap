/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.OrderDB;
import java.util.List;
import models.Orders;

/**
 *
 * @author Jaymen
 */
public class OrderService {
    public Orders get(Integer id) throws Exception {
        Orders order = OrderDB.get(id);
        return order;
    }
    
    public List<Orders> getAll() throws Exception {
        List<Orders> orders = OrderDB.getAll();
        return orders;
    }
    
    public void insert(Orders order) throws Exception {
        OrderDB.insert(order);
    }
    
    public void update(Orders order) throws Exception {
        OrderDB.update(order);
    }
    
    public void delete(Orders order) throws Exception {
        OrderDB.delete(order);
    }
}