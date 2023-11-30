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
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
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
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Email</th>
                                <th scope="col">First Name</th>
                                <th scope="col">Last Name</th>
                                <th scope="col">Role</th>
                            </tr>
                        </thead>
                        <form method="post" action="admin">
                            <input type="submit" name="action" value="Edit" class="btn btn-primary">
                            <input type="submit" name="action" value="Delete"  class="btn btn-danger">
                            <c:forEach items="${users}" var="user">
                                <tbody>
                                    <tr>
                                        <td><input type="radio" name="userId" value="${user.userId}"></td>
                                        <td>${user.email}</td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.roleId.name}</td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </form>
                    </table>
                </div>
            </div>

            <a href="https://dashboard.stripe.com/products">View Products</a>

            <p>
                <a href="login">Logout</a>
            </p>
        </div>
    </body>
</html>
