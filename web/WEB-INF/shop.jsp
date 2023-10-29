<%-- 
    Document   : shop
    Created on : 30-Sep-2023, 11:09:44 AM
    Author     : Jaymen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link href="./css/shop.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
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
            </div>
        </div>
    </header>

     <body>
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
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph2.jpg" id="logo2">
                    <br>
                    Item2
                    <br>
                    <a href="item?productId=2" class="btn btn-primary">Details</a>
                    <br>
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph3.jpg" id="logo3">
                    <br>
                    Item3
                    <br>
                   <a href="item?productId=3" class="btn btn-primary">Details</a>
                    <br>
                    <input type="button" value="Add to Cart">
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
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph5.jpg" id="logo5">
                    <br>
                    Item5
                    <br>
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph6.jpg" id="logo6">
                    <br>
                    Item6
                    <br>
                    <input type="button" value="Add to Cart">
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
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph8.jpg" id="logo8">
                    <br>
                    Item8
                    <br>
                    <input type="button" value="Add to Cart">
                </div>
                <div class="col">
                    <img src="./images/ph9.jpg" id="logo9">
                    <br>
                    Item9
                    <br>
                    <input type="button" value="Add to Cart">
                </div>
            </div>
        </div>
    </body>

</html>
