package com.zychen.servlet;

import com.zychen.bean.Book;
import com.zychen.dao.impl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class showAllBooksServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = (new BookDaoImpl()).queryBook(null);
        req.setAttribute("test",bookList);
        req.getRequestDispatcher("/pages/book/allbook.jsp").forward(req,resp);
    }
}
