/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieu.registration;

/**
 *
 * @author Hieu-Acer
 */
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import java.sql.ResultSet;
import hieu.utils.DBUtils;

/**
 *
 * @author WINDOWS
 */
public class RegistrationDAO implements Serializable {
    
    public int checkLogin (String username, String password) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "";
            if (con != null){ 
                    if (username.contains("@")){
                        sql = "Select * From Account Where email = ? And userPassword = ?";
                    }else {
                        sql = "Select * From Account Where userName = ? And userPassword = ?";
                    }
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                if (rs!=null) { 
                    rs.next();
                    return rs.getInt("userId");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return 0;
    }
    
    public boolean checkDuplicatePhone (String phoneNumber) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "";
            if (con != null){ 
                sql = "Select * From Account Where phoneNumber = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, phoneNumber);
                
                rs = stm.executeQuery();
                if (rs!=null && rs.next()) {
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean checkDuplicateName (String userName) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "";
            if (con != null){ 
                sql = "Select * From Account Where userName = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, userName);
                
                rs = stm.executeQuery();
                if (rs!=null && rs.next()) {
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    }
    
    public boolean checkDuplicateEmail (String email) throws SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "";
            if (con != null){ 
                sql = "Select * From Account Where email = ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                
                rs = stm.executeQuery();
                if (rs!=null && rs.next()) {
                    return true;
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally{
            if(rs!=null){
                rs.close();
            }
            if(stm!=null){
                stm.close();
            }
            if(con!=null){
                con.close();
            }
        }
        return false;
    } 
    
    public boolean insertUser (String userName, String userPassword, String email, String phoneNumber)
            throws SQLException, NamingException{
            Connection con = null;
            PreparedStatement stm = null;
            try {
                con = DBUtils.makeConnection();
                if (con != null) {
                    
                    String sql = "INSERT INTO Account (userName, userPassword, email, phoneNumber)"
                            + "VALUES(N'" + userName + "', '" + userPassword + "', '" + email + "', '" + phoneNumber + "')";
                    
                    stm = con.prepareStatement(sql);
                    int row = stm.executeUpdate();
                    if (row > 0) {
                        return true;
                    }
                }
            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (con !=null) {
                    con.close();
                }
            }
        return false;   
    }
}