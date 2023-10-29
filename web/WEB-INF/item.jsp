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
    </head>
    <body>
    <h1>Product Details</h1>
    <c:choose>
        <c:when test="${not empty productId}">
           
            <img src="${product.imagePath}" alt="${product.name}" width="200" height="200">
            <p>Product ID: ${product.productId}</p>
            <p>Product Name: ${product.name}</p>
            <p>Description: ${product.description}</p>
            <p>Price: ${product.price}</p>
            <p>Stock: ${product.stock}</p>
            <button>Add to Cart</button>
            
        </c:when>
        <c:otherwise>
            <p>No product selected.</p>
        </c:otherwise>
    </c:choose>
</body>
</html>
