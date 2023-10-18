<%-- 
    Document   : user
    Created on : 30-Sep-2023, 11:09:30 AM
    Author     : Jaymen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
        <link href="./css/user.css" rel="stylesheet" type="text/css">
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
        <h1>Your Profile</h1
        
        Name<br>
        ${user}
        
        Email<br>
        ${email}
        
        Address<br>
        ${address}
        
        Phone Number<br>
        ${phone}
        
        <a href="editprofile">Edit Profile</a>
        
        
    </body>
</html>
