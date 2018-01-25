package com.ganapathiram.user.helper;

import android.content.Context;


import com.ganapathiram.user.database.DaoSession;
import com.ganapathiram.user.database.Product;
import com.ganapathiram.user.database.ProductDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Creative IT Works on 10-Aug-17.
 */

public class Helper {
    private final DaoSession daoSession;

    Context context;


    public Helper(DaoSession daoSession, Context context) {
        this.daoSession = daoSession;
        this.context = context;
        helper = this;
    }

    public static Helper getHelper() {
        return helper;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

    public static Helper helper;





    //getMenuItems
    public List<Product> getProductItems(String categoryId) {

        QueryBuilder<Product> qb = daoSession.queryBuilder(Product.class);
        qb.where(ProductDao.Properties.CategoryUid.eq(categoryId));

        return qb.list();

    }


}
