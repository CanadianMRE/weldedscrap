/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Product;
import models.Users;
import services.ProductService;
import services.UserService;

/**
 *
 * @author gursh
 */
public class OrdersServlet extends HttpServlet {
    
    private void getBasePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Users> users = UserService.getAll();
        List<Product> products = ProductService.getAll();
        
        request.setAttribute("users", users);
        request.setAttribute("products", products);
        
        getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
    }
    
    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawName = request.getParameter("productName");
        String rawDesc = request.getParameter("productDesc");
        String rawStock = request.getParameter("productStock");
        String rawPrice = request.getParameter("productPrice");
        
        
        if (rawName == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawDesc == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawStock == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawPrice == null) {
            getBasePage(request, response);
            return;
        }
        
        int stockval = Integer.parseInt(rawStock);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(rawPrice));
        
        Product product = new Product(null, rawName, rawDesc, stockval, price);
        
        ProductService.insert(product);
        
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
            Logger.getLogger(OrdersServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}

