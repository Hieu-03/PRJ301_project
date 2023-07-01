<%-- 
    Document   : login.jsp
    Created on : May 27, 2023, 10:24:14 AM
    Author     : Hieu-Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/loginAndRegister.css" type="text/css">
    </head>
    <body>
        
        <script>
            function myFunction() {
              var x1 = document.getElementById("myInput1");
              var x2 = document.getElementById("myInput2");
              if (x1.type === "password" && x2.type === "password") {
                x1.type = "text";
                x2.type = "text";
              } else {
                x1.type = "password";
                x2.type = "password";
              }
            }
        </script>
        
        <div class="auth-form-container">
            <h2>Register</h2>
            <form class="register-form" action="MainController" method="get">
                
                <%-- INPUT USERNAME--%>
                <input type="text" placeholder="Username (4-30 maximun lenght white space included)" name="username" />
                <div id="nameError" class="error"></div>
                    <%
                        String usernameError = (String)request.getAttribute("usernameError");
                        if (usernameError != null && usernameError != ""){
                    %>
                        <p class="input-error"><%=usernameError%></p>
                    <%
                        }
                    %>
                <br/>
                
                <%-- INPUT EMAIL--%>
                <input type="text" placeholder="Email" name="email" />
                    <%
                        String emailError = (String)request.getAttribute("emailError");
                        if (emailError != null && emailError != ""){
                    %>
                        <p class="input-error"><%=emailError%></p>
                    <%
                        }
                    %>
                <br/>
                
                <%-- INPUT PHONE NUMBER--%>
                <input type="tel" placeholder="Phone number" name="phoneNum" />
                <div id="phoneError" class="error"></div>
                <%
                        String phoneNumError = (String)request.getAttribute("phoneNumError");
                        if (phoneNumError != null && phoneNumError != ""){
                    %>
                        <p class="input-error"><%=phoneNumError%></p>
                    <%
                        }
                    %>
                <br/>
                
                <%-- INPUT PASSWORD--%>
                <input type="password" placeholder="Password (8-16 maximum lenght, must include numbers and letters)" name="password" id="myInput1"/>
                    <%
                        String passwordError = (String)request.getAttribute("passwordError");
                        if (passwordError != null && passwordError != ""){
                    %>
                        <p class="input-error"><%=passwordError%></p>
                    <%
                        }
                    %>
                <br/>
                
                <%-- INPUT PASSWORD CONFIRM--%>
                <input type="password" placeholder="Confirm password" name="passConfirm" id="myInput2"/>
                <div class="show-pass"><input type="checkbox" onclick="myFunction()"><p class="show-text">Show password</p></div>
                <%
                        String passwordConfirmError = (String)request.getAttribute("passwordConfirmError");
                        if (passwordConfirmError != null && passwordConfirmError != ""){
                    %>
                        <p class="input-error"><%=passwordConfirmError%></p>
                    <%
                        }
                    %>
                <br/>
                <div class="submit">
                    <input class="button" type="submit" value="Register" name="btAction"><br/>
                    <input class="home" type="submit" value="Home page" name="btAction"><br/>
                </div>
                
                <div class="register-here">Already have an account? <a href="login.jsp">Login here!</a></div>
            </form>
        </div>
    </body>
</html>
