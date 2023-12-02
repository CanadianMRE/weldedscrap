/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.stripe.model.Product;
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
import services.StripeAccess;

/**
 * This page handles getting the home page and sending all required information
 * @author WeldedScrap
 */
public class HomeServlet extends HttpServlet {
    /**
     * Handles displaying the home page and sending all user and product information
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            request.setAttribute("products", StripeAccess.getAll());
        } catch (Exception ex) {
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession session = request.getSession();
        Users user = null;
                
        if (session != null) {
            user =(Users) session.getAttribute("user");
        }
        
        if (user != null) {
            request.setAttribute("user", user);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/shop.jsp").forward(request, response);
    }
    
    /**
     * Relays to the doGet page
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
