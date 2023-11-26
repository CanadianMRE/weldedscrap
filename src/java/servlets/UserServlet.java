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
    
    private void updateEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawEmail = request.getParameter("newEmail");
        
        if (!VerificationService.verifyEmail(rawEmail)) {
            getBasePage(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        user.setEmail(rawEmail);
        
        UserService.update(user);
        
        getBasePage(request, response);
    }
    
    private void deleteAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        UserService.delete(user);
    }
    
    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawPassword = request.getParameter("newPassword");
        
        if (!VerificationService.verifyPassword(rawPassword)) {
            getBasePage(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        user.setPassword(rawPassword);
        
        UserService.update(user);
        
        getBasePage(request, response);
    }
    
    private void changeAddress(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawAddress = request.getParameter("newAddress");
        
        if (rawAddress == null) {
            getBasePage(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        user.setPassword(rawAddress);
        
        UserService.update(user);
        
        getBasePage(request, response);
    }
    
    private void changeFName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawPassword = request.getParameter("newFname");
        
        if (!VerificationService.verifyName(rawPassword)) {
            getBasePage(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        user.setPassword(rawPassword);
        
        UserService.update(user);
        
        getBasePage(request, response);
    }
    
    private void changeLName(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawPassword = request.getParameter("newLName");
        
        if (!VerificationService.verifyName(rawPassword)) {
            getBasePage(request, response);
            return;
        }
        
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        user.setPassword(rawPassword);
        
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
            case "changeEmail":
                updateEmail(request, response);
                break;
            case "changePassword":
                changePassword(request, response);
                break;
            case "changeAddress":
                changeAddress(request, response);
                break;
            case "changeFName":
                changeFName(request, response);
                break;
            case "changeLName":
                changeLName(request, response);
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

