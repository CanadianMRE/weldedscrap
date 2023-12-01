<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="./css/register.css"> <!-- Use the same CSS as the product page -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
    </head>
    <%@include file="./../jspf/Header.jspf" %>
    <body>
        <div class="container-fluid">
            <div class="row" id='topTitle'>
                <div class="col" id="topRow">
                    <div class="row" id="titleRow">
                        <h1 id="titleID">Register as a New User</h1>
                    </div>
                    ${message}
                    <form action="register" method="post" id="form">
                        Email: <input type="text" name="email" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" required><br>
                        First Name: <input type="text" name="firstName" pattern="\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+" required><br>
                        Last Name: <input type="text" name="lastName" pattern="\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+" required><br>
                        Password: <input type="password" name="password" reqiured><br>
                        <input type="submit" value="Register">
                    </form>
                    <a href="login">Already a User?</a>
                    <br>
                </div>
            </div>
        </div>
    </body>
</html>