/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.regex.*;

/**
 *
 * @author Jaymen
 */
public class VerificationService {
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$");
    private static final Pattern NAME_REGEX = Pattern.compile("[a-zA-Z]");
    
    public static boolean verifyEmail(String email) {
        if (email == null) {
            return false;
        }
        
        return EMAIL_REGEX.matcher(email).matches();
    }
    
    public static boolean verifyPassword(String Password) {
        if (Password == null) {
            return false;
        }
        
        if (Password.length() < 5) {
            return false;
        }
        
        return true;
    }
    
    public static boolean verifyName(String name) {
        if (name == null) {
            return false;
        }
        
        if (name.length() < 1 || name.length() > 100) {
            return false;
        }
        
        return true;
    }
}
