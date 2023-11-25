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
 *
 * @author Jaymen
 */
public class ProductDB {
    public static List<Products> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Products> products = em.createNamedQuery("Products.findAll",Products.class).getResultList();
            return products;
        } finally {
            em.close();
        }
    }

    public static Products get(String id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Products product = em.find(Products.class, id);
            return product;
        } finally { 
            em.close();
        }
    }

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
