/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.stripe.exception.StripeException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.StripeAccess;

/**
 * Handles user access for checking out a cart of items
 * 
 * @author gursh
 */
public class CheckoutServlet extends HttpServlet {
    
    /**
     * Hands off control to StripeAccess to handle the checkout session
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             StripeAccess.PurchaseItems(request, response);
         } catch (Exception ex) {
             Logger.getLogger(CheckoutServlet.class.getName()).log(Level.SEVERE, null, ex);
             response.sendRedirect("home");
         }
    }
    
    /**
     * Relays to the doGet method
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

