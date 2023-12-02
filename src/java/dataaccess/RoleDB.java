/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Roles;

/**
 * This class is used for user roles, indicating permission levels and status of admin accounts.
 * 
 * @author Jaymen
 */
public class RoleDB {
    /**
     * Gets a list of every role in the database
     * 
     * @return A list of all roles in the database
     * @throws Exception 
     */
     public static List<Roles> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Roles> roles = em.createNamedQuery("Roles.findAll",Roles.class).getResultList();
            return roles;
        } finally {
            em.close();
        }
    }
     
    /**
     * Gets a role related to the given id
     * 
     * @param id    Id of the role we want to fetch
     * @return  Role related to the id or null if no role is related
     * @throws Exception 
     */
    public static Roles get(Integer id) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Roles role = em.find(Roles.class, id);
            return role;
        } finally { 
            em.close();
        }
    }

    /**
     * Inserts a new role into the database
     * 
     * @param role  Role we want to insert into the database
     * @throws Exception 
     */
    public static void insert(Roles role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(role);
            em.merge(role);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Updates a role in the database
     * 
     * @param role  Role we want to update
     * @throws Exception 
     */
    public static void update(Roles role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(role);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Deletes a role from the database
     * 
     * @param role  Role we want to delete
     * @throws Exception 
     */
    public static void delete(Roles role) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(role));
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
