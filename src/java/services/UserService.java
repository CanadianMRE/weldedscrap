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
    public Users get(int userId) {
        try {
            UserDB userDB = new UserDB();
            Users user = userDB.getByUserId(userId);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Users getByEmail(String email) {
        try {
            UserDB userDB = new UserDB();
            Users user = userDB.getByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Users> getAll() {
        try {
            UserDB userDB = new UserDB();
            List<Users> users = userDB.getAll();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Users user) {
        try {
            UserDB userDB = new UserDB();
            userDB.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Users user) {
        try {
            UserDB userDB = new UserDB();
            userDB.update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Users user) {
        try {
            UserDB userDB = new UserDB();
            userDB.delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
