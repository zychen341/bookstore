package com.zychen.dao;

import com.zychen.bean.Account;
import java.sql.SQLException;
import java.util.List;

public interface AccountDao {
    List<Account> queryAccount(Account account);

    String insertAccount(Account account);

    String deleteAccount(Account account);

    String updateAccount(Account account);

    String queryPassword(String account) throws SQLException;
}
