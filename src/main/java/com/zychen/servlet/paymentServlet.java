package com.zychen.servlet;

import com.zychen.bean.Account;
import com.zychen.bean.ShoppingCarRecord;
import com.zychen.dao.impl.AccountDaoImpl;
import com.zychen.dao.impl.PackageDaoImpl;
import com.zychen.dao.impl.RecordDaoImpl;
import com.zychen.utils.TestJdbcConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class paymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName =(new accountLoadingServlet()).accountOnly;
        double accountPrice = 0.0;
        double allPrice = 0.0;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        List<Account> accounts = (new AccountDaoImpl()).queryAccount(null);
        for (Account account : accounts) {
            if (account.getAccount().equals(accountName)) {
                accountPrice = account.getMoney();
            }
        }
        List<ShoppingCarRecord> shoppingCarRecords = (new RecordDaoImpl()).queryRecords(null);
        for (int i = 0; i < shoppingCarRecords.size(); i++) {
            if(shoppingCarRecords.get(i).getAccount().equals(accountName)){
                allPrice = allPrice + (shoppingCarRecords.get(i).getPrice() * shoppingCarRecords.get(i).getBookQuanities());
            }
        }
        if (allPrice > accountPrice) {
            resp.sendRedirect("/bookstore/pages/cart/pay_error.jsp");
        } else {
            for (int i = 0; i < shoppingCarRecords.size(); i++) {
                if (shoppingCarRecords.get(i).getAccount().equals(accountName)){
                    (new PackageDaoImpl()).insertPackage(null,shoppingCarRecords.get(i),accountName);
                }
            }
            String sql = "update account set money = money - "+allPrice+" where account='" +accountName+"'";
            TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
            (new RecordDaoImpl()).clearCart(accountName);
            resp.sendRedirect("/bookstore/showShoppingCart");
        }
    }
}
