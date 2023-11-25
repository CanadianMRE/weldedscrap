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
        <%@include file="./../jspf/Header.jspf" %>
        <h1>Products</h1>
        
        <ul>
            <c:forEach items="${products}" var="product">
                <li>
                    <div class="col">
                        <img src="${product.imagePath}" id="logo1">
                        <br>
                            ${product.name}
                        <br>
                        <a href="item?productId=${product.productId}" class="btn btn-primary">Details</a>
                        <br>
                        <form method="post" action="CartServlet?action=add">
                            <input type="hidden" name="productId" value="${product.productId}">
                            <button type="submit" class="btn btn-success">Add to Cart</button>
                        </form>
                    </div>
                </li>
            </c:forEach>
        </ul>
        
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
