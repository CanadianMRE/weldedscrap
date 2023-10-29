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
public class AdminServlet extends HttpServlet {
    
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
    
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("productId");
        String rawName = request.getParameter("productName");
        String rawDesc = request.getParameter("productDesc");
        String rawStock = request.getParameter("productStock");
        String rawPrice = request.getParameter("productPrice");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
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
        
        Integer productId = Integer.valueOf(rawId);
        int stockval = Integer.parseInt(rawStock);
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(rawPrice));
        
        Product oldProduct = ProductService.get(productId);
        
        oldProduct.setName(rawName);
        oldProduct.setDescription(rawDesc);
        oldProduct.setPrice(price);
        oldProduct.setStock(stockval);
        
        ProductService.update(oldProduct);
        
        getBasePage(request, response);
    }
    
    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("productId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer removeId = Integer.valueOf(rawId);
        
        Product removeProduct = ProductService.get(removeId);
        
        if (removeProduct != null) {
            ProductService.delete(removeProduct);
        }
        
        getBasePage(request, response);
    }
    
    private void editUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawUID = request.getParameter("userId");
        String rawEmail = request.getParameter("userEmail");
        String rawFName = request.getParameter("userFName");
        String rawLName = request.getParameter("userLName");
        String rawPassword = request.getParameter("userPassword");
        String rawAddress = request.getParameter("userAddy");
        
        if (rawEmail == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawFName == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawLName == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawPassword == null) {
            getBasePage(request, response);
            return;
        }
        
        if (rawAddress == null) {
            getBasePage(request, response);
            return;
        }
        
        int userId = Integer.parseInt(rawUID);
        
        Users oldUser = UserService.get(userId);
        
        oldUser.setFirstName(rawFName);
        oldUser.setLastName(rawLName);
        oldUser.setEmail(rawEmail);
        oldUser.setAddress(rawAddress);
        oldUser.setPassword(rawPassword);
        
        
        UserService.update(oldUser);
        
        getBasePage(request, response);
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("userId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer removeId = Integer.valueOf(rawId);
        
        Users removeUser = UserService.get(removeId);
        
        if (removeUser != null) {
            UserService.delete(removeUser);
        }
        
        getBasePage(request, response);
    }
    
    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("productId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer editId = Integer.valueOf(rawId);
        
        Product editProduct = ProductService.get(editId);
        
        if (editProduct == null) {
            getBasePage(request, response);
            return;
        }
        
        request.setAttribute("product", editProduct);
        
        getServletContext().getRequestDispatcher("/WEB-INF/editProduct.jsp").forward(request, response);
    }
    
    private void showAddProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        getServletContext().getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
    }
    
    private void showEditUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String rawId = request.getParameter("userId");
        
        if (rawId == null) {
            getBasePage(request, response);
            return;
        }
        
        Integer editId = Integer.valueOf(rawId);
        
        Users editUser = UserService.get(editId);
        
        if (editUser == null) {
            getBasePage(request, response);
            return;
        }
        
        request.setAttribute("user", editUser);
        
        getServletContext().getRequestDispatcher("/WEB-INF/editUser.jsp").forward(request, response);
    }
    
    private void handleAdminPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        
        if (action == null) {
            getBasePage(request, response);
            return;
        }
        
        switch(action) {
            case "deleteUser":
                deleteUser(request, response);
                break;
            case "editUser":
                editUser(request, response);
                break;
            case "showEditProduct":
                showEditProduct(request, response);
                break;
            case "showAddProduct":
                showAddProduct(request, response);
                break;
            case "showEditUser":
                showEditUser(request, response);
                break;
            case "addProduct":
                addProduct(request, response);
                break;
            case "editProduct":
                editProduct(request, response);
                break;
            case "deleteProduct":
                removeProduct(request, response);
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
        
        if (user.getRoleId().getRoleId() != 1) {
            response.sendRedirect("home");
            return;
        }
        
        try {
            handleAdminPage(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("home");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doGet(request,response);
    }
}

