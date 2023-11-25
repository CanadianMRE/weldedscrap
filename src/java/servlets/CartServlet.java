/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
//    HttpSession session = request.getSession();
//    String action = request.getParameter("action");
//
//    if (action != null && action.equals("view")) {
//        List<Integer> cart = (List<Integer>) session.getAttribute("cart");
//        if (cart != null) {
//            List<Product> cartProducts = new ArrayList<>();
//            BigDecimal total = new BigDecimal(0);
//            ProductFetcher productService = new ProductFetcher();
//
//            for (Integer productId : cart) {
//                try {
//                    Product product = productService.get(productId);
//                    if (product != null) {
//                        cartProducts.add(product);
//                        total = total.add(product.getPrice());
//                        
//                        System.out.println("Product Name: " + product.getName());
//                        System.out.println("Product Description: " + product.getDescription());
//                    }
//                } catch (Exception ex) {
//                    Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//
//            request.setAttribute("cartProducts", cartProducts);
//            request.setAttribute("total", total);
//
//            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
//        } else {
//            request.setAttribute("message", "Your cart is empty.");
//            request.getRequestDispatcher("/WEB-INF/cart.jsp").forward(request, response);
//        }
//    } else {
//        response.sendRedirect("home");
//    }
        response.sendRedirect("home");
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String action = request.getParameter("action");
    HttpSession session = request.getSession();

    if (action != null && action.equals("add")) {
        String productIdStr = request.getParameter("productId");
        try {
            int productId = Integer.parseInt(productIdStr);
            List<Integer> cart = (List<Integer>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
            }
            cart.add(productId);
            session.setAttribute("cart", cart);
        } catch (NumberFormatException e) {
            Logger.getLogger(CartServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    String referer = request.getHeader("referer");
    response.sendRedirect(referer);
}
}