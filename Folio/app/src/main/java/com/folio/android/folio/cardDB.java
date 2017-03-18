package com.folio.android.folio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by copperstick6 on 3/13/17.
 *
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


    /**
     * This is the constructor to initialize the database and get the writable object to start writing to the database
     * @param context   This is the application context to which the super class takes as a parameter to initialize the database
     */
    public cardDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
        System.out.println("created object!");
        SQLiteDatabase db = this.getWritableDatabase();
    }

    /**
     * This method is automatically called upon every database object that is created
     * @param db        This is the paramater passed into the method automatically by the system
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("created!");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, ADDRESS1 TEXT, ADDRESS2 TEXT, COUNTRY TEXT, USSTATE TEXT, ZIPCODE TEXT, PHONENUMBER TEXT, CITY TEXT, BUSINESS TEXT)");

    }


    /**
     *TODO Still have to figure what to do with database upgrades, still unsure when this method is called
     * @param db        SQLLiteDatabase passed into upgrade so it can initialize a Cursor object upon it and enact changes
     * @param oldVersion    old version of database to be upgraded
     * @param newVersion    new version of database to upgrade to
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    /**
     * Data to be inserted
     * @param firstName first name passed into the database for insertion
     * @param lastName  last name passed into the database for insertion
     * @param address1  primary address passed into the database for insertion
     * @param address2  secondary address passed into the database for insertion
     * @param Country   country passed into the database for insertion
     * @param state state passed into the database for insertion
     * @param zipCode   zip code passed into the database for insertion
     * @param phoneNumber   phone number passed into the database for insertion
     * @param city  city passed into the database for insertion
     * @param business  business passed into the database for insertion
     * @return  return true if insert is successful, false otherwise
     */
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

    /**
     * Method to return a cursor to iterate through the columns and get all data
     * @return  return a cursor object upon the database
     */
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        return cur;
    }
}
