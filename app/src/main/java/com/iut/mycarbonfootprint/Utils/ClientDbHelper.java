package com.iut.mycarbonfootprint.Utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ClientDbHelper extends SQLiteOpenHelper {
    public static final String CREATE_DB = "CREATE TABLE History (id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER, distance REAL, result REAL);";
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

    public ArrayList<ArrayList<String>> selectAll(SQLiteDatabase sqLiteDatabase) {
        String[] col = {"id", "type", "distance", "result"};
        String[] select = {};
        ArrayList<ArrayList<String>> r = new ArrayList();

        Cursor curs = sqLiteDatabase.query("History", col, "", select, null, null, "id ASC");
        if (curs.moveToFirst()) {
            do {
                ArrayList<String> l = new ArrayList();
                String id = curs.getString(curs.getColumnIndexOrThrow("id"));
                String type = curs.getString(curs.getColumnIndexOrThrow("type"));
                String distance = curs.getString(curs.getColumnIndexOrThrow("distance"));
                String result = curs.getString(curs.getColumnIndexOrThrow("result"));
                l.add(type);
                l.add(distance);
                l.add(result);
                r.add(l);
            } while (curs.moveToNext());
        }
        curs.close();
        Log.v("DBB", r.toString());
        return r;
    }
}

