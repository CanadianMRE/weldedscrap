/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Products;

/**
 * This access class is intended for using with the user's cart to store ids related to stripe 
 * 
 * @author Jaymen
 */
public class ProductDB {
    /**
     * Returns a List of all cached products
     * @return  List of all products we've cached
     * @throws  Exception 
     */
    public static List<Products> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Products> products = em.createNamedQuery("Products.findAll",Products.class).getResultList();
            return products;
        } finally {
            em.close();
        }
    }
    
    /**
     * Gets a cached productid if it exists
     * 
     * @param   id  ProductId which relates to a product we cached
     * @return  Product related to the id given or null
     * @throws  Exception 
     */
    public static Products get(String id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Products product = em.find(Products.class, id);
            return product;
        } finally { 
            em.close();
        }
    }

    /**
     * Inserts a product into database to be cached
     * 
     * @param product a product object to be added
     * @throws Exception 
     */
    public static void insert(Products product) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(product);
            em.merge(product);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Updates a product in the database
     * 
     * @param product  a product object to be updated
     * @throws Exception 
     */
    public static void update(Products product) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(product);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    /**
     * Deletes a product from the database
     * 
     * @param product product to be deleted
     * @throws Exception 
     */
    public static void delete(Products product) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
