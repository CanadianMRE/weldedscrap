/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RoleService;
import services.UserService;
import models.*;

/**
 *
 * @author gursh
 */
public class RegistrationServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        UserService userService = new UserService();
        RoleService roleService = new RoleService();

        int errorCode = 0;

        if (email == null || email.isEmpty()) {
            errorCode = 1;
        } else if (firstName == null || firstName.isEmpty()) {
            errorCode = 2;
        } else if (lastName == null || lastName.isEmpty()) {
            errorCode = 3;
        } else if (password == null || password.isEmpty()) {
            errorCode = 4;
        }

        if (errorCode > 0) {
            String errorMessage;

            switch (errorCode) {
                case 1:
                    errorMessage = "Please enter an email";
                    break;
                case 2:
                    errorMessage = "Please enter a first name";
                    break;
                case 3:
                    errorMessage = "Please enter a last name";
                    break;
                case 4:
                    errorMessage = "Please enter a password";
                    break;
                default:
                    errorMessage = "An error occurred";
            }

            request.setAttribute("message", errorMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        try {
            Users newUser = new Users(email, firstName, lastName, password);
            Role userRole = roleService.get(2);
            newUser.setRoleId(userRole);
            userService.insert(newUser);
            
            
            request.setAttribute("message", "New user has been registered");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } catch (Exception ex) {
             ex.printStackTrace();
             String errorMessage = ex.getMessage();
            request.setAttribute("message", errorMessage + "An error occurred during registration");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
