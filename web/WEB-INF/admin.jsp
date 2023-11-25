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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/admin.css">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <div class="container">
            <div class="row" id="welcome">
                <h1>Welcome ${user.firstName}</h1>
            </div>
            <h2>Users</h2>
            <div class="row">
                <div class="col">
                    <c:forEach items="${users}" var="user">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Email</th>
                                    <th scope="col">First Name</th>
                                    <th scope="col">Last Name</th>
                                    <th scope="col">Role</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="radio"></td>
                                    <td>${user.email}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.roleId.name}</td>
                                    <td>
                                        <form method="post" action="editUser">
                                            <input type="hidden" name="userId" value="${user.userId}">
                                            <input type="hidden" name="action" value="edit">
                                            <button type="submit" name="submit" class="btn btn-primary">Edit</button>
                                        </form>
                                        <form method="post" action="deleteUser">
                                            <input type="hidden" name="userId" value="${user.userId}">
                                            <input type="hidden" name="action" value="delete">
                                            <button type="submit" name="submit" class="btn btn-danger">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:forEach>
                </div>
            </div>
            <h2>Products</h2>
            <div class="row">
                <div class="col">
                    <c:forEach items="${products}" var="product">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col"></th>
                                    <th scope="col">Product ID</th>
                                    <th scope="col">Product Name</th>
                                    <th scope="col">Stock</th>
                                    <th scope="col">Actions</th>                              
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="radio"></td>
                                    <td>${product.productId}</td>
                                    <td>${product.name}</td>
                                    <td>${product.stock}</td>
                                    <td>
                                        <form method="post" action="editUser">
                                            <input type="hidden" name="userId" value="${product.productId}">
                                            <input type="hidden" name="action" value="edit">
                                            <button type="submit" name="submit" class="btn btn-success">Add</button>
                                        </form>
                                        <form method="post" action="deleteUser">
                                            <input type="hidden" name="userId" value="$${product.productId}">
                                            <input type="hidden" name="action" value="delete">
                                            <button type="submit" name="submit" class="btn btn-primary">Edit</button>
                                        </form>
                                        <form method="post" action="deleteUser">
                                            <input type="hidden" name="userId" value="$${product.productId}">
                                            <input type="hidden" name="action" value="delete">
                                            <button type="submit" name="submit" class="btn btn-danger">Delete</button>
                                        </form>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </c:forEach>
                </div>
            </div>
            <p>
                <a href="login">Logout</a>
            </p>
        </div>
    </body>
</html>
