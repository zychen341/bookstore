package com.zychen.dao.impl;

import com.zychen.bean.MyPackage;
import com.zychen.bean.ShoppingCarRecord;
import com.zychen.dao.PackageDao;
import com.zychen.utils.TestJdbcConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDaoImpl implements PackageDao {
    @Override
    public List<MyPackage> queryPackage(MyPackage pack) {
        String sql = "select * from package";
        try {
            List<MyPackage> MyPackageList = new ArrayList<>();
            ResultSet rs = TestJdbcConnection.getResult("firstdemo",sql,"root","88888888");
            MyPackage MyPackageObject;
            //8.处理结果
            while (rs.next()) {
                String bookName = rs.getString("bookName");
                double price = rs.getDouble("price");
                int bookQuanities = rs.getInt("bookQuanities");
                String account = rs.getString("account");
                int id = rs.getInt("id");
                MyPackageObject = new MyPackage(bookName,price,bookQuanities,account,id);
                MyPackageList.add(MyPackageObject);
            }
            return MyPackageList;
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int insertPackage(MyPackage pack, ShoppingCarRecord shoppingCarRecord, String accountName) {
        boolean flag = false;
        List<MyPackage> MyPackageList = (new PackageDaoImpl()).queryPackage(null);
        for (int i = 0; i < MyPackageList.size(); i++) {
            if (MyPackageList.get(i).getBookName().equals(shoppingCarRecord.getBookName()) && MyPackageList.get(i).getAccount().equals(accountName)){
                flag = true;
            }
        }
        if(flag){
            String sql = "update package set bookQuanities = bookQuanities + "+shoppingCarRecord.getBookQuanities()+" where bookName ='" + shoppingCarRecord.getBookName()+"' and account = '"+accountName +"'";
            TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
        }else {
            String sql = "insert into package(bookName,price,bookQuanities,account) values('" + shoppingCarRecord.getBookName() + "'," + shoppingCarRecord.getPrice() +","+shoppingCarRecord.getBookQuanities()+",'" + shoppingCarRecord.getAccount() + "')";
            TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
        }
        return 0;
    }

    @Override
    public int delPackage(MyPackage pack,String accountName) {
        return 0;
    }

    @Override
    public int updatePackage(MyPackage pack) {
        return 0;
    }

    public void clearPackage(String accountName){
        String sql = "delete from package where account = '"+accountName +"'";
        TestJdbcConnection.executeUpdate("firstdemo",sql,"root","88888888");
    }

    public int deletePackage(String bookId, String accountName) {
        int isno = 0;
        int number = 0;
        List<MyPackage> packageList = (new PackageDaoImpl()).queryPackage(null);
        for (int i = 0; i < packageList.size(); i++) {
            if (packageList.get(i).getId() == Integer.valueOf(bookId) && packageList.get(i).getAccount().equals(accountName)) {
                number = packageList.get(i).getBookQuanities();
            }
        }
        if (number >= 2) {
            String sql = "update package set bookQuanities = bookQuanities - 1 where id = " + Integer.valueOf(bookId) + " and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        } else {
            String sql = "delete from package where id=" + Integer.valueOf(bookId) + " and account = '" + accountName + "'";
            TestJdbcConnection.executeUpdate("firstdemo", sql, "root", "88888888");
        }
        return isno;
    }
}
