package com.zychen.servlet;

import com.zychen.bean.Account;
import com.zychen.dao.impl.AccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class rechargeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName =(new accountLoadingServlet()).accountOnly;
        String money;
        money = req.getParameter("money");
        List<Account> accountList = (new AccountDaoImpl()).queryAccount(null);
        (new AccountDaoImpl()).recharge(accountName,money);
        resp.sendRedirect("/bookstore/pages/own/recharge_success.jsp");
    }

}
