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
        <title>WeldedScrap</title>
    </head>
    <body>
        <h1>WeldedScrap.com</h1>
        <h2>Login</h2>
        <h4>${message}</h4>
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