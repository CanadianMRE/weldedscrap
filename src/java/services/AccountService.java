/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.*;
import models.*;

/**
 * A utility service for handling account login and verification
 * 
 * @author gursh
 */
public class AccountService {
    
   /**
    * Attempts to log into an account with the given email and password
    * 
    * @param email Email we want to log in with
    * @param password Password we want to login with
    * @return User object if credentials are correct, null if incorrect
    */
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
