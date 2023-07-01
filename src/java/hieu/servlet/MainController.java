
package hieu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NgocLinh
 */
public class MainController extends HttpServlet {

    private final String LOGINCONTROLLER = "LoginServlet";
    private final String HOMEPAGE = "HomePageServlet";
    private final String DELETECONTROLLER = "DeleteBookServlet";
    private final String UPDATECONTROLLER = "UpdateCartServlet";
    private final String VIEWCART = "LoadCartServlet";
    private final String ADDTOCART = "AddBookServlet";
    private final String FILTER = "FilterServlet";
    private final String CREATEACCOUNT = "CreateAccountServlet";
    private final String SEARCHBOOK = "SearchBookServlet";
    private final String ERROR = "error.html";
    private final String PURCHASE = "purchase.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String url = ERROR;
            String button = request.getParameter("btAction");

            try {
                if (button == null) {
                    url = ERROR;
                } else if (button.equals("Login")) {
                    url = LOGINCONTROLLER;
                } else if (button.equals("Home page")) {
                    url = HOMEPAGE;
                } else if (button.equals("Delete")) {
                    url = DELETECONTROLLER;
                } else if (button.equals("Update")) {
                    url = UPDATECONTROLLER;
                } else if (button.equals("Add to cart")) {
                    url = ADDTOCART;
                } else if (button.equals("View Your Cart")) {
                    url = VIEWCART;
                } else if (button.equals("Filter")) {
                    url = FILTER;
                } else if (button.equals("Register")) {
                    url = CREATEACCOUNT;
                } else if (button.equals("Search")) {
                    url = SEARCHBOOK;
                } else if (button.equals("Purchase")) {
                    url = PURCHASE;
                }
            } finally {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
                
                out.close();
            }
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
