package com.zychen.servlet;


import com.zychen.dao.impl.RecordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountName =(new accountLoadingServlet()).accountOnly;
        String bookId;
        bookId = req.getParameter("id");
        (new RecordDaoImpl()).deleteCart(bookId,accountName);
        resp.sendRedirect("/bookstore/showShoppingCart");
    }
}
