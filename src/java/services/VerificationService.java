/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.regex.*;

/**
 * This class handles verification for various things such as email, password and names.
 * @author Jaymen
 */
public class VerificationService {
    /**
     * Regex pattern for emails
     */
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    
    /**
     * Regex pattern for passwords
     */
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$");
    
    /**
     * Regex pattern for names
     */
    private static final Pattern NAME_REGEX = Pattern.compile("[a-zA-Z]");
    
    /**
     * Verifies an email fits standards
     * @param email Email we want to verify
     * @return boolean indicating if the given email matches what is required
     */
    public static boolean verifyEmail(String email) {
        if (email == null) {
            return false;
        }
        
        return EMAIL_REGEX.matcher(email).matches();
    }
    
    /**
     * Verifies an Password fits standards
     * @param Password Password we want to verify
     * @return boolean indicating if the given Password matches what is required
     */
    public static boolean verifyPassword(String Password) {
        if (Password == null) {
            return false;
        }
        
        if (Password.length() < 5) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Verifies an name fits standards
     * @param name name we want to verify
     * @return boolean indicating if the given name matches what is required
     */
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
