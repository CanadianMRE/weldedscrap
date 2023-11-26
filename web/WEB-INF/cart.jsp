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
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <h1>Shopping Cart</h1>
        <div class="cart-items">
            <c:forEach items="${cartProducts}" var="product">
                <div class="cart-item">
                    <div class="item-details">
                        <c:if test = "${product.getImages().size() > 0}">
                            <img src="${product.getImages().get(0)}" alt="${product.getName()}" width="200" height="200">
                        </c:if>
                        <c:if test = "${product.getImages().size() == 0}">
                            <img src="./images/logo.png" alt="${product.name}" width="200" height="200">
                        </c:if>
                        <div class="item-info">
                            <h3>${product.getName()}</h3>
                            <p>${product.getDescription()}</p>
                            <p>Price: $${product.getDefaultPriceObject().getUnitAmount()}</p>
                            <form action="cart?action=remove" method="post">
                                <input type="hidden" name="productId" value="${product.getId()}">
                                <button type="submit" class="btn-remove">Remove</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="cart-summary">
        <p>Total: $${total}</p>
        <form action="checkout">
            <input type="submit" value="Checkout">
        </form>
        <a href="home" class="back-to-shop">Back to Shop</a>
        </div>
        <footer>
            <p>2023 WeldedScrap.com</p>
        </footer>
        <a href="login">Logout</a>
    </body>
</html>
