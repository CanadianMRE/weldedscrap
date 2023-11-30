/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;
import services.UserService;

/**
 *
 * @author gursh
 */
public class AdminServlet extends HttpServlet {
    
    private void getBasePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Users> users = UserService.getAll();
        
        request.setAttribute("users", users);
        
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
    
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawUID = request.getParameter("userId");
        String rawEmail = request.getParameter("userEmail");
        String rawFName = request.getParameter("userFName");
        String rawLName = request.getParameter("userLName");
        String rawPassword = request.getParameter("userPassword");
        String rawAddress = request.getParameter("userAddy");
        
        if (rawEmail == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawFName == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawLName == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawPassword == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawAddress == null) {
            getBasePage(request, response);
            return;
        }
        
        int userId = Integer.parseInt(rawUID);
        
        Users oldUser = UserService.get(userId);
        
        oldUser.setFirstName(rawFName);
        oldUser.setLastName(rawLName);
        oldUser.setEmail(rawEmail);
        oldUser.setAddress(rawAddress);
        oldUser.setPassword(rawPassword);
        
        
        UserService.update(oldUser);
        
        getBasePage(request, response);
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("userId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer removeId = Integer.valueOf(rawId);
        
        Users removeUser = UserService.get(removeId);
        
        if (removeUser != null) {
            UserService.delete(removeUser);
        }
        
        getBasePage(request, response);
    }
    
    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("userId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer editId = Integer.valueOf(rawId);
        
        Users editUser = UserService.get(editId);
        
        if (editUser == null) {
            getBasePage(request, response);
            return;
        }
        
        request.setAttribute("user", editUser);
        
        getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
    }
    
    private void handleAdminPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        
        if (action == null) {
            getBasePage(request, response);
            return;
        }
        
        switch(action) {
            case "deleteUser":
                deleteUser(request, response);
                break;
            case "editUser":
                editUser(request, response);
                break;
            case "showEditUser":
                showEditUser(request, response);
                break;
            default:
                getBasePage(request, response);
        }
    }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        Users user = (Users) session.getAttribute("user");
        
        if (user == null) {
            response.sendRedirect("login");
            return;
        }
        
        if (user.getRoleId().getRoleId() != 1) {
            response.sendRedirect("home");
            return;
        }
        
        try {
            handleAdminPage(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}

