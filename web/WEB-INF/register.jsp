<%-- 
    Document   : register
    Created on : 11-Oct-2023, 1:55:01 PM
    Author     : gursh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="./css/register.css"> <!-- Use the same CSS as the product page -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <h1>Register as a new User</h1>
        <br>
        ${message}
        <form action="register" method="post">
            Email: <input type="text" name="email" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required><br>
            First Name: <input type="text" name="firstName" pattern="\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+" required><br>
            Last Name: <input type="text" name="lastName" pattern="\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+" required><br>
            Password: <input type="password" name="password" reqiured><br>
            <input type="submit" value="Register">
        </form>
        <br>
        <a href="login">Already a User?</a>
    </body>
</html>


