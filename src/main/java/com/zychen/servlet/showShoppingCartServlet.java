package com.zychen.servlet;

import com.zychen.bean.ShoppingCarRecord;
import com.zychen.dao.impl.RecordDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class showShoppingCartServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingCarRecord> recordList = (new RecordDaoImpl()).queryRecords(null);
        double allPrice = 0.0;
        String accountName =(new accountLoadingServlet()).accountOnly;
        List<ShoppingCarRecord> records = new ArrayList<>();
        for (ShoppingCarRecord record : recordList) {
            if (record.getAccount().equals(accountName)){
                records.add(record);
            }
        }
        for (ShoppingCarRecord record : records) {
            allPrice = allPrice + record.getAllPrice();
        }
        req.setAttribute("record",records);
        req.setAttribute("allPrice",allPrice);
        req.getRequestDispatcher("/pages/cart/cart.jsp").forward(req,resp);
    }
}
