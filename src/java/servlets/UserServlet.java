/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
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
import services.AccountService;

/**
 *
 * @author gursh
 */
public class UserServlet extends HttpServlet {
    
    private void getBasePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        
        Users user = (Users) session.getAttribute("user");
        
        request.setAttribute("user", user);
        
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request, response);
    }
    
    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        UserService.delete(user);
    }
    
    private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String actualPassword = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String newEmail = request.getParameter("email");
        String newFName = request.getParameter("fName");
        String newLName = request.getParameter("lName");
        String newAddress = request.getParameter("address");
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        if (!user.getPassword().equals(actualPassword)) {
            request.setAttribute("response", "Wrong password");
            getBasePage(request, response);
            return;
        }
        
        if (!VerificationService.verifyEmail(newEmail)) {
            request.setAttribute("response", "Invalid email");
            getBasePage(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newFName)) {
            request.setAttribute("response", "First name is too short or too long");
            getBasePage(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newLName)) {
            request.setAttribute("response", "Last name is too short or too long");
            getBasePage(request, response);
            return;
        }
        
        if (!VerificationService.verifyName(newAddress)) {
            request.setAttribute("response", "");
            getBasePage(request, response);
            return;
        }
        
        if (!newPassword.equals("")) {
            if (!VerificationService.verifyPassword(newPassword)) {
                request.setAttribute("response", "Password must be atleast 5 characters long");
                getBasePage(request, response);
                return;
            } else {
                user.setPassword(newPassword);
            }
        }
        
        user.setEmail(newEmail);
        user.setFirstName(newFName);
        user.setLastName(newLName);
        user.setAddress(newAddress);
        
        request.setAttribute("response", "Updated user information");
        UserService.update(user);
        getBasePage(request, response);
    }
        
    private void handleUserPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        
        if (action == null) {
            getBasePage(request, response);
            return;
        }
        
        switch(action) {
            case "deleteAccount":
                deleteAccount(request, response);
                break;
            case "submitProfileEdits":
                updateAccount(request, response);
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
        
        try {
            handleUserPage(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}

