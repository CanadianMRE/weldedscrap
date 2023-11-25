<%-- 
    Document   : editprofile
    Created on : 18-Oct-2023, 1:37:18 PM
    Author     : Marley
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>    
    <%@include file="./../jspf/Header.jspf" %>  
    <body>
        <h1>Edit Profile</h1>
        
        <form>
        First Name:<br>
        <input type="text" name="firstName">
        
        Last Name:<br>
        <input type="text" name="lastName"><br>
        
        Email:<br>
        <input type="text" name="email"><br>
        
        Address:<br>
        <input type="text" name="address"><br>
        
        Phone Number:<br>
        <input type="text" name="phoneNumber"><br>
        
        <input type="submit" value="Save Changes">
        </form>
        <a href="login">Logout</a>
    </body>
</html>
