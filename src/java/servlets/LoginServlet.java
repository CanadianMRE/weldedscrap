/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import models.*;
import services.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Handles logins
 * 
 * @author gursh
 */
public class LoginServlet extends HttpServlet {

    /**
     * Logs out if logged in and loads the login page
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    /**
     * Attempts a login with the given credentials
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    AccountService accountService = new AccountService();
    Users user = accountService.login(email, password);


    System.out.println("User: " + user);

    if (user == null) {
        String errorMessage = "Username or password is wrong";
        request.setAttribute("message", errorMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    HttpSession session = request.getSession();
    session.setAttribute("user", user);

    if (user.getRoleId().getRoleId() == 1) {
        response.sendRedirect("admin");
    } else {
        response.sendRedirect("home");
    }
    }
}
