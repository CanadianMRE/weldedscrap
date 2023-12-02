/*
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataaccess;

import models.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * This class handles user data access
 * 
 * @author Jaymen
 */
public  class UserDB {
    
    /**
     * Gets a list of all users in the database
     * @return  List with all users in the database
     * @throws Exception 
     */
    public static List<Users> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Users> users = em.createNamedQuery("Users.findAll",Users.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }

    /**
     * Gets a specific user related to the given id
     * @param userId Id of the user we want to grab
     * @return User we want to grab or null if no user exists
     */
    public static Users getByUserId(int userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Users> query = em.createNamedQuery("Users.findByUserId", Users.class);
            query.setParameter("userId", userId);
            Users user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null; // Return null if no user is found with the provided userId.
        } finally {
            em.close();
        }
    }
    
    /**
     * Gets a specific user related to the given email
     * 
     * @param email email of the user we want to fetch
     * @return user we want to grab or null if no user exists
     */
    public static Users getByEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Users> query = em.createNamedQuery("Users.findByEmail", Users.class);
            query.setParameter("email", email);
            Users user = query.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null; // Return null if no user is found with the provided email.
        } finally {
            em.close();
        }
    }

    /**
     * Inserts a new user into the database
     * 
     * @param user The user we want to insert into the database
     * @throws Exception 
     */
    public static void insert(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Updates a user in the database
     * 
     * @param user The user we want to update in the database
     * @throws Exception 
     */
    public static void update(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Deletes a user from the database
     * 
     * @param user User we want to delete from the database
     * @throws Exception 
     */
    public static void delete(Users user) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception ex) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}
