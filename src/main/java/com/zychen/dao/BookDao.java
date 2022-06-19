package com.zychen.dao;
import com.zychen.bean.Book;

import java.util.List;

public interface BookDao {
    List<Book> queryBook(Book book);

    int insertBook(Book book);

    int deleteBook(Book book);

    int updateBook(Book book);
}
