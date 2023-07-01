/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hieu.servlet;

import hieu.registration.RegistrationDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hieu-Acer
 */
public class CreateAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static boolean isValid(String str, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    //PASSWORD CHECK
    //Must have at least one numeric character
    //Must have at least one character
    //Password length should be between 8 and 20
    public String passCheck(String str) {
        String regex = "^(?=.*\\d)(?=.*[a-zA-Z]).{8,16}$";
        boolean validPassword = isValid(str, regex);
        String passwordError = "";
        if ("".equals(str)) {
            passwordError = "You must enter \"Password\"!";
        } else if (!validPassword) {
            passwordError = "Password is invalid!";
        }
        return passwordError;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String phoneNum = request.getParameter("phoneNum");
            String password = request.getParameter("password");
            String passConfirm = request.getParameter("passConfirm");
            RegistrationDAO dao = new RegistrationDAO();

            int count = 5;

            //PASSWORD CHECK
            String passwordError = passCheck(password);
            if ("".equals(passwordError)) {
                count--;
            }
            request.setAttribute("passwordError", passwordError);

            //PASSWORD CONFIRM CHECK
            String passwordConfirmError;
            passwordConfirmError = passCheck(passConfirm);
            if (!passConfirm.equals(password)) {
                passwordConfirmError = "Password confirm does not match your Password!";
            } else if ("".equals(passwordConfirmError)) {
                count--;
            }
            request.setAttribute("passwordConfirmError", passwordConfirmError);

            //USERNAME CHECK
            //Username length should be between 4 and 30
            String usernameError = "";
            if ("".equals(username)) {
                usernameError = "You must enter \"Username\"!";
            } else if (username.length() > 20 || username.length() < 4) {
                usernameError = "Username is invalid!";
            } else if (dao.checkDuplicateName(username)) {
                usernameError = "Username is already used!";
            } else {
                count--;
            }
            request.setAttribute("usernameError", usernameError);

            //PHONE NUMBER CHECK
            //Phone number length should be 10
            //Phone number should includes only number
            String regex = "^\\d{10}$";
            boolean validPhoneNumber = isValid(phoneNum, regex);
            String phoneNumError = "";
            if ("".equals(phoneNum)) {
                phoneNumError = "You must enter \"Phone number\"!";
            } else if (!validPhoneNumber) {
                phoneNumError = "Phone number is invalid!";
            } else if (dao.checkDuplicatePhone(phoneNum)) {
                phoneNumError = "Phone number is already used!";
            } else {
                count--;
            }
            request.setAttribute("phoneNumError", phoneNumError);
            //EMAIL CHECK
            //Email length should be 10
            //Email should includes only number
            regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
            boolean validEmail = isValid(email, regex);
            String emailError = "";
            if ("".equals(email)) {
                emailError = "You must enter \"Email\"!";
            } else if (!validEmail) {
                emailError = "Email is invalid!";
            } else if (dao.checkDuplicateEmail(email)) {
                emailError = "Email is already used!";
            } else {
                count--;
            }
            request.setAttribute("emailError", emailError);

            String url = "register.jsp";
            boolean create = false;
            if (count == 0) {
                create = dao.insertUser(username, password, email, phoneNum);
                if (create) {
                    url = "login.jsp";
                } else {
                    url = "error.html";
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(CreateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
