/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.model.ProductCollection;
import com.stripe.model.checkout.Session;
import com.stripe.param.ProductListParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

/**
 * This class handles stripe checkouts and product fetching
 * 
 * @author WeldedScrap
 */
public class StripeAccess {
    /**
     * Domain name for the website
     */
    public static final String MY_DOMAIN = "http://localhost:8084/WeldedScrap";
    
    /**
     * API key for stripe
     */
    private static final String API_KEY = "sk_test_51M7jaMGxD4OrUtXmLf5fbGchQAoWF4ZoOVAorFLwNfDWeE5Q2LM9otIUJDlxO0GT1D7WjqkOhr0jufI4UE0LyM8200YAK8xqWa";
   
    /**
     * Gets the price of a specified product
     * @param product Product Instance we want to get the price for
     * @return Price formatted in average price syntax [0.00]
     * @throws StripeException 
     */
    public static String getPrice(Product product) throws StripeException {
        return String.format("%.2f", (double) Price.retrieve(product.getDefaultPrice()).getUnitAmount()/100);
    }
    
    /**
     * Gets a product related to the given id
     * @param id ID related to a specific stripe product
     * @return A product or null if no product exists
     * @throws Exception 
     */
    public static Product get(String id) throws Exception {
        Stripe.apiKey = API_KEY;
        
        return Product.retrieve(id);
    }
    
    /**
     * Gets a list of all products on stripe
     * @return a List of all products on stripe
     * @throws Exception 
     */
    public static List<Product> getAll() throws Exception {
        Stripe.apiKey = API_KEY;
        ProductCollection collection = Product.list(
                ProductListParams.builder()
                .build()
        );
        
        List<Product> productList = new ArrayList<Product>();
        
        Iterable<Product> iter = collection.autoPagingIterable();
        
        iter.forEach(new Consumer<Product>() {
            @Override
            public void accept(Product prod)
            {   
                productList.add(prod);
            }
        });
        
        return productList;
    }
    
    /**
     * Handles a purchase for a list of items in the user's cart
     * 
     * @param request
     * @param response
     * @throws IOException
     * @throws StripeException
     * @throws Exception 
     */
    public static void PurchaseItems(HttpServletRequest request, HttpServletResponse response) throws IOException, StripeException, Exception {
        HttpSession session = request.getSession();
        
        List<String> cart = (List<String>) session.getAttribute("cart");
        
        if (cart == null) {
            response.sendRedirect("home");
            return;
        }
        
        Stripe.apiKey = API_KEY;
        
        Builder sessionBuild = SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(MY_DOMAIN + "/success")
                .setCancelUrl(MY_DOMAIN + "/failed")
                .setBillingAddressCollection(BillingAddressCollection.REQUIRED)
                .setInvoiceCreation(
                        SessionCreateParams.InvoiceCreation.builder().setEnabled(true).build()
                )
                .setAutomaticTax(
                        SessionCreateParams.AutomaticTax.builder()
                                .setEnabled(true)
                                .build()
                );
        
        
        Users user = (Users) session.getAttribute("User");
        
        if (user != null) {
            sessionBuild.setCustomerEmail(user.getEmail());
        }
        
        Map<String, Long> itemInfo = new HashMap<>();
        
        for (String item : cart) {
            if (itemInfo.containsKey(item)) {
                Long count = itemInfo.remove(item);
                count += 1;
                itemInfo.put(item, count);
            } else {
                itemInfo.put(item, 1L);
            }
        }
        
        for (Map.Entry<String, Long> entry : itemInfo.entrySet()) {
            Product itemObject = get(entry.getKey());
            LineItem lineItem = SessionCreateParams.LineItem.builder()
                .setPrice(itemObject.getDefaultPrice())
                .setQuantity(entry.getValue())
                .build();
            
            sessionBuild.addLineItem(lineItem);
        }
        
        SessionCreateParams params = sessionBuild.build();
        
        session.setAttribute("cart", new ArrayList<String>());
        session.setAttribute("cartCount", 0);
        
        Session stripeSession = Session.create(params);
        
        response.sendRedirect(stripeSession.getUrl());
    }
}
