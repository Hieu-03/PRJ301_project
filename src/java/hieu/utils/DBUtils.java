/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package hieu.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.http.HttpServlet;

public class DBUtils extends HttpServlet {
    public static Connection makeConnection(){
        try {
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://localhost:1433;databasename=Hieu_SP23;instanceName=HIEU;";
            Class.forName(driver);
            Connection cn=DriverManager.getConnection(url, "sa", "12345");
            return cn;
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return null;        
    }
}
