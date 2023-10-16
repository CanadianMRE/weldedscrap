<%-- 
    Document   : register
    Created on : 11-Oct-2023, 1:55:01 PM
    Author     : gursh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="./css/register.css"> <!-- Use the same CSS as the product page -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <header>
        <div class="row" id="header_row">
            <div class="col-4" id="header_left">
                <a href="home">WeldedScrap</a>
            </div>
            <div class="col-4" id="header_center">
                <img src="./images/logo.png" id="logo">
            </div>
            <div class="col-4" id="header_right">
                <a href="login">Login</a>
                <a href="register">Register</a>
            </div>
        </div>
    </header>
    <body>
        <h1>Register as a new User</h1>
        <br>
        ${message}
        <form action="register" method="post">
            Email: <input type="text" name="email"><br>
            First Name: <input type="text" name="firstName"><br>
            Last Name: <input type="text" name="lastName"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Register">
        </form>
        <br>
        <a href="login">Already a User?</a>
    </body>
</html>


