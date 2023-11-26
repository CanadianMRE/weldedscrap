/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Product;
import com.stripe.model.ProductCollection;
import com.stripe.model.checkout.Session;
import com.stripe.param.ProductListParams;
import com.stripe.param.SubscriptionItemCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.*;
import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Users;

/**
 *
 * @author WeldedScrap
 */
public class StripeAccess {
    public static final String MY_DOMAIN = "http://localhost:8084";
    private static final String API_KEY = "sk_test_51M7jaMGxD4OrUtXmLf5fbGchQAoWF4ZoOVAorFLwNfDWeE5Q2LM9otIUJDlxO0GT1D7WjqkOhr0jufI4UE0LyM8200YAK8xqWa";
   
    
    public static Product get(String id) throws Exception {
        Stripe.apiKey = API_KEY;
        
        return Product.retrieve(id);
    }
    
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
    
    public static void PurchaseItems(HttpServletRequest request, HttpServletResponse response) throws IOException, StripeException {
        HttpSession session = request.getSession();
        
        List<String> cart = (List<String>) session.getAttribute("cart");
        
        if (cart == null) {
            response.sendRedirect("home");
            return;
        }
        
        Stripe.apiKey = API_KEY;
        
        Builder sessionBuild =
                SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(MY_DOMAIN + "/genericMessage?bigMessage=Success")
                .setCancelUrl(MY_DOMAIN + "/genericMessage?bigMessage=Failed&message=Purchase Failed")
                .setAutomaticTax(
                        SessionCreateParams.AutomaticTax.builder()
                        .setEnabled(true)
                        .build()
                );
        
        for (String item : cart) {
            LineItem lineItem = SessionCreateParams.LineItem.builder()
                    .setPrice(item)
                    .build();
            
            sessionBuild.addLineItem(lineItem);
        }
        
        SessionCreateParams params = sessionBuild.build();
        
        Session stripeSession = Session.create(params);
        
        response.sendRedirect(stripeSession.getUrl());
    }
}
