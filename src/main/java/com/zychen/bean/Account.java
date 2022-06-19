package com.zychen.bean;

public class Account {
    private double money;
    private String account;
    private String password;

    public Account(String account, String password, double money) {
        this.account = account;
        this.password = password;
        this.money = money;
    }

    public Account() {
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
