/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;



import com.stripe.Stripe;
import com.stripe.model.Product;
import com.stripe.model.ProductCollection;
import com.stripe.model.checkout.Session;
import com.stripe.param.ProductListParams;
import com.stripe.param.SubscriptionItemCreateParams;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.*;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

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
    
    public static void CreateSession() {
        Stripe.apiKey = API_KEY;
        
        Builder sessionBuild =
                SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl(MY_DOMAIN + "/successPayment")
                .setCancelUrl(MY_DOMAIN + "/cancelPayment")
                .setAutomaticTax(
                        SessionCreateParams.AutomaticTax.builder()
                        .setEnabled(true)
                        .build()
                );
        
        SessionCreateParams params = sessionBuild.build();
    }
}
