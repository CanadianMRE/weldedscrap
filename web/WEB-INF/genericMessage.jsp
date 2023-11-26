<%-- 
    Document   : genericMessage
    Created on : 26-Nov-2023, 10:57:57 AM
    Author     : WeldedScrap
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${params.bigMessage}</title>
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        
        <h1>${params.bigMessage}</h1><br>
        ${params.message}
    </body>
</html>
