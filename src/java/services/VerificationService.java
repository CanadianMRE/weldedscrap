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
        
        return PASSWORD_REGEX.matcher(Password).matches();
    }
    
    public static boolean verifyName(String name) {
        if (name == null) {
            return false;
        }
        
        return NAME_REGEX.matcher(name).matches();
    }
}
