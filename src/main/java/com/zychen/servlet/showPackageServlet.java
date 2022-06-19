package com.zychen.servlet;

import com.zychen.bean.MyPackage;
import com.zychen.dao.impl.PackageDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class showPackageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MyPackage> packageList = (new PackageDaoImpl()).queryPackage(null);
        String accountName =(new accountLoadingServlet()).accountOnly;
        List<MyPackage> packages = new ArrayList<>();
        for (MyPackage myPackage : packageList) {
            if (myPackage.getAccount().equals(accountName)){
                packages.add(myPackage);
            }
        }
        req.setAttribute("packages",packages);
        req.getRequestDispatcher("/pages/cart/package.jsp").forward(req,resp);
    }
}
