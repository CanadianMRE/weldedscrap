package services;

import dataaccess.*;
import java.util.List;
import models.*;

/**
 * This is a utility class for accessing user info
 * @author Jaymen
 */
public class UserService {
    /**
     * Gets a user related to the given userId
     * @param userId Userid of the user we want to fetch
     * @return User object or null if no user exists
     */
    public static Users get(int userId) {
        try {
            Users user = UserDB.getByUserId(userId);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Gets a user related to the given Email
     * @param email Email of the user we want to fetch
     * @return User object or null if no user exists
     */
    public static Users getByEmail(String email) {
        try {
            Users user = UserDB.getByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets a list of all users in the database
     * @return A List of all users in the database
     */
    public static List<Users> getAll() {
        try {
            List<Users> users = UserDB.getAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Inserts a user into the database
     * @param user User we want to insert into the database
     */
    public static void insert(Users user) {
        try {
            UserDB.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates a user in the database
     * @param user User we want to update in the database
     */
    public static void update(Users user) {
        try {
            UserDB.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a user from the database
     * @param user The user we want to delete from the database
     */
    public static void delete(Users user) {
        try {
            UserDB.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
