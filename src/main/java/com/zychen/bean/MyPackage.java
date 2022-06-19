package com.zychen.bean;

public class MyPackage {
    private String bookName;
    private double price;
    private int bookQuanities;
    private String account;
    private int id;

    public MyPackage(String bookName, double price, int bookQuanities, String account, int id){
        this.bookName = bookName;
        this.price = price;
        this.bookQuanities = bookQuanities;
        this.account = account;
        this.id = id;
    }

    public MyPackage() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBookQuanities() {
        return bookQuanities;
    }

    public void setBookQuanities(int bookQuanities) {
        this.bookQuanities = bookQuanities;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
