<%-- 
    Document   : shop
    Created on : 30-Sep-2023, 11:09:44 AM
    Author     : Jaymen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="./css/shop.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <div class="row" id="header_row">
                <div class="col-4" id="header_left">
                    <a href="home">WeldedScrap</a>
                </div>
                <div class="col-4" id="header_center">
                    <img src="./images/WeldedScrap.png" id="logo">
                </div>
                <div class="col-4" id="header_right">
                    <a href="login">Login</a>
                    <a href="register">Register</a>
                    <a href="CartServlet?action=view" class="btn btn-warning">
                        <i class="fas fa-shopping-cart"></i> View Cart
                    </a>
                </div>
            </div>
        </header>
        <h1>Products</h1>
        <div class="container text-center" id="product_grid">
            <div class="row">
                <div class="col">
                    <img src="./images/ph1.jpg" id="logo1">
                    <br>
                    Item1
                    <br>
                    <a href="item?productId=1" class="btn btn-primary">Details</a>
                    <br>
                    <form method="post" action="CartServlet?action=add">
                        <input type="hidden" name="productId" value="1">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph2.jpg" id="logo2">
                    <br>
                    Item2
                    <br>
                    <a href="item?productId=2" class="btn btn-primary">Details</a>
                    <br>
                    <form method="post" action="CartServlet?action=add">
                        <input type="hidden" name="productId" value="2">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph3.jpg" id="logo3">
                    <br>
                    Item3
                    <br>
                    <a href="item?productId=3" class="btn btn-primary">Details</a>
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="3">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="container text-center" id="product_grid">
            <div class="row">
                <div class="col">
                    <img src="./images/ph4.jpg" id="logo4">
                    <br>
                    Item4
                    <br>
                    <a href="item?productId=4" class="btn btn-primary">Details</a>
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="4">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph5.jpg" id="logo5">
                    <br>
                    Item5
                    <br>
                    <a href="item?productId=5" class="btn btn-primary">Details</a>
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="5">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph6.jpg" id="logo6">
                    <br>
                    Item6
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="6">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="container text-center" id="product_grid">
            <div class="row">
                <div class="col">
                    <img src="./images/ph7.jpg" id="logo7">
                    <br>
                    Item7
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="7">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph8.jpg" id="logo8">
                    <br>
                    Item8
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="8">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
                <div class="col">
                    <img src="./images/ph9.jpg" id="logo9">
                    <br>
                    Item9
                    <br>
                    <form action="CartServlet?action=add" method="post">
                        <input type="hidden" name="productId" value="9">
                        <button type="submit" class="btn btn-success">Add to Cart</button>
                    </form>
                </div>
            </div>
        </div>
        <a href="login">Logout</a>

        <%
            List<Integer> cart = (List<Integer>) session.getAttribute("cart");
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
        %>
    </body>

</html>
