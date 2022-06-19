package com.zychen.dao;

import com.zychen.bean.MyPackage;
import com.zychen.bean.ShoppingCarRecord;

import java.util.List;

public interface PackageDao {
    List<MyPackage> queryPackage(MyPackage pack);

    int insertPackage(MyPackage pack, ShoppingCarRecord shoppingCarRecord, String accountName);

    int delPackage(MyPackage pack, String accountName);

    int updatePackage(MyPackage pack);
}
