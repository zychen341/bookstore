package com.zychen.dao;


import com.zychen.bean.Book;
import com.zychen.bean.ShoppingCarRecord;

import java.util.List;

public interface RecordDao {
    List<ShoppingCarRecord> queryRecords(ShoppingCarRecord params);

    int insertRecord(ShoppingCarRecord params, Book book, String accountName, int buyBookQuantity);

    int deleteRecords(ShoppingCarRecord params, String accountName);

    int updateRecord(ShoppingCarRecord parmas, String accountName);

}
