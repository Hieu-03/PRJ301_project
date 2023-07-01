/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieu.book;

import hieu.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hieu-Acer
 */
public class BookDAO {
    public List<BookDTO> getAllBook() throws SQLException{
        List<BookDTO> bookList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null){ 
                String sql = "Select * From Book";
                
                stm = con.prepareStatement(sql);
                
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        BookDTO book = new BookDTO();
                        book.setBookId(rs.getInt("bookId"));
                        book.setBookName(rs.getString("bookName"));
                        book.setImage(rs.getString("image"));
                        book.setPrice(rs.getInt("price"));
                        bookList.add(book);
                    }
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
        return bookList;
    }
    
    public List<BookDTO> getBookByBookName(String searchValue) throws SQLException{
        List<BookDTO> bookList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null){ 
                String sql = "Select * From Book where bookName like ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        BookDTO book = new BookDTO();
                        book.setBookId(rs.getInt("bookId"));
                        book.setBookName(rs.getString("bookName"));
                        book.setImage(rs.getString("image"));
                        book.setPrice(rs.getInt("price"));
                        bookList.add(book);
                    }
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
        return bookList;
    }
    
    public List<BookDTO> getFilterBookByPrice(String searchValue, String filter) throws SQLException{
        List<BookDTO> bookList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            String sql = "";
            if (con != null){ 
                if("asc".equals(filter)) sql = "Select * From Book where bookName like ? order by price asc";
                else if("desc".equals(filter)) sql = "Select * From Book where bookName like ? order by price desc";
                else sql = "Select * From Book where bookName like ?";
                
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        BookDTO book = new BookDTO();
                        book.setBookId(rs.getInt("bookId"));
                        book.setBookName(rs.getString("bookName"));
                        book.setImage(rs.getString("image"));
                        book.setPrice(rs.getInt("price"));
                        bookList.add(book);
                    }
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
        return bookList;
    }
    
    public BookDTO getBookByBookId(int bookId) throws SQLException{
        BookDTO book = new BookDTO();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null){ 
                String sql = "Select * From Book where bookId = ?";
                
                stm = con.prepareStatement(sql);
                stm.setInt(1, bookId);
                
                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        book.setBookId(rs.getInt("bookId"));
                        book.setBookName(rs.getString("bookName"));
                        book.setImage(rs.getString("image"));
                        book.setPrice(rs.getInt("price"));
                    }
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
        return book;
    }
}
