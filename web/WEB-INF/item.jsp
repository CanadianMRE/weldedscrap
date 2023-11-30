<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="services.StripeAccess"%>
<!DOCTYPE html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./css/item.css">
    <link rel="stylesheet" type="text/css" href="./css/Header.css">
</head>
<%@include file="./../jspf/Header.jspf" %>
<body>
    <div class="container-fluid">
        <div class="row">
            <div class="col" id="title">
                <div class="row" id="titleRow">
                    <h1 id="header">Product Details</h1>
                </div>
            </div>
        </div>
        <div class="row" id="itemRow">
            <div class="col-6" id="itemCol">
                <c:choose>
                    <c:when test="${not empty product}">

                        <c:if test = "${product.getImages().size() > 0}">
                            <img src="${product.getImages().get(0)}" alt="${product.getName()}" width="400" height="400">
                        </c:if>

                        <c:if test = "${product.getImages().size() == 0}">
                            <img src="./images/logo.png" alt="${product.name}" width="200" height="200">
                        </c:if>

                        Product Name: ${product.getName()}<br>
                        Description: ${product.getDescription()}<br>
                        Price: $${StripeAccess.getPrice(product)}<br>
                        <form method="post" action="cart?action=add" id="cartForm">
                            <input type="hidden" name="productId" value="${product.getId()}">
                            <input type="hidden" name="quantity" value="1"> 
                            <button type="submit">Add to Cart</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <p>No product selected.</p>
                    </c:otherwise>
                </c:choose>
                <a href="cart?action=view">
                    <i class="fa fa-shopping-cart"></i> View Cart
                </a>
                <a href="login">Logout</a>
            </div>
        </div>
    </div>
    <footer>
        <p>2023 WeldedScrap.com</p>
    </footer>
</body>
</html>
