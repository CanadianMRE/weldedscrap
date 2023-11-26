/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.stripe.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.StripeAccess;

/**
 *
 * @author gursh
 */
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        if ("view".equals(action)) {
            viewCart(request, response, session);
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    private void viewCart(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws ServletException, IOException {
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            request.setAttribute("message", "Your cart is empty.");
            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
            return;
        }

        List<Product> cartProducts = new ArrayList<>();
        for (String productId : cart) {
            try {
                Product product = StripeAccess.get(productId);
                cartProducts.add(product);
            } catch (Exception e) {
                e.printStackTrace(); // Logging the exception
            }
        }

        request.setAttribute("cartProducts", cartProducts);
        request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        System.out.println("Action: " + action); // Print the action to console

        if ("add".equals(action)) {
            String productId = request.getParameter("productId");
            System.out.println("Adding Product ID: " + productId); // Print the product ID being added
            if (productId != null && !productId.isEmpty()) {
                cart.add(productId);
            }
        } else if ("remove".equals(action)) {
            String productId = request.getParameter("productId");
            System.out.println("Removing Product ID: " + productId); // Print the product ID being removed
            if (productId != null && !productId.isEmpty()) {
                cart.remove(productId); // Remove the product by ID
                System.out.println("Product removed from cart."); // Confirm removal
            } else {
                System.out.println("Product ID is null or empty for removal.");
            }
        }

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer != null ? referer : request.getContextPath() + "/home");
    }
}
