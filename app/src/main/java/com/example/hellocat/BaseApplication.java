package com.example.hellocat;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.com.sky.downloader.greendao.DaoMaster;
import com.com.sky.downloader.greendao.DaoSession;
import com.facebook.stetho.Stetho;


public class BaseApplication extends Application {



 //创建
      @Override
      public void onCreate() {
         super.onCreate();
         initGreenDao();

          Stetho.initializeWithDefaults(this);

     }
    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private static DaoSession daoSession;
    public static DaoSession getDaoSession() {
        return daoSession;
    }
}


