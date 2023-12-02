<%-- 
    Document   : genericMessage
    Created on : 26-Nov-2023, 10:57:57 AM
    Author     : WeldedScrap
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Failed!</title>
        <link rel="stylesheet" type="text/css" href="./css/login.css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col" id="success">
                    <h1 id="titleID">Payment Failed</h1>
                </div>
            </div>
        </div>
    </body>
</html>