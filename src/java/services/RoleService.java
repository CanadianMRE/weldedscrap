/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.*;
import java.util.List;
import models.Roles;

/**
 *
 * @author Jaymen
 */
public class RoleService {
    public Roles get(Integer id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Roles role = roleDB.get(id);
        return role;
    }
    
    public List<Roles> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Roles> roles = roleDB.getAll();
        return roles;
    }
    
    public void insert(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);
    }
    
    public void update(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);
    }
    
    public void delete(Roles role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.delete(role);
    }
}
