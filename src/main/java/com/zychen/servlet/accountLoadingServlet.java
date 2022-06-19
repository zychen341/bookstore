package com.zychen.servlet;
import com.zychen.dao.impl.AccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class accountLoadingServlet extends HttpServlet {

    public static String accountOnly;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName,password;
        accountName = req.getParameter("accountName");
        accountOnly = accountName;
        password = req.getParameter("password");
        int result = (new AccountDaoImpl()).accountLoading(accountName,password);
        if (result == 1){
            resp.sendRedirect("/bookstore/showAllBooks");
        }else {
            resp.sendRedirect("/bookstore/pages/user/login_error.jsp");
        }
    }
}
