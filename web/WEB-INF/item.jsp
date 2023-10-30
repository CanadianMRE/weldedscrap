<%-- 
    Document   : item
    Created on : 29-Oct-2023, 3:02:10 PM
    Author     : gursh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/item.css">
    </head>
    <body>
    <h1>Product Details</h1>
    <c:choose>
        <c:when test="${not empty productId}">
           
            <img src="${product.imagePath}" alt="${product.name}" width="200" height="200">
            <p>Product Name: ${product.name}</p>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Stock: ${product.stock}</p>
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
    <a href="login">Logout</a>
</body>
</html>
