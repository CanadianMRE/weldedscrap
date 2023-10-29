package services;

import dataaccess.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

/**
 *
 * @author Jaymen
 */
public class UserService {
    public static Users get(int userId) {
        try {
            Users user = UserDB.getByUserId(userId);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Users getByEmail(String email) {
        try {
            Users user = UserDB.getByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Users> getAll() {
        try {
            List<Users> users = UserDB.getAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insert(Users user) {
        try {
            UserDB.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Users user) {
        try {
            UserDB.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(Users user) {
        try {
            UserDB.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
