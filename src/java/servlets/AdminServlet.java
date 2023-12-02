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
import services.VerificationService;

/**
 * This servlet handles the admin page and all actions on the page
 * 
 * @author gursh
 */
public class AdminServlet extends HttpServlet {
    
    /**
     * Gets the base admin page
     * @param request
     * @param response
     * @throws Exception 
     */
    private void getBasePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Users> users = UserService.getAll();
        
        request.setAttribute("users", users);
        
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
    
    /**
     * Handles the action of editing a user
     * @param request
     * @param response
     * @throws Exception 
     */
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String actualPassword = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("email");
        String newFName = request.getParameter("fName");
        String newLName = request.getParameter("lName");
        String newAddress = request.getParameter("address");
        
        String rawId = request.getParameter("userId");
        
        HttpSession session = request.getSession();
        Users adminUser = (Users) session.getAttribute("user");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer removeId = Integer.valueOf(rawId);
        
        Users removeUser = UserService.get(removeId);
        
        if (!adminUser.getPassword().equals(actualPassword)) {
            request.setAttribute("response", "Wrong password");
            request.setAttribute("user", removeUser);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            return;
        }
        
        if (!VerificationService.verifyEmail(newEmail)) {
            request.setAttribute("response", "Invalid email");
            request.setAttribute("user", removeUser);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newFName)) {
            request.setAttribute("response", "First name is too short or too long");
            request.setAttribute("user", removeUser);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newLName)) {
            request.setAttribute("response", "Last name is too short or too long");
            request.setAttribute("user", removeUser);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newAddress)) {
            request.setAttribute("response", "");
            request.setAttribute("user", removeUser);
            getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
            return;
        }
        
        if (!newPassword.equals("")) {
            if (!VerificationService.verifyPassword(newPassword)) {
                request.setAttribute("response", "Password must be atleast 5 characters long");
                request.setAttribute("user", removeUser);
                getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
                return;
            } else {
                removeUser.setPassword(newPassword);
            }
        }
        
        removeUser.setEmail(newEmail);
        removeUser.setFirstName(newFName);
        removeUser.setLastName(newLName);
        removeUser.setAddress(newAddress);
        
        UserService.update(removeUser);
        getBasePage(request, response);
    }
    
    /**
     * Handles deleting a user from the database
     * @param request
     * @param response
     * @throws Exception 
     */
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
    
    /**
     * Handles displaying the edit user page to an admin
     * @param request
     * @param response
     * @throws Exception 
     */
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
    
    /**
     * Handles action choices from the admin page
     * @param request
     * @param response
     * @throws Exception 
     */
    private void handleAdminPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        
        if (action == null) {
            getBasePage(request, response);
            return;
        }
        
        switch(action) {
            case "Delete":
                deleteUser(request, response);
                break;
            case "editUser":
                editUser(request, response);
                break;
            case "Edit":
                showEditUser(request, response);
                break;
            default:
                getBasePage(request, response);
        }
    }
    
    /**
     * Handles verifying the user requesting this page is an administrator
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
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
    
    /**
     * Jumps to the doGet method
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}

