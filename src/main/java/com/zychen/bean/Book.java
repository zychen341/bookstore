package com.zychen.bean;

public class Book {
    private String bookName;
    private String author;
    private Double price;
    private int id;

    public Book(int id, String bookName, String author, Double price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.id = id;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
