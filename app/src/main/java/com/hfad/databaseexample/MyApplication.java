package com.hfad.databaseexample;

import android.app.Application;

import com.hfad.databaseexample.db.DatabaseManager;

/**
 * Created by user on 9/4/2016.
 */
public class MyApplication extends Application {
     private DatabaseManager dbDatabaseManager;
    @Override
    public void onCreate() {
        super.onCreate();
       dbDatabaseManager= DatabaseManager.newInstance(this);
    }
    public DatabaseManager getDbDatabaseManager()
    {
        return dbDatabaseManager;
    }
}
