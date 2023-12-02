/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.stripe.model.Product;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.stripe.model.Price;
import services.*;
/**
 * Handles access to viewing a specific product
 * 
 * @author gursh
 */
public class ItemServlet extends HttpServlet {

    /**
     * Handles fetching information related to a specific product
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        if (productIdStr == null || productIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is required");
            return;
        }

        try {
            
            Product prod = StripeAccess.get(productIdStr);
            request.setAttribute("product", prod);
        } catch (Exception ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/item.jsp").forward(request, response);
    }

   /**
    * Passes control to the doGet method
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