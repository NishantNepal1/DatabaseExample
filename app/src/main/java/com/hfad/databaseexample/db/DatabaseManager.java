package com.hfad.databaseexample.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hfad.databaseexample.Info;

import java.util.ArrayList;

/**
 * Created by user on 9/4/2016.
 */
public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    SQLiteDatabase db;


    private DatabaseManager(Context mContext) {
        DatabaseHelper mDatabaseHelper = new DatabaseHelper(mContext);
        this.db = mDatabaseHelper.getWritableDatabase();
    }


    public static DatabaseManager newInstance(Context mContext) {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseManager(mContext);
        }

        return INSTANCE;
    }

    public void addContact(Info contact) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.CONTACT_ADDRESS, contact.getAdress());
        contentValues.put(DatabaseHelper.CONTACT_ID, contact.getContact());
        contentValues.put(DatabaseHelper.CONTACT_NAME, contact.getName());
        contentValues.put(DatabaseHelper.GNEDER, contact.getGetGender());
        db.insert(DatabaseHelper.TBL_CONTACT, null, contentValues);
    }

    public void deleteContact(String contactId) {
        int i = db.delete(DatabaseHelper.TBL_CONTACT, DatabaseHelper.CONTACT_ID + " = '" + contactId + "'", null);
        Log.e("tag", i + "");
    }

    public void upateContact(String contactId, String updatedName) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.CONTACT_NAME, updatedName);
        db.update(DatabaseHelper.TBL_CONTACT, cv, DatabaseHelper.CONTACT_ID + " = '" + contactId + "'", null);

    }

    public ArrayList<Info> fetchContact() {
        String query = "SELECT * FROM " + DatabaseHelper.TBL_CONTACT;
        Cursor cursor = db.rawQuery(query, null);

        ArrayList<Info> infoArrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            Info info = new Info();
            info.setName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.CONTACT_NAME)));
            info.setGetGender(cursor.getString(cursor.getColumnIndex(DatabaseHelper.GNEDER)));
            info.setAdress(cursor.getString(cursor.getColumnIndex(DatabaseHelper.CONTACT_ADDRESS)));
            info.setContact(cursor.getString(cursor.getColumnIndex(DatabaseHelper.CONTACT_ID)));
            Log.e("Contact Name ", cursor.getString(cursor.getColumnIndex(DatabaseHelper.CONTACT_NAME)) + "");
            Log.e("Contact ID ", cursor.getString(cursor.getColumnIndex(DatabaseHelper.CONTACT_ID)) + "");
            Log.e("Contact GENDER ", cursor.getString(cursor.getColumnIndex(DatabaseHelper.GNEDER)) + "");

            infoArrayList.add(info);
        }
        return infoArrayList;
    }

}

