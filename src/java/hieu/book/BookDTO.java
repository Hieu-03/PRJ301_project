/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hieu.book;

/**
 *
 * @author Hieu-Acer
 */
public class BookDTO {
    private int bookId;
    private String bookName;
    private String image;
    private int price;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BookDTO(int bookId, String bookName, String image, int price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.image = image;
        this.price = price;
    }
    
    public BookDTO() {

    }
}
