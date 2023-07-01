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

        <title>Coder Home</title>

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
        <!-- ***** Header Area Start ***** -->
        <header class="header-area header-sticky">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <nav class="main-nav">
                            <!-- ***** Logo Start ***** -->
                            <a href="HomePageServlet" class="logo">
                                <img class="logo-img" src="Image/logo.png" alt="">
                            </a>
                            <!-- ***** Logo End ***** -->

                            <!-- ***** Search End ***** -->
                            <div class="search-input">
                                <form id="search" action="MainController">
                                    <input type="text"  placeholder="Search by book name" id='searchText' name="searchValue" value=""/></br>
                                    <button type="submit" class="search-button" value="Search" name="btAction"><i class="fa fa-search"></i></button>
                                </form>
                            </div>
                            <!-- ***** Search End ***** -->

                            <!-- ***** Menu Start ***** -->
                            <ul class="nav">
                                <li><a href="HomePageServlet" class="active">Home</a></li> 
                                <%
                                    String userId = (String)session.getAttribute("userId");
                                    if(userId != null){
                                %>
                                        <li><a href="LoadCartServlet">Cart</a></li>
                                        <li><a href="LogoutServlet">Logout</a></li>
                                <%  
                                    }else{
                                %>
                                        <li><a href="login.jsp">Login</a></li>    
                                <%
                                    }
                                %>
                            </ul>   
                            <!-- ***** Menu end ***** -->
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ***** Header area end ***** -->

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="page-content">

                    <!-- ***** Banner start ***** -->
                        <div class="main-banner">
                            <div class="row">
                                <div class="col-lg-7">
                                    <div class="header-text">
                                        <h6>Welcome to Coder book store</h6>
                                        <h4><em>Enjoy</em> awesome programming book with Coder</h4>
                                        <p>Login to buy interesting books now!!!</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- ***** Banner end ***** -->

                        <!-- ***** Book store start ***** -->
                        <div class="most-popular">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="heading-section">
                                        <h4>Book shelf</h4>
                                        <form action="MainController" method="get" class="filter">
                                            <select name="filter" id="filter">
                                                <option value="none">None</option>
                                                <option value="asc">Price ascending</option>
                                                <option value="desc">Price descending</option>                                               
                                            </select>
                                            <%
                                                String lastSearchValue = (String)request.getAttribute("lastSearchValue");
                                                if(lastSearchValue == null) lastSearchValue = "";
                                            %>
                                            <input type="hidden" name="lastSearchValue" value="<%=lastSearchValue%>"/>
                                            <input type="submit" value="Filter" name="btAction">
                                        </form>
                                    </div>
                                        <div class="row">
                                        <%
                                            List<BookDTO> bookList = (List<BookDTO>)request.getAttribute("bookList");
                                            for (int i = 0; i < bookList.size(); i++){
                                                String bookName = bookList.get(i).getBookName();
                                                String image = bookList.get(i).getImage();
                                                int price = bookList.get(i).getPrice();
                                                Locale vn = new Locale("vn", "VN");
                                                Currency vnd = Currency.getInstance(vn);
                                                NumberFormat vndFormat = NumberFormat.getCurrencyInstance(vn);
                                        %>
                                                <div class="col-lg-3 col-sm-6">
                                                    <div class="item">
                                                        <form action="MainController" method="post">
                                                        <input type="hidden" name="quantity" value="1"/>
                                                        <input type="hidden" name="bookId" value="<%=bookList.get(i).getBookId()%>"/>  
                                                        <img src="<%=image%>" alt="">
                                                        <h4><%=bookName%><br>
                                                    <%
                                                        if(userId != null){
                                                    %>    
                                                        <span><input class="add" type="submit" value="Add to cart" name="btAction"/></span>
                                                    <%
                                                        }
                                                    %>  
                                                        </h4>
                                                        <ul>
                                                            <li><i class="fa fa-money"></i> <%=vndFormat.format(price)%></li>
                                                        </ul>
                                                        </form>
                                                    </div>
                                                </div>
                                        <%
                                            }
                                        %>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- ***** Book store end ***** -->
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

