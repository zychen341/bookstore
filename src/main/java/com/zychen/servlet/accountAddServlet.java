package com.zychen.servlet;

import com.zychen.bean.Account;
import com.zychen.dao.impl.AccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class accountAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName,password,repassword;
        accountName = req.getParameter("accountName");
        password = req.getParameter("password");
        repassword = req.getParameter("repwd");
        if (password.equals(repassword)) {
            Account account = new Account(accountName, password, 0);
            int result = (new AccountDaoImpl()).accountAdd(account);
            if (result == 0) {
                resp.sendRedirect("/bookstore/pages/user/regist_success.jsp");
            } else {
                resp.sendRedirect("/bookstore/pages/user/regist_error.jsp");
            }
        }else {
            resp.sendRedirect("/bookstore/pages/user/regist_error_pass.jsp");
        }
    }
}
