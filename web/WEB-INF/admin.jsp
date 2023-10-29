<%-- 
    Document   : admin
    Created on : 30-Sep-2023, 11:10:13 AM
    Author     : Jaymen
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/admin.css">
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
        <h1>Welcome ${user}</h1>
        <c:forEach items="${users}" var="user">
        <tr>
            <th>${user.email}</th>
            <th>${user.firstName}</th>
            <th>${user.lastName}</th>
            <th>${user.role.roleName}</th>
            <th>
                <form method="post" action="editUser">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="hidden" name="action" value="edit">
                    <button type="submit" name="submit" class="link-button">Edit</button>
                </form>
            </th>
            <th>
                <form method="post" action="deleteUser">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" name="submit" class="link-button">Delete</button>
                </form>
            </th>
        </tr>
    </c:forEach>

        <c:forEach items="${products}" var="product">
        <tr>
            <th>${product.productId}</th>
            <th>${product.name}</th>
            <th>${product.stock}</th>
            <th>
                <form method="post" action="addProduct">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <input type="hidden" name="action" value="edit">
                    <button type="submit" name="submit" class="link-button">add</button>
                </form>
            </th>
            <th>
                <form method="post" action="editProduct">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" name="submit" class="link-button">Edit</button>
                </form>
            </th
            <th>
                <form method="post" action="deleteProduct">
                    <input type="hidden" name="productId" value="${product.productId}">
                    <input type="hidden" name="action" value="delete">
                    <button type="submit" name="submit" class="link-button">Delete</button>
                </form>
            </th>
        </tr>
    </c:forEach>
</body>
</html>
