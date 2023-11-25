<%-- 
    Document   : login
    Created on : 30-Sep-2023, 11:09:23 AM
    Author     : Jaymen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/login.css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <h1 id="loginT">Login</h1>
        <br>
        <h4>${message}</h4>
        <br>
        <form action="login" method="post">
            <label>Email:</label>
            <input type="text" name="email" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required><br>
            <label>Password:</label>
            <input type="password" name="password" required><br>
            <input type="submit" value="Sign in">
        </form>
        <a href="register">Register</a>

    </body>
</html>