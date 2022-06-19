package com.zychen.servlet;


import com.zychen.dao.impl.AccountDaoImpl;
import com.zychen.dao.impl.RecordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateAccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName =(new accountLoadingServlet()).accountOnly;
        String newPass,rePass;
        newPass = req.getParameter("newpwd");
        rePass = req.getParameter("renewpwd");
        if (newPass.equals(rePass)){
            (new AccountDaoImpl()).updatePassword(accountName,newPass);
            resp.sendRedirect("/bookstore/pages/own/updatePWD_success.jsp");
        }else {
            resp.sendRedirect("/bookstore/pages/own/updatePWD_error.jsp");
        }

    }
}
