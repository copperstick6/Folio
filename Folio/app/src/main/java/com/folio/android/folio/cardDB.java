package com.folio.android.folio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by copperstick6 on 3/13/17.
 */

public class cardDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cards.db";
    public static final String TABLE_NAME = "card_table";
    

    public cardDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
