<%-- 
    Document   : cart
    Created on : 11-Oct-2023, 3:17:31 PM
    Author     : gursh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Your Cart</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="./css/cart.css">
</head>
<body>
<header>
    <h1>Shopping Cart</h1>
</header>
<div class="cart-items">
    <c:forEach items="${cartProducts}" var="product">
        <div class="cart-item">
            <div class="item-details">
                <img src="${product.imagePath}" alt="${product.name}" width="100" height="100">
                <div class="item-info">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <p>Price: $${product.price}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<div class="cart-summary">
    <p>Total: $${total}</p>
    <button class="checkout-button">Checkout</button>
    <a href="home" class="back-to-shop">Back to Shop</a>
</div>
<footer>
    <p>2023 WeldedScrap.com</p>
</footer>
<a href="login">Logout</a>
</body>
</html>

