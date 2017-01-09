package com.wzgiceman.xutilsdb;

import android.app.Application;

import com.wzgiceman.dbutils.db.x;


/**
 * Created by WZG on 2017/1/9.
 */

public class App  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
    }
}
