<%-- 
    Document   : login.jsp
    Created on : May 27, 2023, 10:24:14 AM
    Author     : Hieu-Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginAndRegister.css" type="text/css">
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
        
        <div class="auth-form-container">
            <h2>Login</h2>
            <form class='login-form' action="MainController" method="get">
                <input class="input" type="text" placeholder="Email or username" name="username"/>
                    <%
                        String nameError = (String)request.getAttribute("nameError");
                        if (nameError != null){
                    %>
                        <p class="input-error"><%=nameError%></p>
                    <%
                        }
                    %>
                <br/>
                <input type="password" placeholder="Password" name="password" id="myInput"/>
                <div class="show-pass"><input type="checkbox" onclick="myFunction()"><p class="show-text">Show password</p></div>
                    <%
                        String passError = (String)request.getAttribute("passError");
                        if (passError != null){
                    %>
                        <p class="input-error"><%=passError%></p>
                    <%
                        }
                    %>
                <br/>
                <%
                    String error = (String)request.getAttribute("loginError");
                    if (error != null){
                %>
                    <p class="error"><%=error%></p>
                <%
                    }
                %>
                
                <div class="submit">
                    <input class="button" type="submit" value="Login" name="btAction"><br/>
                    <input class="home" type="submit" value="Home page" name="btAction"><br/>
                </div>
                
                <div class="register-here">Do not have an account? <a href="register.jsp">Register here!</a></div>
            </form>
        </div>
    </body>
</html>
