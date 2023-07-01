<%@page import="hieu.cart.CartDTO"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Currency"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="hieu.book.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

        <title>Cart</title>

        <!-- Bootstrap core CSS -->
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="css/fontawesome.css">
        <link rel="stylesheet" href="css/homePageStyle.css">
        <link rel="stylesheet" href="css/owl.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body>
        <script>
            function myFunction() {
                var x = document.getElementById("myInput");
                if (x.type === "password") {
                    x.type = "text";
                } else {
                    x.type = "password";
                }
            }
        </script>

        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">

                            <a href="HomePageServlet" class="logo">
                                <img class="logo-img" src="Image/logo.png" alt="">
                            </a>

                            <div class="search-input">
                                <form id="search" action="MainController">
                                    <input type="text"  placeholder="Search by book name" id='searchText' name="searchValue" value=""/></br>
                                    <button type="submit" class="search-button" value="Search" name="btAction"><i class="fa fa-search"></i></button>
                                </form>
                            </div>

                            <ul class="nav">
                                <li><a use href="HomePageServlet" class="active">Home</a></li>
                                <li><a href="LoadCartServlet">Cart</a></li>
                                    <%
                                        String userId = (String) session.getAttribute("userId");
                                        if (userId != null) {
                                    %>
                                <li><a href="LogoutServlet">Logout</a></li>
                                    <%
                                    } else {
                                    %>
                                <li><a href="login.jsp">Login</a></li>    
                                    <%
                                        }
                                    %>
                            </ul>   
                        </nav>
                    </div>
                </div>
            </div>
        </header>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-content">
                        <!-- ***** Gaming Library Start ***** -->
                        <div class="book-library profile-library">
                            <div class="col-lg-12">
                                <div class="heading-section">
                                    <h4><em>Your Book</em> Library</h4>
                                </div>
                                <div>
                                    <%
                                        Locale vn = new Locale("vn", "VN");
                                        Currency vnd = Currency.getInstance(vn);
                                        NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);
                                        int total = 0;
                                        List<CartDTO> cartList = (List<CartDTO>) request.getAttribute("cartList");
                                        for (int i = 0; i < cartList.size(); i++) {
                                            BookDTO book = cartList.get(i).getBook();
                                            String bookName = book.getBookName();
                                            String image = book.getImage();
                                            int price = book.getPrice();
                                            int purchaseQuantity = cartList.get(i).getPurchaseQuantity();
                                            total = total + (purchaseQuantity * price);
                                            int cartId = cartList.get(i).getCartId();
                                    %>

                                    <form action="MainController" method="post">
                                        <input type="hidden" value="<%=cartId%>" name="cartId"/>
                                        <div class="item">
                                            <ul>
                                                <li><img src="<%=image%>" alt="" class="templatemo-item"></li>
                                                <li><span>Title</span><h4><%=bookName%></h4></li>
                                                <li><span>Unit price</span><h4><%=vndFormat.format(price)%></h4></li>
                                                <li><span>Quantity</span><h4><input class="quantity" type="number" min="1" value="<%=purchaseQuantity%>" name="newQuantity"/></h4></li>
                                                <li><span>Price</span><h4><%=vndFormat.format(price * purchaseQuantity)%></h4></li>
                                                <li><div class="main-border-button delete"><input type="submit" value="Delete" name="btAction"/></div></li>
                                                <li><div class="main-border-button"><input type="submit" value="Update" name="btAction"/></div></li>
                                            </ul>
                                        </div>
                                    </form>
                                    <%
                                        }
                                    %>
                                    <div class="other col-lg-12">
                                        <h5 class="col-lg-10">Total: <span class="total-value"> <%=vndFormat.format(total)%></span></h5>
                                        <form action="MainController" class="col-lg-2">
                                            <input class="buy" type="submit" value="Purchase" name="btAction"/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Gaming Library End ***** -->
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p>Copyright © 2023 <a href="#">Coder</a> book store. All rights reserved. 
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>

