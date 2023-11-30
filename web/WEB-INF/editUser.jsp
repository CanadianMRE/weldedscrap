<%-- 
    Document   : user
    Created on : 30-Sep-2023, 11:09:30 AM
    Author     : Jaymen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
        <link href="./css/user.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>   
    <%@include file="./../jspf/Header.jspf" %>    
    <body>
        <div class="container-fluid">
            <div class="row" >
                <div class="col" id='topRow'>
                    <div class="row" id="titleRow">
                        <h1>Editing ${user.getEmail()}</h1>
                    </div>
                    

                    <form action="admin" id='form'>
                        <div class="row">
                            <div class='col'>
                                <label for="fName">First Name: </label>
                                <input type="text" id="fName" name="fName" value="${user.getFirstName()}">
                            </div>
                            <div class='col'>
                                <label for="lName">Last Name: </label>
                                <input type="text" id="lName" name="lName" value="${user.getLastName()}"><br>
                            </div>
                        </div>
                        <label for="email">Email: </label>
                        <input type="text" id="email" name="email" value="${user.getEmail()}"><br>
                        <label for="address">Address: </label>
                        <input type="text" id="address" name="address" value="${user.getAddress()}"><br>
                        <label for="newPassword">New Password: </label>
                        <input type="password" id="pnum" name="newPassword"><br>
                        <input type="hidden" name="action" value="editUser">
                        <input type="hidden" name="userId" value="${user.getUserId()}">
                        
                        <label for="password">Password: </label>
                        <input type="password" id="password" name="password">
                        <br>
                        ${response}
                        <br>
                        <input type="submit" value="Save">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>