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
    <%@include file="./../jspf/Header.jspf" %>
    <body>
        <div class="container-fluid">
            <div class="row" id='topTitle'>
                <div class="col" id="topRow">
                    <div class="row" id="titleRow">
                        <h1 id="titleID">Login</h1>
                    </div>
                    ${message}
                    <form action="login" method="post">
                        Email:
                        <input type="text" name="email" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required><br>
                        Password:
                        <input type="password" name="password" required><br>
                        <input type="submit" value="Sign in">
                    </form>
                    <br>
                </div>
                <a href="login">Already a User?</a>
            </div>
        </div>
    </body>
</html>