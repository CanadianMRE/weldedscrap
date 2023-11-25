<%-- 
    Document   : item
    Created on : 29-Oct-2023, 3:02:10 PM
    Author     : gursh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="./css/item.css">
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
            </div>
        </div>
    </header>
    <h1>Product Details</h1>
<c:choose>
    <c:when test="${not empty productId}">

        <img src="${product.imagePath}" alt="${product.name}" width="200" height="200">
        <p>
            Product Name: ${product.name}<br>
            Description: ${product.description}<br>
            Price: ${product.price}<br>
            Stock: ${product.stock}<br>
        </p>
        <form method="post" action="CartServlet">
            <input type="hidden" name="productId" value="${product.productId}">
            <input type="hidden" name="quantity" value="1"> 
            <button type="submit">Add to Cart</button>
        </form>
    </c:when>
    <c:otherwise>
        <p>No product selected.</p>
    </c:otherwise>
</c:choose>
<a href="CartServlet?action=view">
    <i class="fa fa-shopping-cart"></i> View Cart
</a>

<a href="login">Logout</a>
</body>
</html>
