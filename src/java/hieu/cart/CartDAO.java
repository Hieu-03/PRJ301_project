/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieu.cart;

import hieu.book.BookDAO;
import hieu.book.BookDTO;
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
public class CartDAO {

    public List<CartDTO> getAllCartItemByUserId(int userId) throws SQLException {
        List<CartDTO> cartList = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDAO bookDao = new BookDAO();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Cart where userId = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);

                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cartId = rs.getInt("cartId");
                        int quantity = rs.getInt("quantity");
                        BookDTO book = bookDao.getBookByBookId(rs.getInt("bookId"));
                        CartDTO cart = new CartDTO(cartId, userId, quantity, book);
                        cartList.add(cart);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return cartList;
    }
    
    public CartDTO getCartItemByUserIdAndBookId(int userId, int bookId) throws SQLException {
        CartDTO cart = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        BookDAO bookDao = new BookDAO();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Select * From Cart where userId = ? and bookId = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, bookId);

                rs = stm.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        int cartId = rs.getInt("cartId");
                        int quantity = rs.getInt("quantity");
                        BookDTO book = bookDao.getBookByBookId(bookId);
                        cart = new CartDTO(cartId, userId, quantity, book);
                    }
                    return cart;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean addToCart(int userId, int purchaseQuantity, int bookId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Insert into Cart(userId, bookId, quantity) Values(?, ?, ?)";

                stm = con.prepareStatement(sql);
                stm.setInt(1, userId);
                stm.setInt(2, bookId);
                stm.setInt(3, purchaseQuantity);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean deleteFromCart(int cartId) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Delete from Cart where cartId = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, cartId);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateCart(int cartId, int purchaseQuantity) throws SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "Update Cart set quantity = ? where cartId = ?";

                stm = con.prepareStatement(sql);
                stm.setInt(1, purchaseQuantity);
                stm.setInt(2, cartId);

                int row = stm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
}
