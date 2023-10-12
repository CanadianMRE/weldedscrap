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
 *
 * @author Jaymen
 */
public class UserDB {
     public List<Users> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            List<Users> users = em.createNamedQuery("User.findAll",Users.class).getResultList();
            return users;
        } finally {
            em.close();
        }
    }

    public Users getByUserId(int userId) {
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

    public Users getByEmail(String email) {
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


    public void insert(Users user) throws Exception {
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

    public void update(Users user) throws Exception {
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

    public void delete(Users user) throws Exception {
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
