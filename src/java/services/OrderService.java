/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.OrderDB;
import java.util.List;
import models.Order;

/**
 *
 * @author Jaymen
 */
public class OrderService {
    public Order get(Integer id) throws Exception {
        Order order = OrderDB.get(id);
        return order;
    }
    
    public List<Order> getAll() throws Exception {
        List<Order> orders = OrderDB.getAll();
        return orders;
    }
    
    public void insert(Order order) throws Exception {
        OrderDB.insert(order);
    }
    
    public void update(Order order) throws Exception {
        OrderDB.update(order);
    }
    
    public void delete(Order order) throws Exception {
        OrderDB.delete(order);
    }
}