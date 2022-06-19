package com.zychen.servlet;
import com.zychen.bean.Book;
import com.zychen.dao.impl.BookDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class queryBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName;
        List<Book> books = new ArrayList<>();
        bookName = req.getParameter("bookName");
        books = (new BookDaoImpl()).searchBooks(bookName);
        if (books == null){
            resp.sendRedirect("/bookstore/pages/book/query_error.jsp");
        }else {
            req.setAttribute("queryBooks",books);
            req.getRequestDispatcher("/pages/book/queryBook.jsp").forward(req,resp);
        }
    }
}
