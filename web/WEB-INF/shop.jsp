<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
        <link href="./css/shop.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="./css/Header.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script type="module" src="../css/maps.js"></script>
    </head>
    <body>
        <%@include file="./../jspf/Header.jspf" %>
        <div class="container">
            <div class="row">
                <div class="col" id="hero">
                    <div class="row" id='innerrow'>
                        <div class="col-6" id="heroinner">
                            <h1 id="content">Welded Scrap</h1>
                            <h2 id="content2">recycled creations</h2>                           
                        </div>
                    </div>
                </div>
            </div>
            <hr class="rounded">
            <h1>Products</h1>
            <div class="row">
                <div class="col" id='heroMessage'>
                    They say one persons trash is another's treasure. At Welded
                    Scrap, we embraced it as our motto. Our unique works of art 
                    are all made from recycled local materials, that other wise 
                    would be discarded and forgotten. Stop procrastinating and 
                    grab some welded scrap today!
                </div>
            </div>
            <ul class="row list-unstyled">
                <c:forEach items="${products}" var="product" varStatus="loop">
                    <li class="col-4 d-flex flex-column align-items-center">
                        <div class="card">
                            <c:if test="${product.getImages().size() > 0}">
                                <img src="${product.getImages().get(0)}" class="card-img-top" alt="Product Image">
                            </c:if>
                            <c:if test="${product.getImages().size() == 0}">
                                <img src="./images/logo.png" class="card-img-top" alt="Product Image">
                            </c:if>
                            <div class="card-body">
                                <h5 class="card-title text-center">${product.getName()}</h5>
                                <a href="item?productId=${product.getId()}" class="btn btn-primary">Details</a>
                                <form method="post" action="cart?action=add" class="mt-1">
                                    <input type="hidden" name="productId" value="${product.getId()}">
                                    <button type="submit" class="btn btn-success">Add to Cart</button>
                                </form>
                            </div>
                        </div>
                    </li>
                    <%-- Insert a new row after every third product --%>
                    <c:if test="${loop.index % 3 == 2 && not loop.last}">
                    </ul>
                    <ul class="row list-unstyled">
                    </c:if>
                </c:forEach>
            </ul>
            <hr class="rounded">
            <div class="row">
                <div class="col">
                    <h1>About Us</h1>
                </div>
            </div>
            <div class="row">
                <div class="col" id="about">
                    Welded Scrap is a local Albertan business that prides itself
                    in delivering quality, unique pieces. We are a family driven
                    and extremely passionate about our craft. Don't hesitate to
                    reach out to us with any inquiries or to get a custom piece 
                    made.<br>
                    <table class="table" id="contact">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">By email</th>
                                <th scope="col">By Phone</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="mailto:tyler@weldedscrap.ca" name='email'>tyler@weldedscrap.ca</a></td>
                                <td><a href="403-857-3423">(403)857-3423</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" id="hoursandmap">
                <div class="col">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">Hours of Operation</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Monday</td>
                                <td>9am - 5pm</td>
                            </tr>
                            <tr>
                                <td>Tuesday</td>
                                <td>9am - 5pm</td>
                            </tr>
                            <tr>
                                <td>Wednesday</td>
                                <td>9am - 5pm</td>
                            </tr>
                            <tr>
                                <td>Thursday</td>
                                <td>9am - 5pm</td>
                            </tr>
                            <tr>
                                <td>Friday</td>
                                <td>9am - 9pm</td>
                            </tr>
                            <tr>
                                <td>Saturday</td>
                                <td>9am - 9pm</td>
                            </tr>
                            <tr>
                                <td>Sunday</td>
                                <td>9am - 5pm</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col" id="map" >
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2966.423329727998!2d-114.03000183105716!3d51.30275749699409!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x53715f68bc9e1e03%3A0x91fe193692e62f5!2sAirdrie%2C%20AB!5e0!3m2!1sen!2sca!4v1701454243503!5m2!1sen!2sca" width="600" height="325" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <a href="login">Logout</a>
                </div>
            </div>


            <%
                List<Integer> cart = (List<Integer>) session.getAttribute("cart");
                if (cart == null) {
                    cart = new ArrayList<>();
                    session.setAttribute("cart", cart);
                }
            %>
        </div>
    </body>
</html>

