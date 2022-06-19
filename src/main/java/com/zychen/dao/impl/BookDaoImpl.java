package com.zychen.dao.impl;

import com.zychen.bean.Book;
import com.zychen.dao.BookDao;
import com.zychen.utils.TestJdbcConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> queryBook(Book book) {
        //4.定义sql
        String sql = "select * from book";
        //5.获取pstmt对象
        try {
            List<Book> books = new ArrayList<>();
            ResultSet rs = TestJdbcConnection.getResult("firstdemo",sql,"root","88888888");
            //6.设置参数
            //7.执行sql
            Book bookObject;
            //8.处理结果
            while (rs.next()) {
                //1.获取数据。
                String bookName = rs.getString("bookName");
                String author = rs.getString("author");
                double price = rs.getDouble("price");
                int id = rs.getInt("id");
                bookObject = new Book(id,bookName,author,price);
                books.add(bookObject);
            }
            return books;
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertBook(Book book) {
        return 0;
    }

    @Override
    public int deleteBook(Book book) {
        return 0;
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }

    //    搜索书
    public List<Book> searchBooks(String bookName) {
        List<Book> books = (new BookDaoImpl()).queryBook(null);
        List<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            if (book.getBookName().contains(bookName)){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
