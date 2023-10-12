/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.*;
import models.*;

/**
 *
 * @author gursh
 */
public class AccountService {
    
   public Users login(String email, String password) {
    UserDB userDB = new UserDB();

    try {
        Users user = userDB.getByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        } else {
            return null; 
        }
    } catch (Exception e) {
        
        e.printStackTrace();
        return null; 
    }
}
}
