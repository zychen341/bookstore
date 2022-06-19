package com.zychen.dao.impl;

import com.zychen.bean.Account;
import com.zychen.bean.Book;
import com.zychen.bean.ShoppingCarRecord;
import com.zychen.dao.RecordDao;
import com.zychen.utils.TestJdbcConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecordDaoImpl implements RecordDao {

    @Override
    public List<ShoppingCarRecord> queryRecords(ShoppingCarRecord params) {
        String sql = "select * from shoppingcartrecord";
        try {
            List<ShoppingCarRecord> result = new ArrayList<>();
            ResultSet rs = TestJdbcConnection.getResult("firstdemo", sql, "root", "88888888");
            //8.处理结果
            ShoppingCarRecord record;
            while (rs.next()) {
                //1.获取数据。
                String bookName = rs.getString("bookName");
                double price = rs.getDouble("price");
                int bookQuanities = rs.getInt("bookQuanities");
                String account = rs.getString("account");
                int id = rs.getInt("id");
                record = new ShoppingCarRecord(bookName, price, bookQuanities, account, id);
                result.add(record);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertRecord(ShoppingCarRecord params, Book book, String accountName, int buyBookQuantity) {
        boolean flag = false;
        List<ShoppingCarRecord> shoppingCarRecords = (new RecordDaoImpl()).queryRecords(null);
        for (int i = 0; i < shoppingCarRecords.size(); i++) {
            if (shoppingCarRecords.get(i).getBookName().equals(book.getBookName()) && shoppingCarRecords.get(i).getAccount().equals(accountName)) {
                flag = true;
            }
        }
        if (flag) {
            String sql = "update shoppingcartrecord set bookQuanities = bookQuanities + " + buyBookQuantity + " where bookName ='" + book.getBookName() + "' and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        } else {
            String sql = "insert into shoppingcartrecord(bookName,price,bookQuanities,account) values('" + book.getBookName() + "'," + book.getPrice() + "," + buyBookQuantity + ",'" + accountName + "')";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        }
        return 0;
    }

    @Override
    public int deleteRecords(ShoppingCarRecord params, String accountName) {
        return 0;
    }

    @Override
    public int updateRecord(ShoppingCarRecord parmas, String accountName) {
        return 0;
    }

    public int updateCart(String bookId, String accountName) {
        int id = Integer.parseInt(bookId);
        String sql = "update shoppingcartrecord set bookQuanities = bookQuanities + 1 where id = " + id + " and account = '" + accountName + "'";
        TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        return 0;
    }

    public void clearCart(String accountName) {
        String sql = "delete from shoppingcartrecord where account = '" + accountName + "'";
        TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
    }

    public int addtoCart(String bookId, String accountName) {
        boolean flag = false;
        int isno = 0;
        String bookName = null;
        double price = 0.0;
        List<ShoppingCarRecord> shoppingCarRecords = (new RecordDaoImpl()).queryRecords(null);
        List<Book> bookList = (new BookDaoImpl()).queryBook(null);
        for (Book book : bookList) {
            if (book.getId() == Integer.valueOf(bookId)){
                bookName = book.getBookName();
                price = book.getPrice();
            }
        }
        for (int i = 0; i < shoppingCarRecords.size(); i++) {
            if (shoppingCarRecords.get(i).getBookName().equals(bookName) && shoppingCarRecords.get(i).getPrice() == price && shoppingCarRecords.get(i).getAccount().equals(accountName)) {
                flag = true;
            }
        }
        if (flag) {
            String sql = "update shoppingcartrecord set bookQuanities = bookQuanities + 1  where bookName ='" + bookName + "' and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        } else {
            String sql = "insert into shoppingcartrecord(bookName,price,bookQuanities,account) values('" + bookName + "'," + price + "," + 1 + ",'" + accountName + "')";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        }
        return isno;
    }

    public int deleteCart(String bookId, String accountName) {
        boolean flag = false;
        int isno = 0;
        String bookName = null;
        int id = Integer.parseInt(bookId);
        int number = 0;
        double price = 0.0;
        List<ShoppingCarRecord> shoppingCarRecords = (new RecordDaoImpl()).queryRecords(null);
        for (int i = 0; i < shoppingCarRecords.size(); i++) {
            if (shoppingCarRecords.get(i).getId() == id && shoppingCarRecords.get(i).getAccount().equals(accountName)) {
                number = shoppingCarRecords.get(i).getBookQuanities();
            }
        }
        if (number >= 2) {
            String sql = "update shoppingcartrecord set bookQuanities = bookQuanities - 1 where id = " + id + " and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");

        } else {
            String sql = "delete from shoppingcartrecord where id=" + bookId + " and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        }
        return isno;
    }
}
