package com.zychen.dao.impl;


import com.zychen.bean.Account;
import com.zychen.dao.AccountDao;
import com.zychen.utils.TestJdbcConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDaoImpl implements AccountDao {
    @Override
    public List<Account> queryAccount(Account account) {
        String sql = "select * from account";
        try {
            List<Account> accounts = new ArrayList<>();
            ResultSet rs = TestJdbcConnection.getResult("firstdemo",sql,"root","88888888");
            Account accountObject;
            //8.处理结果
            while (rs.next()) {
                //1.获取数据。
                String accountName = rs.getString("account");
                String password = rs.getString("pwd");
                double money = rs.getDouble("money");
                accountObject = new Account(accountName,password,money);
                accounts.add(accountObject);
            }
            return accounts;
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insertAccount(Account account) {
        return null;
    }

    @Override
    public String deleteAccount(Account account) {
        return null;
    }

    @Override
    public String updateAccount(Account account) {
        return null;
    }

    @Override
    public String queryPassword(String account) throws SQLException {
        String sql = "select pwd from account where account ='"+account+"'";
        ResultSet rs = TestJdbcConnection.getResult("firstdemo",sql,"root","88888888");
        String password = "";
        while (rs.next()){
            password = rs.getString("pwd");
        }
        return password;
    }

    //    充值余额
    public void recharge(String accountName,String price){
        double newPrice;
        newPrice = Double.valueOf(price);
        String sql = "update account set money=money+"+newPrice+" where account='" +accountName+"'";
        TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
    }

    //用户注册
    public int accountAdd(Account account){
        List<Account> accountList = queryAccount(null);
        int isno = 0;
        for (Account account1 : accountList) {
            if (account1.getAccount().equals(account.getAccount())){
                isno = 1;
            }
        }
        if (isno==0){
            String sql = "insert into account(account,pwd,money) values('" + account.getAccount() + "','" + account.getPassword()+"',"+account.getMoney()+")";
            TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
        }
        return isno;
    }

    //用户登录
    public int accountLoading(String accountName,String password){
        List<Account> accountList = queryAccount(null);
        int isno = 0;
        for (Account account : accountList) {
            if (account.getAccount().equals(accountName)){
                if (account.getPassword().equals(password)) {
                    isno = 1;
                }
            }
        }
        return isno;
    }

//    修改密码
    public void updatePassword(String accountName,String newPass){
        String sql = "update account set pwd='"+newPass+"' where account='" +accountName+"'";
        TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
    }
}
