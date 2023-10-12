/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.PaymentDB;
import java.util.List;
import models.Payment;
/**
 *
 * @author Jaymen
 */
public class PaymentService {
    public Payment get(Integer id) throws Exception {
        Payment payment = PaymentDB.get(id);
        return payment;
    }
    
    public List<Payment> getAll() throws Exception {
        List<Payment> orders = PaymentDB.getAll();
        return orders;
    }
    
    public void insert(Payment payment) throws Exception {
        PaymentDB.insert(payment);
    }
    
    public void update(Payment payment) throws Exception {
        PaymentDB.update(payment);
    }
    
    public void delete(Payment payment) throws Exception {
        PaymentDB.delete(payment);
    }
}
