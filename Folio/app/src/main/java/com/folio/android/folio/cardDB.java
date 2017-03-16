package com.folio.android.folio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by copperstick6 on 3/13/17.
 */

public class cardDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cards.db";
    public static final String TABLE_NAME = "card_table";
    public static final String COL_1 = "FIRSTNAME";
    public static final String COL_2 = "LASTNAME";
    public static final String COL_3 = "ADDRESS1";
    public static final String COL_4 = "ADDRESS2";
    public static final String COL_5 = "COUNTRY";
    public static final String COL_6 = "USSTATE";
    public static final String COL_7 = "ZIPCODE";
    public static final String COL_8 = "PHONENUMBER";
    public static final String COL_9 = "CITY";
    public static final String COL_10 = "BUSINESS";



    public cardDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
        System.out.println("created object!");
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("created!");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, ADDRESS1 TEXT, ADDRESS2 TEXT, COUNTRY TEXT, USSTATE TEXT, ZIPCODE TEXT, PHONENUMBER TEXT, CITY TEXT, BUSINESS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String firstName, String lastName, String address1, String address2, String Country, String state, String zipCode, String phoneNumber, String city, String business){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(COL_1, firstName);
        content.put(COL_2, lastName);
        content.put(COL_3, address1);
        content.put(COL_4, address2);
        content.put(COL_5, Country);
        content.put(COL_6, state);
        content.put(COL_7, zipCode);
        content.put(COL_8, phoneNumber);
        content.put(COL_9, city);
        content.put(COL_10, business);
        long result = db.insert(TABLE_NAME, null, content);
        if(result == -1){
            return false;
        }
        return true;
    }
}
