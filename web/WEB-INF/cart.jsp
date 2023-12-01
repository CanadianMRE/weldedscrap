<%-- 
    Document   : cart
    Created on : 11-Oct-2023, 3:17:31 PM
    Author     : gursh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="services.StripeAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="services.StripeAccess"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/cart.css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <div class="container-fluid">
            <div class="row">
                <h1 id="Scart">Shopping Cart</h1>
                <div class="col" id="cartRow">                 
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Preview</th>
                                <th scope="col">Item Name</th>
                                <th scope="col">Item Details</th>
                                <th scope="col">Price</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${cartProducts}" var="product">
                                <tr>
                                    <td>
                                        <c:if test = "${product.getImages().size() > 0}">
                                            <img src="${product.getImages().get(0)}" alt="${product.getName()}" width="200" height="200">
                                        </c:if>
                                        <c:if test = "${product.getImages().size() == 0}">
                                            <img src="./images/logo.png" alt="${product.name}" width="200" height="200">
                                        </c:if>
                                    </td>
                                    <td>${product.getName()}</td>
                                    <td>${product.getDescription()}</td>
                                    <td>$${StripeAccess.getPrice(product)}</td>
                                    <td><form action="cart?action=remove" method="post" id="frm2">
                                            <input type="hidden" name="productId" value="${product.getId()}">
                                            <button type="submit" class="btn-remove">Remove</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" id="cartRow1">
                <div class="col" id="checkOut">
                    Total: $${total}
                    <form action="checkout" id="frm">
                        <input type="submit" value="Checkout">
                    </form>
                    <a href="home">Continue Shopping</a>
                </div>
            </div>
        </div>
    </body>
</html>
