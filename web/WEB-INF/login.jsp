<%-- 
    Document   : login
    Created on : 30-Sep-2023, 11:09:23 AM
    Author     : Jaymen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/login.css">
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
        <h2 id="loginT">Login</h2>
        <br>
        <h4>${message}</h4>
        <br>
        <form action="login" method="post">
            <label>Email:</label>
            <input type="text" name="email"><br>
            <label>Password:</label>
            <input type="password" name="password"><br>
            <input type="submit" value="Sign in">
        </form>
        <a href="register">Register</a>

    </body>
</html>