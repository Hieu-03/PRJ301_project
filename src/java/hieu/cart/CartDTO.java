/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieu.cart;

import hieu.book.BookDTO;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hieu-Acer
 */
public class CartDTO implements Serializable {
    private int cartId;
    private int userId; 
    private int purchaseQuantity;
    private BookDTO book;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }
    
    public CartDTO(){   
    }

    public CartDTO(int cartId, int userId, int purchaseQuantity, BookDTO book) {
        this.cartId = cartId;
        this.userId = userId;
        this.purchaseQuantity = purchaseQuantity;
        this.book = book;
    }
}
