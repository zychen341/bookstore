package com.zychen.utils;

import java.sql.*;

public class TestJdbcConnection {

    /**
     * 获取数据库链接
     *
     * @param dataBaseName
     * @param username
     * @param usepassword
     * @return
     */
    public static Connection getConnection(String dataBaseName, String username, String usepassword) {
        //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/" + dataBaseName + "?useSSL=false&useServerPrepStmts=false";
            return DriverManager.getConnection(url, username, usepassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取预编译对象
     *
     * @param dataBaseName
     * @param sql
     * @param username
     * @param usepassword
     * @return
     */
    public static PreparedStatement getPstmt(String dataBaseName, String sql, String username, String usepassword) {
        try {
            return getConnection(dataBaseName, username, usepassword).prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 执行语句获取Result对象
     *
     * @param dataBaseName
     * @param sql
     * @param username
     * @param usepassword
     * @return
     */
    public static ResultSet getResult(String dataBaseName, String sql, String username, String usepassword) {
        try {
            return getPstmt(dataBaseName, sql, username, usepassword).executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 更新，删除，插入语句封装
     *
     * @param dataBaseName
     * @param sql
     * @param username
     * @param usepassword
     * @return
     */
    public static int executeUpdate(String dataBaseName, String sql, String username, String usepassword) {
        try {
            return getPstmt(dataBaseName, sql, username, usepassword).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
