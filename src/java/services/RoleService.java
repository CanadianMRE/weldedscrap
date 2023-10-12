/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dataaccess.*;
import java.util.List;
import models.Role;

/**
 *
 * @author Jaymen
 */
public class RoleService {
    public Role get(Integer id) throws Exception {
        RoleDB roleDB = new RoleDB();
        Role role = roleDB.get(id);
        return role;
    }
    
    public List<Role> getAll() throws Exception {
        RoleDB roleDB = new RoleDB();
        List<Role> roles = roleDB.getAll();
        return roles;
    }
    
    public void insert(Role role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.insert(role);
    }
    
    public void update(Role role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.update(role);
    }
    
    public void delete(Role role) throws Exception {
        RoleDB roleDB = new RoleDB();
        roleDB.delete(role);
    }
}
