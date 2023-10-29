/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;
import services.*;
/**
 *
 * @author gursh
 */
public class ItemServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productIdStr = request.getParameter("productId");
        if (productIdStr == null || productIdStr.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Product ID is required");
            return;
        }

        try {
            int productId = Integer.parseInt(productIdStr);
            System.out.println("PRODUCT ID:"+ productId);
            ProductService productService = new ProductService();
            Product product = productService.get(productId);
            request.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/WEB-INF/item.jsp").forward(request, response);

    }   catch (Exception ex) {
            Logger.getLogger(ItemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doGet(request,response);
            }
}