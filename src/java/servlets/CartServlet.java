package servlets;

import com.stripe.model.Price;
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
 
@author gursh*/
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

        Double totalCost = 0.0;

        List<Product> cartProducts = new ArrayList<>();
        for (String productId : cart) {
            try {
                Product product = StripeAccess.get(productId);
                cartProducts.add(product);
                totalCost += Price.retrieve(product.getDefaultPrice()).getUnitAmount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        request.setAttribute("total", String.format("%.2f", (double) totalCost / 100));
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

        if ("add".equals(action)) {
            String productId = request.getParameter("productId");
            if (productId != null && !productId.isEmpty()) {
                cart.add(productId);
                session.setAttribute("cartCount", cart.size());
            }
        } else if ("remove".equals(action)) {
            String productId = request.getParameter("productId");
            if (productId != null && !productId.isEmpty()) {
                cart.remove(productId);
                session.setAttribute("cartCount", cart.size());
            }
        }

        String referer = request.getHeader("Referer");
        response.sendRedirect(referer != null ? referer : request.getContextPath() + "/home");
    }

}