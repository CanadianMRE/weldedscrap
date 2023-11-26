<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="./css/shop.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <div class="container">
            <h1>Products</h1>
            <ul class="row list-unstyled">
                <c:forEach items="${products}" var="product" varStatus="loop">
                    <li class="col-4 d-flex flex-column align-items-center">
                        <div class="card">
                            <c:if test="${product.getImages().size() > 0}">
                                <img src="${product.getImages().get(0)}" class="card-img-top" alt="Product Image">
                            </c:if>
                            <c:if test="${product.getImages().size() == 0}">
                                <img src="./images/logo.png" class="card-img-top" alt="Product Image">
                            </c:if>
                            <div class="card-body">
                                <h5 class="card-title text-center">${product.getName()}</h5>
                                <a href="item?productId=${product.getId()}" class="btn btn-primary">Details</a>
                                <form method="post" action="CartServlet?action=add" class="mt-1">
                                    <input type="hidden" name="productId" value="${product.getId()}">
                                    <button type="submit" class="btn btn-success">Add to Cart</button>
                                </form>
                            </div>
                        </div>
                    </li>
                    <%-- Insert a new row after every third product --%>
                    <c:if test="${loop.index % 3 == 2 && not loop.last}">
                    </ul>
                    <ul class="row list-unstyled">
                    </c:if>
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
        </div>
    </body>
</html>

