package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.RoleService;
import services.UserService;
import models.*;
import services.VerificationService;

/**
 * Handles registration
 * @author WeldedScrap
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

        String errorMessage = null;
        int errorCode = 0;

        if (!VerificationService.verifyEmail(email)) {
            errorCode = 1;
        } else if (!VerificationService.verifyName(firstName)) {
            errorCode = 2;
        } else if (!VerificationService.verifyName(lastName)) {
            errorCode = 3;
        } else if (!VerificationService.verifyPassword(password)) {
            errorCode = 4;
        }

        switch (errorCode) {
            case 1:
                errorMessage = "Invalid email format.";
                break;
            case 2:
                errorMessage = "Invalid first name.";
                break;
            case 3:
                errorMessage = "Invalid last name.";
                break;
            case 4:
                errorMessage = "Invalid password. Password must be at least 5 characters long.";
                break;
            default:
                break;
        }

        if (errorMessage != null) {
            request.setAttribute("message", errorMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }

        try {
            Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setFirstName(firstName);
            newUser.setLastName(lastName);
            newUser.setPassword(password);
            newUser.setRoleId(roleService.get(2));
            userService.insert(newUser);

            request.setAttribute("message", "New user has been registered successfully.");
            response.sendRedirect(request.getContextPath() + "/login");
        } catch (Exception ex) {
            ex.printStackTrace();
            errorMessage = "An error occurred during registration: " + ex.getMessage();
            request.setAttribute("message", errorMessage);
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}