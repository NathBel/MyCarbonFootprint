package com.example.mycarbonfootprint.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ClientDbHelper extends SQLiteOpenHelper {
    public static final String CREATE_DB = "CREATE TABLE History (id INTEGER PRIMARY KEY AUTOINCREMENT, result REAL);";
    public static final String DELETE_DB = "DROP TABLE IF EXISTS History;";
    public static String DATABASE_NAME = "MyCarbonFootPrint.db";
    public static int DATABASE_VERSION = 1;

    public ClientDbHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(DELETE_DB);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    public ArrayList<String> selectAll(SQLiteDatabase sqLiteDatabase) {
        String[] col = {"id", "result"};
        String[] select = {};
        ArrayList<String> r = new ArrayList();

        Cursor curs = sqLiteDatabase.query("History", col, "", select, null, null, "id ASC");
        if (curs.moveToFirst()) {
            do {
                long id = curs.getLong(curs.getColumnIndexOrThrow("id"));
                String result = curs.getString(curs.getColumnIndexOrThrow("result"));
                r.add(result);
                Log.v("DBB", result);
            } while (curs.moveToNext());
        }
        curs.close();
        return r;
    }
}

