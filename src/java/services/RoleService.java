/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.*;
import java.util.List;
import models.Roles;

/**
 * This is a utility class intended for role database access
 * @author Jaymen
 */
public class RoleService {
    /**
     * Gets a role with the specified id
     * @param id id of the role we want to grab
     * @return Role class or null if no role exists
     * @throws Exception 
     */
    public Roles get(Integer id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Roles role = roleDB.get(id);
        return role;
    }
    
    /**
     * Gets a list of all roles in the database
     * @return A List of all roles in the database
     * @throws Exception 
     */
    public List<Roles> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Roles> roles = roleDB.getAll();
        return roles;
    }
    
    /**
     * Inserts a role into the database
     * @param role Role we want to insert into the database
     * @throws Exception 
     */
    public void insert(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);
    }
    
    /**
     * Updates a role in the database
     * @param role Role we want to update in the database
     * @throws Exception 
     */
    public void update(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);
    }
    
    /**
     * Deletes a role in the database
     * @param role Role we want to delete from the database
     * @throws Exception 
     */
    public void delete(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.delete(role);
    }
}
